package reader;

import configuration.Log;

public class Reader extends Thread {
	
	Log thisLog;
	
	public Reader(Log a) {
		this.thisLog = a;
	}

	public void run() {
		System.out.println("WORKIIING!");
	}
	
}
