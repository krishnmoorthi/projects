/**
 * 
 */
package com.kittyprojects.jimmyexpanalyser.utils;

import java.math.BigDecimal;

import com.kittyprojects.jimmyexpanalyser.model.Ledger;

/**
 * @author krishnamoorthi
 *
 */
public class LedgerUtil {

	public static Ledger extractLedgerData(String data) {
		if (null != data && data.isEmpty()) {
			String[] fields = data.split("\\,");
			Ledger ledger = new Ledger();
			ledger.setDate(fields[0]);
			ledger.setDebitOrCredit(fields[1]);
			ledger.setCategory(fields[2]);
			ledger.setDescription(fields[3]);
			ledger.setAmount(new BigDecimal(fields[4]));
			return ledger;
		} else {
			return null;
		}
	}

}
