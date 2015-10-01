package dataObjects;

public class ErrorDate {

	String Date;
	String Time;
	String TZone;
	
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getTime() {
		return Time;
	}
	public void setTime(String time) {
		Time = time;
	}
	public String getTZone() {
		return TZone;
	}
	public void setTZone(String tZone) {
		TZone = tZone;
	}
	
	public void parseDateAndTime(String dateAndTime){
		
		String[] separator;
		
		separator = dateAndTime.split(" ");
		
		this.setDate(separator[0]);
		this.setTime(separator[1]);
		this.setTZone(separator[2]);
		
	}
	
}
