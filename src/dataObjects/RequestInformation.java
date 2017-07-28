package dataObjects;

public class RequestInformation {

	private String URI;
	private String Method;
	private String PathInfo;
	private String QueryString;
	private String RemoteAddress;
	private String RemoteUser;
	
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
	public String getRemoteUser() {
		return RemoteUser;
	}
	public void setRemoteUser(String remoteUser) {
		RemoteUser = remoteUser;
	}	
	
}
