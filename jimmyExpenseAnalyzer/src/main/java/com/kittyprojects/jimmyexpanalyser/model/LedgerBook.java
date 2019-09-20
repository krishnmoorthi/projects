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
	public List<Ledger> Ledgers;

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

	/**
	 * @return the ledgers
	 */
	public List<Ledger> getLedgers() {
		return Ledgers;
	}

	/**
	 * @param ledgers the ledgers to set
	 */
	public void setLedgers(List<Ledger> ledgers) {
		Ledgers = ledgers;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "LedgerBook [id=" + id + ", name=" + name + ", Ledgers=" + Ledgers + "]";
	}

}
