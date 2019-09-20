/**
 * 
 */
package com.kittyprojects.jimmyexpanalyser.model;

import java.util.List;

/**
 * @author Krishnamoorthi
 *
 */
public class LedgerBook {

	public long id;
	public String name;
	public List<LedgerMonthWise> LedgerMonthWise;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	public List<LedgerMonthWise> getLedgerMonthWise() {
		return LedgerMonthWise;
	}

	public void setLedgerMonthWise(List<LedgerMonthWise> ledgerMonthWise) {
		LedgerMonthWise = ledgerMonthWise;
	}


}
