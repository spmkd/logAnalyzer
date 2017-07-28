package configuration;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import main.MainClass;

public class DatabaseConfiguration {
	
	private static String Url;
	private static String User;
	private static String Password;
	
	private static final Logger log4j = LogManager.getLogger(MainClass.class.getName());
	
	public static void ReadConfigurationFile(){
		
		File file = new File("resources/DatabaseConnectionDetails");
		
		
		
		try (Scanner scanner = new Scanner(file)) {

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				
				if (!line.startsWith("#")){
					log4j.info("1.2.1 Configuration Entry Line: " + line);
		
					String[] splited = line.split("=");
					
					if (line.startsWith("url")){
						setUrl(splited[1]);
					}else if (line.startsWith("user")){
						setUser(splited[1]);
					}else if (line.startsWith("password")){
						setPassword(splited[1]);
					}
					
				}
				
			}

			scanner.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static String getUrl() {
		return Url;
	}

	public static void setUrl(String url) {
		Url = url;
	}

	public static String getUser() {
		return User;
	}

	public static void setUser(String user) {
		User = user;
	}

	public static String getPassword() {
		return Password;
	}

	public static void setPassword(String password) {
		Password = password;
	}

}
