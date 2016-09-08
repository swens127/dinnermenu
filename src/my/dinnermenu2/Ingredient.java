/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.dinnermenu2;

/**
 *
 * @author ajswe
 */
public class Ingredient {
    private String name;
    private Fraction frac_quantity;
    private double dec_quantity;
    private String measurement;
    private boolean is_frac;
    
    public Ingredient() {
        //Initialize ingredient as a null fraction. In the case that the quantity
        //is left blank, we don't want to accidently access the uninitialized double
        is_frac = true;
        frac_quantity = null;
    }
    
    //Getters and setters
    public String get_name() {
        return name;
    }
    public void set_name(String name) {
        this.name = name;
    }
    
    public Fraction get_frac_quantity() {
        return frac_quantity;
    }
    public double get_dec_quantity() {
        return dec_quantity;
    }
    
    public void set_quantity(Fraction quantity) {
        this.frac_quantity = quantity;
        this.dec_quantity = -1;
        this.is_frac = true;
    }
    public void set_quantity(double quantity) {
        this.dec_quantity = quantity;
        this.frac_quantity = null;
        this.is_frac = false;
    }
    //Empty quantity (null fraction)
    public void set_quantity() {
        this.frac_quantity = null;
        this.dec_quantity = -1;
        this.is_frac = true;
    }
    
    public String get_measurement() {
        return this.measurement;
    }
    public void set_measurement(String measurement) {
        this.measurement = measurement;
    }
    
    public boolean is_frac() {
        return this.is_frac;
    }
}
