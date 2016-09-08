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
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ajswe
 */
public class MenuConfig extends javax.swing.JFrame {

    private static Component popup;
    /**
     * Creates new form MenuConfig
     * @param menu
     * @param settings
     * @param ingredients
     */
    public MenuConfig(ArrayList<Meal> menu,Settings settings, ArrayList<String> ingredients) {
        setDefaultCloseOperation(MenuConfig.EXIT_ON_CLOSE);
        try {
            Image image = new ImageIcon("icon.png").getImage();
            this.setIconImage(image);
        } catch(Exception ex){
            JOptionPane.showMessageDialog(popup, "Application icon not found!");
        }
        initComponents();
        this.setTitle("Dinner Menu");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setResizable(false);
        
        //Initialize variables
        this.settings = settings;
        this.menu = menu;
        this.ingredients = ingredients;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        monday_label = new javax.swing.JLabel();
        tuesday_label = new javax.swing.JLabel();
        wednesday_label = new javax.swing.JLabel();
        thursday_label = new javax.swing.JLabel();
        friday_label = new javax.swing.JLabel();
        saturday_label = new javax.swing.JLabel();
        sunday_label = new javax.swing.JLabel();
        quick_label = new javax.swing.JLabel();
        special_label = new javax.swing.JLabel();
        eating_out_label = new javax.swing.JLabel();
        fast_sunday_label = new javax.swing.JLabel();
        special_monday_check = new javax.swing.JCheckBox();
        eatout_monday_check = new javax.swing.JCheckBox();
        quick_monday_check = new javax.swing.JCheckBox();
        special_tuesday_check = new javax.swing.JCheckBox();
        eatout_tuesday_check = new javax.swing.JCheckBox();
        quick_tuesday_check = new javax.swing.JCheckBox();
        special_wednesday_check = new javax.swing.JCheckBox();
        eatout_wednesday_check = new javax.swing.JCheckBox();
        quick_wednesday_check = new javax.swing.JCheckBox();
        special_thursday_check = new javax.swing.JCheckBox();
        eatout_thursday_check = new javax.swing.JCheckBox();
        quick_thursday_check = new javax.swing.JCheckBox();
        special_friday_check = new javax.swing.JCheckBox();
        eatout_friday_check = new javax.swing.JCheckBox();
        quick_friday_check = new javax.swing.JCheckBox();
        special_saturday_check = new javax.swing.JCheckBox();
        eatout_saturday_check = new javax.swing.JCheckBox();
        quick_saturday_check = new javax.swing.JCheckBox();
        special_sunday_check = new javax.swing.JCheckBox();
        eatout_sunday_check = new javax.swing.JCheckBox();
        quick_sunday_check = new javax.swing.JCheckBox();
        fast_sunday_check = new javax.swing.JCheckBox();
        continue_button = new javax.swing.JButton();
        back_button = new javax.swing.JButton();
        large_monday_check = new javax.swing.JCheckBox();
        large_tuesday_check = new javax.swing.JCheckBox();
        large_wednesday_check = new javax.swing.JCheckBox();
        large_thursday_check = new javax.swing.JCheckBox();
        large_friday_check = new javax.swing.JCheckBox();
        large_saturday_check = new javax.swing.JCheckBox();
        eating_out_label1 = new javax.swing.JLabel();
        large_sunday_check = new javax.swing.JCheckBox();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        monday_label.setText("Monday");

        tuesday_label.setText("Tuesday");

        wednesday_label.setText("Wednesday");

        thursday_label.setText("Thursday");

        friday_label.setText("Friday");

        saturday_label.setText("Saturday");

        sunday_label.setText("Sunday");

        quick_label.setText("Quick");

        special_label.setText("Special");

        eating_out_label.setText("Eating out");

        fast_sunday_label.setText("Fast Sunday");

        continue_button.setText("Continue");
        continue_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continue_buttonActionPerformed(evt);
            }
        });

        back_button.setText("Back");
        back_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                back_buttonActionPerformed(evt);
            }
        });

        eating_out_label1.setText("Large");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(fast_sunday_label)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fast_sunday_check)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                        .addComponent(back_button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(continue_button))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(wednesday_label)
                                            .addGap(106, 106, 106))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(tuesday_label)
                                            .addGap(106, 106, 106))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(monday_label)
                                            .addGap(105, 105, 105)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(sunday_label)
                                                .addGap(106, 106, 106))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(saturday_label)
                                                .addGap(106, 106, 106))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(friday_label)
                                                .addGap(106, 106, 106))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(thursday_label)
                                                .addGap(106, 106, 106))))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(quick_wednesday_check)
                                                    .addGap(19, 19, 19)
                                                    .addComponent(special_wednesday_check))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(quick_tuesday_check)
                                                    .addGap(19, 19, 19)
                                                    .addComponent(special_tuesday_check))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addGap(1, 1, 1)
                                                    .addComponent(quick_monday_check)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(special_monday_check)))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(quick_sunday_check)
                                                    .addGap(19, 19, 19)
                                                    .addComponent(special_sunday_check))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(quick_saturday_check)
                                                    .addGap(19, 19, 19)
                                                    .addComponent(special_saturday_check))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(quick_friday_check)
                                                    .addGap(19, 19, 19)
                                                    .addComponent(special_friday_check))
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(quick_thursday_check)
                                                    .addGap(19, 19, 19)
                                                    .addComponent(special_thursday_check)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(quick_label)
                                        .addGap(18, 18, 18)
                                        .addComponent(special_label)))
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(large_wednesday_check)
                                .addComponent(large_tuesday_check, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(large_monday_check, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(large_sunday_check)
                                .addComponent(large_saturday_check)
                                .addComponent(large_friday_check)
                                .addComponent(large_thursday_check))
                            .addComponent(eating_out_label1))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(eatout_wednesday_check)
                                        .addComponent(eatout_tuesday_check, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(eatout_monday_check, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(eatout_sunday_check)
                                        .addComponent(eatout_saturday_check)
                                        .addComponent(eatout_friday_check)
                                        .addComponent(eatout_thursday_check))))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(eating_out_label)))
                        .addGap(15, 15, 15)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(monday_label)
                        .addGap(25, 25, 25)
                        .addComponent(tuesday_label)
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(thursday_label)
                                .addGap(25, 25, 25)
                                .addComponent(friday_label)
                                .addGap(22, 22, 22)
                                .addComponent(saturday_label)
                                .addGap(25, 25, 25)
                                .addComponent(sunday_label))
                            .addComponent(wednesday_label)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(eating_out_label)
                            .addComponent(eating_out_label1)
                            .addComponent(special_label)
                            .addComponent(quick_label))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(eatout_monday_check)
                                .addGap(18, 18, 18)
                                .addComponent(eatout_tuesday_check)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(eatout_thursday_check)
                                        .addGap(18, 18, 18)
                                        .addComponent(eatout_friday_check)
                                        .addGap(15, 15, 15)
                                        .addComponent(eatout_saturday_check)
                                        .addGap(18, 18, 18)
                                        .addComponent(eatout_sunday_check))
                                    .addComponent(eatout_wednesday_check)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(quick_monday_check)
                                    .addComponent(special_monday_check))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(quick_tuesday_check)
                                    .addComponent(special_tuesday_check))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(quick_thursday_check)
                                            .addComponent(special_thursday_check))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(quick_friday_check)
                                            .addComponent(special_friday_check))
                                        .addGap(15, 15, 15)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(quick_saturday_check)
                                            .addComponent(special_saturday_check))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(quick_sunday_check)
                                            .addComponent(special_sunday_check)))
                                    .addComponent(quick_wednesday_check)
                                    .addComponent(special_wednesday_check)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(large_monday_check)
                        .addGap(18, 18, 18)
                        .addComponent(large_tuesday_check)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addComponent(large_thursday_check)
                                .addGap(18, 18, 18)
                                .addComponent(large_friday_check)
                                .addGap(15, 15, 15)
                                .addComponent(large_saturday_check)
                                .addGap(18, 18, 18)
                                .addComponent(large_sunday_check))
                            .addComponent(large_wednesday_check))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fast_sunday_check, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(continue_button)
                        .addComponent(back_button))
                    .addComponent(fast_sunday_label, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void back_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_back_buttonActionPerformed
        dispose();
        InitialMenu next_window;
        try {
            next_window = new InitialMenu();
            next_window.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(MenuConfig.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_back_buttonActionPerformed

    private void continue_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continue_buttonActionPerformed
        boolean[] eatout_meals = assign_eatout_meals();
        boolean[] quick_meals = assign_quick_meals();
        boolean[] special_meals = assign_special_meals();
        boolean[] large_meals = assign_large_meals();
        boolean fast_sunday = fast_sunday_check.isSelected();
        
        //Store menu configuration
        dispose();
        MenuGeneration next_window;
        next_window = new MenuGeneration(menu,settings,eatout_meals,quick_meals,special_meals,large_meals,fast_sunday,ingredients);
        next_window.setVisible(true);
    }//GEN-LAST:event_continue_buttonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton back_button;
    private javax.swing.JButton continue_button;
    private javax.swing.JLabel eating_out_label;
    private javax.swing.JLabel eating_out_label1;
    private javax.swing.JCheckBox eatout_friday_check;
    private javax.swing.JCheckBox eatout_monday_check;
    private javax.swing.JCheckBox eatout_saturday_check;
    private javax.swing.JCheckBox eatout_sunday_check;
    private javax.swing.JCheckBox eatout_thursday_check;
    private javax.swing.JCheckBox eatout_tuesday_check;
    private javax.swing.JCheckBox eatout_wednesday_check;
    private javax.swing.JCheckBox fast_sunday_check;
    private javax.swing.JLabel fast_sunday_label;
    private javax.swing.JLabel friday_label;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JCheckBox large_friday_check;
    private javax.swing.JCheckBox large_monday_check;
    private javax.swing.JCheckBox large_saturday_check;
    private javax.swing.JCheckBox large_sunday_check;
    private javax.swing.JCheckBox large_thursday_check;
    private javax.swing.JCheckBox large_tuesday_check;
    private javax.swing.JCheckBox large_wednesday_check;
    private javax.swing.JLabel monday_label;
    private javax.swing.JCheckBox quick_friday_check;
    private javax.swing.JLabel quick_label;
    private javax.swing.JCheckBox quick_monday_check;
    private javax.swing.JCheckBox quick_saturday_check;
    private javax.swing.JCheckBox quick_sunday_check;
    private javax.swing.JCheckBox quick_thursday_check;
    private javax.swing.JCheckBox quick_tuesday_check;
    private javax.swing.JCheckBox quick_wednesday_check;
    private javax.swing.JLabel saturday_label;
    private javax.swing.JCheckBox special_friday_check;
    private javax.swing.JLabel special_label;
    private javax.swing.JCheckBox special_monday_check;
    private javax.swing.JCheckBox special_saturday_check;
    private javax.swing.JCheckBox special_sunday_check;
    private javax.swing.JCheckBox special_thursday_check;
    private javax.swing.JCheckBox special_tuesday_check;
    private javax.swing.JCheckBox special_wednesday_check;
    private javax.swing.JLabel sunday_label;
    private javax.swing.JLabel thursday_label;
    private javax.swing.JLabel tuesday_label;
    private javax.swing.JLabel wednesday_label;
    // End of variables declaration//GEN-END:variables
    private Settings settings;
    private ArrayList<Meal> menu;
    private ArrayList<String> ingredients;
    
    public boolean[] assign_eatout_meals() {
        boolean[] eatout_meals = new boolean[7];
        eatout_meals[0] = eatout_monday_check.isSelected();
        eatout_meals[1] = eatout_tuesday_check.isSelected();
        eatout_meals[2] = eatout_wednesday_check.isSelected();
        eatout_meals[3] = eatout_thursday_check.isSelected();
        eatout_meals[4] = eatout_friday_check.isSelected();
        eatout_meals[5] = eatout_saturday_check.isSelected();
        eatout_meals[6] = eatout_sunday_check.isSelected();
        return eatout_meals;
    }
    
    public boolean[] assign_quick_meals() {
        boolean[] quick_meals = new boolean[7];
        quick_meals[0] = quick_monday_check.isSelected();
        quick_meals[1] = quick_tuesday_check.isSelected();
        quick_meals[2] = quick_wednesday_check.isSelected();
        quick_meals[3] = quick_thursday_check.isSelected();
        quick_meals[4] = quick_friday_check.isSelected();
        quick_meals[5] = quick_saturday_check.isSelected();
        quick_meals[6] = quick_sunday_check.isSelected();
        return quick_meals;
    }
    
    public boolean[] assign_special_meals() {
        boolean[] special_meals = new boolean[7];
        special_meals[0] = special_monday_check.isSelected();
        special_meals[1] = special_tuesday_check.isSelected();
        special_meals[2] = special_wednesday_check.isSelected();
        special_meals[3] = special_thursday_check.isSelected();
        special_meals[4] = special_friday_check.isSelected();
        special_meals[5] = special_saturday_check.isSelected();
        special_meals[6] = special_sunday_check.isSelected();
        return special_meals;
    }
    
    public boolean[] assign_large_meals() {
        boolean[] large_meals = new boolean[7];
        large_meals[0] = large_monday_check.isSelected();
        large_meals[1] = large_tuesday_check.isSelected();
        large_meals[2] = large_wednesday_check.isSelected();
        large_meals[3] = large_thursday_check.isSelected();
        large_meals[4] = large_friday_check.isSelected();
        large_meals[5] = large_saturday_check.isSelected();
        large_meals[6] = large_sunday_check.isSelected();
        return large_meals;
    }


}
