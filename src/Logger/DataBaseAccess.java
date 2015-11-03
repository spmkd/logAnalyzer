package Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import dataObjects.ErrorObject;

public class DataBaseAccess {
	
    public static Connection con = null;
    public static Statement st = null;
    public static Statement stU = null;
    public static ResultSet rs = null;
    
    String url = "jdbc:mysql://localhost:3306/testdb";
    String user = "testuser";
    String password = "test623";


    public void CheckErrorInDictionary(ErrorObject errorObject){
    	
        
        try {
        	con = DriverManager.getConnection(url, user, password);
        	
        	st = con.createStatement();
        	
        	stU = con.createStatement();
        	
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
	            	
	            	String SQL_INSERT = "INSERT INTO errorstackdictionary"
	        		+ " (HashNumber, FullStackTrace, LoggedForFirstTime, LoggedLastTime) VALUES"
	        		+ "(\"" + errorObject.ErrorStackHash 
	        		+ "\",\"" + errorObject.getStackTrace() 
	        		+ "\",\"" + errorObject.getErrorLogDate().getDate() + " " + errorObject.getErrorLogDate().getTime() 
	        		+ "\",\"" + errorObject.getErrorLogDate().getDate() + " " + errorObject.getErrorLogDate().getTime() + "\")";
	            	
	            	stU.executeUpdate(SQL_INSERT);
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


	private void addToMainTable(String string, ErrorObject errorObject) {
		// TODO Auto-generated method stub
		
	}
    
}
