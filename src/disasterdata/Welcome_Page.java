package disasterdata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Welcome_Page extends javax.swing.JFrame {

    private final Database db;
    private HashMap<String, Integer> list;
    private int id;

    public Welcome_Page(Database db) {
        initComponents();
        this.db = db;
        loadDisasters();
    }

    public int getDisasterID() {
        return id;
    }

    private void loadDisasters() {
        System.out.println("test");
        try {
            ResultSet disasterSet = db.query("SELECT `id`, `name` FROM `disaster`;");

            list = new HashMap<>();
            //disaster_dropdown.removeAllItems();
            while (disasterSet.next()) {
                list.put(disasterSet.getString("name"), disasterSet.getInt("id"));

                disaster_dropdown.addItem(disasterSet.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Welcome_Page.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        disaster_dropdown = new javax.swing.JComboBox<>();
        welcome_message = new javax.swing.JLabel();
        search_disaster = new javax.swing.JLabel();
        modify_data_button = new javax.swing.JButton();
        view_data_button = new javax.swing.JButton();
        addNewButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Welcome  to DisasterData");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        disaster_dropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disaster_dropdownActionPerformed(evt);
            }
        });

        welcome_message.setText("WELCOME");

        search_disaster.setText("Select Disaster");

        modify_data_button.setText("Modify Data");
        modify_data_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modify_data_buttonActionPerformed(evt);
            }
        });

        view_data_button.setText("View Data");
        view_data_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_data_buttonActionPerformed(evt);
            }
        });

        addNewButton.setText("Add New");
        addNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addNewButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(welcome_message))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(search_disaster)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(disaster_dropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(view_data_button, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addNewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(modify_data_button)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(welcome_message)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(disaster_dropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search_disaster)
                    .addComponent(addNewButton)
                    .addComponent(modify_data_button))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(view_data_button)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void view_data_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_data_buttonActionPerformed

        String s = (String) disaster_dropdown.getSelectedItem();
        int did = list.get(s);
        ViewFrame viewFrame = new ViewFrame(db, did);
        viewFrame.setVisible(true);
    }//GEN-LAST:event_view_data_buttonActionPerformed

    private void modify_data_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modify_data_buttonActionPerformed
        Modify modify = new Modify(db, id);
        modify.setVisible(true);
        modify.loadDisasterDropdown();
    }//GEN-LAST:event_modify_data_buttonActionPerformed

    private void disaster_dropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disaster_dropdownActionPerformed
        //id = (int)disaster_dropdown.getSelectedItem();
    }//GEN-LAST:event_disaster_dropdownActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void addNewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addNewButtonActionPerformed
        NewDisasterFrame newDisasterFrame = new NewDisasterFrame(db, id);
        newDisasterFrame.setVisible(true);

    }//GEN-LAST:event_addNewButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addNewButton;
    private javax.swing.JComboBox<String> disaster_dropdown;
    private javax.swing.JButton modify_data_button;
    private javax.swing.JLabel search_disaster;
    private javax.swing.JButton view_data_button;
    private javax.swing.JLabel welcome_message;
    // End of variables declaration//GEN-END:variables
}
