package project.framework.view;

import project.framework.model.Address;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Date;

/**
 * Created by Jonathan on 2/3/2020.
 */

public class MainWindow  extends javax.swing.JFrame {
	/****
	 * init variables in the object
	 ****/
	protected static MainWindow myframe;
	public double amountDeposit;
	public boolean newAccount;

	private String accountNumber;
	private String customerName;
	private String customerEmail;
	private Address address;
	private Date birthDate;

	protected DefaultTableModel model;
	protected JTable JTable1;
	protected JScrollPane JScrollPane1;
	protected Object rowdata[];

	public MainWindow()
	{
		myframe = this;

		accountNumber = "";
		customerName = "";
		customerEmail = "";
		address = new Address("", "", "", "");
		birthDate = new Date();

		setTitle("FinCo");
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0,0));
		setSize(575,310);
		setVisible(false);
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0,0,575,310);
		/*
		/Add five buttons on the pane
		/for Adding personal account, Adding company account
		/Deposit, Withdraw and Exit from the system
		*/
		JScrollPane1 = new JScrollPane();
		model = new DefaultTableModel();
		JTable1 = new JTable(model);
		model.addColumn("AccountNr");
		model.addColumn("Name");
		model.addColumn("City");
		model.addColumn("P/C");
		model.addColumn("Amount");
		rowdata = new Object[8];
		newAccount =false;


		JPanel1.add(JScrollPane1);
		JScrollPane1.setBounds(12,92,444,160);
		JScrollPane1.getViewport().add(JTable1);
		JTable1.setBounds(0, 0, 420, 0);
