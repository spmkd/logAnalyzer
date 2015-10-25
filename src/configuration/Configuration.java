package configuration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Configuration {
	
	public static ArrayList<Log> allLogFiles = new ArrayList<Log>();
	
	private static ArrayList<String> rawLogLines = new ArrayList<String>();	
	
	// readConfigurationFile	- has a location of the configuration file and reads all lines (excluding lines starting with #)
	// 							stores them AS THEY are in the rawLogLines ArrayList
	
	public static void readConfigurationFile(){
		
//		File file = new File("C://Users//stojanp//workspace//LogAnalyzer//resources//configuration.txt");
		
		File file = new File(Configuration.class.getClassLoader().getResource("configuration.txt").getFile());
		
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
		
//		String[] separated;
//		
//		String 	location; 			// The full path of the directory or file (win/unix/anything)
//		char 	DirectoryOrFile;	// we put F(ile) or D(irectory) depending we want a single file or all files
//		String 	Label;				// a meaningful description of the file. In case it is a directory, an increment at the end of the lable will be used
//		char	Type;				// Continuous (C) or OneTimeRead (O)
//		char	Separator;
//		
//		for (String i : rawLogLines){
//			
//			separated = i.split(",");
//			
//			location = new String();
//			Label = new String();
//			
//			location = separated[0];
//			DirectoryOrFile = separated[1].charAt(0);
//			Label = separated[2];
//			Type = separated[3].charAt(0);
//			Separator = separated[4].charAt(0);
//
//			location = fixLocation(location);
//			location = Configuration.class.getClassLoader().getResource("error-dbkecmprapp11.5g4k.sys.carrenza.net-ES2-appserver0-2015-09-27.log").getPath();
//			
////			addToAllLogFiles(location, DirectoryOrFile, Label, Type, Separator);
//			
//		}
		
		List<String> logFilesPaths = getPaths(Config.WORD_MATCH);
		for (String loc : logFilesPaths) {
			addToAllLogFiles(loc, Config.FILE, Config.ERROR, Config.ONE_TIME_READ, Config.SEPARATOR);
		}	
	

}

/**
 * 
 * @param wordPattern
 * @return list of files that contain the wordPattern in the file name
 */
	public static List<String> getPaths(String wordPattern){
		List<String> results = new ArrayList<String>();
		String path = Configuration.class.getClassLoader().getResource(".").getPath();
		System.out.println("path =" + path);

		//If this pathname does not denote a directory, then listFiles() returns null. 
		File[] files = new File(path).listFiles();

		for (File file : files) {
		    if (file.isFile()) {
		    	if (file.getName().contains(wordPattern)) {
		    		System.out.println("fielpath = " + file.getPath());
		    		results.add(file.getPath());	
				}
		        
		    }
		}
		return results;
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
