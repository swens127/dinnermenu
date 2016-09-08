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
public class Settings {
    private ArrayList<String> emails;
    private boolean combine_quick_meals;
    private boolean combine_special_meals;
    private boolean combine_large_meals;
    private boolean combine_fast_sunday_meals;
    
    
    //Getters and Setters
    public void set_emails(ArrayList<String> emails) {
        this.emails = emails;
    }
    public ArrayList<String> get_emails() {
        return this.emails;
    }
    
    public void set_unsol_quick(boolean unsol_quick) {
        this.combine_quick_meals = unsol_quick;
    }
    public boolean get_unsol_quick() {
        return this.combine_quick_meals;
    }
    
    public void set_unsol_special(boolean unsol_special) {
        this.combine_special_meals = unsol_special;
    }
    public boolean get_unsol_special() {
        return this.combine_special_meals;
    }
    
    public void set_unsol_large(boolean unsol_large) {
        this.combine_large_meals = unsol_large;
    }
    public boolean get_unsol_large() {
        return this.combine_large_meals;
    }
    
    public void set_unsol_fast_sunday(boolean unsol_fast_sunday) {
        this.combine_fast_sunday_meals = unsol_fast_sunday;
    }
    public boolean get_unsol_fast_sunday() {
        return this.combine_fast_sunday_meals;
    }
    
}
