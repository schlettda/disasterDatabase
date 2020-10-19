package disasterdata;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jtrenaud1s
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Database {

    private static Connection connect = null;

    public void open() throws Exception {
        try {
            connect = DriverManager.getConnection("jdbc:mysql://97.88.185.186/disaster?user=disaster&password=goodmorning");
        } catch (Exception e) {
            throw e;
        }

    }

    public boolean execute(String sql) {
        try {
            Statement statement = connect.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);

            return false;
        }
        return true;
    }

    public ResultSet query(String sql) {
        try {
            Statement statement = connect.createStatement();
            return statement.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void printResultSet(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                System.out.println(resultSet.getMetaData().getColumnName(i) + ": " + resultSet.getString(resultSet.getMetaData().getColumnName(i)));
            }
        }
    }

    private void close() {
        try {
            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}
