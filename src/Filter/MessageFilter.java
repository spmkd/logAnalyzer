package Filter;

public class MessageFilter {

	public static String FilterIt(String errorMessage){
		
		if (errorMessage.contains("!!!File")){
			return "!!!File";
		
		}else if (errorMessage.matches(".*Cannot parse query string.*bad parameter.*")){
			return "Cannot parse query string...bad parameter";
		
		}else if (errorMessage.matches(".*Got to have reservation handle against the cart.*Check the flow that caused this pipelet to be invoked with cart not containing the reservation. ")){
			return "[ExtendBasketReservation] Got to have reservation handle against the cart";
			
		}
		
		return errorMessage; //this is it
	}
	
	public static String EscapeApostrophes(String errorMessage){
		
		if(errorMessage.contains("'")){
			errorMessage = errorMessage.replaceAll("'", "\'\'");
		}
		
		return errorMessage;
	}
	
}