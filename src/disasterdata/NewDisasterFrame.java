package disasterdata;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class NewDisasterFrame extends javax.swing.JFrame {

    private int id;
    private final Database db;

    public NewDisasterFrame(Database db, int id) {
        initComponents();
        pack();
        this.db = db;
        this.id = id;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        endMonth = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        beginYear = new javax.swing.JComboBox<>();
        beginDay = new javax.swing.JComboBox<>();
        endYear = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        nameTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        beginMonth = new javax.swing.JComboBox<>();
        endDay = new javax.swing.JComboBox<>();
        finishedButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        severityTextField = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();

        setTitle("Add New Disaster");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        endMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Month", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        endMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endMonthActionPerformed(evt);
            }
        });

        jLabel5.setText("Severity");

        beginYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Year", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980" }));

        beginDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Day", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        beginDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beginDayActionPerformed(evt);
            }
        });

        endYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Year", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980" }));
        endYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                endYearActionPerformed(evt);
            }
        });

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hurricane", "Tornado", "Earthquake", "Volcano", "Epidemic", "Alien Invasion", "Avalanche", "Sinkhole", "Mudslide" }));

        jLabel1.setText("Type");

        beginMonth.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Month", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));

        endDay.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Day", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        finishedButton.setText("Cancel");
        finishedButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishedButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("End Date");

        jLabel2.setText("Begin Date");

        jLabel4.setText("Name");

        addButton.setText("Next");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(4, 4, 4)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jComboBox4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(severityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(beginMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(endMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(endDay, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(beginDay, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(endYear, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(beginYear, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(finishedButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(beginMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(beginDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(beginYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(endMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endDay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(severityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(finishedButton)
                    .addComponent(addButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed

        try {
            //todo verification
            if (beginMonth.getSelectedIndex() <= 0 || beginDay.getSelectedIndex() <= 0 || beginYear.getSelectedIndex() <= 0 || endMonth.getSelectedIndex() <= 0 || endDay.getSelectedIndex() <= 0 || endYear.getSelectedIndex() <= 0) {
                JOptionPane.showMessageDialog(this, "You must select valid dates!");
                return;
            }

            String name = nameTextField.getText();
            String type = jComboBox4.getSelectedItem().toString();
            String begDate = beginYear.getSelectedItem().toString() + "-" + beginMonth.getSelectedItem().toString() + "-" + beginDay.getSelectedItem().toString();
            String endDate = endYear.getSelectedItem().toString() + "-" + endMonth.getSelectedItem().toString() + "-" + endDay.getSelectedItem().toString();
            String severity = severityTextField.getText();

            boolean error = false;
            if (name.equals("")) {
                error = true;
            }
            if (type.equals("")) {
                error = true;
            }
            if (severity.equals("")) {
                error = true;
            }

            if (error) {
                JOptionPane.showMessageDialog(this, "Fields cannot be left empty!");
                return;
            }

            if (db.execute("INSERT INTO `disaster` (`name`, `type`, `date_begin`, `date_end`, `severity`) VALUES ('" + name + "', '" + type + "', '" + begDate + "', '" + endDate + "', '" + severity + "');")) {
                JOptionPane.showMessageDialog(this, "Successfully added disaster!");
            }

            ResultSet rs = db.query("SELECT last_insert_id() AS id FROM disaster");
            rs.next();
            id = rs.getInt("id");

            AffectedCounties af = new AffectedCounties(db, id);
            af.setVisible(true);
            setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(NewDisasterFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_addButtonActionPerformed

    private void endYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_endYearActionPerformed

    private void finishedButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishedButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_finishedButtonActionPerformed

    private void endMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_endMonthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_endMonthActionPerformed

    private void beginDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beginDayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_beginDayActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JComboBox<String> beginDay;
    private javax.swing.JComboBox<String> beginMonth;
    private javax.swing.JComboBox<String> beginYear;
    private javax.swing.JComboBox<String> endDay;
    private javax.swing.JComboBox<String> endMonth;
    private javax.swing.JComboBox<String> endYear;
    private javax.swing.JButton finishedButton;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTextField severityTextField;
    // End of variables declaration//GEN-END:variables
}
