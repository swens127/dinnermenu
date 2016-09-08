#!/usr/bin/python

import re
import sys, getopt, os
from bs4 import BeautifulSoup
import urllib2
import isodate

web_address = sys.argv[1]
db_name = sys.argv[2]
quick_meal_minutes = int(sys.argv[3])

headers = {'User-Agent' : 'Mozilla/5.0'}
req = urllib2.Request(web_address, None, headers)

recipe_url = urllib2.urlopen(req).read()
#recipe_url = urllib.urlopen('http://www.foodnetwork.com/recipes/food-network-kitchens/oven-fried-chicken-recipe2.html').read()
#recipe_url = urllib.urlopen('https://www.verybestbaking.com/recipes/18470/libbys-famous-pumpkin-pie/').read()
#recipe_url = urllib.urlopen('http://allrecipes.com/recipe/230785/hawaiian-haystacks/').read()
#recipe_url = urllib.urlopen('http://allrecipes.com/recipe/20334/banana-pancakes-i/').read()

soup = BeautifulSoup(recipe_url,'html.parser')
if False:
#if True:
    full_text =  soup.prettify().encode('utf-8')
    print full_text

def extract_text(soup):
     # kill all script and style elements
     for script in soup(["script", "style"]):
         script.extract()    # rip it out
     # get text
     text = soup.get_text()
     # break into lines and remove leading and trailing space on each
     lines = (line.strip() for line in text.splitlines())
     # break multi-headlines into a line each
     chunks = (phrase.strip() for line in lines for phrase in line.split("  "))
     # drop blank lines
     text = '\n'.join(chunk for chunk in chunks if chunk)
     return text.encode('utf-8')

def scrape_recipes():
    for recipe in recipes:
        ## NAME ##
        name = recipe.find("meta",itemprop='name')
        if name:
            recipe_name = name["content"]
        else:
            name = recipe.find(itemprop='name')
            recipe_name = extract_text(name)

        print "recipe name %s"%recipe_name

        ## INGREDIENTS ##
        ingredients = recipe.find_all(itemprop='ingredients')
        recipe_ingredients = []
        for ingredient in ingredients:
           recipe_ingredients.append(extract_text(ingredient).replace("\n",''))

        ## INSTRUCTIONS ##
        instructions = recipe.find_all(itemprop='recipeInstructions')
        recipe_instructions = ""
        for instruction in instructions:
            recipe_instructions = recipe_instructions + extract_text(instruction) + "\n"
   
        ## TIME ##
        for content_type,key in {'meta':'content','time':'content','time':'datetime'}.iteritems():
            try:
                total_time = recipe.find(content_type,itemprop='totalTime')
                if total_time != None:
                    total_time = isodate.parse_duration(total_time[key]).total_seconds()
                else:
                    prep_time = recipe.find(content_type,itemprop="prepTime")
                    if prep_time != None:
                        prep_time = isodate.parse_duration(prep_time[key]).total_seconds()
                    cook_time = recipe.find(content_type,itemprop="cookTime")
                    if cook_time != None:
                        cook_time = isodate.parse_duration(cook_time[key]).total_seconds()
    
                if total_time or (prep_time and cook_time):
                    total_time = int(prep_time) + int(cook_time) if total_time == None else int(total_time)
                    break
            except:
                continue

        if total_time:
            quick_meal = True if total_time <= int(quick_meal_minutes*60) else False
        else:
            quick_meal = False

        return (recipe_name,recipe_ingredients,recipe_instructions,quick_meal)

def standardize_measure(measure):
    possible_measures_dict = {}
    possible_measures_dict['cup(s)']   = ['cup']
    possible_measures_dict['tbsp']     = ['tbsp','tablespoon']
    possible_measures_dict['tsp']     = ['tsp','teaspoon']
    possible_measures_dict['can(s)']     = ['can']
    possible_measures_dict['package(s)']     = ['pkg','package']
    possible_measures_dict['box(es)']     = ['box']
    possible_measures_dict['pound(s)']     = ['lb','pound']
    possible_measures_dict['ml(s)']     = ['ml','milliliter']
    possible_measures_dict['quart(s)']     = ['qt','qrt','quart']
    possible_measures_dict['pint(s)']     = ['pt','pint']
    possible_measures_dict['fl oz(s)']     = ['fl oz','fluid ounce']
    possible_measures_dict['oz(s)']     = ['oz','ounce']
    possible_measures_dict['slice(s)']     = ['slice']

    for (standard_value, measure_variations) in possible_measures_dict.iteritems():
         for variation in measure_variations:
             if variation in measure.lower():
                 #print "STANDARD VALUE FOUND: %s"%standard_value
                 return (standard_value,True)

    #print "NON-STANDARD VALUE FOUND: %s"%measure
    return (measure,False)



def write_food_file(recipe_name,recipe_ingredients,recipe_instructions,quick_meal):
    #db_file = open(db_name,'a') if not os.path.isfile(db_name) else open(db_name,'w+')
    db_file = open(db_name,'w+')
    quick_meal = "true" if quick_meal else "false"
    recipe_instructions = recipe_instructions.replace("\n","NEWLINE")
    db_file.write(recipe_name + "\n")
    ingredient_number = 0
    for ingredient in recipe_ingredients:
        ingredient_number += 1
        quantity = re.search('^[\d.\\\/\s]+',ingredient)
        measure = ''
        if quantity:
            quantity = quantity.group(0).strip()
            #print "QUANTITY: %s"%quantity
            ingredient = ingredient[len(quantity):]
            ingredient = ingredient.split()
            if len(ingredient) > 1:
                measure = ingredient[0]
                (measure,standard_value) = standardize_measure(measure)
                if standard_value:
                    ingredient.pop(0)
                else:
                    measure = ''
            ingredient = ' '.join(ingredient)
            db_file.write(quantity + "|")
            db_file.write(measure + "|")
            #print "MEASURE: %s"%measure
            #print "INGREDIENT: %s"%ingredient
        else:
            db_file.write("||")
            #print "INGREDIENT: %s"%ingredient
        if ingredient_number != len(recipe_ingredients):
            db_file.write(ingredient + "|")
        else:
            db_file.write(ingredient + "\n")     

    db_file.write(recipe_instructions + "\n")
    db_file.write("false\n") #Large meal
    db_file.write("false\n") #Fast Sunday meal
    db_file.write(quick_meal + "\n") #Quick meal
    db_file.write("2\n") #Meal frequency
    db_file.write("*&*&*") #Parsing check

    db_file.close()
    

recipes = soup.find_all(itemtype="http://schema.org/Recipe")
if len(recipes) != 0:
    recipe_name,recipe_ingredients,recipe_instructions,quick_meal = scrape_recipes()
    write_food_file(recipe_name,recipe_ingredients,recipe_instructions,quick_meal)
    sys.exit(0)
else:
    print "0 Recipes Found!"
    sys.exit(2)

