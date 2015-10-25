package configuration;

public class Config {

	/**
	 * word contained in the file name 
	 */
	public static final String WORD_MATCH = "carrenza";
	public static String location; // The full path of the directory or file
									// (win/unix/anything)
	public static char FILE = 'F';
	public static char DIR = 'D'; // we put F(ile) or D(irectory)
										// depending we want a single file or
										// all files
	public static String ERROR = "Error Log"; // a meaningful description of the file. In case
								// it is a directory, an increment at the end of
								// the lable will be used
	public static char ONE_TIME_READ = 'O'; // Continuous (C) or OneTimeRead (O)
	public static char CONTINUOUS = 'C';
	public static char SEPARATOR = '[';
}
