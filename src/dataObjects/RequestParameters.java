package dataObjects;

import java.util.ArrayList;

public class RequestParameters {

	private ArrayList<RequestParameter> allRequestParameter = new ArrayList<RequestParameter>();

	public ArrayList<RequestParameter> getAllRequestParameter() {
		return allRequestParameter;
	}

	public void setAllRequestParameter(ArrayList<RequestParameter> allRequestParameter) {
		this.allRequestParameter = allRequestParameter;
	}
	
}
