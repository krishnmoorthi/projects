/**
 * 
 */
package com.kittyprojects.jimmyexpanalyser.service;

import java.util.List;
import java.util.Map;

import com.kittyprojects.jimmyexpanalyser.helper.LedgerBookHelper;
import com.kittyprojects.jimmyexpanalyser.model.LedgerBook;

/**
 * @author krishnamoorthi
 *
 */
public class LedgerBookService {
	
	private LedgerBookHelper ledgerBookHelper;
	
	public LedgerBookService(Map<String,String> mapOfOperation) {
		ledgerBookHelper = new LedgerBookHelper(mapOfOperation);
	}
	

	public List<LedgerBook> getAllLedgerBooks(){
		return ledgerBookHelper.getLedgerBooks();
	}
	
	public void createLedgerBook() {
		
	}
	
	public void deleteLedgerBook() {
		
	}
}
