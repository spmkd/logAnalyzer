package readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import Logger.DataBaseAccess;
import configuration.Log;
import dataObjects.ErrorObject;
import main.MainClass;
import parser.Parser;
import reader.Reader;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class ApplicationReader extends Reader{

	long startTime;
	long estimatedTime;
	
	private static final Logger log4j = LogManager.getLogger(MainClass.class.getName());
	
	public ApplicationReader(Log log) {
		super(log);
		
		log4j.info("[" + this.getName() + " started!] - [Location: " + thisLog.getLocation() + "]");
	}
	
	public void run() {
		
		// We need a timer to display the whole time
		startTime = System.currentTimeMillis();
		
		// First, we need to check whether this is Continuous or OneTimeRead
		boolean Continuous=true;
		
		if (thisLog.getType() == 'O'){Continuous=false;}

		// Here, we start our reading 

		try{

			// The BufferedLine is so that we can get several lines of ERROR log or single line of other logs

			ArrayList<String> BufferedLine = new ArrayList<String>();

			BufferedReader br = new BufferedReader(new FileReader(thisLog.getLocation()));
			String line;
			
			// If we need continuous stream Continuous will be always true and the condition will be met. Otherwise, once the file is read, both conditions will be false
			
			while ( ((line = br.readLine()) != null) || (Continuous)) {
				
				if(line == null){
					//in case there is no new data written in the log, pause the execution for 1 sec
					System.out.println("need to sleep!");
					Thread.sleep(1000);
                    continue;
				}

				//There might be an empty line so we need to take care of it
				
				String FirstChar = new String();
				
				if (line.length()==0){
					FirstChar = "";
				}else{
					FirstChar = line.substring(0, 1);
				}
				
				if ( FirstChar.startsWith("[") ){

					//if the BufferedLine array list is emtpy, it means we are starting a new feed
					//if the BufferedLine is not emtpy, it means we have reached a new error and we need to flush the 
					//whole buffered information for processing to be made ERROR object off

					if ( BufferedLine.isEmpty() ){

						BufferedLine.add(line);

					}else{

						//1. This is when we receive a new line which should be a new entry
						//2. We need to put the previous objects for processing
						//3. We clear the current ArrayList and after that we put the new line
						
						ErrorObject EO = parseMessage(BufferedLine,thisLog);
						
						DAcheckErrorInDictionary(EO);
						
						BufferedLine.clear();
						BufferedLine.add(line);

					}

				}else{
					BufferedLine.add(line);
				}

			}
			
			if (!BufferedLine.isEmpty()){
				
				ErrorObject EO = parseMessage(BufferedLine,thisLog);
				DAcheckErrorInDictionary(EO);			
				BufferedLine.clear();
			}
			
			br.close();
		} catch (Exception e) {e.printStackTrace();}
		
		// Calculate end time
		estimatedTime = System.currentTimeMillis() - startTime;
		
		log4j.info("[" + this.getName() + " stopped!] - [Location: " + thisLog.getLocation() + "] - [Time Elapsed: " + (estimatedTime / 1000) + " seconds ]");
		
	}
	
	public synchronized void  DAcheckErrorInDictionary(ErrorObject eo){
		
		DataBaseAccess.CheckErrorInDictionary(eo);
		
	}
	
	public synchronized ErrorObject parseMessage(ArrayList<String> bufferedLine, Log thisLog){
		
		return Parser.applicationParse(bufferedLine, thisLog);
		
	}

}