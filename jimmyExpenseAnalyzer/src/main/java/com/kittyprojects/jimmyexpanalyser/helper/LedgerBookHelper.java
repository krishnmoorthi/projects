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
import com.kittyprojects.jimmyexpanalyser.model.LedgerBooks;
import com.kittyprojects.jimmyexpanalyser.model.LedgerMonthWise;
import com.kittyprojects.jimmyexpanalyser.utils.DateUtil;
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

	public LedgerBooks getLedgerBooks() {
		LedgerBooks ledgerBooks = new LedgerBooks();
		File file = new File(mapOfOperations.get(PropertyConstants.APP_DATALOCATION));
		File[] ledgerBookFiles = FileOperationUtils.listFilesFromLocation(file);
		LedgerHelper ledgerhelper = new LedgerHelper();
		for (File ledgerbookFile : ledgerBookFiles) {
			LedgerBook ledgerBook = new LedgerBook();
			ledgerBook.setName(ledgerbookFile.getName());
			ledgerBook.setLedgerMonthWise(prepareMonthWise(ledgerhelper.getLedgers(ledgerbookFile)));
		}
		return ledgerBooks;
	}

	private List<LedgerMonthWise> prepareMonthWise(List<Ledger> ledgers) {
		List<LedgerMonthWise> monthWiseList = new ArrayList<>();
		for (Ledger ledger : ledgers) {
			String monthEntry = DateUtil.dateToMMMYYYY(ledger.getDate());
			if (checkMonthWiseListForMonth(monthEntry, monthWiseList)) {
				LedgerMonthWise ledgerMonthWise = getLedgerMonthWiseForGiveMonth(monthEntry, monthWiseList);
				ledgerMonthWise.getLedgers().add(ledger);
			} else {
				List<Ledger> newMonthLedgers = new ArrayList<>();
				LedgerMonthWise ledgerMonthWise = new LedgerMonthWise();
				ledgerMonthWise.setMonth(monthEntry);
				newMonthLedgers.add(ledger);
				ledgerMonthWise.setLedgers(newMonthLedgers);
				monthWiseList.add(ledgerMonthWise);
			}
		}
		return monthWiseList;
	}

	private boolean checkMonthWiseListForMonth(String monthEntry, List<LedgerMonthWise> monthWiseList) {
		boolean flag = false;
		if (monthWiseList.isEmpty()) {
			return flag;
		} else {
			for (LedgerMonthWise monthWise : monthWiseList) {
				if (monthWise.getMonth().equalsIgnoreCase(monthEntry)) {
					flag = true;
					break;
				}
			}
		}
		return flag;
	}

	private LedgerMonthWise getLedgerMonthWiseForGiveMonth(String monthEntry, List<LedgerMonthWise> monthWiseList) {
		LedgerMonthWise ledgerMonthWise = null;
		if (!monthWiseList.isEmpty()) {
			for (LedgerMonthWise monthWise : monthWiseList) {
				if (monthWise.getMonth().equalsIgnoreCase(monthEntry)) {
					ledgerMonthWise = monthWise;
					break;
				}
			}
		}
		return ledgerMonthWise;
	}

}
