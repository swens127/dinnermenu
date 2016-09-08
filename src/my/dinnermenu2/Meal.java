/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.dinnermenu2;

import java.util.ArrayList;


/**
 *
 * @author ajswe
 */
public class Meal {
    String name;
    ArrayList<Ingredient> ingredients;
    String recipe;
    boolean large_meal;
    boolean fast_sunday;
    boolean quick_meal;
    int frequency;
    
    public Meal() {
        ingredients = new ArrayList<>();
    }
}
