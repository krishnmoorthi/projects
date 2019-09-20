/**
 * 
 */
package com.kittyprojects.jimmyexpanalyser.model;

import java.util.List;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

/**
 * @author kthangav
 *
 */
public class LedgerBooks implements TreeModel {

	protected String root;
	private List<LedgerBook> books;
	
	LedgerBooks() {
		this.root = "Ledgers";
	}
	

	public List<LedgerBook> getBooks() {
		return books;
	}

	public void setBooks(List<LedgerBook> books) {
		this.books = books;
	}

	@Override
	public void addTreeModelListener(TreeModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getChild(Object arg0, int arg1) {
		String[] ledgerbooks = (arg0)
		return null;
	}

	@Override
	public int getChildCount(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getIndexOfChild(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getRoot() {
		return root;
	}

	@Override
	public boolean isLeaf(Object arg0) {
		return false;
	}

	@Override
	public void removeTreeModelListener(TreeModelListener arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void valueForPathChanged(TreePath arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}
}
