/**
 * 
 */
package com.kittyprojects.jimmyexpanalyser.helper;

import java.io.File;
import java.util.List;

import com.kittyprojects.jimmyexpanalyser.model.Ledger;
import com.kittyprojects.jimmyexpanalyser.utils.FileOperationUtils;

/**
 * @author krishnamoorthi
 *
 */
public class LedgerHelper {

	public void addLedger(List<Ledger> ledger) {

	}

	public void deleteLedger(List<Ledger> ledger) {

	}

	public List<Ledger> getLedgers(File ledgerbook) {
		List<Ledger> ledgers = prepareMonthWise(FileOperationUtils.readFile(ledgerbook));
		return ledgers;

	}

	private List<Ledger> prepareMonthWise(List<Ledger> completeLedgers) {
		return completeLedgers;

	}

}
