package ie.cfl.school.infra;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MenageProperties {
	
	private static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream(
				"./src/main/resources/application.properties");
		props.load(file);
		return props;

	}
	
	
	public static String getString(String key) {
		try {
			return getProp().getProperty(key);
		} catch (IOException e) {
			throw new RuntimeException("Error to getProperties: "+e.getMessage());
		}
	}

}
