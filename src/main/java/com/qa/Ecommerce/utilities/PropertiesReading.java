package com.qa.Ecommerce.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReading {

	public static String setProperty(String key) {
		String value = null;
		String projectPath = System.getProperty("user.dir");
		try {
			FileInputStream input = new FileInputStream(projectPath + "\\Config File\\PathFile.properties");
			Properties prop = new Properties();
			prop.load(input);
			value = prop.getProperty(key);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return value;

	}

	public static String setDataProperty(String key) {
		String value = null;
		String projectPath = System.getProperty("user.dir");
		try {
			FileInputStream input = new FileInputStream(projectPath + "\\Config File\\TestData.properties");
			Properties prop = new Properties();
			prop.load(input);
			value = prop.getProperty(key);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return value;

	}

}
