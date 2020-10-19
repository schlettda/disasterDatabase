package disasterdata;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jalaws1s
 */
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Modify extends javax.swing.JFrame {

    /**
     * Creates new form Modify
     */
    private final int id;
    private final HashMap<String, Integer> counties;
    private final HashMap<String, Integer> counties2;
    private final HashMap<String, Integer> medicalCenters;
    private final HashMap<String, Integer> disasterWorkers;
    private final HashMap<String, Integer> civilians;
    private final HashMap<String, Integer> organizations;
    private final HashMap<String, Integer> organizations2;
    private final HashMap<String, Integer> disasters;
    private final HashMap<String, Integer> properties;
    private final HashMap<String, Integer> disasters2;
    private final HashMap<String, Integer> properties2;
    private final HashMap<String, Integer> disasters3;
    private final Database db;

    public Modify(Database db, int id) {
        initComponents();
        this.db = db;
        this.id = id;
        counties = new HashMap<>();
        medicalCenters = new HashMap<>();
        disasterWorkers = new HashMap<>();
        organizations = new HashMap<>();
        properties = new HashMap<>();
        disasters = new HashMap<>();
        civilians = new HashMap<>();
        disasters2 = new HashMap<>();
        counties2 = new HashMap<>();
        organizations2 = new HashMap<>();
        properties2 = new HashMap<>();
        disasters3 = new HashMap<>();
    }

    public int getDisasterID() {
        return id;
    }

    public void loadAffectedCounties() {
        county_id_dropdown.removeAllItems();
        try {

            counties.clear();
            ResultSet disasterSet2 = db.query("Select `id`, `name` FROM `affected_county`;");
            while (disasterSet2.next()) {
                counties.put(disasterSet2.getString("name"), disasterSet2.getInt("id"));
                county_id_dropdown.addItem(disasterSet2.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadAffectedCounties2() {
        id_dropdown.removeAllItems();
        try {

            counties2.clear();
            ResultSet disasterSet2 = db.query("Select `id`, `name` FROM `affected_county`;");
            while (disasterSet2.next()) {
                counties2.put(disasterSet2.getString("name"), disasterSet2.getInt("id"));
                id_dropdown.addItem(disasterSet2.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadMedicalCenters() {
        id_dropdown.removeAllItems();
        try {

            medicalCenters.clear();
            ResultSet disasterSet3 = db.query("Select `id`, `address` FROM `medical_center`;");
            while (disasterSet3.next()) {
                medicalCenters.put(disasterSet3.getString("address"), disasterSet3.getInt("id"));
                id_dropdown.addItem(disasterSet3.getString("address"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadDisasterWorkers() {
        id_dropdown.removeAllItems();
        try {

            disasterWorkers.clear();
            ResultSet disasterSet2 = db.query("SELECT `disaster_worker`.`employee_id`, `person`.`name` FROM disaster_worker, person WHERE `disaster_worker`.`ssn`=`person`.`ssn`;");
            while (disasterSet2.next()) {
                disasterWorkers.put(disasterSet2.getString("name"), disasterSet2.getInt("employee_id"));
                id_dropdown.addItem(disasterSet2.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void loadCivilians() {
        id_dropdown.removeAllItems();
        try {
            civilians.clear();
            ResultSet disasterSet2 = db.query("SELECT `civilian`.`ssn`, `person`.`name` FROM civilian, person WHERE `civilian`.`ssn` = `person`.`ssn`;");
            while (disasterSet2.next()) {
                civilians.put(disasterSet2.getString("name"), disasterSet2.getInt("ssn"));
                id_dropdown.addItem(disasterSet2.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadProperties2() {
        owner_ssn_dropdown.removeAllItems();
        try {

            properties2.clear();
            ResultSet disasterSet2 = db.query("Select `person`.`name`, `civilian`.`ssn` FROM person, civilian WHERE `civilian`.`ssn` = `person`.`ssn`;");
            while (disasterSet2.next()) {
                properties2.put(disasterSet2.getString("name"), disasterSet2.getInt("ssn"));
                owner_ssn_dropdown.addItem(disasterSet2.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadDisasterOrgs() {
        id_dropdown.removeAllItems();
        try {

            organizations.clear();
            ResultSet disasterSet2 = db.query("Select `id`, `name` FROM `disaster_org`;");
            while (disasterSet2.next()) {
                organizations.put(disasterSet2.getString("name"), disasterSet2.getInt("id"));
                id_dropdown.addItem(disasterSet2.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadDisasterOrgs2() {
        org_id_dropdown.removeAllItems();
        try {

            organizations2.clear();
            ResultSet disasterSet2 = db.query("Select `id`, `name` FROM `disaster_org`;");
            while (disasterSet2.next()) {
                organizations2.put(disasterSet2.getString("name"), disasterSet2.getInt("id"));
                org_id_dropdown.addItem(disasterSet2.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadProperties() {

        id_dropdown.removeAllItems();
        try {

            properties.clear();
            ResultSet disasterSet2 = db.query("Select `id`, `type` FROM `property`;");
            while (disasterSet2.next()) {
                properties.put(disasterSet2.getString("type"), disasterSet2.getInt("id"));
                id_dropdown.addItem(disasterSet2.getString("type"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadDisasters() {
        id_dropdown.removeAllItems();
        try {

            disasters.clear();
            ResultSet disasterSet2 = db.query("Select `id`, `name` FROM `disaster`;");
            while (disasterSet2.next()) {
                disasters.put(disasterSet2.getString("name"), disasterSet2.getInt("id"));
                id_dropdown.addItem(disasterSet2.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadDisasters3() {
        type_dropdown.removeAllItems();
        try {

            disasters3.clear();
            ResultSet disasterSet2 = db.query("Select `id`, `type` FROM `disaster`;");
            while (disasterSet2.next()) {
                disasters3.put(disasterSet2.getString("type"), disasterSet2.getInt("id"));
                type_dropdown.addItem(disasterSet2.getString("type"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadDisasterDropdown() {
        disaster_dropdown.removeAllItems();
        try {

            disasters2.clear();
            ResultSet disasterSet2 = db.query("Select `id`, `name` FROM `disaster`;");
            while (disasterSet2.next()) {
                disasters2.put(disasterSet2.getString("name"), disasterSet2.getInt("id"));
                disaster_dropdown.addItem(disasterSet2.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, null, ex);
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        disaster_label = new javax.swing.JLabel();
        disaster_dropdown = new javax.swing.JComboBox<>();
        select_table_label = new javax.swing.JLabel();
        select_table_dropdown = new javax.swing.JComboBox<>();
        id_label = new javax.swing.JLabel();
        id_dropdown = new javax.swing.JComboBox<>();
        name_label = new javax.swing.JLabel();
        name_textField = new javax.swing.JTextField();
        damages_label = new javax.swing.JLabel();
        damages_textField = new javax.swing.JTextField();
        capacity_label = new javax.swing.JLabel();
        capacity_textField = new javax.swing.JTextField();
        phone_label = new javax.swing.JLabel();
        phone_textField = new javax.swing.JTextField();
        address_label = new javax.swing.JLabel();
        address_textField = new javax.swing.JTextField();
        isTemp_label = new javax.swing.JLabel();
        isTemp_true = new javax.swing.JRadioButton();
        isTemp_false = new javax.swing.JRadioButton();
        county_id_label = new javax.swing.JLabel();
        county_id_dropdown = new javax.swing.JComboBox<>();
        salary_label = new javax.swing.JLabel();
        salary_textField = new javax.swing.JTextField();
        ssn_label = new javax.swing.JLabel();
        ssn_textField = new javax.swing.JTextField();
        position_label = new javax.swing.JLabel();
        position_textField = new javax.swing.JTextField();
        age_label = new javax.swing.JLabel();
        age_textField = new javax.swing.JTextField();
        sex_label = new javax.swing.JLabel();
        sex_dropdown = new javax.swing.JComboBox<>();
        status_label = new javax.swing.JLabel();
        status_dropdown = new javax.swing.JComboBox<>();
        last_location_label = new javax.swing.JLabel();
        last_location_textField = new javax.swing.JTextField();
        damage_label = new javax.swing.JLabel();
        damage_textField = new javax.swing.JTextField();
        value_label = new javax.swing.JLabel();
        value_textField = new javax.swing.JTextField();
        type_label = new javax.swing.JLabel();
        type_dropdown = new javax.swing.JComboBox<>();
        owner_ssn_label = new javax.swing.JLabel();
        owner_ssn_dropdown = new javax.swing.JComboBox<>();
        start_date_label = new javax.swing.JLabel();
        start_date_textField = new javax.swing.JTextField();
        end_date_label = new javax.swing.JLabel();
        end_date_textField = new javax.swing.JTextField();
        severity_label = new javax.swing.JLabel();
        severity_textField = new javax.swing.JTextField();
        add_button = new javax.swing.JButton();
        remove_button = new javax.swing.JButton();
        change_button = new javax.swing.JButton();
        finished_button = new javax.swing.JButton();
        org_id_label = new javax.swing.JLabel();
        org_id_dropdown = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.HIDE_ON_CLOSE);
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 1000, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGap(0, 500, Short.MAX_VALUE)
        );
        //getContentPane().setLayout(null);

        disaster_label.setText("Disaster");
        getContentPane().add(disaster_label);
        disaster_label.setBounds(32, 40, 70, 14);
        disaster_dropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Item 1", "Item 2", "Item 3", "Item 4"}));
        getContentPane().add(disaster_dropdown);
        disaster_dropdown.setBounds(130, 37, 200, 20);

        select_table_label.setText("Select Table");
        getContentPane().add(select_table_label);
        select_table_label.setBounds(32, 79, 70, 14);
        //select_table_label.setVisible(false);

        select_table_dropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"<select one>", "AFFECTED_COUNTY", "MEDICAL_CENTER", "DISASTER_WORKER", "CIVILIAN", "DISASTER_ORG", "PROPERTY", "DISASTER"}));
        select_table_dropdown.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                select_table_dropdownActionPerformed(e);
            }
        });
        getContentPane().add(select_table_dropdown);
        select_table_dropdown.setBounds(130, 76, 200, 20);
        //select_table_dropdown.setVisible(false);

        id_label.setText("Item");
        getContentPane().add(id_label);
        id_label.setBounds(64, 180, 70, 14);
        id_label.setVisible(false);

        id_dropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{}));
        getContentPane().add(id_dropdown);
        id_dropdown.setBounds(130, 177, 199, 20);
        id_dropdown.setVisible(false);

        id_dropdown.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                id_dropdownActionPerformed(e);
            }
        });

        name_label.setText("Name");
        getContentPane().add(name_label);
        name_label.setBounds(50, 220, 70, 14);
        getContentPane().add(name_textField);
        name_textField.setBounds(130, 220, 199, 20);
        name_label.setVisible(false);
        name_textField.setVisible(false);

        name_textField.addActionListener((java.awt.event.ActionEvent evt) -> {
            name_textFieldActionPerformed(evt);
        });

        damages_label.setText("Damages");
        getContentPane().add(damages_label);
        damages_label.setBounds(30, 260, 70, 14);
        getContentPane().add(damages_textField);
        damages_textField.setBounds(130, 260, 199, 20);
        damages_label.setVisible(false);
        damages_textField.setVisible(false);

        damages_textField.addActionListener((java.awt.event.ActionEvent evt) -> {
            damages_textFieldActionPerformed(evt);
        });

        capacity_label.setText("Capacity");
        getContentPane().add(capacity_label);
        capacity_label.setBounds(30, 220, 70, 14);
        getContentPane().add(capacity_textField);
        capacity_textField.setBounds(130, 220, 200, 20);
        capacity_label.setVisible(false);
        capacity_textField.setVisible(false);

        capacity_textField.addActionListener((java.awt.event.ActionEvent evt) -> {
            capacity_textFieldActionPerformed(evt);
        });

        phone_label.setText("Phone");
        getContentPane().add(phone_label);
        phone_label.setBounds(40, 260, 70, 14);
        getContentPane().add(phone_textField);
        phone_textField.setBounds(130, 260, 200, 20);
        phone_label.setVisible(false);
        phone_textField.setVisible(false);

        phone_textField.addActionListener((java.awt.event.ActionEvent evt) -> {
            phone_textFieldActionPerformed(evt);
        });

        address_label.setText("Address");
        getContentPane().add(address_label);
        address_label.setBounds(30, 300, 70, 14);
        getContentPane().add(address_textField);
        address_textField.setBounds(130, 300, 200, 20);
        address_label.setVisible(false);
        address_textField.setVisible(false);

        address_textField.addActionListener((java.awt.event.ActionEvent evt) -> {
            address_textFieldActionPerformed(evt);
        });

        isTemp_label.setText("Temporary");
        getContentPane().add(isTemp_label);
        isTemp_label.setBounds(20, 340, 70, 14);
        isTemp_label.setVisible(false);

        buttonGroup1.add(isTemp_true);
        isTemp_true.setText("True");
        getContentPane().add(isTemp_true);
        isTemp_true.setBounds(130, 340, 47, 23);
        isTemp_true.setVisible(false);

        isTemp_true.addActionListener((java.awt.event.ActionEvent evt) -> {
            isTemp_trueActionPerformed(evt);
        });

        buttonGroup1.add(isTemp_false);
        isTemp_false.setText("False");
        getContentPane().add(isTemp_false);
        isTemp_false.setBounds(210, 340, 93, 23);
        isTemp_false.setVisible(false);

        isTemp_false.addActionListener((java.awt.event.ActionEvent evt) -> {
            isTemp_falseActionPerformed(evt);
        });

        county_id_label.setText("County ID");
        getContentPane().add(county_id_label);
        county_id_label.setBounds(20, 380, 70, 14);
        county_id_label.setVisible(false);

        county_id_dropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{}));
        getContentPane().add(county_id_dropdown);
        county_id_dropdown.setBounds(130, 380, 200, 20);
        county_id_dropdown.setVisible(false);

        county_id_dropdown.addActionListener((java.awt.event.ActionEvent evt) -> {
            county_id_dropdownActionPerformed(evt);
        });

        salary_label.setText("Salary");
        getContentPane().add(salary_label);
        salary_label.setBounds(370, 180, 70, 14);
        getContentPane().add(salary_textField);
        salary_textField.setBounds(450, 180, 200, 20);
        salary_label.setVisible(false);
        salary_textField.setVisible(false);

        salary_textField.addActionListener((java.awt.event.ActionEvent evt) -> {
            salary_textFieldActionPerformed(evt);
        });

        ssn_label.setText("SSN");
        getContentPane().add(ssn_label);
        ssn_label.setBounds(50, 260, 70, 14);
        getContentPane().add(ssn_textField);
        ssn_textField.setBounds(130, 260, 200, 20);
        ssn_label.setVisible(false);
        ssn_textField.setVisible(false);
        ssn_textField.setEditable(true);

        ssn_textField.addActionListener((java.awt.event.ActionEvent evt) -> {
            ssn_textFieldActionPerformed(evt);
        });

        position_label.setText("Position");
        getContentPane().add(position_label);
        position_label.setBounds(30, 300, 70, 14);
        getContentPane().add(position_textField);
        position_textField.setBounds(130, 300, 200, 20);
        position_label.setVisible(false);
        position_textField.setVisible(false);

        position_textField.addActionListener((java.awt.event.ActionEvent evt) -> {
            position_textFieldActionPerformed(evt);
        });

        org_id_label.setText("Org ID");
        getContentPane().add(org_id_label);
        org_id_label.setBounds(40, 340, 70, 14);
        getContentPane().add(org_id_dropdown);
        org_id_dropdown.setBounds(130, 340, 200, 20);
        org_id_dropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{}));
        org_id_label.setVisible(false);
        org_id_dropdown.setVisible(false);

        age_label.setText("Age");
        getContentPane().add(age_label);
        age_label.setBounds(380, 220, 70, 14);
        getContentPane().add(age_textField);
        age_textField.setBounds(450, 220, 200, 20);
        age_label.setVisible(false);
        age_textField.setVisible(false);

        age_textField.addActionListener((java.awt.event.ActionEvent evt) -> {
            age_textFieldActionPerformed(evt);
        });

        sex_label.setText("Sex");
        getContentPane().add(sex_label);
        sex_label.setBounds(380, 260, 70, 14);
        sex_label.setVisible(false);

        sex_dropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Male", "Female", "Other"}));
        getContentPane().add(sex_dropdown);
        sex_dropdown.setBounds(450, 260, 200, 20);
        sex_dropdown.setVisible(false);

        sex_dropdown.addActionListener((java.awt.event.ActionEvent evt) -> {
            sex_dropdownActionPerformed(evt);
        });

        status_label.setText("Status");
        getContentPane().add(status_label);
        status_label.setBounds(370, 300, 70, 14);
        status_label.setVisible(false);

        status_dropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Alive", "Diseased", "Unknown", "Hospitalized"}));
        getContentPane().add(status_dropdown);
        status_dropdown.setBounds(450, 300, 200, 20);
        status_dropdown.setVisible(false);

        status_dropdown.addActionListener((java.awt.event.ActionEvent evt) -> {
            status_dropdownActionPerformed(evt);
        });

        last_location_label.setText("Last Location");
        getContentPane().add(last_location_label);
        last_location_label.setBounds(340, 340, 80, 14);
        getContentPane().add(last_location_textField);
        last_location_textField.setBounds(450, 340, 200, 20);
        last_location_label.setVisible(false);
        last_location_textField.setVisible(false);

        last_location_textField.addActionListener((java.awt.event.ActionEvent evt) -> {
            last_location_textFieldActionPerformed(evt);
        });

        damage_label.setText("Damage");
        getContentPane().add(damage_label);
        damage_label.setBounds(40, 220, 70, 14);
        getContentPane().add(damage_textField);
        damage_textField.setBounds(130, 220, 200, 20);
        damage_label.setVisible(false);
        damage_textField.setVisible(false);

        damage_textField.addActionListener((java.awt.event.ActionEvent evt) -> {
            damage_textFieldActionPerformed(evt);
        });

        value_label.setText("Value");
        getContentPane().add(value_label);
        value_label.setBounds(40, 260, 70, 14);
        getContentPane().add(value_textField);
        value_textField.setBounds(130, 260, 200, 20);
        value_label.setVisible(false);
        value_textField.setVisible(false);

        value_textField.addActionListener((java.awt.event.ActionEvent evt) -> {
            value_textFieldActionPerformed(evt);
        });

        type_label.setText("Type");
        getContentPane().add(type_label);
        type_label.setBounds(40, 300, 70, 14);
        type_label.setVisible(false);

        type_dropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Animal", "Land", "Home", "Vehicle", "Toy", "Tool"}));
        getContentPane().add(type_dropdown);
        type_dropdown.setBounds(130, 300, 200, 20);
        type_dropdown.setVisible(false);

        type_dropdown.addActionListener((java.awt.event.ActionEvent evt) -> {
            type_dropdownActionPerformed(evt);
        });

        owner_ssn_label.setText("Owner");
        getContentPane().add(owner_ssn_label);
        owner_ssn_label.setBounds(10, 380, 70, 14);
        owner_ssn_label.setVisible(false);

        owner_ssn_dropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{}));
        getContentPane().add(owner_ssn_dropdown);
        owner_ssn_dropdown.setBounds(130, 380, 200, 20);
        owner_ssn_dropdown.setVisible(false);

        owner_ssn_dropdown.addActionListener((java.awt.event.ActionEvent evt) -> {
            owner_ssn_dropdownActionPerformed(evt);
        });

        start_date_label.setText("Start Date");
        getContentPane().add(start_date_label);
        start_date_label.setBounds(30, 340, 70, 14);//220
        getContentPane().add(start_date_textField);
        start_date_textField.setBounds(130, 340, 200, 20);
        start_date_label.setVisible(false);
        start_date_textField.setVisible(false);

        start_date_textField.addActionListener((java.awt.event.ActionEvent evt) -> {
            start_date_textFieldActionPerformed(evt);
        });

        end_date_label.setText("End Date");
        getContentPane().add(end_date_label);
        end_date_label.setBounds(30, 380, 70, 14);//260
        getContentPane().add(end_date_textField);
        end_date_textField.setBounds(130, 380, 200, 20);
        end_date_label.setVisible(false);
        end_date_textField.setVisible(false);

        end_date_textField.addActionListener((java.awt.event.ActionEvent evt) -> {
            end_date_textFieldActionPerformed(evt);
        });

        severity_label.setText("Severity");
        getContentPane().add(severity_label);
        severity_label.setBounds(30, 260, 70, 14);//340
        getContentPane().add(severity_textField);
        severity_textField.setBounds(130, 260, 200, 20);
        severity_label.setVisible(false);
        severity_textField.setVisible(false);

        severity_textField.addActionListener((java.awt.event.ActionEvent evt) -> {
            severity_textFieldActionPerformed(evt);
        });

        add_button.setText("Add");
        getContentPane().add(add_button);
        add_button.setBounds(280, 420, 100, 40);
        add_button.setVisible(false);

        add_button.addActionListener((java.awt.event.ActionEvent evt) -> {
            add_buttonActionPerformed(evt); //To change body of generated methods, choose Tools | Templates.
        });

        remove_button.addActionListener((java.awt.event.ActionEvent evt) -> {
            remove_buttonActionPerformed(evt); //To change body of generated methods, choose Tools | Templates.
        });

        change_button.addActionListener((java.awt.event.ActionEvent evt) -> {
            change_buttonActionPerformed(evt); //To change body of generated methods, choose Tools | Templates.
        });

        finished_button.addActionListener((java.awt.event.ActionEvent evt) -> {
            finished_buttonActionPerformed(evt); //To change body of generated methods, choose Tools | Templates.
        });

        remove_button.setText("Remove");
        getContentPane().add(remove_button);
        remove_button.setBounds(380, 420, 100, 40);
        remove_button.setVisible(false);

        change_button.setText("Change");
        getContentPane().add(change_button);
        change_button.setBounds(480, 420, 100, 40);
        change_button.setVisible(false);

        finished_button.setText("Finished");
        getContentPane().add(finished_button);
        finished_button.setBounds(580, 420, 100, 40);
        finished_button.setVisible(false);
        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void select_table_dropdownActionPerformed(ItemEvent e) {//GEN-FIRST:event_select_table_dropdownActionPerformed
        // TODO add your handling code here:
        if (select_table_dropdown.getSelectedItem().equals("AFFECTED_COUNTY")) {
            loadAffectedCounties();
            loadAffectedCounties2();
            //MEDICAL_CENTER//

            capacity_label.setVisible(false);
            capacity_textField.setVisible(false);
            phone_label.setVisible(false);
            phone_textField.setVisible(false);
            address_label.setVisible(false);
            address_textField.setVisible(false);
            isTemp_label.setVisible(false);
            isTemp_true.setVisible(false);
            isTemp_false.setVisible(false);
            county_id_label.setVisible(false);
            county_id_dropdown.setVisible(false);
            //////////////////

            //DISASTER_WORKER//
            salary_label.setVisible(false);
            salary_textField.setVisible(false);
            ssn_label.setVisible(false);
            ssn_textField.setVisible(false);
            position_label.setVisible(false);
            position_textField.setVisible(false);
            org_id_label.setVisible(false);
            org_id_dropdown.setVisible(false);
            ///////////////////

            //PERSON//
            age_label.setVisible(false);
            age_textField.setVisible(false);
            sex_label.setVisible(false);
            sex_dropdown.setVisible(false);
            name_label.setVisible(false);
            name_textField.setVisible(false);
            county_id_label.setVisible(false);
            county_id_dropdown.setVisible(false);
            //////////

            //CIVILIAN//
            ssn_label.setVisible(false);
            ssn_textField.setVisible(false);
            status_label.setVisible(false);
            status_dropdown.setVisible(false);
            last_location_label.setVisible(false);
            last_location_textField.setVisible(false);
            ////////////

            //DISASTER_ORG//
            ssn_label.setVisible(false);
            ssn_textField.setVisible(false);
            name_label.setVisible(false);
            name_textField.setVisible(false);
            phone_label.setVisible(false);
            phone_textField.setVisible(false);
            address_label.setVisible(false);
            address_textField.setVisible(false);
            org_id_label.setVisible(false);
            org_id_dropdown.setVisible(false);

            ////////////////
            //PROPERTY//
            damage_label.setVisible(false);
            damage_textField.setVisible(false);
            value_label.setVisible(false);
            value_textField.setVisible(false);
            type_label.setVisible(false);
            type_dropdown.setVisible(false);
            owner_ssn_label.setVisible(false);
            owner_ssn_dropdown.setVisible(false);
            ////////////

            //DISASTER//
            type_label.setVisible(false);
            type_dropdown.setVisible(false);
            start_date_label.setVisible(false);
            start_date_textField.setVisible(false);
            end_date_label.setVisible(false);
            end_date_textField.setVisible(false);
            name_label.setVisible(false);
            name_textField.setVisible(false);
            severity_label.setVisible(false);
            severity_textField.setVisible(false);
            ////////////

            //AFFECTED COUNTY//
            id_label.setVisible(true);
            id_dropdown.setVisible(true);
            name_label.setVisible(true);
            name_textField.setVisible(true);
            damages_label.setVisible(true);
            damages_textField.setVisible(true);
            ///////////////////

            add_button.setVisible(true);
            remove_button.setVisible(true);
            change_button.setVisible(true);
            finished_button.setVisible(true);

        } else if (select_table_dropdown.getSelectedItem().equals("MEDICAL_CENTER")) {
            loadMedicalCenters();
            //AFFECTED COUNTY//

            name_label.setVisible(false);
            name_textField.setVisible(false);
            damages_label.setVisible(false);
            damages_textField.setVisible(false);
            ///////////////////

            //DISASTER_WORKER//
            salary_label.setVisible(false);
            salary_textField.setVisible(false);
            ssn_label.setVisible(false);
            ssn_textField.setVisible(false);
            position_label.setVisible(false);
            position_textField.setVisible(false);
            org_id_label.setVisible(false);
            org_id_dropdown.setVisible(false);
            ///////////////////

            //PERSON//
            age_label.setVisible(false);
            age_textField.setVisible(false);
            sex_label.setVisible(false);
            sex_dropdown.setVisible(false);
            name_label.setVisible(false);
            name_textField.setVisible(false);
            county_id_label.setVisible(false);
            county_id_dropdown.setVisible(false);
            //////////

            //CIVILIAN//
            ssn_label.setVisible(false);
            ssn_textField.setVisible(false);
            status_label.setVisible(false);
            status_dropdown.setVisible(false);
            last_location_label.setVisible(false);
            last_location_textField.setVisible(false);
            ////////////

            //DISASTER_ORG//
            ssn_label.setVisible(false);
            ssn_textField.setVisible(false);
            name_label.setVisible(false);
            name_textField.setVisible(false);
            phone_label.setVisible(false);
            phone_textField.setVisible(false);
            address_label.setVisible(false);
            address_textField.setVisible(false);
            org_id_label.setVisible(false);
            org_id_dropdown.setVisible(false);
            ////////////////

            //PROPERTY//
            damage_label.setVisible(false);
            damage_textField.setVisible(false);
            value_label.setVisible(false);
            value_textField.setVisible(false);
            type_label.setVisible(false);
            type_dropdown.setVisible(false);
            owner_ssn_label.setVisible(false);
            owner_ssn_dropdown.setVisible(false);
            ////////////

            //DISASTER//
            type_label.setVisible(false);
            type_dropdown.setVisible(false);
            start_date_label.setVisible(false);
            start_date_textField.setVisible(false);
            end_date_label.setVisible(false);
            end_date_textField.setVisible(false);
            name_label.setVisible(false);
            name_textField.setVisible(false);
            severity_label.setVisible(false);
            severity_textField.setVisible(false);
            ////////////

            //MEDICAL_CENTER//
            id_label.setVisible(true);
            id_dropdown.setVisible(true);
            capacity_label.setVisible(true);
            capacity_textField.setVisible(true);
            phone_label.setVisible(true);
            phone_textField.setVisible(true);
            address_label.setVisible(true);
            address_textField.setVisible(true);
            //isTemp_label.setVisible(true);
            //isTemp_true.setVisible(true);
            //isTemp_false.setVisible(true);
            county_id_label.setVisible(true);
            county_id_dropdown.setVisible(true);
            //////////////////

            add_button.setVisible(true);
            remove_button.setVisible(true);
            change_button.setVisible(true);
            finished_button.setVisible(true);

        } else if (select_table_dropdown.getSelectedItem().equals("DISASTER_WORKER")) {
            loadDisasterWorkers();
            //AFFECTED COUNTY//

            name_label.setVisible(false);
            name_textField.setVisible(false);
            damages_label.setVisible(false);
            damages_textField.setVisible(false);
            ///////////////////

            //MEDICAL_CENTER//
            capacity_label.setVisible(false);
            capacity_textField.setVisible(false);
            phone_label.setVisible(false);
            phone_textField.setVisible(false);
            address_label.setVisible(false);
            address_textField.setVisible(false);
            isTemp_label.setVisible(false);
            isTemp_true.setVisible(false);
            isTemp_false.setVisible(false);
            county_id_label.setVisible(false);
            county_id_dropdown.setVisible(false);
            //////////////////

            //CIVILIAN//
            ssn_label.setVisible(false);
            ssn_textField.setVisible(false);
            status_label.setVisible(false);
            status_dropdown.setVisible(false);
            last_location_label.setVisible(false);
            last_location_textField.setVisible(false);
            ////////////

            //DISASTER_ORG//
            ssn_label.setVisible(false);
            ssn_textField.setVisible(false);
            name_label.setVisible(false);
            name_textField.setVisible(false);
            phone_label.setVisible(false);
            phone_textField.setVisible(false);
            address_label.setVisible(false);
            address_textField.setVisible(false);
            org_id_label.setVisible(false);
            org_id_dropdown.setVisible(false);
            ////////////////

            //PROPERTY//
            damage_label.setVisible(false);
            damage_textField.setVisible(false);
            value_label.setVisible(false);
            value_textField.setVisible(false);
            type_label.setVisible(false);
            type_dropdown.setVisible(false);
            owner_ssn_label.setVisible(false);
            owner_ssn_dropdown.setVisible(false);
            ////////////

            //DISASTER//
            type_label.setVisible(false);
            type_dropdown.setVisible(false);
            start_date_label.setVisible(false);
            start_date_textField.setVisible(false);
            end_date_label.setVisible(false);
            end_date_textField.setVisible(false);
            name_label.setVisible(false);
            name_textField.setVisible(false);
            severity_label.setVisible(false);
            severity_textField.setVisible(false);
            ////////////

            //DISASTER_WORKER//
            id_label.setVisible(true);
            id_dropdown.setVisible(true);
            salary_label.setVisible(true);
            salary_textField.setVisible(true);
            ssn_label.setVisible(true);
            ssn_textField.setVisible(true);
            position_label.setVisible(true);
            position_textField.setVisible(true);
            ///////////////////

            //PERSON//
            age_label.setVisible(true);
            age_textField.setVisible(true);
            sex_label.setVisible(true);
            sex_dropdown.setVisible(true);
            name_label.setVisible(true);
            name_textField.setVisible(true);
            county_id_label.setVisible(true);
            county_id_dropdown.setVisible(true);
            org_id_label.setVisible(true);
            org_id_dropdown.setVisible(true);
            //////////

            add_button.setVisible(true);
            remove_button.setVisible(true);
            change_button.setVisible(true);
            finished_button.setVisible(true);
        } else if (select_table_dropdown.getSelectedItem().equals("CIVILIAN")) {
            //AFFECTED COUNTY//

            loadCivilians();
            name_label.setVisible(false);
            name_textField.setVisible(false);
            damages_label.setVisible(false);
            damages_textField.setVisible(false);
            ///////////////////

            //MEDICAL_CENTER//
            capacity_label.setVisible(false);
            capacity_textField.setVisible(false);
            phone_label.setVisible(false);
            phone_textField.setVisible(false);
            address_label.setVisible(false);
            address_textField.setVisible(false);
            isTemp_label.setVisible(false);
            isTemp_true.setVisible(false);
            isTemp_false.setVisible(false);
            county_id_label.setVisible(false);
            county_id_dropdown.setVisible(false);
            //////////////////

            //DISASTER_WORKER//
            salary_label.setVisible(false);
            salary_textField.setVisible(false);
            ssn_label.setVisible(false);
            ssn_textField.setVisible(false);
            position_label.setVisible(false);
            position_textField.setVisible(false);
            org_id_label.setVisible(false);
            org_id_dropdown.setVisible(false);
            ///////////////////

            //DISASTER_ORG//
            ssn_label.setVisible(false);
            ssn_textField.setVisible(false);
            name_label.setVisible(false);
            name_textField.setVisible(false);
            phone_label.setVisible(false);
            phone_textField.setVisible(false);
            address_label.setVisible(false);
            address_textField.setVisible(false);
            ////////////////

            //PROPERTY//
            damage_label.setVisible(false);
            damage_textField.setVisible(false);
            value_label.setVisible(false);
            value_textField.setVisible(false);
            type_label.setVisible(false);
            type_dropdown.setVisible(false);
            owner_ssn_label.setVisible(false);
            owner_ssn_dropdown.setVisible(false);
            ////////////

            //DISASTER//
            type_label.setVisible(false);
            type_dropdown.setVisible(false);
            start_date_label.setVisible(false);
            start_date_textField.setVisible(false);
            end_date_label.setVisible(false);
            end_date_textField.setVisible(false);
            name_label.setVisible(false);
            name_textField.setVisible(false);
            severity_label.setVisible(false);
            severity_textField.setVisible(false);
            org_id_label.setVisible(false);
            org_id_dropdown.setVisible(false);
            ////////////

            //CIVILIAN//
            ssn_label.setVisible(true);
            ssn_textField.setVisible(true);
            status_label.setVisible(true);
            status_dropdown.setVisible(true);
            last_location_label.setVisible(true);
            last_location_textField.setVisible(true);
            ////////////

            //PERSON//
            age_label.setVisible(true);
            age_textField.setVisible(true);
            sex_label.setVisible(true);
            sex_dropdown.setVisible(true);
            name_label.setVisible(true);
            name_textField.setVisible(true);
            county_id_label.setVisible(true);
            county_id_dropdown.setVisible(true);
            //////////

            add_button.setVisible(true);
            remove_button.setVisible(true);
            change_button.setVisible(true);
            finished_button.setVisible(true);
        } else if (select_table_dropdown.getSelectedItem().equals("DISASTER_ORG")) {
            loadDisasterOrgs();
            //AFFECTED COUNTY//

            name_label.setVisible(false);
            name_textField.setVisible(false);
            damages_label.setVisible(false);
            damages_textField.setVisible(false);
            ///////////////////

            //MEDICAL_CENTER//
            capacity_label.setVisible(false);
            capacity_textField.setVisible(false);
            phone_label.setVisible(false);
            phone_textField.setVisible(false);
            address_label.setVisible(false);
            address_textField.setVisible(false);
            isTemp_label.setVisible(false);
            isTemp_true.setVisible(false);
            isTemp_false.setVisible(false);
            county_id_label.setVisible(false);
            county_id_dropdown.setVisible(false);
            //////////////////

            //DISASTER_WORKER//
            salary_label.setVisible(false);
            salary_textField.setVisible(false);
            ssn_label.setVisible(false);
            ssn_textField.setVisible(false);
            position_label.setVisible(false);
            position_textField.setVisible(false);
            org_id_label.setVisible(false);
            org_id_dropdown.setVisible(false);
            ///////////////////

            //PERSON//
            age_label.setVisible(false);
            age_textField.setVisible(false);
            sex_label.setVisible(false);
            sex_dropdown.setVisible(false);
            name_label.setVisible(false);
            name_textField.setVisible(false);
            county_id_label.setVisible(false);
            county_id_dropdown.setVisible(false);
            //////////

            //CIVILIAN//
            ssn_label.setVisible(false);
            ssn_textField.setVisible(false);
            status_label.setVisible(false);
            status_dropdown.setVisible(false);
            last_location_label.setVisible(false);
            last_location_textField.setVisible(false);
            ////////////

            //PROPERTY//
            damage_label.setVisible(false);
            damage_textField.setVisible(false);
            value_label.setVisible(false);
            value_textField.setVisible(false);
            type_label.setVisible(false);
            type_dropdown.setVisible(false);
            owner_ssn_label.setVisible(false);
            owner_ssn_dropdown.setVisible(false);
            ////////////

            //DISASTER//
            type_label.setVisible(false);
            type_dropdown.setVisible(false);
            start_date_label.setVisible(false);
            start_date_textField.setVisible(false);
            end_date_label.setVisible(false);
            end_date_textField.setVisible(false);
            name_label.setVisible(false);
            name_textField.setVisible(false);
            severity_label.setVisible(false);
            severity_textField.setVisible(false);
            ////////////

            //DISASTER_ORG//
            id_label.setVisible(true);
            id_dropdown.setVisible(true);
            name_label.setVisible(true);
            name_textField.setVisible(true);
            phone_label.setVisible(true);
            phone_textField.setVisible(true);
            address_label.setVisible(true);
            address_textField.setVisible(true);
            org_id_label.setVisible(true);
            org_id_dropdown.setVisible(true);
            ////////////////

            add_button.setVisible(true);
            remove_button.setVisible(true);
            change_button.setVisible(true);
            finished_button.setVisible(true);

        } else if (select_table_dropdown.getSelectedItem().equals("PROPERTY")) {
            loadProperties();
            loadProperties2();
            //AFFECTED COUNTY//

            name_label.setVisible(false);
            name_textField.setVisible(false);
            damages_label.setVisible(false);
            damages_textField.setVisible(false);
            ///////////////////

            //MEDICAL_CENTER//
            capacity_label.setVisible(false);
            capacity_textField.setVisible(false);
            phone_label.setVisible(false);
            phone_textField.setVisible(false);
            address_label.setVisible(false);
            address_textField.setVisible(false);
            isTemp_label.setVisible(false);
            isTemp_true.setVisible(false);
            isTemp_false.setVisible(false);
            county_id_label.setVisible(false);
            county_id_dropdown.setVisible(false);
            //////////////////

            //DISASTER_WORKER//
            salary_label.setVisible(false);
            salary_textField.setVisible(false);
            ssn_label.setVisible(false);
            ssn_textField.setVisible(false);
            position_label.setVisible(false);
            position_textField.setVisible(false);
            org_id_label.setVisible(false);
            org_id_dropdown.setVisible(false);
            ///////////////////

            //PERSON//
            age_label.setVisible(false);
            age_textField.setVisible(false);
            sex_label.setVisible(false);
            sex_dropdown.setVisible(false);
            name_label.setVisible(false);
            name_textField.setVisible(false);
            county_id_label.setVisible(false);
            county_id_dropdown.setVisible(false);
            //////////

            //CIVILIAN//
            ssn_label.setVisible(false);
            ssn_textField.setVisible(false);
            status_label.setVisible(false);
            status_dropdown.setVisible(false);
            last_location_label.setVisible(false);
            last_location_textField.setVisible(false);
            ////////////

            //DISASTER_ORG//
            ssn_label.setVisible(false);
            ssn_textField.setVisible(false);
            name_label.setVisible(false);
            name_textField.setVisible(false);
            phone_label.setVisible(false);
            phone_textField.setVisible(false);
            address_label.setVisible(false);
            address_textField.setVisible(false);
            org_id_label.setVisible(false);
            org_id_dropdown.setVisible(false);
            ////////////////

            //DISASTER//
            type_label.setVisible(false);
            type_dropdown.setVisible(false);
            start_date_label.setVisible(false);
            start_date_textField.setVisible(false);
            end_date_label.setVisible(false);
            end_date_textField.setVisible(false);
            name_label.setVisible(false);
            name_textField.setVisible(false);
            severity_label.setVisible(false);
            severity_textField.setVisible(false);
            ////////////

            //PROPERTY//
            id_label.setVisible(true);
            id_dropdown.setVisible(true);
            damage_label.setVisible(true);
            damage_textField.setVisible(true);
            value_label.setVisible(true);
            value_textField.setVisible(true);
            type_label.setVisible(true);
            type_dropdown.setVisible(true);
            owner_ssn_label.setVisible(true);
            owner_ssn_dropdown.setVisible(true);
            ////////////

            add_button.setVisible(true);
            remove_button.setVisible(true);
            change_button.setVisible(true);
            finished_button.setVisible(true);
        } else if (select_table_dropdown.getSelectedItem().equals("DISASTER")) {
            loadDisasters();
            loadDisasters3();
            //AFFECTED COUNTY//

            name_label.setVisible(false);
            name_textField.setVisible(false);
            damages_label.setVisible(false);
            damages_textField.setVisible(false);
            ///////////////////

            //MEDICAL_CENTER//
            capacity_label.setVisible(false);
            capacity_textField.setVisible(false);
            phone_label.setVisible(false);
            phone_textField.setVisible(false);
            address_label.setVisible(false);
            address_textField.setVisible(false);
            isTemp_label.setVisible(false);
            isTemp_true.setVisible(false);
            isTemp_false.setVisible(false);
            county_id_label.setVisible(false);
            county_id_dropdown.setVisible(false);
            //////////////////

            //DISASTER_WORKER//
            salary_label.setVisible(false);
            salary_textField.setVisible(false);
            ssn_label.setVisible(false);
            ssn_textField.setVisible(false);
            position_label.setVisible(false);
            position_textField.setVisible(false);
            org_id_label.setVisible(false);
            org_id_dropdown.setVisible(false);
            ///////////////////

            //PERSON//
            age_label.setVisible(false);
            age_textField.setVisible(false);
            sex_label.setVisible(false);
            sex_dropdown.setVisible(false);
            name_label.setVisible(false);
            name_textField.setVisible(false);
            county_id_label.setVisible(false);
            county_id_dropdown.setVisible(false);
            //////////

            //CIVILIAN//
            ssn_label.setVisible(false);
            ssn_textField.setVisible(false);
            status_label.setVisible(false);
            status_dropdown.setVisible(false);
            last_location_label.setVisible(false);
            last_location_textField.setVisible(false);
            ////////////

            //DISASTER_ORG//
            ssn_label.setVisible(false);
            ssn_textField.setVisible(false);
            name_label.setVisible(false);
            name_textField.setVisible(false);
            phone_label.setVisible(false);
            phone_textField.setVisible(false);
            address_label.setVisible(false);
            address_textField.setVisible(false);
            org_id_label.setVisible(false);
            org_id_dropdown.setVisible(false);
            ////////////////

            //PROPERTY//
            damage_label.setVisible(false);
            damage_textField.setVisible(false);
            value_label.setVisible(false);
            value_textField.setVisible(false);
            type_label.setVisible(false);
            type_dropdown.setVisible(false);
            owner_ssn_label.setVisible(false);
            owner_ssn_dropdown.setVisible(false);
            ////////////

            //DISASTER//
            type_label.setVisible(true);
            type_dropdown.setVisible(true);
            start_date_label.setVisible(true);
            start_date_textField.setVisible(true);
            end_date_label.setVisible(true);
            end_date_textField.setVisible(true);
            name_label.setVisible(true);
            name_textField.setVisible(true);
            severity_label.setVisible(true);
            severity_textField.setVisible(true);
            id_dropdown.setVisible(true);
            id_label.setVisible(true);
            ////////////

            add_button.setVisible(true);
            remove_button.setVisible(true);
            change_button.setVisible(true);
            finished_button.setVisible(true);
        } else {
            //AFFECTED COUNTY//

            name_label.setVisible(false);
            name_textField.setVisible(false);
            damages_label.setVisible(false);
            damages_textField.setVisible(false);
            ///////////////////

            //MEDICAL_CENTER//
            capacity_label.setVisible(false);
            capacity_textField.setVisible(false);
            phone_label.setVisible(false);
            phone_textField.setVisible(false);
            address_label.setVisible(false);
            address_textField.setVisible(false);
            isTemp_label.setVisible(false);
            isTemp_true.setVisible(false);
            isTemp_false.setVisible(false);
            county_id_label.setVisible(false);
            county_id_dropdown.setVisible(false);
            //////////////////

            //DISASTER_WORKER//
            salary_label.setVisible(false);
            salary_textField.setVisible(false);
            ssn_label.setVisible(false);
            ssn_textField.setVisible(false);
            position_label.setVisible(false);
            position_textField.setVisible(false);
            org_id_label.setVisible(false);
            org_id_dropdown.setVisible(false);
            ///////////////////

            //PERSON//
            age_label.setVisible(false);
            age_textField.setVisible(false);
            sex_label.setVisible(false);
            sex_dropdown.setVisible(false);
            name_label.setVisible(false);
            name_textField.setVisible(false);
            county_id_label.setVisible(false);
            county_id_dropdown.setVisible(false);
            //////////

            //CIVILIAN//
            ssn_label.setVisible(false);
            ssn_textField.setVisible(false);
            status_label.setVisible(false);
            status_dropdown.setVisible(false);
            last_location_label.setVisible(false);
            last_location_textField.setVisible(false);
            ////////////

            //DISASTER_ORG//
            ssn_label.setVisible(false);
            ssn_textField.setVisible(false);
            name_label.setVisible(false);
            name_textField.setVisible(false);
            phone_label.setVisible(false);
            phone_textField.setVisible(false);
            address_label.setVisible(false);
            address_textField.setVisible(false);
            org_id_label.setVisible(false);
            org_id_dropdown.setVisible(false);
            ////////////////

            //PROPERTY//
            damage_label.setVisible(false);
            damage_textField.setVisible(false);
            value_label.setVisible(false);
            value_textField.setVisible(false);
            type_label.setVisible(false);
            type_dropdown.setVisible(false);
            owner_ssn_label.setVisible(false);
            owner_ssn_dropdown.setVisible(false);
            ////////////

            //DISASTER//
            type_label.setVisible(false);
            type_dropdown.setVisible(false);
            start_date_label.setVisible(false);
            start_date_textField.setVisible(false);
            end_date_label.setVisible(false);
            end_date_textField.setVisible(false);
            name_label.setVisible(false);
            name_textField.setVisible(false);
            severity_label.setVisible(false);
            severity_textField.setVisible(false);
            ////////////

            add_button.setVisible(false);
            remove_button.setVisible(false);
            change_button.setVisible(false);
            finished_button.setVisible(false);
        }
    }//GEN-LAST:event_select_table_dropdownActionPerformed

    private void id_dropdownActionPerformed(ItemEvent e) {
        loadDisasterDropdown();

        if (select_table_dropdown.getSelectedItem().equals("AFFECTED_COUNTY")) {
            try {
                if (counties2 == null) {
                    System.out.println("Something's fucked");
                }
                if (id_dropdown.getSelectedItem() == null) {
                    System.out.println("Something's fucked 2");
                }
                int cid = counties2.get(id_dropdown.getSelectedItem().toString());
                ResultSet query = db.query("SELECT * FROM `affected_county` WHERE `id` = " + cid + ";");
                query.next();
                String name = query.getString("name");
                int damages = query.getInt("damages");

                name_textField.setText(name);
                damages_textField.setText(damages + "");
            } catch (SQLException ex) {
                System.out.println("Exception thrown");
            }
        } else if (select_table_dropdown.getSelectedItem().equals("MEDICAL_CENTER")) {
            try {
                loadAffectedCounties();
                if (medicalCenters == null) {
                    System.out.println("Something's fucked");
                }
                if (id_dropdown.getSelectedItem() == null) {
                    System.out.println("Something's fucked 2");
                }
                int mcid = medicalCenters.get(id_dropdown.getSelectedItem().toString());
                ResultSet query = db.query("SELECT * FROM `medical_center` WHERE `id` = " + mcid + ";");
                query.next();
                long phone = query.getLong("phone_num");
                String address = query.getString("address");
                //String name = query.getString("name");
                int capacity = query.getInt("capacity");
                int county_id = query.getInt("county_id");

                phone_textField.setText(phone + "");
                address_textField.setText(address);
                //name_textField.setText(name);
                capacity_textField.setText(capacity + "");
                county_id_dropdown.setSelectedItem(county_id);
            } catch (SQLException ex) {
                System.out.println("Exception thrown");
            }

        } else if (select_table_dropdown.getSelectedItem().equals("DISASTER_WORKER")) {
            try {
                loadAffectedCounties();
                loadDisasterOrgs2();
                if (disasterWorkers == null) {
                    System.out.println("Something's fucked");
                }
                if (id_dropdown.getSelectedItem() == null) {
                    System.out.println("Something's fucked 2");
                }
                int dwid = disasterWorkers.get(id_dropdown.getSelectedItem().toString());
                ResultSet query = db.query("SELECT * FROM `person` JOIN `disaster_worker` ON `person`.`ssn`=`disaster_worker`.`ssn` WHERE `employee_id`='" + dwid + "';");
                query.next();
                int salary = query.getInt("salary");
                //String address = query.getString("address");
                String name = query.getString("name");
                int age = query.getInt("age");
                String position = query.getString("position");
                int ssn = query.getInt("ssn");
                int county_id = query.getInt("county_id");
                int org_id = query.getInt("org_id");

                salary_textField.setText(salary + "");
                //address_textField.setText(address);
                name_textField.setText(name);
                age_textField.setText(age + "");
                position_textField.setText(position);
                ssn_textField.setText(ssn + "");
                county_id_dropdown.setSelectedItem(county_id);
                org_id_dropdown.setSelectedItem(org_id);
                //System.out.println(org_id);
            } catch (SQLException ex) {
                System.out.println("Exception thrown");
            }

        } else if (select_table_dropdown.getSelectedItem().equals("CIVILIAN")) {
            loadAffectedCounties();
            try {
                if (civilians == null) {
                    System.out.println("Something's fucked");
                }
                if (id_dropdown.getSelectedItem() == null) {
                    System.out.println("Something's fucked 2");
                }
                int ssn = civilians.get(id_dropdown.getSelectedItem().toString());
                ResultSet query = db.query("SELECT * FROM `person` JOIN `civilian` ON `person`.`ssn`=`civilian`.`ssn` WHERE `person`.`ssn`='" + ssn + "';");
                query.next();
                //String address = query.getString("address");
                String name = query.getString("name");
                String last_location = query.getString("last_location");
                String status = query.getString("status");
                int age = query.getInt("age");
                int county_id = query.getInt("county_id");
                //address_textField.setText(address);
                name_textField.setText(name);
                last_location_textField.setText(last_location);
                status_dropdown.setSelectedItem(status);
                age_textField.setText(age + "");
                ssn_textField.setText(ssn + "");
                county_id_dropdown.setSelectedItem(county_id);
            } catch (SQLException ex) {
                System.out.println("Exception thrown");
            }

        } else if (select_table_dropdown.getSelectedItem().equals("DISASTER_ORG")) {
            loadDisasterOrgs2();
            try {
                if (organizations == null) {
                    System.out.println("Something's fucked");
                }
                if (id_dropdown.getSelectedItem() == null) {
                    System.out.println("Something's fucked 2");
                }
                int oid = organizations.get(id_dropdown.getSelectedItem().toString());
                ResultSet query = db.query("SELECT * FROM `disaster_org` WHERE `id` = " + oid + ";");
                query.next();
                long phone = query.getLong("phone_num");
                String address = query.getString("address");
                String name = query.getString("name");
                int org_id = query.getInt("id");
                //int capacity = query.getInt("capacity");

                phone_textField.setText(phone + "");
                address_textField.setText(address);
                name_textField.setText(name);
                org_id_dropdown.setSelectedItem(org_id);
                //capacity_textField.setText(capacity + "");
            } catch (SQLException ex) {
                System.out.println("Exception thrown");
            }

        } else if (select_table_dropdown.getSelectedItem().equals("PROPERTY")) {
            loadProperties2();
            try {
                if (properties == null) {
                    System.out.println("Something's fucked");
                }
                if (id_dropdown.getSelectedItem() == null) {
                    System.out.println("Something's fucked 2");
                }
                int prid = properties.get(id_dropdown.getSelectedItem().toString());
                ResultSet query = db.query("SELECT * FROM `property` WHERE `id` = " + prid + ";");
                query.next();
                String type = query.getString("type");
                String damage = query.getString("damage");
                int value = query.getInt("value");
                type_dropdown.setSelectedItem(type);
                damage_textField.setText(damage);
                value_textField.setText(value + "");
            } catch (SQLException ex) {
                System.out.println("Exception thrown");
            }

        } else if (select_table_dropdown.getSelectedItem().equals("DISASTER")) {
            try {
                if (disasters == null) {
                    System.out.println("Something's fucked");
                }
                if (id_dropdown.getSelectedItem() == null) {
                    System.out.println("Something's fucked 2");
                }
                int did = disasters.get(id_dropdown.getSelectedItem().toString());
                ResultSet query = db.query("SELECT * FROM `disaster` WHERE `id` = " + did + ";");
                query.next();
                String name = query.getString("name");
                String type = query.getString("type");
                String start_date = query.getDate("date_begin").toString();
                String end_date = query.getDate("date_end").toString();
                String severity = query.getString("severity");
                name_textField.setText(name);
                type_dropdown.setSelectedItem(type);
                start_date_textField.setText(start_date);
                end_date_textField.setText(end_date);
                severity_textField.setText(severity);
            } catch (SQLException ex) {
                System.out.println("Exception thrown");
            }

        }

    }

    private void name_textFieldActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void damages_textFieldActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void capacity_textFieldActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void phone_textFieldActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void address_textFieldActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void isTemp_trueActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void isTemp_falseActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void county_id_dropdownActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void salary_textFieldActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void ssn_textFieldActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void position_textFieldActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void age_textFieldActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void sex_dropdownActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void status_dropdownActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void last_location_textFieldActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void damage_textFieldActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void value_textFieldActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void type_dropdownActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void owner_ssn_dropdownActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void start_date_textFieldActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void end_date_textFieldActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void severity_textFieldActionPerformed(java.awt.event.ActionEvent evt) {

    }

    /*
    private void ActionPerformed(java.awt.event.ActionEvent evt) {
       
    }
     */
    private void add_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        if (select_table_dropdown.getSelectedItem().equals("AFFECTED_COUNTY")) {
            try {
                if (disasters2 == null) {
                    System.out.println("Something's fucked");
                }
                if (disaster_dropdown.getSelectedItem() == null) {
                    System.out.println("Something's fucked 2");
                }
                int did = disasters2.get(disaster_dropdown.getSelectedItem().toString());
                if (db.execute("INSERT INTO `affected_county` (`disaster_id`,`name`, `damages`) VALUES (" + did + ", '" + name_textField.getText() + "', '" + damages_textField.getText() + "');")) {
                    JOptionPane.showMessageDialog(this, "Successfully added affected county!");

                }
            } catch (Exception ex) {
                System.out.println("Somethings fucked 3");
            }
        } else if (select_table_dropdown.getSelectedItem().equals("MEDICAL_CENTER")) {
            try {
                if (disasters2 == null) {
                    System.out.println("Something's fucked");
                }
                if (disaster_dropdown.getSelectedItem() == null) {
                    System.out.println("Something's fucked 2");
                }
                int did = disasters2.get(disaster_dropdown.getSelectedItem().toString());
                int id2 = counties.get(county_id_dropdown.getSelectedItem().toString());
                if (db.execute("INSERT INTO `medical_center` (`disaster_id`, `capacity`, `phone_num`, `address`, `county_id`) VALUES (" + did + ", '" + capacity_textField.getText() + "', '" + phone_textField.getText() + "', '" + address_textField.getText() + "', '" + id2 + "');")) {
                    JOptionPane.showMessageDialog(this, "Successfully added medical center!");
                }
            } catch (Exception ex) {
                System.out.println("Somethings fucked 3");
            }
        } else if (select_table_dropdown.getSelectedItem().equals("DISASTER_WORKER")) {
            try {
                if (disasters2 == null) {
                    System.out.println("Something's fucked");
                }
                if (disaster_dropdown.getSelectedItem() == null) {
                    System.out.println("Something's fucked 2");
                }
                int did = disasters2.get(disaster_dropdown.getSelectedItem().toString());
                int id2 = counties.get(county_id_dropdown.getSelectedItem().toString());
                int id3 = organizations2.get(org_id_dropdown.getSelectedItem().toString());
                //System.out.println(id3);
                //System.out.println(counties.get(county_id_dropdown.getSelectedItem().toString()));
                if ((db.execute("INSERT INTO `person` (`ssn`, `name`, `age`, `sex`, `county_id`, `disaster_id`) VALUES (" + ssn_textField.getText() + ", '" + name_textField.getText() + "', '" + age_textField.getText() + "', '" + sex_dropdown.getSelectedItem().toString().charAt(0) + "', '" + id2 + "', '" + did + "');")) && (db.execute("INSERT INTO `disaster_worker` (`ssn`, `salary`, `position`, `org_id`) VALUES ('" + ssn_textField.getText() + "', '" + salary_textField.getText() + "', '" + position_textField.getText() + "', '" + id3 + "');"))) {
                    JOptionPane.showMessageDialog(this, "Successfully added disaster worker!");
                }
            } catch (Exception ex) {
                System.out.println("Somethings fucked 3");
            }
        } else if (select_table_dropdown.getSelectedItem().equals("CIVILIAN")) {
            try {
                if (disasters2 == null) {
                    System.out.println("Something's fucked");
                }
                if (disaster_dropdown.getSelectedItem() == null) {
                    System.out.println("Something's fucked 2");
                }
                int did = disasters2.get(disaster_dropdown.getSelectedItem().toString());
                int id2 = counties.get(county_id_dropdown.getSelectedItem().toString());
                if ((db.execute("INSERT INTO `person` (`ssn`, `name`, `age`, `sex`, `county_id`, `disaster_id`) VALUES ('" + ssn_textField.getText() + "', '" + name_textField.getText() + "', '" + age_textField.getText() + "', '" + sex_dropdown.getSelectedItem().toString().charAt(0) + "', '" + id2 + "', '" + did + "');")) && (db.execute("INSERT INTO `civilian` (`ssn`, `status`, `last_location`) VALUES ('" + ssn_textField.getText() + "', '" + status_dropdown.getSelectedItem() + "', '" + last_location_textField.getText() + "');"))) {
                    JOptionPane.showMessageDialog(this, "Successfully added civilian!");
                }
            } catch (Exception ex) {
                System.out.println("Somethings fucked 3");
            }
        } else if (select_table_dropdown.getSelectedItem().equals("DISASTER_ORG")) {
            try {
                if (disasters2 == null) {
                    System.out.println("Something's fucked");
                }
                if (disaster_dropdown.getSelectedItem() == null) {
                    System.out.println("Something's fucked 2");
                }
                int did = disasters2.get(disaster_dropdown.getSelectedItem().toString());
                //int id2 = organizations2.get(org_id_dropdown.getSelectedItem().toString());
                if (db.execute("INSERT INTO `disaster_org` (`name`, `phone_num`, `address`, `disaster_id`) VALUES ('" + name_textField.getText() + "', '" + phone_textField.getText() + "', '" + address_textField.getText() + "', '" + did + "')")) {
                    JOptionPane.showMessageDialog(this, "Successfully added disaster org!");
                }
            } catch (Exception ex) {
                System.out.println("Somethings fucked 3");
            }
        } else if (select_table_dropdown.getSelectedItem().equals("PROPERTY")) {
            try {
                if (disasters2 == null) {
                    System.out.println("Something's fucked");
                }
                if (disaster_dropdown.getSelectedItem() == null) {
                    System.out.println("Something's fucked 2");
                }
                int prid = properties2.get(owner_ssn_dropdown.getSelectedItem().toString());
                int id2 = disasters2.get(disaster_dropdown.getSelectedItem().toString());
                if (db.execute("INSERT INTO `property` (`damage`, `value`, `type`, `owner_ssn`, `disaster_id`) VALUES ('" + damage_textField.getText() + "', '" + value_textField.getText() + "', '" + type_dropdown.getSelectedItem() + "', '" + prid + "', '" + id2 + "')")) {
                    JOptionPane.showMessageDialog(this, "Successfully added property!");
                }
            } catch (Exception ex) {
                System.out.println("Somethings fucked 3");
            }
        } else if (select_table_dropdown.getSelectedItem().equals("DISASTER")) {
            try {
                if (disasters2 == null) {
                    System.out.println("Something's fucked");
                }
                if (disaster_dropdown.getSelectedItem() == null) {
                    System.out.println("Something's fucked 2");
                }
                if (db.execute("INSERT INTO `DISASTER` (`name`, `severity`, `type`, `date_begin`, `date_end`) VALUES ('" + name_textField.getText() + "', '" + severity_textField.getText() + "', '" + type_dropdown.getSelectedItem() + "', '" + start_date_textField.getText() + "', '" + end_date_textField.getText() + "')")) {
                    JOptionPane.showMessageDialog(this, "Successfully added disaster!");
                }
            } catch (Exception ex) {
                System.out.println("Somethings fucked 3");
            }
        }
    }

    private void remove_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        if (select_table_dropdown.getSelectedItem().equals("AFFECTED_COUNTY")) {
            if (db.execute("DELETE FROM `affected_county` WHERE `id`='" + counties.get(id_dropdown.getSelectedItem().toString()) + "';")) {
                JOptionPane.showMessageDialog(this, "Removed Affected County!");
                loadAffectedCounties();
                return;
            }
        }
        if (select_table_dropdown.getSelectedItem().equals("MEDICAL_CENTER")) {
            if (db.execute("DELETE FROM `medical_center` WHERE `id`='" + medicalCenters.get(id_dropdown.getSelectedItem().toString()) + "';")) {
                JOptionPane.showMessageDialog(this, "Removed Medical Center!");
                loadMedicalCenters();
                return;
            }
        }
        if (select_table_dropdown.getSelectedItem().equals("DISASTER_WORKER")) {
            if (db.execute("DELETE FROM `disaster_worker` WHERE `employee_id`='" + disasterWorkers.get(id_dropdown.getSelectedItem().toString()) + "';")) {
                if (db.execute("DELETE FROM `person` WHERE `ssn`='" + disasterWorkers.get(id_dropdown.getSelectedItem().toString()) + "';")) {
                    JOptionPane.showMessageDialog(this, "Removed Disaster Worker!");
                    loadDisasterWorkers();
                    return;
                }
            }
        }
        if (select_table_dropdown.getSelectedItem().equals("CIVILIAN")) {
            if (db.execute("DELETE FROM `civilian` WHERE `ssn`='" + civilians.get(id_dropdown.getSelectedItem().toString()) + "';")) {
                if (db.execute("DELETE FROM `person` WHERE `ssn`='" + civilians.get(id_dropdown.getSelectedItem().toString()) + "';")) {
                    JOptionPane.showMessageDialog(this, "Removed Civilian!");
                    loadCivilians();
                    return;
                }
            }
        }
        if (select_table_dropdown.getSelectedItem().equals("DISASTER_ORG")) {
            if (db.execute("DELETE FROM `disaster_org` WHERE `id`='" + organizations.get(id_dropdown.getSelectedItem().toString()) + "';")) {
                JOptionPane.showMessageDialog(this, "Removed Organization!");
                loadDisasterOrgs();
                return;
            }
        }
        if (select_table_dropdown.getSelectedItem().equals("PROPERTY")) {
            if (db.execute("DELETE FROM `property` WHERE `id`='" + properties.get(id_dropdown.getSelectedItem().toString()) + "';")) {
                JOptionPane.showMessageDialog(this, "Removed Property!");
                loadProperties();
                return;
            }
        }
        if (select_table_dropdown.getSelectedItem().equals("DISASTER")) {
            if (db.execute("DELETE FROM `disaster` WHERE `id`='" + disasters.get(id_dropdown.getSelectedItem().toString()) + "';")) {
                JOptionPane.showMessageDialog(this, "Removed Disaster!");
                loadDisasters();
            }
        }

    }

    private void change_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        if (select_table_dropdown.getSelectedItem().equals("AFFECTED_COUNTY")) {
            if (db.execute("UPDATE `affected_county` SET `name`='" + name_textField.getText() + "', `damages`='" + damages_textField.getText() + "'  WHERE `id` = '" + counties.get(id_dropdown.getSelectedItem().toString()) + "';")) {
                JOptionPane.showMessageDialog(this, "Successfully updated data");
            }
        } else if (select_table_dropdown.getSelectedItem().equals("MEDICAL_CENTER")) {
            if (db.execute("UPDATE `medical_center` SET is_temp='0', capacity='" + capacity_textField.getText()
                    + "', `phone_num`='" + phone_textField.getText() + "', `address`='" + address_textField.getText() + "'  WHERE id = '" + medicalCenters.get(id_dropdown.getSelectedItem().toString()) + "';")) {
                JOptionPane.showMessageDialog(this, "Successfully updated medical center");
            }

        } else if (select_table_dropdown.getSelectedItem().equals("DISASTER_ORG")) {
            if (db.execute("UPDATE `disaster_org` SET `phone_num`='" + phone_textField.getText()
                    + "', `address`='" + address_textField.getText() + "', `name`='" + name_textField.getText() + "'  WHERE id = '" + organizations.get(id_dropdown.getSelectedItem().toString()) + "';")) {
                JOptionPane.showMessageDialog(this, "Successfully updated Disaster Org");
            }
        } else if (select_table_dropdown.getSelectedItem().equals("DISASTER_WORKER")) {
            if (db.execute("UPDATE `disaster_worker` SET `salary`='" + salary_textField.getText()
                    + "', `position`='" + position_textField.getText()
                    + "', `ssn`='" + ssn_textField.getText() + "'  WHERE employee_id = '" + disasterWorkers.get(id_dropdown.getSelectedItem().toString()) + "';")
                    && db.execute("UPDATE `person` SET `name`='" + name_textField.getText() + "', `age`='" + age_textField.getText()
                            + "'  WHERE ssn = '" + ssn_textField.getText() + "';")) {
                JOptionPane.showMessageDialog(this, "Successfully updated Disaster Worker");
            }

        } else if (select_table_dropdown.getSelectedItem().equals("CIVILIAN")) {
            if (db.execute("UPDATE `civilian` SET `status`='" + status_dropdown.getSelectedItem()
                    + "', `last_location`='" + last_location_textField.getText()
                    + "' WHERE ssn = '" + disasterWorkers.get(id_dropdown.getSelectedItem().toString()) + "';")
                    && db.execute("UPDATE `person` SET `name`='" + name_textField.getText() + "', `age`='" + age_textField.getText()
                            + "'  WHERE ssn = '" + ssn_textField.getText() + "';")) {
                JOptionPane.showMessageDialog(this, "Successfully updated Disaster Worker");
                System.out.println(status_dropdown.getSelectedItem());
            } else {
                System.out.println("Something's definitely fucked");
            }

        } else if (select_table_dropdown.getSelectedItem().equals("PROPERTY")) {
            if (db.execute("UPDATE `property` SET `type`='" + type_dropdown.getSelectedItem()
                    + "', `damage`='" + damage_textField.getText() + "', `value`='" + value_textField.getText()
                    + "' WHERE id = '" + properties.get(id_dropdown.getSelectedItem().toString()) + "';")) {
                JOptionPane.showMessageDialog(this, "Successfully updated Property");

            } else {
                System.out.println("Something's definitely fucked");
            }

        } else if (select_table_dropdown.getSelectedItem().equals("DISASTER")) {
            if (db.execute("UPDATE `disaster` SET `name`='" + name_textField.getText()
                    + "', `date_begin`='" + start_date_textField.getText() + "', `date_end`='" + end_date_textField.getText()
                    + "', `severity`='" + severity_textField.getText() + "' WHERE `id` = '" + disasters.get(id_dropdown.getSelectedItem().toString()) + "';")) {
                JOptionPane.showMessageDialog(this, "Successfully updated Disaster");

            } else {
                System.out.println("Something's definitely fucked");
            }

        }

    }

    private void finished_buttonActionPerformed(java.awt.event.ActionEvent evt) {
        this.setVisible(false);
    }

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel disaster_label;
    private javax.swing.JComboBox<String> disaster_dropdown;
    private javax.swing.JLabel address_label;
    private javax.swing.JTextField address_textField;
    private javax.swing.JLabel age_label;
    private javax.swing.JTextField age_textField;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel capacity_label;
    private javax.swing.JTextField capacity_textField;
    private javax.swing.JComboBox<String> county_id_dropdown;
    private javax.swing.JLabel county_id_label;
    private javax.swing.JLabel damage_label;
    private javax.swing.JTextField damage_textField;
    private javax.swing.JLabel damages_label;
    private javax.swing.JTextField damages_textField;
    private javax.swing.JLabel end_date_label;
    private javax.swing.JTextField end_date_textField;
    private javax.swing.JComboBox<String> id_dropdown;
    private javax.swing.JLabel id_label;
    private javax.swing.JRadioButton isTemp_false;
    private javax.swing.JLabel isTemp_label;
    private javax.swing.JRadioButton isTemp_true;
    private javax.swing.JLabel severity_label;////////////
    private javax.swing.JLabel last_location_label;
    private javax.swing.JTextField last_location_textField;
    private javax.swing.JLabel name_label;
    private javax.swing.JTextField name_textField;
    private javax.swing.JComboBox<String> owner_ssn_dropdown;
    private javax.swing.JLabel owner_ssn_label;
    private javax.swing.JLabel phone_label;
    private javax.swing.JTextField phone_textField;
    private javax.swing.JLabel position_label;
    private javax.swing.JTextField position_textField;
    private javax.swing.JLabel salary_label;
    private javax.swing.JTextField salary_textField;
    private javax.swing.JComboBox<String> select_table_dropdown;
    private javax.swing.JLabel select_table_label;
    private javax.swing.JTextField severity_textField;
    private javax.swing.JComboBox<String> sex_dropdown;
    private javax.swing.JLabel sex_label;
    private javax.swing.JLabel ssn_label;
    private javax.swing.JTextField ssn_textField;
    private javax.swing.JLabel start_date_label;
    private javax.swing.JTextField start_date_textField;
    private javax.swing.JComboBox<String> status_dropdown;
    private javax.swing.JLabel status_label;
    private javax.swing.JComboBox<String> type_dropdown;
    private javax.swing.JLabel type_label;
    private javax.swing.JLabel value_label;
    private javax.swing.JTextField value_textField;
    private javax.swing.JButton add_button;
    private javax.swing.JButton remove_button;
    private javax.swing.JButton change_button;
    private javax.swing.JButton finished_button;
    private javax.swing.JLabel org_id_label;
    private javax.swing.JComboBox<String> org_id_dropdown;
    // End of variables declaration//GEN-END:variables
}
