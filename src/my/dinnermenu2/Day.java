/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.dinnermenu2;

import java.util.Random;

/**
 *
 * @author ajswe
 */
public class Day {
    String name;
    Meal meal;
    int lmh;
    
    public Day(String name) {
        this.name = name;
        
        //Decide what 'frequency' of meal this day will get.
        Random randomGenerator = new Random();
        int randomInt = randomGenerator.nextInt(100);
        if (randomInt < 10) {
            this.lmh = 1; //low freq
        } else if (randomInt < 40) {
            this.lmh = 2; //normal freq
        } else {
            this.lmh = 3; //high freq
        }
        
    }
    
    public void set_meal(Meal meal) {
        this.meal = meal;
    }
}
