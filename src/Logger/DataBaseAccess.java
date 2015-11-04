package Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


import dataObjects.ErrorObject;

public class DataBaseAccess {
	
    public static Connection con = null;
    public static Statement st = null;
    public static ResultSet rs = null;
    
    static String url = "jdbc:mysql://localhost:3306/testdb";
    static String user = "testuser";
    static String password = "test623";


    public static synchronized void CheckErrorInDictionary(ErrorObject errorObject){
    	
        
        try {
        	con = DriverManager.getConnection(url, user, password);
        	
        	st = con.createStatement();
        	
        	rs = st.executeQuery("SELECT * FROM errorstackdictionary WHERE HashNumber = '" + errorObject.getErrorStackHash() + "'");

        	
            if (rs.next()) {
            	
            	//In case there is a result returned from the search, we need to update the main table with reference of the idErrorStackDictionary
            	
            	System.out.println(errorObject.getObjectHash());
                addToMainTable(rs.getString(1), errorObject);
                
            }else{
            	
            	//In case there is no result returned from the search, we need to update the dictionary and to update the main table with reference of the idErrorStackDictionary
            	
            	if(errorObject.getErrorStackHash() != null){
            		
            		//check if there is an actual error stack
            		
	            	System.out.println("Not found! Will Add");
	            	
	            	String SQL_INSERT = "INSERT INTO errorstackdictionary (HashNumber, FullStackTrace, LoggedForFirstTime, LoggedLastTime) VALUES (?,?,?,?)";
	            	
	            	try(PreparedStatement statement = con.prepareStatement(SQL_INSERT)){
	            		statement.setInt(1, Integer.parseInt(errorObject.ErrorStackHash));
	            		statement.setString(2, errorObject.getStackTrace());
	            		statement.setString(3, errorObject.getErrorLogDate().getDate() + " " + errorObject.getErrorLogDate().getTime());
	            		statement.setString(4, errorObject.getErrorLogDate().getDate() + " " + errorObject.getErrorLogDate().getTime());
	            		statement.executeUpdate();
	            	}
	            	
            	}else{
            		
            		//if there is no actual error stack just enter it in the main table
            		//System.out.println("Without stack!");
            	}
            }
        	
        }catch (SQLException ex) {
            Logger lgr = Logger.getLogger(checkDBConnection.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);

        }finally {
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


	private static void addToMainTable(String string, ErrorObject errorObject) {
		// TODO Auto-generated method stub
		
	}
    
}
