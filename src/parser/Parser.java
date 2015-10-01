package parser;

import java.util.ArrayList;

import configuration.Log;
import dataObjects.ErrorObject;

public class Parser {

	public static void applicationParse(ArrayList<String> bufferedLine, Log thisLog){

		PBO pbo = new PBO();
		ErrorObject EO = new ErrorObject();
		
		EO = pbo.processObject(bufferedLine);
		
	}
	
}