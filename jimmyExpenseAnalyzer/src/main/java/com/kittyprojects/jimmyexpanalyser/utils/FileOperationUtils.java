/**
 * 
 */
package com.kittyprojects.jimmyexpanalyser.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.kittyprojects.jimmyexpanalyser.model.Ledger;

/**
 * @author krishnamoorthi
 *
 */
public class FileOperationUtils {

	public static void writeFile(StringBuilder data, File file) {
		try (FileWriter writer = new FileWriter(file)) {
			writer.write(data.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static List<Ledger> readFile(File file) {
		List<Ledger> ledgers = new ArrayList<>();
		String line = "";
		try (FileReader reader = new FileReader(file)) {
			BufferedReader bufferedReader = new BufferedReader(reader);
			while ((line = bufferedReader.readLine()) != null) {
				ledgers.add(LedgerUtil.extractLedgerData(line));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ledgers;
	}

	public static boolean checkFileLocation(File file) {
		return file.exists();
	}

	public static boolean checkDirectoryLocation(File file) {
		return file.isDirectory();
	}

	public static boolean chkAndCreateDirectories(File file) {
		if (checkDirectoryLocation(file)) {
			return false;
		} else {
			return file.mkdirs();
		}
	}

	public static File[] listFilesFromLocation(File file) {
		if (checkDirectoryLocation(file)) {
			return file.listFiles();
		} else {
			return null;
		}
	}

}
