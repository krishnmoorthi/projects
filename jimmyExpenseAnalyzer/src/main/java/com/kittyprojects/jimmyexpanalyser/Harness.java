/**
 * 
 */
package com.kittyprojects.jimmyexpanalyser;

import java.io.File;
import java.util.Map;

import com.kittyprojects.jimmyexpanalyser.constants.PropertyConstants;
import com.kittyprojects.jimmyexpanalyser.gui.JimmyExpenseAnalyzer;
import com.kittyprojects.jimmyexpanalyser.utils.FileOperationUtils;
import com.kittyprojects.jimmyexpanalyser.utils.PropertiesUtil;

/**
 * @author krishnamoorthi
 *
 */
public class Harness {
	
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Reads application properties from the file "app.properties"
		Map<String, String> mapOfProperties = PropertiesUtil.loadproperties("app.properties");
		initExpenseAnalyser(mapOfProperties);
		JimmyExpenseAnalyzer gui = new JimmyExpenseAnalyzer();
		gui.startGui();
	}

	private static void initExpenseAnalyser(Map<String, String> mapOfProperties) {
		// Check and create application directories for first time.
		File file = new File(mapOfProperties.get(PropertyConstants.APP_DATALOCATION));
		if(FileOperationUtils.chkAndCreateDirectories(file)) {
			System.out.println("Data ledgers directory created !");
		}
	}

}
