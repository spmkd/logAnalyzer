package Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import configuration.DatabaseConfiguration;

public class checkDBConnection {
	
    public static Connection con = null;
    public static Statement st = null;
    public static ResultSet rs = null;
	
    public static void main(String[] args) {



        String url = DatabaseConfiguration.getUrl();
        String user = DatabaseConfiguration.getUser();
        String password = DatabaseConfiguration.getPassword();

        try {
            con = DriverManager.getConnection(url, user, password);
            st = con.createStatement();
            rs = st.executeQuery("SELECT VERSION()");

            if (rs.next()) {
                System.out.println(rs.getString(1));
            }

        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(checkDBConnection.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
                if (con != null) {
                    con.close();
                }

            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(checkDBConnection.class.getName());
                lgr.log(Level.WARNING, ex.getMessage(), ex);
            }
        }
    }

}
