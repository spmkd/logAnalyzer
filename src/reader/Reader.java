package reader;

import configuration.Log;

public class Reader extends Thread {
	
	Log thisLog;
	
	public Reader(Log log) {
		this.thisLog = log;
	}
	
}
