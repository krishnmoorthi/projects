/**
 * 
 */
package com.kittyprojects.jimmyexpanalyser.service;

import java.util.Map;

import com.kittyprojects.jimmyexpanalyser.helper.LedgerBookHelper;
import com.kittyprojects.jimmyexpanalyser.model.LedgerBooks;

/**
 * @author krishnamoorthi
 *
 */
public class LedgerBookService {
	
	private LedgerBookHelper ledgerBookHelper;
	
	public LedgerBookService(Map<String,String> mapOfOperation) {
		ledgerBookHelper = new LedgerBookHelper(mapOfOperation);
	}
	

	public LedgerBooks getLedgerBooks(){
		return ledgerBookHelper.getLedgerBooks();
	}
	
	public void createLedgerBook() {
		
	}
	
	public void deleteLedgerBook() {
		
	}
}
