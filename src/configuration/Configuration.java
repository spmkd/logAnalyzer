package configuration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Configuration {
	
	public static ArrayList<Log> allLogFiles = new ArrayList<Log>();
	
	private static ArrayList<String> rawLogLines = new ArrayList<String>();
	
	
	// readConfigurationFile	- has a location of the configuration file and reads all lines (excluding lines starting with #)
	// 							stores them AS THEY are in the rawLogLines ArrayList
	
	public static void readConfigurationFile(){
		
		File file = new File("C://Users//stojanp//workspace//LogAnalyzer//resources//configuration.txt");
		
		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				
				if (!line.startsWith("#")){
					rawLogLines.add(line);
				}
				
			}

			scanner.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
	// parseLogLines			- Takes each entry in the rawLogLines , separates them in a temp StringArray so that we can check
	//							whether all information is present and directory structure is correct
	
	public static void fillAllLogfiles(){
		
		String[] separated;
		
		String 	Location; 			// The full path of the directory or file (win/unix/anything)
		char 	DirectoryOrFile;	// we put F(ile) or D(irectory) depending we want a single file or all files
		String 	Label;				// a meaningful description of the file. In case it is a directory, an increment at the end of the lable will be used
		char	Type;				// Continuous (C) or OneTimeRead (O)
		char	Separator;
		
		for (String i : rawLogLines){
			
			separated = i.split(",");
			
			Location = new String();
			Label = new String();
			
			Location = separated[0];
			DirectoryOrFile = separated[1].charAt(0);
			Label = separated[2];
			Type = separated[3].charAt(0);
			Separator = separated[4].charAt(0);

			Location = fixLocation(Location);
			
			addToAllLogFiles(Location, DirectoryOrFile, Label, Type, Separator);
		}
		
		
		
	}


	private static void addToAllLogFiles(String location, char directoryOrFile, String label, char type, char separator) {

		Log tempLog = new Log(location, directoryOrFile, label , type, separator);
		
		allLogFiles.add(tempLog);
		
	}


	private static String fixLocation(String location) {
		// This function will replace all windows locations to a JAVA recognizable locations
		
		String l2 = location.replace("\\", "//");
		
		return l2;
	}
	
}
