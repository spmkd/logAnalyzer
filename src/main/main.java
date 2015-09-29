package main;

import configuration.Configuration;
import configuration.Log;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		main LogAnalyzer = new main();
		LogAnalyzer.start();
	}

	private void start() {
		// TODO Auto-generated method stub
		
		Configuration.readConfigurationFile();
		Configuration.fillAllLogfiles();
		
		this.LoadAllReaderClasses();

	}

	private void LoadAllReaderClasses() {
		// TODO Auto-generated method stub
		
		for (Log n : Configuration.allLogFiles){
			
			
			
		}
		
	}

}
