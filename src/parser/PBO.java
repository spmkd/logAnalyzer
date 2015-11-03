package parser;

import java.util.ArrayList;

import dataObjects.ErrorDate;
import dataObjects.ErrorObject;
import dataObjects.RequestInformation;
import dataObjects.RequestParameter;
import dataObjects.RequestParameters;
import dataObjects.SystemInformation;



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

	ErrorObject errorObject = new ErrorObject();
	
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

	public ErrorObject processObject(ArrayList<String> completeErrorStack) {
		
		//we get the first error line and split all parts into a StringArray
		splitFirstErrorLine(completeErrorStack.get(0));
		
		checkForErrorStack(completeErrorStack);
		checkForSystemInformation(completeErrorStack);
		checkForRequestInfo(completeErrorStack);
		checkForRequestParam(completeErrorStack);
		
		return errorObject;
	}

	private void checkForRequestParam(ArrayList<String> completeErrorStack) {

		/* We will get the Request Parameters by going through the whole error stack
		 * and checking if there is a field labeled: 
		 * 
		 * Request Parameters
		 * ------------------
		 */
		
		Integer theStartIndex;
		
		if ( (completeErrorStack.contains("Request Parameters")) &&  (completeErrorStack.contains("------------------")) ){
			
			theStartIndex = completeErrorStack.indexOf("Request Parameters");
			RequestParameters tempReqParm = new RequestParameters();
			
			ArrayList<RequestParameter> tempParams = new ArrayList<RequestParameter>();
			
			// The First Line is the Title, second are the - and after that we start with the info.
			// We need to split each line into two parts, separated by =
			
			for (int i=theStartIndex+2; i<completeErrorStack.size();i++){
				
				String check = completeErrorStack.get(i);

				if (check.isEmpty()){
					break;
				}else{
					
					String[] tempSplit = check.split("=");
					
					// in case some parameter does not have a value, we need to set it to ""
					
					if(tempSplit.length==1){
						
						tempParams.add(new RequestParameter(tempSplit[0],""));
						
						continue;
					}
					
					tempParams.add(new RequestParameter(tempSplit[0],tempSplit[1]));
					
				}
				
			}
			
			tempReqParm.setAllRequestParameter(tempParams);
			
			errorObject.setRequestParameters(tempReqParm);
			
		}
		
	}

	private String printTempSplitContains(String message, String[] tempSplit) {
		// TODO Auto-generated method stub
		
//		System.out.print(message);
		
		for (String s : tempSplit){
			System.out.print(" - " + s);
		}
		
//		System.out.println();
		
		return null;
	}

	private void checkForRequestInfo(ArrayList<String> completeErrorStack) {

		/* We will get the Request information by going through the whole error stack
		 * and checking if there is a field labeled: 
		 * 
		 * Request Information
		 * ------------------
		 */
		
		Integer theStartIndex;
		
		if ( (completeErrorStack.contains("Request Information")) &&  (completeErrorStack.contains("------------------")) ){
			
			theStartIndex = completeErrorStack.indexOf("Request Information");
			RequestInformation tempReqInf = new RequestInformation();
			
			// The First Line is the Title, second are the - and after that we start with the info.
			// We need to split each line into two parts, separated by :
			
			for (int i=theStartIndex+2; i<completeErrorStack.size();i++){
				
				String check = completeErrorStack.get(i);

				if (check.isEmpty()){
					break;
				}else{
					
					String[] tempSplit = check.split(":");
					
					switch (tempSplit[0]) {
					
					case "URI":
						tempReqInf.setURI(tempSplit[1].trim());
						break;
						
					case "Method":
						tempReqInf.setMethod(tempSplit[1].trim());
						break;
						
					case "PathInfo":
						tempReqInf.setPathInfo(tempSplit[1].trim());
						break;
						
					case "QueryString":
						tempReqInf.setQueryString(tempSplit[1].trim());
						break;
						
					case "Remote Address":
						tempReqInf.setRemoteAddress(tempSplit[1].trim());
						break;
					
					default:
						String message = "Unexpected Request Information";
						printTempSplitContains(message,tempSplit);
					
					}
					
				}
				
			}
			
			errorObject.setRequestInformation(tempReqInf);
			
		}
		
	}

	private void checkForSystemInformation(ArrayList<String> completeErrorStack) {

		/* We will get the SYSTEM information by going through the whole error stack
		 * and checking if there is a field labeled: 
		 * 
		 * System Information
		 * ------------------
		 */
		
		Integer theStartIndex;
		
		if ( (completeErrorStack.contains("System Information")) &&  (completeErrorStack.contains("------------------")) ){
			
			theStartIndex = completeErrorStack.indexOf("System Information");
			SystemInformation tempSysInf = new SystemInformation();
			
			// The First Line is the Title, second are the - and after that we start with the info.
			// We need to split each line into two parts, separated by :
			
			for (int i=theStartIndex+2; i<completeErrorStack.size();i++){
				
				String check = completeErrorStack.get(i);

				if (check.isEmpty()){
					break;
				}else{
					
					String[] tempSplit = check.split(":");
					
					switch (tempSplit[0]) {
					
					case "RequestID":
						tempSysInf.setRequestID(tempSplit[1].trim());
						break;
					
					case "StartDate":
						tempSysInf.setStartDate(tempSplit[1].trim() + ":" + tempSplit[2].trim() + ":" + tempSplit[3].trim());
						break;
						
					case "SessionType":
						tempSysInf.setSessionType(tempSplit[1].trim());
						break;
						
					case "SessionID":
						tempSysInf.setSessionID(tempSplit[1].trim());
						break;
						
					case "UserID":
						tempSysInf.setUserID(tempSplit[1].trim());
						break;
						
					case "ServerName":
						tempSysInf.setServerName(tempSplit[1].trim());
						break;
						
					case "ServerPort":
						tempSysInf.setServerPort(tempSplit[1].trim());
						break;
						
					default:
						String message = "Unexpected System Information";
						printTempSplitContains(message,tempSplit);
					
					}
					
				}
				
			}
			
			errorObject.setSystemInformation(tempSysInf);
			
		}
		
	}

	private void checkForErrorStack(ArrayList<String> completeErrorStack) {

		/* Error stacks should start at the second line and end with an empty line
		 * Error stack might not be present. As I have seen, all stacktraces start with:	at
		 */
		
		// here we check whether the Error is one line only. If it is, there is no stack or stuff
		if (completeErrorStack.size()==1){
			return;
		}
		
		String tempLine = new String();
		
		String forHashFromStack = new String();
		
		tempLine = completeErrorStack.get(1);
		
		if(!tempLine.startsWith("\tat")){
			return;
		}
		
		forHashFromStack += tempLine;
		
		for(int i=2; i<completeErrorStack.size(); i++){
			
			tempLine = completeErrorStack.get(i);
			
			if(tempLine.isEmpty()){
				break;
			}else{
				forHashFromStack += tempLine;
			}
			
		}
		
		int theHash = forHashFromStack.hashCode();
		
		errorObject.setErrorStackHash(Integer.toString(theHash));
		
		errorObject.setStackTrace(forHashFromStack);
		
	}

	private void splitFirstErrorLine(String firstErrorLine) {
		
		//The Date and Time between the brackets
		//Assign it to the first in the ArrayList
		int OpenBracketInDate = 1, ClosedBracketInDate;
		
		ClosedBracketInDate = firstErrorLine.indexOf("]");
		
		
		ErrorDate eDate = new ErrorDate();
		eDate.parseDateAndTime(firstErrorLine.substring(OpenBracketInDate, ClosedBracketInDate));
		
		errorObject.setErrorLogDate(eDate);
		
		//Put the type in the second one [ERROR, WARN, INFO]
		
		int EndOfType = firstErrorLine.indexOf(" ", ClosedBracketInDate+2);
		
		errorObject.setType(firstErrorLine.substring(ClosedBracketInDate+2, EndOfType));
		
		//Hostname
		
		int EndOfHostName = firstErrorLine.indexOf(" ", EndOfType + 1);
		
		errorObject.setLocalServerName(firstErrorLine.substring(EndOfType+1, EndOfHostName));
		
		//INSTANCE ES2, ES1
		
		int EndOfInstance = firstErrorLine.indexOf(" ", EndOfHostName + 1);
		
		errorObject.setServerInstance(firstErrorLine.substring(EndOfHostName+1, EndOfInstance));
		
		//NODE appserver0, appserver1, appserver2
		
		int EndOfNode = firstErrorLine.indexOf(" ", EndOfInstance + 1);
		
		errorObject.setServerNode(firstErrorLine.substring(EndOfInstance+1, EndOfNode));
		
		//RequestSite
		
		int EndOfRequestSite = firstErrorLine.indexOf("]", EndOfNode + 2);
		
		errorObject.setRequestSite(firstErrorLine.substring(EndOfNode+2, EndOfRequestSite));
		
		//RequestApplication
		
		int EndOfRequestApplication = firstErrorLine.indexOf("]", EndOfRequestSite + 3);
		
		errorObject.setRequestApplication(firstErrorLine.substring(EndOfRequestSite+3, EndOfRequestApplication));
		
		//Logger
		
		int EndOfLogger = firstErrorLine.indexOf(" ", EndOfRequestApplication + 2);
		
		errorObject.setLogger(firstErrorLine.substring(EndOfRequestApplication+2, EndOfLogger));
		
		//Marker
		
		int Marker = firstErrorLine.indexOf("]", EndOfLogger + 2);
		
		errorObject.setMarker(firstErrorLine.substring(EndOfLogger+2, Marker));
		
		//RequestType
		
		int RequestType = firstErrorLine.indexOf("]", Marker + 2);
		
		errorObject.setRequestType(firstErrorLine.substring(Marker+3, RequestType));
		
		//SessionId
		
		int SessionId = firstErrorLine.indexOf("]", RequestType + 2);
		
		errorObject.setSessionId(firstErrorLine.substring(RequestType+3, SessionId));
		
		//RequestUUID
		
		int RequestUUID = firstErrorLine.indexOf("]", SessionId + 2);
		
		errorObject.setRequestUuid(firstErrorLine.substring(SessionId+3, RequestUUID));
		
		//LOGThread
		
		int LOGThread = firstErrorLine.indexOf("\"", RequestUUID + 3);
		
		errorObject.setThread(firstErrorLine.substring(RequestUUID+3, LOGThread));

		//LogMSG This should be the last line before the exception is logged
		
		errorObject.setMsg(firstErrorLine.substring(LOGThread+1));
		
	}

	
	
}
