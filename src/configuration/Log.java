// This is the object in which we will hold each log configuration information

package configuration;

public class Log {

	public Log(String location, char directoryOrFile, String label, char type, char separator) {
		Location = location;
		DirectoryOrFile = directoryOrFile;
		Label = label;
		Type = type;
		Separator = separator;
	}
	
	private String Location;		 // The location of the log directory or the file
	private char DirectoryOrFile;	 // D - directory , F - file
	private String Label;			 // Used for labeling the logs
	private char Type; 				 // True - Continuous , Fale - OneTimeRead
	private char Separator;			 // If it is empty, then it is new line (for access, syslog...). For Error logs it is usually [

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		Label = label;
	}

	public char getType() {
		return Type;
	}

	public void setType(char type) {
		Type = type;
	}

	public char getDirectoryOrFile() {
		return DirectoryOrFile;
	}

	public void setDirectoryOrFile(char directoryOrFile) {
		DirectoryOrFile = directoryOrFile;
	}

	public char getSeparator() {
		return Separator;
	}

	public void setSeparator(char separator) {
		Separator = separator;
	}

}
