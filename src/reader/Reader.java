package reader;

import configuration.Log;

public class Reader extends Thread {
	
	protected Log thisLog;
	
	public Reader(Log log) {
		this.thisLog = log;
	}
	
}