//        rowdata = new Object[8];

		JButton_PerAC.setText("Add personal account");
		JPanel1.add(JButton_PerAC);
		JButton_PerAC.setBounds(24,20,192,33);
		JButton_CompAC.setText("Add company account");
		JButton_CompAC.setActionCommand("jbutton");
		JPanel1.add(JButton_CompAC);
		JButton_CompAC.setBounds(240,20,192,33);
		JButton_Deposit.setText("Deposit");
		JPanel1.add(JButton_Deposit);
		JButton_Deposit.setBounds(468,104,96,33);
		JButton_Withdraw.setText("Withdraw");
		JPanel1.add(JButton_Withdraw);
		JButton_Addinterest.setBounds(448,20,106,33);
		JButton_Addinterest.setText("Add interest");
		JPanel1.add(JButton_Addinterest);
		JButton_Withdraw.setBounds(468,164,96,33);
		JButton_Exit.setText("Exit");
		JPanel1.add(JButton_Exit);
		JButton_Exit.setBounds(468,248,96,31);
		// lineBorder1.setRoundedCorners(true);
		// lineBorder1.setLineColor(java.awt.Color.green);
		//$$ lineBorder1.move(24,312);

		JButton_PerAC.setActionCommand("jbutton");

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		JButton_Exit.addActionListener(lSymAction);
		JButton_PerAC.addActionListener(lSymAction);
		JButton_CompAC.addActionListener(lSymAction);
		JButton_Deposit.addActionListener(lSymAction);
		JButton_Withdraw.addActionListener(lSymAction);
		JButton_Addinterest.addActionListener(lSymAction);

	}


	public javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
	public javax.swing.JButton JButton_PerAC = new javax.swing.JButton();
	public javax.swing.JButton JButton_CompAC = new javax.swing.JButton();
	public javax.swing.JButton JButton_Deposit = new javax.swing.JButton();
	public javax.swing.JButton JButton_Withdraw = new javax.swing.JButton();
	public javax.swing.JButton JButton_Addinterest= new javax.swing.JButton();
	public javax.swing.JButton JButton_Exit = new javax.swing.JButton();

	public void exitApplication()
	{
		try {
			this.setVisible(false);    // hide the Frame
			this.dispose();            // free the system resources
			System.exit(0);            // close the application
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

	public void MainWindow_windowClosing(java.awt.event.WindowEvent event)
	{
		// to do: code goes here.

		MainWindow_windowClosing_Interaction1(event);
	}

	public void MainWindow_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}

	public class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_Exit)
				JButtonExit_actionPerformed(event);
			else if (object == JButton_PerAC)
				JButtonPerAC_actionPerformed(event);
			else if (object == JButton_CompAC)
				JButtonCompAC_actionPerformed(event);
			else if (object == JButton_Deposit)
				JButtonDeposit_actionPerformed(event);
			else if (object == JButton_Withdraw)
				JButtonWithdraw_actionPerformed(event);
			else if (object == JButton_Addinterest)
				JButtonAddinterest_actionPerformed(event);

		}
	}

	//When the Exit button is pressed this code gets executed
	//this will exit from the system
	public void JButtonExit_actionPerformed(java.awt.event.ActionEvent event)
	{
		System.exit(0);
	}

	public void JButtonPerAC_actionPerformed(java.awt.event.ActionEvent event)
	{
		/*
		 JDialog_AddPAcc type object is for adding personal information
		 construct a JDialog_AddPAcc type object
		 set the boundaries and show it
		*/

		AddPersonalAccountDialog addPersonalAccountDialog = new AddPersonalAccountDialog(myframe);
		addPersonalAccountDialog.setBounds(450, 20, 300, 330);
		addPersonalAccountDialog.show();

		if (newAccount){
			// add row to table
			rowdata[0] = getAccountNumber();
			rowdata[1] = getCustomerName();
			rowdata[2] = getAddress().getCity();
			rowdata[3] = "P";
			rowdata[4] = "0.0";
			model.addRow(rowdata);
			JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
			newAccount =false;
		}



	}

	public void JButtonCompAC_actionPerformed(java.awt.event.ActionEvent event)
	{
		/*
		 construct a JDialog_AddCompAcc type object
		 set the boundaries and
		 show it
		*/

		AddOrganizationAccountDialog pac = new AddOrganizationAccountDialog(myframe);
		pac.setBounds(450, 20, 300, 330);
		pac.show();

		if (newAccount){
			// add row to table
			rowdata[0] = getAccountNumber();
			rowdata[1] = getCustomerName();
			rowdata[2] = getAddress().getCity();
			rowdata[3] = "C";
			rowdata[4] = "0.0";
			model.addRow(rowdata);
			JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
			newAccount =false;
		}

	}

	public void JButtonDeposit_actionPerformed(java.awt.event.ActionEvent event)
	{
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >=0){
			String accnr = (String)model.getValueAt(selection, 0);

			//Show the dialog for adding deposit amount for the current mane
			DepositDialog dep = new DepositDialog(myframe,accnr);
			dep.setBounds(430, 15, 275, 140);
			dep.show();

			if (newAccount){
				// compute new amount
				String samount = (String)model.getValueAt(selection, 4);
				double currentamount = Double.parseDouble(samount);
				double newamount=currentamount+amountDeposit;
				model.setValueAt(String.valueOf(newamount),selection, 4);
				newAccount =false;
			}
		}
	}

	public void JButtonWithdraw_actionPerformed(java.awt.event.ActionEvent event)
	{
		// get selected name
		int selection = JTable1.getSelectionModel().getMinSelectionIndex();
		if (selection >=0){
			String accnr = (String)model.getValueAt(selection, 0);

			//Show the dialog for adding withdraw amount for the current mane
			WithdrawDialog wd = new WithdrawDialog(myframe,accnr);
			wd.setBounds(430, 15, 275, 140);
			wd.show();

			if (newAccount){
				// compute new amount
				String samount = (String)model.getValueAt(selection, 4);
				double currentamount = Double.parseDouble(samount);
				double newamount=currentamount-amountDeposit;
				model.setValueAt(String.valueOf(newamount),selection, 4);
				if (newamount <0){
					JOptionPane.showMessageDialog(JButton_Withdraw, " Account "+accnr+" : balance is negative: $"+String.valueOf(newamount)+" !","Warning: negative balance",JOptionPane.WARNING_MESSAGE);
				}
				newAccount =false;
			}
		}


	}

	public void JButtonAddinterest_actionPerformed(java.awt.event.ActionEvent event)
	{
		JOptionPane.showMessageDialog(JButton_Addinterest, "Add interest to all accounts","Add interest to all accounts",JOptionPane.WARNING_MESSAGE);

		// TODO: fire the Add Interest Command here

	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
}
