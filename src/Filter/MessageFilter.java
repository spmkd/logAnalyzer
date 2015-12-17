package Filter;

public class MessageFilter {

	public static String FilterIt(String errorMessage){
		
		if (errorMessage.contains("!!!File")){
			return "!!!File";
		
		}else if (errorMessage.matches(".*Cannot parse query string.*bad parameter.*")){
			return "Cannot parse query string...bad parameter";
		}
		
		return errorMessage;
	}
	
}
