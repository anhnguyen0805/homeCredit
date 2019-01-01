package configuration;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class Configuration {
	public static String IE_DRIVER_PATH = "";
	public static String FIREFOX_DRIVER_PATH = "";
	public static String PROJECT_URL = "https://localhost:9443/ccm/";
	public static String USER_NAME = "myadmin";
	public static String PASSWORD = "myadmin";
	public static void loadProjectProperties(){
		BufferedReader br = null;
		String projectPropFileName = "project.properties";
		Path p = Paths.get(projectPropFileName);
		if(Files.exists(p)){
			Properties prop = null;
			try {
				prop = new Properties();
				br = new BufferedReader(new FileReader(projectPropFileName));
				prop.load(br);
				IE_DRIVER_PATH = prop.getProperty("iedriverpath");
				FIREFOX_DRIVER_PATH = prop.getProperty("ffdriverpath");
				PROJECT_URL = prop.getProperty("projecturl");
				USER_NAME = prop.getProperty("username");
				PASSWORD = prop.getProperty("password");
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
