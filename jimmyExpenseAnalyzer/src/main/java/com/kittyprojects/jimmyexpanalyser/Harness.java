/**
 * 
 */
package com.kittyprojects.jimmyexpanalyser;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTree;

import com.kittyprojects.jimmyexpanalyser.constants.PropertyConstants;
import com.kittyprojects.jimmyexpanalyser.utils.FileOperationUtils;
import com.kittyprojects.jimmyexpanalyser.utils.PropertiesUtil;

/**
 * @author krishnamoorthi
 *
 */
public class Harness {
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Harness window = new Harness();
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
	public Harness() {
		initializeGui();
		// Reads application properties from the file "app.properties"
		Map<String, String> mapOfProperties = PropertiesUtil.loadproperties("app.properties");
		initExpenseAnalyser(mapOfProperties);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeGui() {
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

	private static void initExpenseAnalyser(Map<String, String> mapOfProperties) {
		// Check and create application directories for first time.
		File file = new File(mapOfProperties.get(PropertyConstants.APP_DATALOCATION));
		if(FileOperationUtils.chkAndCreateDirectories(file)) {
			System.out.println("Data ledgers directory created !");
		}
	}

}
