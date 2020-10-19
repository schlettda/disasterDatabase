package disasterdata;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DisasterData {

    public Database d;

    public DisasterData() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            d = new Database();
            d.open();

            Welcome_Page welcome = new Welcome_Page(d);
            welcome.setVisible(true);

        } catch (Exception ex) {
            Logger.getLogger(DisasterData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        DisasterData disasterData;
        disasterData = new DisasterData();
    }

}
