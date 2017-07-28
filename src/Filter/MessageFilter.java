package Filter;

import org.apache.logging.log4j.Logger;

import main.MainClass;

import org.apache.logging.log4j.LogManager;

public class MessageFilter {
	
	private static final Logger log4j = LogManager.getLogger(MainClass.class.getName());

	public static String FilterIt(String errorMessage){
		
		log4j.debug(errorMessage);
		
		errorMessage = clearTextInBrackets(errorMessage);
		errorMessage = removeAllNumbers(errorMessage);
		
		if (errorMessage.contains("!!!File")){
			return "!!!File";
			
		}else if (errorMessage.matches(".*No Bazaarvoice response received for the following SKUs.*")){
			
			return "No Bazaarvoice response received for the following SKUs";
		
		}
		
		return errorMessage; //this is it
	}
	
	private static String removeAllNumbers(String errorMessage) {
		
		return errorMessage.replaceAll("\\d", "");
		
	}

	private static String clearTextInBrackets(String errorMessage) {

		if(errorMessage.contains("[")){
			
			return errorMessage.replaceAll("\\[.*?\\]", "[]");
		
		}
		
		return errorMessage;
		
	}

	public static String EscapeApostrophes(String errorMessage){
		
		if(errorMessage.contains("'")){
			errorMessage = errorMessage.replaceAll("'", "\'\'");
		}
		
		return errorMessage;
	}
	
}