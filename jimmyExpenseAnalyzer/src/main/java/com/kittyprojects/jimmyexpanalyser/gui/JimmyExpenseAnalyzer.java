package com.kittyprojects.jimmyexpanalyser.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTree;

public class JimmyExpenseAnalyzer {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public void startGui() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JimmyExpenseAnalyzer window = new JimmyExpenseAnalyzer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JimmyExpenseAnalyzer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1271, 685);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel statusBarPanel = new JPanel();
		frame.getContentPane().add(statusBarPanel, BorderLayout.SOUTH);

		JSplitPane ledgerReportPane = new JSplitPane();
		frame.getContentPane().add(ledgerReportPane, BorderLayout.CENTER);

		JTree ledgers = new JTree();
		ledgerReportPane.setLeftComponent(ledgers);

		JSplitPane reportAndLedgerEditorPane = new JSplitPane();
		reportAndLedgerEditorPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		ledgerReportPane.setRightComponent(reportAndLedgerEditorPane);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnTools = new JMenu("Tools");
		menuBar.add(mnTools);
		
		JMenuItem mntmExport = new JMenuItem("Export");
		mnTools.add(mntmExport);
	}

}
