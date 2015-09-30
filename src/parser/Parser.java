package parser;

import java.util.ArrayList;

import DataObjects.ErrorObject;
import configuration.Log;

public class Parser {

	public static void applicationParse(ArrayList<String> bufferedLine, Log thisLog){

		PBO pbo = new PBO();
		ErrorObject EO = new ErrorObject();
		
		EO = pbo.processObject(bufferedLine);
		
	}
	
}