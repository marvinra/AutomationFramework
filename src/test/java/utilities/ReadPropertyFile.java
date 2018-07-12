package utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertyFile {


	Properties prop = new Properties();

	public ReadPropertyFile() {
		InputStream input = ReadPropertyFile.class.getClassLoader().getResourceAsStream("config.properties");
		try {
			prop.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public String getDBconnection() {return prop.getProperty("databaseUrl");}

	public String getDBusername() {return prop.getProperty("dbusername");}

	public String DBpassword() {return prop.getProperty("dbpassword");}

	public String geturl() {return prop.getProperty("Url");}

	public String getUserName() {return prop.getProperty("Username");}

	public String getPassword() {return prop.getProperty("Password");}





}
