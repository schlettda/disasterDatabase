package disasterdata;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class ViewFrame extends javax.swing.JFrame {

    private HashMap<String, String> queries;
    private final Database db;
    private int id;
    HashMap<String, Integer> list;

    public ViewFrame(Database db, int id) {
        initComponents();
        this.db = db;
        this.id = id;
        queries = new HashMap<>();
        loadDisasters();
        pack();
        System.out.println(id);
        int index = 0;
        for (Entry<String, Integer> entry : list.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
            if (entry.getValue() == id) {

                disaster_dropdown.setSelectedItem(entry.getKey());
                break;
            }
            index++;
        }
        setupQueries();
    }

    private void setupQueries() {
        System.out.println("setup");
        queryComboBox.removeAllItems();

        queries.put("Disaster workers without salary", "SELECT * FROM `person` JOIN `disaster_worker` ON `person`.`ssn`=`disaster_worker`.`ssn` WHERE `disaster_id`='" + id + "' AND `salary`=0;");
        queries.put("People who's age is > 18", "SELECT * FROM `person` WHERE `disaster_id`='" + id + "' AND `age`>18;");
        queries.put("People who's age is < 18", "SELECT * FROM `person` WHERE `disaster_id`='" + id + "' AND `age`<18;");
        queries.put("Disasters", "SELECT * FROM `disaster`;");
        queries.put("Affected Counties For Selection", "SELECT * FROM `affected_county` WHERE `disaster_id`='" + id + "';");
        queries.put("Civilians Involved", "SELECT * FROM `person` JOIN `civilian` ON `person`.`ssn`=`civilian`.`ssn` WHERE `disaster_id`='" + id + "';");
        queries.put("Workers Involved", "SELECT * FROM `person` JOIN `disaster_worker` ON `person`.`ssn`=`disaster_worker`.`ssn` WHERE `disaster_id`='" + id + "';");
        queries.put("Medical Centers Utilized", "SELECT * FROM `medical_center` WHERE `disaster_id`='" + id + "';");

        /*
        TODO
        Total number of damages
        Most affected county
        Total deceased
         */
        queries.entrySet().stream().forEach((query) -> {
            queryComboBox.addItem(query.getKey());
        });

    }

    private void loadDisasters() {
        try {
            ResultSet disasterSet = db.query("SELECT `id`, `name` FROM `disaster`;");

            list = new HashMap<>();
            disaster_dropdown.removeAllItems();
            while (disasterSet.next()) {
                list.put(disasterSet.getString("name"), disasterSet.getInt("id"));

                disaster_dropdown.addItem(disasterSet.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Welcome_Page.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setupTable(ResultSet rs) throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();

        Vector<String> columnNames = new Vector<>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        Vector<Vector<Object>> data = new Vector<>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }
        jTable1.setModel(new DefaultTableModel(data, columnNames));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        disaster_dropdown = new javax.swing.JComboBox<>();
        queryComboBox = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setTitle("View Data");

        jLabel1.setText("Disaster");

        jLabel2.setText("Query");

        disaster_dropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disaster_dropdownActionPerformed(evt);
            }
        });

        queryComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                queryComboBoxActionPerformed(evt);
            }
        });

        jButton1.setText("Execute");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Finished");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable1.setColumnSelectionAllowed(true);
        jScrollPane3.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(queryComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(disaster_dropdown, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 438, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(disaster_dropdown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(queryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            String query = queries.get(queryComboBox.getSelectedItem().toString());
            ResultSet res = db.query(query);

            setupTable(res);
        } catch (SQLException ex) {
            Logger.getLogger(ViewFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void queryComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_queryComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_queryComboBoxActionPerformed

    private void disaster_dropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disaster_dropdownActionPerformed
        id = list.get(disaster_dropdown.getSelectedItem().toString());
        setupQueries();
    }//GEN-LAST:event_disaster_dropdownActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> disaster_dropdown;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JComboBox<String> queryComboBox;
    // End of variables declaration//GEN-END:variables
}
