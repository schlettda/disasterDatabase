package disasterdata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jalaws1s
 */
public class PropertyFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    private final Database db;
    private final int id;
    private HashMap<String, Integer> list;

    public PropertyFrame(Database db, int id) {
        initComponents();
        this.db = db;
        this.id = id;
        loadPeople(id);
    }

    public void loadPeople(int disaster) {
        try {
            ResultSet disasterSet = db.query("SELECT `person`.`name`, `civilian`.`ssn` FROM `person`, `civilian` WHERE `person`.`ssn`=`civilian`.`ssn` AND `disaster_id`=" + id + ";");

            list = new HashMap<>();
            while (disasterSet.next()) {
                list.put(disasterSet.getString("name"), disasterSet.getInt("ssn"));
                owner_dropdown.addItem(disasterSet.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Welcome_Page.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        value_field = new javax.swing.JTextField();
        damage_field1 = new javax.swing.JTextField();
        type_dropdown = new javax.swing.JComboBox<>();
        owner_dropdown = new javax.swing.JComboBox<>();
        add_btn = new javax.swing.JButton();
        finished_btn = new javax.swing.JButton();

        setTitle("Add Property");

        jLabel1.setText("Damage");

        jLabel2.setText("Value");

        jLabel3.setText("Type");

        jLabel4.setText("Owner");

        type_dropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Animal", "Land", "Home", "Vehicle", "Toy", "Tool" }));
        type_dropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                type_dropdownActionPerformed(evt);
            }
        });

        add_btn.setText("Add");
        add_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_btnActionPerformed(evt);
            }
        });

        finished_btn.setText("Finished");
        finished_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finished_btnActionPerformed(evt);
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
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(damage_field1)
                            .addComponent(value_field)
                            .addComponent(type_dropdown, 0, 177, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(owner_dropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(add_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(finished_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(damage_field1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(value_field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(type_dropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(owner_dropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(add_btn)
                    .addComponent(finished_btn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void type_dropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_type_dropdownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_type_dropdownActionPerformed

    private void add_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_btnActionPerformed

        boolean error = false;

        if (damage_field1.getText().equals("")) {
            error = true;
        }
        if (value_field.getText().equals("")) {
            error = true;
        }
        if (type_dropdown.getSelectedItem().toString().equals("")) {
            error = true;
        }
        if (owner_dropdown.getSelectedItem().equals("")) {
            error = true;
        }

        if (error) {
            JOptionPane.showMessageDialog(this, "Fields cannot be left empty!");
            return;
        }

        boolean number = true;

        try {
            Integer.parseInt(value_field.getText());
        } catch (NumberFormatException e) {
            number = false;
        }

        if (!number) {
            JOptionPane.showMessageDialog(this, "Value must be a number!");
            return;
        }

        String damage = damage_field1.getText();
        int value = Integer.parseInt(value_field.getText());
        String type = type_dropdown.getSelectedItem().toString();
        int ownerssn = list.get(owner_dropdown.getSelectedItem().toString());

        if (db.execute("INSERT INTO `property` (`owner_ssn`, `type`, `damage`, `value`, `disaster_id`) VALUES ('" + ownerssn + "', '" + type + "', '" + damage + "', '" + value + "', '" + id + "')")) {
            JOptionPane.showMessageDialog(this, "Successfully added disaster worker!");
        }

    }//GEN-LAST:event_add_btnActionPerformed

    private void finished_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finished_btnActionPerformed
        setVisible(false);
    }//GEN-LAST:event_finished_btnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add_btn;
    private javax.swing.JTextField damage_field1;
    private javax.swing.JButton finished_btn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox<String> owner_dropdown;
    private javax.swing.JComboBox<String> type_dropdown;
    private javax.swing.JTextField value_field;
    // End of variables declaration//GEN-END:variables
}
