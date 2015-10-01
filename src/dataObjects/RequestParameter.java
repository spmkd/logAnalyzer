package dataObjects;

public class RequestParameter {

	private String Parameter;
	private String Value;
	
	public RequestParameter(String parameter, String value) {
		super();
		Parameter = parameter;
		Value = value;
	}
	public String getParameter() {
		return Parameter;
	}
	public void setParameter(String parameter) {
		Parameter = parameter;
	}
	public String getValue() {
		return Value;
	}
	public void setValue(String value) {
		Value = value;
	}
	
	
}
