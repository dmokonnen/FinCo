package project.framework.view;

import project.framework.model.Account;
import project.framework.model.Address;
import project.framework.model.IAccount;
import project.framework.model.ICustomer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Jonathan on 2/3/2020.
 */

public class MainWindow  extends javax.swing.JFrame {
	protected DefaultTableModel model;
	protected JTable JTable1;
	protected JScrollPane JScrollPane1;
	private final List<ICustomer> customers;

	public MainWindow(List<ICustomer> customers) {
		this.customers = customers;
		JPanel JPanel1 = new JPanel();

		setTitle("FinCo");
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0,0));
		setSize(575,310);
		setVisible(false);
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0,0,575,310);

		JScrollPane1 = new JScrollPane();
		model = new DefaultTableModel();
		JTable1 = new JTable(model);

		JPanel1.add(JScrollPane1);
		JScrollPane1.setBounds(12,92,444,160);
		JScrollPane1.getViewport().add(JTable1);
		JTable1.setBounds(0, 0, 420, 0);

		getButtonsOnTop(JPanel1);
		getButtonsOnRight(JPanel1);

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
	}

	public void getButtonsOnRight(JPanel panel) {
		JButton JButton_Exit = new JButton("Exit");
		panel.add(JButton_Exit);
		JButton_Exit.setBounds(468,248,96,31);
		JButton_Exit.addActionListener((e)->System.exit(0));
	}

	public void getButtonsOnTop(JPanel panel) {
		JButton addAccountButton = new JButton();
		JButton removeAccountButton = new JButton();
		addAccountButton.setText("Add Account");
		panel.add(addAccountButton);
		addAccountButton.setBounds(24,20,192,33);
		removeAccountButton.setText("Remove Account");
		panel.add(removeAccountButton);
		removeAccountButton.setBounds(240,20,192,33);

		addAccountButton.addActionListener((e)->{
			AddAccountDialog addAccountDialog = new AddAccountDialog(this, customers);
			addAccountDialog.setBounds(450, 20, 300, 330);
			addAccountDialog.show();

			if (!addAccountDialog.isCancelled()){
				drawTable();
			}
		});
		removeAccountButton.addActionListener((e)->{
			int selected = JTable1.getSelectedRow();
			if(selected<0) return;
			String accNo = ((Vector)model.getDataVector().get(selected)).get(0).toString();
			for(Iterator<ICustomer> i = customers.iterator(); i.hasNext(); ) {
				ICustomer c = i.next();
				for(Iterator<IAccount> ia= c.getAccounts().iterator(); ia.hasNext(); ) {
					IAccount a = ia.next();
					if(a.getAccountNo().equals(accNo)) {
						ia.remove();
					}
				}
			}
			model.removeRow(selected);
		});
	}

	public void drawTable() {
		JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
		String[] columns = new String[] {
				"AccountNr",
				"Name",
				"City",
				"Amount"
		};
		final List<IAccount> accounts = getAccounts();
		String[][] data = new String[accounts.size()][4];
		for(int i=0; i<accounts.size(); i++)  {
			IAccount a = accounts.get(i);
			data[i] = new String[] {
					a.getAccountNo(),
					a.getCustomer().getName(),
					a.getCustomer().getAddress().getCity(),
					a.getBalance().toString()
			};
		}
		model.setDataVector(data, columns);
		JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
	}

	private List<IAccount> getAccounts() {
		List<IAccount> res = new ArrayList<>();
		customers.forEach((c)->res.addAll(c.getAccounts()));
		return res;
	}

	public void exitApplication() {
		try {
			this.setVisible(false);
			this.dispose();
			System.exit(0);
		} catch (Exception e) {
		}
	}

	public class SymWindow extends java.awt.event.WindowAdapter
	{
		public void windowClosing(java.awt.event.WindowEvent event)
		{
			Object object = event.getSource();
			if (object == MainWindow.this)
				MainWindow_windowClosing(event);
		}
	}

	public void MainWindow_windowClosing(java.awt.event.WindowEvent event) {
		MainWindow_windowClosing_Interaction1(event);
	}

	public void MainWindow_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}
}
