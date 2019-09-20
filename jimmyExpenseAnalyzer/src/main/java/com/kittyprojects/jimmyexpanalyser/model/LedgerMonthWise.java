/**
 * 
 */
package com.kittyprojects.jimmyexpanalyser.model;

import java.util.List;

/**
 * @author krishnamoorthi
 *
 */
public class LedgerMonthWise {
	
	private String month;
	private List<Ledger> ledgers;
	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	/**
	 * @return the ledgers
	 */
	public List<Ledger> getLedgers() {
		return ledgers;
	}
	/**
	 * @param ledgers the ledgers to set
	 */
	public void setLedgers(List<Ledger> ledgers) {
		this.ledgers = ledgers;
	}

}
