package dataObjects;

public class SystemInformation {
	
	private String RequestID;
	private String StartDate;
	private String SessionType;
	private String SessionID;
	private String UserID;
	private String ServerName;
	private String ServerPort;
	
	public String getRequestID() {
		return RequestID;
	}
	public void setRequestID(String requestID) {
		RequestID = requestID;
	}
	public String getStartDate() {
		return StartDate;
	}
	public void setStartDate(String startDate) {
		StartDate = startDate;
	}
	public String getSessionType() {
		return SessionType;
	}
	public void setSessionType(String sessionType) {
		SessionType = sessionType;
	}
	public String getSessionID() {
		return SessionID;
	}
	public void setSessionID(String sessionID) {
		SessionID = sessionID;
	}
	public String getUserID() {
		return UserID;
	}
	public void setUserID(String userID) {
		UserID = userID;
	}
	public String getServerName() {
		return ServerName;
	}
	public void setServerName(String serverName) {
		ServerName = serverName;
	}
	public String getServerPort() {
		return ServerPort;
	}
	public void setServerPort(String serverPort) {
		ServerPort = serverPort;
	}
	
	

}
