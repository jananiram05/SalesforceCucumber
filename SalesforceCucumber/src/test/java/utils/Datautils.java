package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Datautils {
	public static String readLoginTestData(String key) throws IOException {
		FileInputStream in=new FileInputStream(Constants.APPLICATION_PROPERTIES);
		Properties prop=new Properties();
		prop.load(in);
		
		return prop.getProperty(key);
		
	}

}
