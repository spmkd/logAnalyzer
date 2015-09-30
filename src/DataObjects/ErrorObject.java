package DataObjects;

import java.util.ArrayList;

//In this class every Error Object will be stored
//
//This will be from the [DATE.... ends with the start of the next [

public class ErrorObject {
	
	ErrorDate ErrorLogDate;			//2015-06-03 15:58:38.360 +0200CEST
	String Type; 					//ERROR
	String LocalServerName;			//jmbpapp12.jmbp.local
	String ServerInstance;			//ES1, ES2
	String ServerNode;				//appserver0, appserver1
	String RequestSite;				//Jumbo-Grocery-Site
	String RequestApplication;		//[mobile]
	String Logger;					//com.intershop.beehive.core.internal.request.RequestHandlerServlet
	String Marker;
	String RequestType;				//Storefront
	String SessionId;				//rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr
	String RequestUuid;				//Nna6AVVuJwAaHGMK-1-01
	String Thread;					//Nna6AVVuJwAaHGMK-1-01
	String Msg;						//ISH-CORE-2351: Exception occurred during request processing:
	ArrayList<String> StackTrace;	//Complete Track Trace
	String UserId;					//jUMKYx4iDzgAAAFNdgxJ4rQq
	String ServerName;				//www.jumbo.com
	String ServerPort;				//80
	String URI;						///servlet/Beehive/WFS/Jumbo-Grocery-Site/nl_NL/-/EUR/ViewPromotionDetailpage-Start
	String Method;					//GET
	String PathInfo;				///WFS/Jumbo-Grocery-Site/nl_NL/-/EUR/ViewPromotionDetailpage-Start
	String QueryString;				//tabURL=week18&promotionID=9403058-B-1
	String RemoteAddress;			//207.86.215.199
	String TabURL;					//week18
	String PromotionID;				//9403058-B-1
	
	public ErrorDate getErrorLogDate() {
		return ErrorLogDate;
	}
	public void setErrorLogDate(ErrorDate errorLogDate) {
		ErrorLogDate = errorLogDate;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getLocalServerName() {
		return LocalServerName;
	}
	public void setLocalServerName(String localServerName) {
		LocalServerName = localServerName;
	}
	public String getServerInstance() {
		return ServerInstance;
	}
	public void setServerInstance(String serverInstance) {
		ServerInstance = serverInstance;
	}
	public String getServerNode() {
		return ServerNode;
	}
	public void setServerNode(String serverNode) {
		ServerNode = serverNode;
	}
	public String getRequestSite() {
		return RequestSite;
	}
	public void setRequestSite(String requestSite) {
		RequestSite = requestSite;
	}
	public String getRequestApplication() {
		return RequestApplication;
	}
	public void setRequestApplication(String requestApplication) {
		RequestApplication = requestApplication;
	}
	public String getLogger() {
		return Logger;
	}
	public void setLogger(String logger) {
		Logger = logger;
	}
	public String getMarker() {
		return Marker;
	}
	public void setMarker(String marker) {
		Marker = marker;
	}
	public String getRequestType() {
		return RequestType;
	}
	public void setRequestType(String requestType) {
		RequestType = requestType;
	}
	public String getSessionId() {
		return SessionId;
	}
	public void setSessionId(String sessionId) {
		SessionId = sessionId;
	}
	public String getRequestUuid() {
		return RequestUuid;
	}
	public void setRequestUuid(String requestUuid) {
		RequestUuid = requestUuid;
	}
	public String getThread() {
		return Thread;
	}
	public void setThread(String thread) {
		Thread = thread;
	}
	public String getMsg() {
		return Msg;
	}
	public void setMsg(String msg) {
		Msg = msg;
	}
	public ArrayList<String> getStackTrace() {
		return StackTrace;
	}
	public void setStackTrace(ArrayList<String> stackTrace) {
		StackTrace = stackTrace;
	}
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
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
	public String getURI() {
		return URI;
	}
	public void setURI(String uRI) {
		URI = uRI;
	}
	public String getMethod() {
		return Method;
	}
	public void setMethod(String method) {
		Method = method;
	}
	public String getPathInfo() {
		return PathInfo;
	}
	public void setPathInfo(String pathInfo) {
		PathInfo = pathInfo;
	}
	public String getQueryString() {
		return QueryString;
	}
	public void setQueryString(String queryString) {
		QueryString = queryString;
	}
	public String getRemoteAddress() {
		return RemoteAddress;
	}
	public void setRemoteAddress(String remoteAddress) {
		RemoteAddress = remoteAddress;
	}
	public String getTabURL() {
		return TabURL;
	}
	public void setTabURL(String tabURL) {
		TabURL = tabURL;
	}
	public String getPromotionID() {
		return PromotionID;
	}
	public void setPromotionID(String promotionID) {
		PromotionID = promotionID;
	}

}
