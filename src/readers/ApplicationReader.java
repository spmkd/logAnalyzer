package readers;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import configuration.Log;
import dataObjects.ErrorObject;
import parser.Parser;
import reader.Reader;

public class ApplicationReader extends Reader{


	public ApplicationReader(Log log) {
		super(log);
		
		System.out.println(this.getName() + " (label: " + thisLog.getLabel() + ") starting!");
	}
	
	public void run() {
		
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
					Thread.sleep(1000);
					System.out.println("need to sleep!");
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
						
						BufferedLine.clear();
						BufferedLine.add(line);

					}

				}else{
					BufferedLine.add(line);
				}

			}
			br.close();
		} catch (Exception e) {e.printStackTrace();}
		
		System.out.println(this.getName() + " (label: " + thisLog.getLabel() + ") stopping!");
		
	}
	
	public synchronized ErrorObject parseMessage(ArrayList<String> bufferedLine, Log thisLog){
		
		return Parser.applicationParse(bufferedLine, thisLog);
		
	}

}