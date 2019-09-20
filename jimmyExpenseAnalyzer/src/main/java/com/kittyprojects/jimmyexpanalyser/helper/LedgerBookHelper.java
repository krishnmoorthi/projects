/**
 * 
 */
package com.kittyprojects.jimmyexpanalyser.helper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.kittyprojects.jimmyexpanalyser.constants.PropertyConstants;
import com.kittyprojects.jimmyexpanalyser.model.Ledger;
import com.kittyprojects.jimmyexpanalyser.model.LedgerBook;
import com.kittyprojects.jimmyexpanalyser.utils.FileOperationUtils;

/**
 * @author krishnamoorthi
 *
 */
public class LedgerBookHelper {

	Map<String, String> mapOfOperations;

	public LedgerBookHelper(Map<String, String> mapOfOperations) {
		this.mapOfOperations = mapOfOperations;
	}

	public void createLedgerBook(LedgerBook ledgerbook) {
		StringBuilder data = new StringBuilder();
		File ledgerBookFile = new File(ledgerbook.getName());
		FileOperationUtils.writeFile(data, ledgerBookFile);
	}

	public void deleteLedgerBook(LedgerBook ledgerbook) {

	}

	public List<LedgerBook> getLedgerBooks() {
		List<LedgerBook> ledgerBooks = new ArrayList<>();
		File file = new File(mapOfOperations.get(PropertyConstants.APP_DATALOCATION));
		File[] ledgerBookFiles = FileOperationUtils.listFilesFromLocation(file);
		LedgerHelper ledgerhelper = new LedgerHelper();
		for (File ledgerbookFile : ledgerBookFiles) {
			LedgerBook ledgerBook = new LedgerBook();
			ledgerBook.setName(ledgerbookFile.getName());
			ledgerBook.setLedgers(ledgerhelper.getLedgers(ledgerbookFile));
		}
		return ledgerBooks;
	}
	
}
