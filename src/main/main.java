package main;

import configuration.Configuration;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		main LogAnalyzer = new main();
		LogAnalyzer.start();
	}

	private void start() {
		// TODO Auto-generated method stub
		
		Configuration.readConfigurationFile();
		Configuration.parseLogLines();
		
	}

}
