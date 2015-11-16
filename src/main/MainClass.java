package main;

import configuration.Configuration;
import configuration.Log;
import readers.ApplicationReader;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainClass LogAnalyzer = new MainClass();
		LogAnalyzer.start();
	}

	private void start() {
		// TODO Auto-generated method stub
		
		System.out.println("1.0 initialize...");
		this.initialize();
		
		System.out.println("2.0 Start reading all logs...");
		this.LoadAllReaderClasses();
		
		System.out.println("3.0 Finished reading all logs!");

	}
	
	private void initialize(){

		System.out.println("1.1 Read Configuration File...");
		Configuration.readConfigurationFile();
		
		System.out.println("1.2 Put all configuration data into array...");
		Configuration.fillAllLogfiles();
		
	}

	private void LoadAllReaderClasses() {
		// TODO Auto-generated method stub
		
		for (Log n : Configuration.allLogFiles){
			
			ApplicationReader worker = new ApplicationReader(n);
			worker.start();
			
		}
		
	}

}
