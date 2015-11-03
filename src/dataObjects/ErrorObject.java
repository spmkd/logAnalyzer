package dataObjects;

//In this class every Error Object will be stored
//
//This will be from the [DATE.... ends with the start of the next [

public class ErrorObject {
	
	public ErrorDate ErrorLogDate;					//2015-06-03 15:58:38.360 +0200CEST
	public String Type; 							//ERROR
	public String LocalServerName;					//jmbpapp12.jmbp.local
	public String ServerInstance;					//ES1, ES2
	public String ServerNode;						//appserver0, appserver1
	public String RequestSite;						//Jumbo-Grocery-Site
	public String RequestApplication;				//[mobile]
	public String Logger;							//com.intershop.beehive.core.internal.request.RequestHandlerServlet
	public String Marker;
	public String RequestType;						//Storefront
	public String SessionId;						//rrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr
	public String RequestUuid;						//Nna6AVVuJwAaHGMK-1-01
	public String Thread;							//Nna6AVVuJwAaHGMK-1-01
	public String Msg;								//ISH-CORE-2351: Exception occurred during request processing:
	public String StackTrace;						//Complete StackTrace
	public String UserId;							//jUMKYx4iDzgAAAFNdgxJ4rQq
	public String ServerName;						//www.jumbo.com
	public String ServerPort;						//80
	public String URI;								///servlet/Beehive/WFS/Jumbo-Grocery-Site/nl_NL/-/EUR/ViewPromotionDetailpage-Start
	public String Method;							//GET
	public String PathInfo;							///WFS/Jumbo-Grocery-Site/nl_NL/-/EUR/ViewPromotionDetailpage-Start
	public String QueryString;						//tabURL=week18&promotionID=9403058-B-1
	public String RemoteAddress;					//207.86.215.199
	public String TabURL;							//week18
	public String PromotionID;						//9403058-B-1
	
	public SystemInformation systemInformation;		//Complete System Informaiton
	public RequestInformation requestInformation;	//Complete Request Information
	public RequestParameters requestParameters;		//Complete Request Parameters
	
	public String ErrorStackHash;					//HashTag created from all lines in the Error Stack trace
	public String ObjectHash;						//Is created by combining ErrorDate, Type, LocalServerName,ServerNode
	
	public RequestInformation getRequestInformation() {
		return requestInformation;
	}
	public void setRequestInformation(RequestInformation requestInformation) {
		this.requestInformation = requestInformation;
	}
	public RequestParameters getRequestParameters() {
		return requestParameters;
	}
	public void setRequestParameters(RequestParameters requestParameters) {
		this.requestParameters = requestParameters;
	}
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
	public SystemInformation getSystemInformation() {
		return systemInformation;
	}
	public void setSystemInformation(SystemInformation systemInformation) {
		this.systemInformation = systemInformation;
	}
	
	public String getErrorStackHash() {
		return ErrorStackHash;
	}
	public void setErrorStackHash(String errorStackHash) {
		ErrorStackHash = errorStackHash;
	}
	public String getObjectHash() {
		return ObjectHash;
	}
	public void setObjectHash(String objectHash) {
		ObjectHash = objectHash;
	}

	public String getStackTrace() {
		return StackTrace;
	}
	public void setStackTrace(String stackTrace) {
		StackTrace = stackTrace;
	}

}
