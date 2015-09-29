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
		
		Configuration.readConfigurationFile();
		Configuration.fillAllLogfiles();
		
		this.LoadAllReaderClasses();

	}

	private void LoadAllReaderClasses() {
		// TODO Auto-generated method stub
		
		for (Log n : Configuration.allLogFiles){
			
			ApplicationReader worker = new ApplicationReader(n);
			worker.start();
			
		}
		
	}

}
