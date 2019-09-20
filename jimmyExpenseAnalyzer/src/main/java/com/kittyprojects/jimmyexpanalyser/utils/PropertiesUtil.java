/**
 * 
 */
package com.kittyprojects.jimmyexpanalyser.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * @author krishnamoorthi
 *
 */
public class PropertiesUtil {

	public static Map<String, String> loadproperties(String file) {

		try (InputStream input = PropertiesUtil.class.getClassLoader().getResourceAsStream(file)) {

			Properties properties = new Properties();

			if (input == null) {
				System.out.println("Sorry, unable to find config.properties");
				return null;
			}

			// load a properties file from class path, inside static method
			properties.load(input);

			// get the property value and print it out
			System.out.println(properties.get("ledger.year.format"));
			return properties.entrySet().stream().collect(
					Collectors.toMap(prop -> String.valueOf(prop.getKey()), prop -> String.valueOf(prop.getValue())));

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return null;

	}

}
