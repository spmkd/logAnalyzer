package Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.fabric.jdbc.ErrorReportingExceptionInterceptor;

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

        	//System.out.println("ItsHere," + errorObject.getObjectHash());
        	
            if (rs.next()) {
            	
            	//In case there is a result returned from the search, we need to:
            	// - check if the LoggedForFirstTime is earlier than the one recorded
            	// - check if the LoggedLastTime is later than the one recorded
            	// - update the main table with reference of the idErrorStackDictionary
            	
            	String SQL_UPDATE = "UPDATE errorstackdictionary SET ";
            	Boolean shouldIUpdate = false;

            	if (checkLoggedForFirstTime(rs, errorObject)){
            		//System.out.println("Should update loggedFirstTime");
            		SQL_UPDATE += " LoggedForFirstTime = '" + errorObject.getErrorLogDate().getDate() + " " + errorObject.getErrorLogDate().getTime() + "' ";
            		shouldIUpdate = true;
            	}
            	
            	if(checkLoggedLastTime(rs, errorObject)){
            		//System.out.println("Should update LoggedLastTime");
            		SQL_UPDATE += " LoggedLastTime = '" + errorObject.getErrorLogDate().getDate() + " " + errorObject.getErrorLogDate().getTime() + "' ";
            		shouldIUpdate = true;
            	}
            	
            	if (shouldIUpdate){
            		SQL_UPDATE += " WHERE idErrorStackDictionary = '" + rs.getString(1) + "';";
            		
            		
            		//System.out.println("SQL UPDATE: " + SQL_UPDATE);
                	PreparedStatement statement = con.prepareStatement(SQL_UPDATE);
                	statement.executeUpdate();
            	}
            	
            	
            	//System.out.println(errorObject.getObjectHash());
                addToMainTable(rs.getString(1), errorObject);
                
            }else{
            	
            	//In case there is no result returned from the search, we need to update the dictionary and to update the main table with reference of the idErrorStackDictionary
            	
            	if(errorObject.getErrorStackHash() != null){
            		
            		//check if there is an actual error stack
	            	
	            	String SQL_INSERT = "INSERT INTO errorstackdictionary (HashNumber, FullStackTrace, LoggedForFirstTime, LoggedLastTime, TheErrorMessage) VALUES (?,?,?,?,?)";
	            	
	            	try(PreparedStatement statement = con.prepareStatement(SQL_INSERT)){
	            		statement.setInt(1, Integer.parseInt(errorObject.ErrorStackHash));
	            		statement.setString(2, errorObject.getStackTrace());
	            		statement.setString(3, errorObject.getErrorLogDate().getDate() + " " + errorObject.getErrorLogDate().getTime());
	            		statement.setString(4, errorObject.getErrorLogDate().getDate() + " " + errorObject.getErrorLogDate().getTime());
	            		statement.setString(5, errorObject.getMsg());
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

	private static boolean checkLoggedForFirstTime(ResultSet rs2, ErrorObject errorObject) {
		
		try {
			
			Date inDbDate = null;
			Date inErrorObject = null;
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			
			try {
				
				if(rs2.getString(4).length()==21)
				{
					String tmpParse = rs2.getString(4) + "00";
					inDbDate =  sdf.parse(tmpParse);
				}else if(rs2.getString(4).length()==22)
				{
					String tmpParse = rs2.getString(4) + "0";
					inDbDate =  sdf.parse(tmpParse);
				}else if(rs2.getString(4).length()==23)
				{
					inDbDate =  sdf.parse(rs2.getString(4));
				}
				
				inErrorObject = sdf.parse( errorObject.getErrorLogDate().getDate() + " " + errorObject.getErrorLogDate().getTime());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			if ( inDbDate.after(inErrorObject) ){
				return true;
			}
			
			//System.out.println("checkDateTimeInDictinoray - " + inDbDate + " in ErrorObject - " + inErrorObject);			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	private static boolean checkLoggedLastTime(ResultSet rs2, ErrorObject errorObject) {
		
		try {
			
			Date inDbDate = null;
			Date inErrorObject = null;
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			
			try {
				
				if(rs2.getString(5).length()==21)
				{
					String tmpParse = rs2.getString(5) + "00";
					inDbDate =  sdf.parse(tmpParse);
				}else if(rs2.getString(5).length()==22)
				{
					String tmpParse = rs2.getString(5) + "0";
					inDbDate =  sdf.parse(tmpParse);
				}else if(rs2.getString(5).length()==23)
				{
					inDbDate =  sdf.parse(rs2.getString(5));
				}
				
				String secondObject = errorObject.getErrorLogDate().getDate() + " " + errorObject.getErrorLogDate().getTime();

				inErrorObject = sdf.parse(secondObject);

			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			if ( inDbDate.before(inErrorObject) ){
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	private static void addToMainTable(String string, ErrorObject errorObject) {		
	}
    
}
