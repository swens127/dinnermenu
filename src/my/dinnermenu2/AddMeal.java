/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.dinnermenu2;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.MathContext;
import java.nio.file.Files;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ajswe
 */


public class AddMeal extends javax.swing.JFrame {

 
    private static Component popup;
    
    /**
     * Creates new form AddMeal
     * @param menu
     * @param prepop_meal_name
     * @param settings
     */
    public AddMeal(ArrayList<Meal> menu, String prepop_meal_name, Settings settings,String menu_file_name, String parsing_check) {
        setDefaultCloseOperation(AddMeal.EXIT_ON_CLOSE);
        try {
            Image image = new ImageIcon("icon.png").getImage();
            this.setIconImage(image);
        } catch(Exception ex){
            JOptionPane.showMessageDialog(popup, "Application icon not found!");
        }
        this.menu = menu;
        this.ingredients = new ArrayList<>();
        this.menu_file_name = menu_file_name;
        this.parsing_check = parsing_check;
        this.settings = settings;
        initComponents();
        this.setTitle("Dinner Menu");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setResizable(false);
        
        //Set up window settings
        meal_frequency.removeAllItems();
        meal_frequency.addItem("High");
        meal_frequency.addItem("Normal");
        meal_frequency.addItem("Low");
        meal_frequency.addItem("Special");
        meal_frequency.setSelectedIndex(1);
        unit_combobox.removeAllItems();
        unit_combobox.addItem("");
        unit_combobox.addItem("box(es)");
        unit_combobox.addItem("can(s)");
        unit_combobox.addItem("cup(s)");
        unit_combobox.addItem("fl oz(s)");
        unit_combobox.addItem("ml(s)");
        unit_combobox.addItem("oz(s)");
        unit_combobox.addItem("package(s)");
        unit_combobox.addItem("pint(s)");
        unit_combobox.addItem("pound(s)");
        unit_combobox.addItem("quart(s)");
        unit_combobox.addItem("tbsp");
        unit_combobox.addItem("tsp");        
        unit_combobox.setSelectedIndex(0);
        ingredient_display = "";
        
        
        recipe.setWrapStyleWord(true);
        //ingredient_list = (new DefaultListModel<String>());
        
        //Populate meal display
        meal_display = "";
        for (int i = 0; i < menu.size(); i++) {
            meal_display += menu.get(i).name + "\n";
        }
        current_meals_display.setText(meal_display);
        
        //Prepopulate the screen if editing meal
        original_name = "";
        editing_meal = false;
        if (!prepop_meal_name.equals("")) {
            original_name = prepop_meal_name;
            editing_meal = true;
            Meal prepop_meal = new Meal();
            for (Meal meal : menu) {
                if (meal.name.equals(prepop_meal_name)) {
                    prepop_meal = meal;
                    break;
                }
            }
            meal_name.setText(prepop_meal.name);
            this.ingredients = prepop_meal.ingredients;
 
            ingredient_display = "";
            for (int i = 0; i < prepop_meal.ingredients.size(); i++) {
                if (prepop_meal.ingredients.get(i).is_frac()) {
                    //Check for empty quantity
                    if (ingredients.get(i).is_frac()) {
                        //If no quantity is set, it will show as a null fraction
                        if (prepop_meal.ingredients.get(i).get_frac_quantity() != null) {
                            ingredient_display += prepop_meal.ingredients.get(i).get_frac_quantity().toString() + " ";
                        }
                    } else {
                        ingredient_display += prepop_meal.ingredients.get(i).get_dec_quantity() + " ";
                    }
                }
                if (!prepop_meal.ingredients.get(i).get_measurement().isEmpty()) {
                    ingredient_display += prepop_meal.ingredients.get(i).get_measurement() + " ";
                }
                if (!prepop_meal.ingredients.get(i).get_name().isEmpty()) {
                    ingredient_display += prepop_meal.ingredients.get(i).get_name() + "\n";
                }

            }
            ingredient_list.setText(ingredient_display);

            recipe.setText(prepop_meal.recipe);
            large_meal.setSelected(prepop_meal.large_meal);
            fast_sunday_meal.setSelected(prepop_meal.fast_sunday);
            quick_meal.setSelected(prepop_meal.quick_meal);
            switch (prepop_meal.frequency) {
                case 3:
                    meal_frequency.setSelectedIndex(0);
                    break;
                case 2:
                    meal_frequency.setSelectedIndex(1);
                    break;
                case 1:
                    meal_frequency.setSelectedIndex(2);
                    break;
                case 0:
                    meal_frequency.setSelectedIndex(3);
                    break;
            }
            for (int i = 0; i < menu.size(); i++) {
                if (menu.get(i).name.equals(prepop_meal.name)) {
                    menu.remove(i);
                    break;
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        recipe = new javax.swing.JTextArea();
        fast_sunday_meal = new javax.swing.JCheckBox();
        quick_meal = new javax.swing.JCheckBox();
        meal_name_label = new javax.swing.JLabel();
        meal_frequency = new javax.swing.JComboBox();
        meal_name = new javax.swing.JTextField();
        frequency_label = new javax.swing.JLabel();
        go_back_button = new javax.swing.JButton();
        save_button = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        current_meals_display = new javax.swing.JTextArea();
        current_meals_label = new javax.swing.JLabel();
        current_ingredients_label = new javax.swing.JLabel();
        new_ingredient_label = new javax.swing.JLabel();
        new_ingredient_name = new javax.swing.JTextField();
        quantity_label = new javax.swing.JLabel();
        quantity_textfield = new javax.swing.JTextField();
        unit_label = new javax.swing.JLabel();
        unit_combobox = new javax.swing.JComboBox();
        add_ingredient_button = new javax.swing.JButton();
        remove_ingredient_button = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ingredient_list = new javax.swing.JTextArea();
        large_meal = new javax.swing.JCheckBox();
        url_textfield = new javax.swing.JTextField();
        import_recipe_button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        recipe.setColumns(20);
        recipe.setLineWrap(true);
        recipe.setRows(5);
        jScrollPane2.setViewportView(recipe);

        fast_sunday_meal.setText("Fast Sunday Meal");

        quick_meal.setText("Quick Meal");

        meal_name_label.setText("Name:");

        meal_frequency.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        frequency_label.setText("Frequency of Meal:");

        go_back_button.setText("Go Back");
        go_back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                go_back_buttonActionPerformed(evt);
            }
        });

        save_button.setText("Save");
        save_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_buttonActionPerformed(evt);
            }
        });

        jLabel3.setText("Recipe:");

        current_meals_display.setEditable(false);
        current_meals_display.setBackground(new java.awt.Color(180, 180, 180));
        current_meals_display.setColumns(20);
        current_meals_display.setRows(5);
        current_meals_display.setFocusable(false);
        jScrollPane3.setViewportView(current_meals_display);

        current_meals_label.setText("Saved Meals:");

        current_ingredients_label.setText("Current Ingredients:");

        new_ingredient_label.setText("Ingredient Name:");

        quantity_label.setText("Amount:");

        unit_label.setText("Unit:");

        add_ingredient_button.setText("Add Ingredient");
        add_ingredient_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_ingredient_buttonActionPerformed(evt);
            }
        });

        remove_ingredient_button.setText("Remove Ingredient");
        remove_ingredient_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remove_ingredient_buttonActionPerformed(evt);
            }
        });

        ingredient_list.setEditable(false);
        ingredient_list.setBackground(new java.awt.Color(180, 180, 180));
        ingredient_list.setColumns(20);
        ingredient_list.setRows(5);
        ingredient_list.setFocusable(false);
        jScrollPane1.setViewportView(ingredient_list);

        large_meal.setText("Large Meal");

        url_textfield.setText("Paste URL here");

        import_recipe_button.setText("Import Recipe");
        import_recipe_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                import_recipe_buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(frequency_label)
                            .addComponent(go_back_button))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(meal_frequency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(url_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(import_recipe_button)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(save_button))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(67, 67, 67)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(quantity_label)
                                            .addComponent(unit_label)))
                                    .addComponent(add_ingredient_button)
                                    .addComponent(new_ingredient_label, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(new_ingredient_name, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(quantity_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(unit_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(remove_ingredient_button)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(current_ingredients_label)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane1)
                                        .addGap(10, 10, 10))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(fast_sunday_meal)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(quick_meal)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(large_meal))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 447, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(meal_name_label)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(meal_name, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(current_meals_label)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(current_ingredients_label)
                            .addComponent(current_meals_label))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(meal_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(meal_name_label))
                        .addGap(26, 26, 26)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(new_ingredient_name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(new_ingredient_label))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(quantity_label)
                                    .addComponent(quantity_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(unit_combobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(unit_label))
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(add_ingredient_button)
                                    .addComponent(remove_ingredient_button))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fast_sunday_meal)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(quick_meal)
                                .addComponent(large_meal))))
                    .addComponent(jScrollPane3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(meal_frequency, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(frequency_label))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(go_back_button)
                    .addComponent(save_button)
                    .addComponent(url_textfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(import_recipe_button))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void save_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_buttonActionPerformed
        Meal meal_to_save = new Meal();
        
        //INITIAL CHECKS BEFORE SAVING MEAL//
        
        //Check for no meal name
        if (meal_name.getText().isEmpty()) {
            JOptionPane.showMessageDialog(popup, "Must have meal name!");
            return;
        }
        String meal_name_uppercase;
        meal_name_uppercase = Character.toUpperCase(meal_name.getText().charAt(0)) + meal_name.getText().substring(1);
        //Check for meal name reusage
        for (Meal meal : menu) {
            if (meal_name_uppercase.equals(meal.name) && !editing_meal) {
                JOptionPane.showMessageDialog(popup, "Name already in use!");
                return;
            }
            if(!meal_name_uppercase.equals(original_name) && editing_meal && meal_name_uppercase.equals(meal.name)) {
                JOptionPane.showMessageDialog(popup, "Can't overwrite another meal!");
                return;
            }
        }
        
        //Check for ingredients
        meal_to_save.name = meal_name_uppercase;
        //if (ingredients.getText().isEmpty()) {
        //    JOptionPane.showMessageDialog(popup, "Must include ingredients!");
        //    return;
        //}
        
        //FINISH INITIAL CHECKS//
        meal_to_save.ingredients = ingredients;
        
        //Save recipe
        if (recipe.getText().isEmpty()) {
            meal_to_save.recipe = "No recipe stored...";
        } else {
            meal_to_save.recipe = recipe.getText();
        }
        
        //Save large meal
        meal_to_save.large_meal = large_meal.isSelected();
        
        //Save fast Sunday meal
        meal_to_save.fast_sunday = fast_sunday_meal.isSelected();
        
        //Save quick meal
        meal_to_save.quick_meal = quick_meal.isSelected();
        
        //Save frequency
        switch(meal_frequency.getSelectedItem().toString()) {
            case "High":      
                meal_to_save.frequency = 3;
                break;
            case "Normal":
                meal_to_save.frequency = 2;
                break;
            case "Low":
                meal_to_save.frequency = 1;
                break;
            case "Special":
                meal_to_save.frequency = 0;
                break;
            default:
                JOptionPane.showMessageDialog(popup, "Error: Meal Frequency!");
                break;
        }
        menu.add(meal_to_save);
        
        //Custom sorting for Meal objects
        Collections.sort(menu, (Meal meal1, Meal meal2) -> meal1.name.compareTo(meal2.name));
        
        //Write to DB!
        try {
            write_to_db();
            JOptionPane.showMessageDialog(popup, meal_to_save.name + " saved!");
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(popup, "Error: Unable to write to DB");
        }
        
        //Return to main menu if editing meal
        if (editing_meal) {
            dispose();
            InitialMenu next_window = null;
            try {
                next_window = new InitialMenu();
            } catch (IOException ex) {
                Logger.getLogger(AddMeal.class.getName()).log(Level.SEVERE, null, ex);
            }
            //If unable to open main menu, exit
            if (next_window == null) {
                JOptionPane.showMessageDialog(popup, "Fatal error. Exiting...");
                System.exit(1);
            }

            next_window.setVisible(true);
        }
        
        //Update meal/indredient display
        meal_display = "";
        for (int i = 0; i < menu.size(); i++) {
            meal_display += menu.get(i).name + "\n";
        }
        current_meals_display.setText(meal_display);
        ingredient_list.setText("");
        
        //Reset window
        meal_name.setText("");
        ingredients = new ArrayList<>();
        new_ingredient_name.setText("");
        quantity_textfield.setText("");
        unit_combobox.setSelectedIndex(0);
        recipe.setText("");
        fast_sunday_meal.setSelected(false);
        quick_meal.setSelected(false);
        large_meal.setSelected(false);
        meal_frequency.setSelectedIndex(1);
        meal_name.requestFocusInWindow();
    }//GEN-LAST:event_save_buttonActionPerformed

    private void go_back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_go_back_buttonActionPerformed
        dispose();
        InitialMenu next_window = null;
        try {
            next_window = new InitialMenu();
        } catch (IOException ex) {
            Logger.getLogger(AddMeal.class.getName()).log(Level.SEVERE, null, ex);
        }
        //If unable to open main menu, exit
        if(next_window == null)
        {
            JOptionPane.showMessageDialog(popup, "Fatal error. Exiting...");
            System.exit(1);
        }
        
        next_window.setVisible(true);
    }//GEN-LAST:event_go_back_buttonActionPerformed

    private void add_ingredient_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_ingredient_buttonActionPerformed
        if(new_ingredient_name.getText().isEmpty()) {
            return;
        }

        String pattern1 = "^\\d+/\\d+$";
        String pattern2 = "^\\d+\\s+\\d+/\\d+$";
        String pattern3 = "^\\d+$";
        String pattern4 = "^\\d*\\.\\d+$";
        String pattern5 = "^$";
        Pattern r1 = Pattern.compile(pattern1);
        Pattern r2 = Pattern.compile(pattern2);
        Pattern r3 = Pattern.compile(pattern3);
        Pattern r4 = Pattern.compile(pattern4);
        Pattern r5 = Pattern.compile(pattern5);
        Matcher m1 = r1.matcher(quantity_textfield.getText());
        Matcher m2 = r2.matcher(quantity_textfield.getText());
        Matcher m3 = r3.matcher(quantity_textfield.getText());
        Matcher m4 = r4.matcher(quantity_textfield.getText());
        Matcher m5 = r5.matcher(quantity_textfield.getText());

        if (!(m1.find() || m2.find() || m3.find() || m4.find() || m5.find())) {
            JOptionPane.showMessageDialog(popup, "Invalid quantity. Valid examples include:\n1\n1.5\n1/2\n1 3/4");
            return;
        }
        
        Ingredient new_ingredient = new Ingredient();
        new_ingredient.set_name(Character.toUpperCase(new_ingredient_name.getText().charAt(0)) + new_ingredient_name.getText().substring(1));
        
        //Assign quantity to ingredient (fraction or decimal)
        if (quantity_textfield.getText().contains(".")) {
            new_ingredient.set_quantity(Double.parseDouble(quantity_textfield.getText()));
        } else if(!quantity_textfield.getText().isEmpty()) {
            new_ingredient.set_quantity(new Fraction(quantity_textfield.getText()));
        }
        new_ingredient.set_measurement(unit_combobox.getSelectedItem().toString());
        ingredients.add(new_ingredient);
        
        //Update the ingredient display
        update_ingredient_list_display();
        new_ingredient_name.setText("");
        quantity_textfield.setText("");
        unit_combobox.setSelectedItem("");
        
        new_ingredient_name.requestFocusInWindow();
    }//GEN-LAST:event_add_ingredient_buttonActionPerformed

    private void remove_ingredient_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remove_ingredient_buttonActionPerformed
        if(new_ingredient_name.getText().isEmpty()) {
            return;
        }
        String ingredient_name = Character.toUpperCase(new_ingredient_name.getText().charAt(0)) + new_ingredient_name.getText().substring(1);
        for(int i = 0; i < ingredients.size(); i++)
        {
            if (ingredients.get(i).get_name().equals(ingredient_name)) {
                ingredients.remove(i);
                break;
            }
        }
        
        //Updates ingredient display
        update_ingredient_list_display();
    }//GEN-LAST:event_remove_ingredient_buttonActionPerformed

    private void import_recipe_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_import_recipe_buttonActionPerformed
        try {
            String tmpout;
            String stderr = "";
            boolean failed = false;
            String cmd = "python recipe_extract.py " + url_textfield.getText() + " imported_url.food 60";
            Process p = Runtime.getRuntime().exec(cmd);
            BufferedReader bri = new BufferedReader(new InputStreamReader(p.getInputStream()));
            BufferedReader bre = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            while ((tmpout = bri.readLine()) != null) {
                System.out.println(tmpout);
            }
            bri.close();
            while ((tmpout = bre.readLine()) != null) {
                stderr = tmpout + "\n";
                System.out.println(tmpout);
                failed = true;
                
            }
            if (failed) {
                JOptionPane.showMessageDialog(popup, "Can't import recipe:\n" + stderr);
                bre.close();
                p.waitFor();
                return;
            }
            bre.close();
            p.waitFor();
            parse_imported_url();
            System.out.println("Done.");
        } catch (IOException | InterruptedException err) {
            err.printStackTrace();
        }
    }//GEN-LAST:event_import_recipe_buttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_ingredient_button;
    private javax.swing.JLabel current_ingredients_label;
    private javax.swing.JTextArea current_meals_display;
    private javax.swing.JLabel current_meals_label;
    private javax.swing.JCheckBox fast_sunday_meal;
    private javax.swing.JLabel frequency_label;
    private javax.swing.JButton go_back_button;
    private javax.swing.JButton import_recipe_button;
    private javax.swing.JTextArea ingredient_list;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JCheckBox large_meal;
    private javax.swing.JComboBox meal_frequency;
    private javax.swing.JTextField meal_name;
    private javax.swing.JLabel meal_name_label;
    private javax.swing.JLabel new_ingredient_label;
    private javax.swing.JTextField new_ingredient_name;
    private javax.swing.JLabel quantity_label;
    private javax.swing.JTextField quantity_textfield;
    private javax.swing.JCheckBox quick_meal;
    private javax.swing.JTextArea recipe;
    private javax.swing.JButton remove_ingredient_button;
    private javax.swing.JButton save_button;
    private javax.swing.JComboBox unit_combobox;
    private javax.swing.JLabel unit_label;
    private javax.swing.JTextField url_textfield;
    // End of variables declaration//GEN-END:variables
    private ArrayList<Meal> menu;
    private String meal_display;
    private String ingredient_display;
    private ArrayList<Ingredient> ingredients;
    private final String menu_file_name;
    private final String parsing_check;
    private Settings settings;
    
    private boolean editing_meal; //whether or not currently editing meal
    private String original_name; //original name, if editing meal
    
    public void update_ingredient_list_display()
    {
        ingredient_list.removeAll();
        ingredient_display = "";
        for(int i = 0; i < ingredients.size(); i++)
        {
            String new_ingredient_line = "";
            if (ingredients.get(i).is_frac()) {
                //If no quantity is set, it will show as a null fraction
                if (ingredients.get(i).get_frac_quantity() != null) {
                    new_ingredient_line += ingredients.get(i).get_frac_quantity().toString() + " ";
                }
            } else {
                new_ingredient_line += ingredients.get(i).get_dec_quantity() + " ";
            }
            if (!ingredients.get(i).get_measurement().isEmpty()) {
                new_ingredient_line += ingredients.get(i).get_measurement() + " ";
            }
            if (!ingredients.get(i).get_name().isEmpty()) {
                new_ingredient_line += ingredients.get(i).get_name() + " ";
            }
            ingredient_display += new_ingredient_line + "\n";
        }
        ingredient_list.setText(ingredient_display);
    }
    
    public Double fraction2double(String fraction)
            throws ParseException {
        Double d = null;
        if (fraction != null) {
            if (fraction.contains("/")) {
                String[] numbers = fraction.split("/");
                if (numbers.length == 2) {
                    BigDecimal d1 = BigDecimal.valueOf(Double.valueOf(numbers[0]));
                    BigDecimal d2 = BigDecimal.valueOf(Double.valueOf(numbers[1]));
                    BigDecimal response = d1.divide(d2, MathContext.DECIMAL128);
                    d = response.doubleValue();
                }
            } else {
                d = Double.valueOf(fraction);
            }
        }
        if (d == null) {
            throw new ParseException(fraction, 0);
        }
        return d;
    }
    
    void parse_imported_url() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("imported_url.food"))) {
            String line;
            Meal new_meal = new Meal();
            boolean parse_fail = false;
            while ((line = br.readLine()) != null) {
                
                new_meal.name = line;
                
                //Ingredients
                String[] ingredients_line = br.readLine().split(Pattern.quote("|"));
                for(int i = 0; i < ingredients_line.length; i+=3)
                {
                    Ingredient temp_ingredient = new Ingredient();
                    if (!ingredients_line[i].contains(".") && !ingredients_line[i].isEmpty()) {
                        temp_ingredient.set_quantity(new Fraction(ingredients_line[i]));
                    } else if (!ingredients_line[i].isEmpty()) {
                        temp_ingredient.set_quantity(Double.parseDouble(ingredients_line[i]));
                    } else {
                        temp_ingredient.set_quantity();
                    }
                    temp_ingredient.set_measurement(ingredients_line[i + 1]);
                    temp_ingredient.set_name(ingredients_line[i+2]);
                    new_meal.ingredients.add(temp_ingredient);
                }
                new_meal.recipe = br.readLine();
                new_meal.recipe = new_meal.recipe.replaceAll("NEWLINE", "\n");
                new_meal.large_meal = Boolean.parseBoolean(br.readLine());
                new_meal.fast_sunday = Boolean.parseBoolean(br.readLine());
                new_meal.quick_meal = Boolean.parseBoolean(br.readLine());
                new_meal.frequency = Integer.parseInt(br.readLine());
                menu.add(new_meal);

                //Read in backup file if parsing fails
                if (!parsing_check.equals(br.readLine())) {
                    JOptionPane.showMessageDialog(popup, "Error parsinsg DB! Attempting to recover backup database...");
                }
            }
            br.close();
            if (!parse_fail) {
                dispose();
                AddMeal next_window = null;
                next_window = new AddMeal(menu, new_meal.name, settings, menu_file_name, parsing_check);
                next_window.setVisible(true);
                
                //Delete temporary file after successful parsing
                File file = new File("imported_url.food");
            }
        } 
        catch (IOException e) {
            JOptionPane.showMessageDialog(popup, "Failed to import from URL :(");
        }
    }
    
    void write_to_db() throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(menu_file_name)) {
            for (Meal meal : menu) {
                meal.recipe = meal.recipe.replaceAll("\n", "NEWLINE");
                writer.println(meal.name);
                
                //Ingredients
                ArrayList<Ingredient> temp_ingredients = meal.ingredients;
                for (int i = 0; i < temp_ingredients.size()- 1; i++) {
                    if (temp_ingredients.get(i).is_frac()) {
                        //Assign empty quantity
                        if(temp_ingredients.get(i).get_frac_quantity() == null) {
                            writer.print("|");
                        } else {
                            writer.print(temp_ingredients.get(i).get_frac_quantity().toString() + "|");
                        }
                    } else {
                        writer.print(temp_ingredients.get(i).get_dec_quantity() + "|");
                    }
                    writer.print(temp_ingredients.get(i).get_measurement() + "|");
                    writer.print(temp_ingredients.get(i).get_name().toLowerCase() + "|");
                }
                //End case, don't want to end with a '|'
                if (temp_ingredients.isEmpty()) {
                    writer.println("|||");
                } else {
                    if (temp_ingredients.get(temp_ingredients.size() - 1).is_frac()) {
                        //Assign empty quantity
                        if(temp_ingredients.get(temp_ingredients.size() - 1).get_frac_quantity() == null) {
                            writer.print("|");
                        } else {
                            writer.print(temp_ingredients.get(temp_ingredients.size() - 1).get_frac_quantity().toString() + "|");
                        }
                    } else {
                        writer.print(temp_ingredients.get(temp_ingredients.size() - 1).get_dec_quantity() + "|");
                    }
                    writer.print(temp_ingredients.get(temp_ingredients.size() - 1).get_measurement() + "|");
                    writer.println(temp_ingredients.get(temp_ingredients.size() - 1).get_name().toLowerCase());
                }

                writer.println(meal.recipe);
                writer.println(meal.large_meal);
                writer.println(meal.fast_sunday);
                writer.println(meal.quick_meal);
                writer.println(meal.frequency);
                writer.println(parsing_check);
            }
            writer.flush();
        }
    }
}
