package Filter;

import org.apache.logging.log4j.Logger;

import main.MainClass;

import org.apache.logging.log4j.LogManager;

public class MessageFilter {
	
	private static final Logger log4j = LogManager.getLogger(MainClass.class.getName());

	public static String FilterIt(String errorMessage){
		
		log4j.debug(errorMessage);
		
		if (errorMessage.contains("!!!File")){
			return "!!!File";
		
		}else if (errorMessage.matches(".*Cannot parse query string.*bad parameter.*")){
			return "Cannot parse query string...bad parameter";
		
		}else if (errorMessage.matches(".*Got to have reservation handle against the cart.*Check the flow that caused this pipelet to be invoked with cart not containing the reservation. ")){
			return "[ExtendBasketReservation] Got to have reservation handle against the cart";
			
		}else if (errorMessage.matches(".*Error while trying to validate token. providedRefreshToken.*")){
			return	"Error while trying to validate token. providedRefreshToken";
					
		}else if (errorMessage.matches(".*Error received when executing Fredhopper query.*")){
			return "Error received when executing Fredhopper query";
			
		}else if (errorMessage.matches(".*Servlet\\.service.*for servlet.*in context with path.*threw exception java\\.lang\\.IllegalArgumentException.*")){
			return "Servlet.service() for servlet [RequestHandlerServlet] in context with path [\\] threw exception java.lang.IllegalArgumentException";
			
		}else if (errorMessage.matches(".*true . Couldn't retrieve order by orderRefID.*")){
			return "true . Couldn't retrieve order by orderRefID";
			
		}else if (errorMessage.matches(".*3 - FH1_S0007 - FredHopper search error.*")){
			return "3 - FH1_S0007 - FredHopper search error : Error Occurred requesting search com.javelingroup.majestic.fredhopper.capi.SearchServiceException";
			
		}else if (errorMessage.matches(".*No Bazaarvoice response received for the following SKUs.*")){
			
			return "No Bazaarvoice response received for the following SKUs";
		}
		
		return errorMessage; //this is it
	}
	
	public static String EscapeApostrophes(String errorMessage){
		
		if(errorMessage.contains("'")){
			errorMessage = errorMessage.replaceAll("'", "\'\'");
		}
		
		return errorMessage;
	}
	
//	public static void main(String[] args)
//	{
//		String input = " Servlet.service() for servlet [RequestHandlerServlet] in context with path [/] threw exception java.lang.IllegalArgumentException: Illegal character in path at index 38: http://10.47.4.200:4503/tablet/action/{{=";
//		String regexp = ".*Servlet.service.*for servlet.*in context with path.*threw exception java.lang.IllegalArgumentException.*";
//		
//		Pattern p = Pattern.compile(regexp);
//		Matcher m = p.matcher(input);
//		if (m.matches())
//		{
//			System.out.println("matches");
//		}
//	}
	
}