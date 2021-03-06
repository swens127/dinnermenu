/*
 * Initial menu that reads in the database and settings files. Each time this
 * class is created, the menu DB and settings will be read in, and backup menu
 * DB will be created.
 * This file contains the main function and is the only runnable file.
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
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author ajswe
 */
public class InitialMenu extends javax.swing.JFrame {

    private static Component popup;
    private final String menu_file_name;
    private final String common_ingredients_file_name;
    private final String settings_file_name;
    private final String backup_menu_file_name;
    private final String parsing_check;

    /**
     * Creates new form InitialMenu
     * @throws java.io.IOException
     */
    public InitialMenu() throws IOException {
        //Set up the window
        setDefaultCloseOperation(InitialMenu.EXIT_ON_CLOSE);
        try {
            Image image = new ImageIcon("icon.png").getImage();
            this.setIconImage(image);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(popup, "Application icon not found!");
        }
        initComponents();
        this.setTitle("Dinner Menu");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
        setResizable(false);
        
        //Initial variables
        this.menu = new ArrayList<>();
        this.common_ingredients = new ArrayList<>();
        this.menu_file_name = "menuDB.food";
        this.settings_file_name = "settings";
        this.common_ingredients_file_name = "common_ingredients.txt";
        this.backup_menu_file_name = "menuDB.backup";
        this.parsing_check = "*&*&*";
        
        //Read in menu file, create backup, and read in settings:
        read_in_db();
        read_in_settings();
        read_in_common_ingredients();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        get_new_menu = new javax.swing.JButton();
        jToolBar2 = new javax.swing.JToolBar();
        add_new_meal = new javax.swing.JButton();
        jToolBar3 = new javax.swing.JToolBar();
        edit_existing_meal = new javax.swing.JButton();
        jToolBar4 = new javax.swing.JToolBar();
        settings = new javax.swing.JButton();
        jToolBar5 = new javax.swing.JToolBar();
        exit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setIcon(new javax.swing.ImageIcon("hamburger.png"));
        background.setFocusable(false);
        background.setOpaque(true);

        jToolBar1.setRollover(true);

        get_new_menu.setText("Get New Menu");
        get_new_menu.setFocusable(false);
        get_new_menu.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        get_new_menu.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        get_new_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                get_new_menuActionPerformed(evt);
            }
        });
        jToolBar1.add(get_new_menu);

        jToolBar2.setRollover(true);

        add_new_meal.setText("Add New Meal");
        add_new_meal.setFocusable(false);
        add_new_meal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        add_new_meal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        add_new_meal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_new_mealActionPerformed(evt);
            }
        });
        jToolBar2.add(add_new_meal);

        jToolBar3.setRollover(true);

        edit_existing_meal.setText("Edit Existing Meal");
        edit_existing_meal.setFocusable(false);
        edit_existing_meal.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        edit_existing_meal.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        edit_existing_meal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit_existing_mealActionPerformed(evt);
            }
        });
        jToolBar3.add(edit_existing_meal);

        jToolBar4.setRollover(true);

        settings.setText("Settings");
        settings.setFocusable(false);
        settings.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        settings.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                settingsActionPerformed(evt);
            }
        });
        jToolBar4.add(settings);

        jToolBar5.setRollover(true);

        exit.setText("Exit");
        exit.setFocusable(false);
        exit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        exit.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        jToolBar5.add(exit);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jToolBar5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToolBar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jToolBar5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        //Simply Exit
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void get_new_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_get_new_menuActionPerformed
        //Function connected with Generate Menu button
        if(menu.size() < 7) {
            JOptionPane.showMessageDialog(popup, "Only " + menu.size() + " meals are entered.\nNeed at least 7!");
            return;
        }
        dispose();
        CurrentIngredients next_window;
        next_window = new CurrentIngredients(menu,Settings,common_ingredients);
        next_window.setVisible(true);
    }//GEN-LAST:event_get_new_menuActionPerformed

    private void add_new_mealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_new_mealActionPerformed
        //Function connected with Add Meal button
        dispose();
        AddMeal next_window;
        next_window = new AddMeal(menu, "", Settings, menu_file_name, parsing_check);
        next_window.setVisible(true);
    }//GEN-LAST:event_add_new_mealActionPerformed

    private void edit_existing_mealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit_existing_mealActionPerformed
        //Function connected with Edit Meal button
        if (!menu.isEmpty()) {
            dispose();
            ChooseMeal next_window = new ChooseMeal(menu, Settings, menu_file_name, parsing_check);
            next_window.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(popup, "No meals to edit!");
        }
    }//GEN-LAST:event_edit_existing_mealActionPerformed

    private void settingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_settingsActionPerformed
        //Function connected with Settings button
        dispose();
        SettingsGUI next_window = new SettingsGUI(Settings);
        next_window.setVisible(true);
    }//GEN-LAST:event_settingsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //Set look and feel to current system look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (InstantiationException | ClassNotFoundException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InitialMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new InitialMenu().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(InitialMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_new_meal;
    private javax.swing.JLabel background;
    private javax.swing.JButton edit_existing_meal;
    private javax.swing.JButton exit;
    private javax.swing.JButton get_new_menu;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JToolBar jToolBar4;
    private javax.swing.JToolBar jToolBar5;
    private javax.swing.JButton settings;
    // End of variables declaration//GEN-END:variables
    private ArrayList<Meal> menu;
    private ArrayList<String> common_ingredients;
    private Settings Settings;
    private String new_user_dialogue;

    //Read in settings, display welcome message, set settings defaults
    final void read_in_settings() throws FileNotFoundException, IOException {
        File f = new File(settings_file_name);
        Settings = new Settings();
        //New user!
        if (!f.exists()) {
            f.createNewFile();
            //new user dialog
            new_user_dialogue = "Thanks for trying Dinner Menu!\n\n" +
                    "This program is designed to help speed up the\n" + 
                    "process of creating a weekly dinner plan.\n" + 
                    "Some suggestions to get started:\n\n" + 
                    "1. Use the 'Add Meal' button to start adding meals (at least 7)\n" + 
                    "2. Use the 'Settings' button to add an email address, so that\n" + 
                    "   the weekly ingredient list can be emailed to you\n" +
                    "\nGood luck!";
            //JOptionPane.showMessageDialog(popup, new_user_dialogue);
            
            try (PrintWriter writer = new PrintWriter(settings_file_name)) {

                //**Set Default Settings**//
                //Emails
                Settings.set_emails(new ArrayList<>());
                writer.println("");

                //Default unsolicited meal settings
                Settings.set_unsol_quick(true);
                writer.println("true");
                Settings.set_unsol_special(false);
                writer.println("false");
                Settings.set_unsol_large(false);
                writer.println("false");
                Settings.set_unsol_fast_sunday(false);
                writer.println("false");

                //End sequence
                writer.println(parsing_check);
                writer.flush();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(SettingsGUI.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(popup, "Failed to save!");
            }
            return;
        }
        
        //Read in current settings file. WARNING - will not start program if file is shorter than expected
        try (BufferedReader br = new BufferedReader(new FileReader("settings"))) {
            String line;
            while ((line = br.readLine()) != null) {
                //Special case for empty line
                if (line.equals("")) {
                    Settings.set_emails(new ArrayList<>());
                } else {
                    String[] emails = line.split(",");
                    Settings.set_emails(new ArrayList(Arrays.asList(emails)));
                }
                
                Settings.set_unsol_quick(Boolean.parseBoolean(br.readLine()));
                Settings.set_unsol_special(Boolean.parseBoolean(br.readLine()));
                Settings.set_unsol_large(Boolean.parseBoolean(br.readLine()));
                Settings.set_unsol_fast_sunday(Boolean.parseBoolean(br.readLine()));

                if (!parsing_check.equals(br.readLine())) {
                    JOptionPane.showMessageDialog(popup, "Error Parsing Settings!");
                }
                br.close();
                break;
            }
        }
    }

    final void read_in_db() throws FileNotFoundException, IOException {
        File f = new File(menu_file_name);
        if (!f.exists()) {
            f.createNewFile();
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(menu_file_name))) {
            String line;
            boolean parse_fail = false;
            while ((line = br.readLine()) != null) {
                Meal new_meal = new Meal();
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
                    br.close();
                    Files.copy(Paths.get(backup_menu_file_name), Paths.get(menu_file_name), REPLACE_EXISTING);
                    JOptionPane.showMessageDialog(popup, "Success!");
                    menu = new ArrayList();
                    read_in_db();
                    parse_fail = true;
                    break;
                }
            }
            br.close();
            if (!parse_fail) {
                //Create backup file if parsing was successful
                Files.copy(Paths.get(menu_file_name), Paths.get(backup_menu_file_name), REPLACE_EXISTING);
            }
        } 
    }
    
    //Read in list of common ingredients to store in an ArrayList
    final void read_in_common_ingredients() throws FileNotFoundException, IOException {
        File f = new File(common_ingredients_file_name);
        if (!f.exists()) {
            return;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(common_ingredients_file_name))) {
            String line;
            while ((line = br.readLine()) != null) {
                this.common_ingredients.add(line);
            }
        } 
    }
}
