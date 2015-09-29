package parser;

import java.util.ArrayList;

import DataObjects.ErrorObject;



/* PBO - Process Buffered Objects
 * 
 * This class takes an ArrayList object filled with a line-by-line
 * strings of an error. 
 * 
 * A function within should return ErrorObject object
 * 
 * It starts from [... and ends and the next start of [....
 * 
 * All possible parts of an errors are logged in ErrorObject
 * 
 * First line of the ERROR should be separated in several different parts
 */


public class PBO {

	ErrorObject errorObject;
	
	/*
	 * We should separate the object into 3 parts:
	 * 
	 * 1. ERROR LINE
	 * 2. Stack Trace
	 * 3. Additional Information
	 * 
	 * The First line should be the ERROR Line
	 * After that starts the Strack Trace
	 * The Additional Information starts when a line starts with -
	 */
	
	String FirstErrorLine; //
	//ArrayList<String> StackTrace = new ArrayList<String>();
	ArrayList<String> SystemAndRequest = new ArrayList<String>();
	ArrayList<String> firstErrorLineParts = new ArrayList<String>();

	public ErrorObject processObject(ArrayList<String> string) {
		
		//we get the first error line and split all parts into a StringArray
		FirstErrorLine = string.get(0);
		
		firstErrorLineParts = splitFirstErrorLine(FirstErrorLine);
		
		return errorObject;
	}

	private ArrayList<String> splitFirstErrorLine(String firstErrorLine2) {
		// TODO Auto-generated method stub
		
		ArrayList<String> tempErrorLines = new ArrayList<String>();
		
		//The Date and Time between the brackets
		//Assign it to the first in the ArrayList
		int OpenBracketInDate = 1, ClosedBracketInDate;
		
		ClosedBracketInDate = firstErrorLine2.indexOf("]");
		
		tempErrorLines.add(firstErrorLine2.substring(OpenBracketInDate, ClosedBracketInDate));
		
		//Put the type in the second one [ERROR, WARN, INFO]
		
		int EndOfType = firstErrorLine2.indexOf(" ", ClosedBracketInDate+2);
		
		tempErrorLines.add(firstErrorLine2.substring(ClosedBracketInDate+2, EndOfType));
		
		//Hostname
		
		int EndOfHostName = firstErrorLine2.indexOf(" ", EndOfType + 1);
		
		tempErrorLines.add(firstErrorLine2.substring(EndOfType+1, EndOfHostName));
		
		
		//INSTANCE ES2, ES1
		
		int EndOfInstance = firstErrorLine2.indexOf(" ", EndOfHostName + 1);
		
		tempErrorLines.add(firstErrorLine2.substring(EndOfHostName+1, EndOfInstance));
		
		//NODE appserver0, appserver1, appserver2
		
		int EndOfNode = firstErrorLine2.indexOf(" ", EndOfInstance + 1);
		
		tempErrorLines.add(firstErrorLine2.substring(EndOfInstance+1, EndOfNode));
		
		//RequestSite
		
		int EndOfRequestSite = firstErrorLine2.indexOf("]", EndOfNode + 2);
		
		tempErrorLines.add(firstErrorLine2.substring(EndOfNode+2, EndOfRequestSite));
		
		//RequestApplication
		
		int EndOfRequestApplication = firstErrorLine2.indexOf("]", EndOfRequestSite + 3);
		
		tempErrorLines.add(firstErrorLine2.substring(EndOfRequestSite+3, EndOfRequestApplication));
		
		//Logger
		
		int EndOfLogger = firstErrorLine2.indexOf(" ", EndOfRequestApplication + 2);
		
		tempErrorLines.add(firstErrorLine2.substring(EndOfRequestApplication+2, EndOfLogger));
		
		//Marker
		
		int Marker = firstErrorLine2.indexOf("]", EndOfLogger + 2);
		
		tempErrorLines.add(firstErrorLine2.substring(EndOfLogger+2, Marker));

		//RequestType
		
		int RequestType = firstErrorLine2.indexOf("]", Marker + 2);
		
		tempErrorLines.add(firstErrorLine2.substring(Marker+3, RequestType));
		
		//SessionId
		
		int SessionId = firstErrorLine2.indexOf("]", RequestType + 2);
		
		tempErrorLines.add(firstErrorLine2.substring(RequestType+3, SessionId));
		
		//RequestUUID
		
		int RequestUUID = firstErrorLine2.indexOf("]", SessionId + 2);
		
		tempErrorLines.add(firstErrorLine2.substring(SessionId+3, RequestUUID));
		
		//LOGThread
		
		int LOGThread = firstErrorLine2.indexOf("\"", RequestUUID + 3);
		
		tempErrorLines.add(firstErrorLine2.substring(RequestUUID+3, LOGThread));

		//LogMSG This should be the last line before the exception is logged
		
		tempErrorLines.add(firstErrorLine2.substring(LOGThread+1));		
		
		return tempErrorLines;
	}

	
	
}
