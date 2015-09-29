// This is the object in which we will hold each log configuration information

package configuration;

public class Log {

	public Log(String location, String label, char type, char directoryOrFile) {
		Location = location;
		Label = label;
		Type = type;
		DirectoryOrFile = directoryOrFile;
	}
	
	private String Location; // The location of the log directory or the file
	private String Label; // Used for labeling the logs
	private char DirectoryOrFile; // D - directory , F - file
	private char Type; // True - Continuous , Fale - OneTimeRead

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

}
