package main;

import configuration.Configuration;
import configuration.Log;
import readers.ApplicationReader;
import org.apache.logging.log4j.Logger; 
import org.apache.logging.log4j.LogManager;

public class MainClass {
	
	private static final Logger log4j = LogManager.getLogger(MainClass.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainClass LogAnalyzer = new MainClass();
		LogAnalyzer.start();
	}

	private void start() {
		// TODO Auto-generated method stub
		
		log4j.info("1.0 initialize...");
		this.initialize();
		
		log4j.info("2.0 Start reading all logs...");
		this.LoadAllReaderClasses();
		
		log4j.info("2.2 All Threads Started. Initialization Finished!");

	}
	
	private void initialize(){

		log4j.info("1.1 Read Configuration File...");
		Configuration.readConfigurationFile();
		
		log4j.info("1.2 Put all configuration data into classes...");
		Configuration.fillAllLogfiles();
		
	}

	private void LoadAllReaderClasses() {
		// TODO Auto-generated method stub
		
		for (Log n : Configuration.allLogFiles){
			
			log4j.info("2.1 Starting a Log Reader Thread!");
			ApplicationReader worker = new ApplicationReader(n);
			worker.start();
			
		}
		
	}

}
