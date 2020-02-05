package project.bank.view;

import project.framework.model.ICustomer;
import project.framework.view.MainWindow;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

/***
 * A basic JFC based application.
 ***/
public class BankFrm extends MainWindow {
	/****
	 * init variables in the object
	 ****/
	String accountnr, clientName, street, city, zip, state, accountType, clientType, amountDeposit;
	boolean newaccount;
	private DefaultTableModel model;
	private JTable JTable1;
	private JScrollPane JScrollPane1;
	BankFrm myframe;
	private Object rowdata[];

	private final List<ICustomer> customers;

	public BankFrm(java.util.List<ICustomer> customers) {
		super(customers);
		this.customers = customers;
		myframe = this;

		setTitle("Bank Application");
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setSize(575, 310);
		setVisible(false);

		javax.swing.JPanel JPanel1 = new javax.swing.JPanel();
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0, 0, 575, 310);
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
		model.addColumn("Ch/S");
		model.addColumn("Amount");
		rowdata = new Object[8];
		newaccount = false;


		JPanel1.add(JScrollPane1);
		JScrollPane1.setBounds(12, 92, 444, 160);
		JScrollPane1.getViewport().add(JTable1);
		JTable1.setBounds(0, 0, 420, 0);
//        rowdata = new Object[8];

		// lineBorder1.setRoundedCorners(true);
		// lineBorder1.setLineColor(java.awt.Color.green);
		//$$ lineBorder1.move(24,312);

		getButtonsOnRight(JPanel1);
		getButtonsOnTop(JPanel1);

		SymWindow aSymWindow = new SymWindow();
		this.addWindowListener(aSymWindow);
		SymAction lSymAction = new SymAction();
		this.addWindowListener(lSymAction);

	}

	@Override
	public void getButtonsOnRight(JPanel panel) {
		super.getButtonsOnRight(panel);
		javax.swing.JButton JButton_Deposit = new javax.swing.JButton("Deposit");
		JButton_Deposit.setBounds(468, 104, 96, 33);
		JButton_Deposit.addActionListener(e -> {
			// get selected name
			int selection = JTable1.getSelectionModel().getMinSelectionIndex();
			if (selection >= 0) {
				String accnr = (String) model.getValueAt(selection, 0);

				//Show the dialog for adding deposit amount for the current mane
				JDialog_Deposit dep = new JDialog_Deposit(myframe, accnr);
				dep.setBounds(430, 15, 275, 140);
				dep.show();

				// compute new amount
				long deposit = Long.parseLong(amountDeposit);
				String samount = (String) model.getValueAt(selection, 5);
				long currentamount = Long.parseLong(samount);
				long newamount = currentamount + deposit;
				model.setValueAt(String.valueOf(newamount), selection, 5);
			}

		});

		javax.swing.JButton JButton_Withdraw = new javax.swing.JButton("Withdraw");
		JButton_Withdraw.setBounds(468, 164, 96, 33);
		JButton_Withdraw.addActionListener(e -> {
			// get selected name
			int selection = JTable1.getSelectionModel().getMinSelectionIndex();
			if (selection >= 0) {
				String accnr = (String) model.getValueAt(selection, 0);

				//Show the dialog for adding withdraw amount for the current mane
				JDialog_Withdraw wd = new JDialog_Withdraw(myframe, accnr);
				wd.setBounds(430, 15, 275, 140);
				wd.show();

				// compute new amount
				long deposit = Long.parseLong(amountDeposit);
				String samount = (String) model.getValueAt(selection, 5);
				long currentamount = Long.parseLong(samount);
				long newamount = currentamount - deposit;
				model.setValueAt(String.valueOf(newamount), selection, 5);
				if (newamount < 0) {
					JOptionPane.showMessageDialog(JButton_Withdraw, " Account " + accnr + " : balance is negative: $" + String.valueOf(newamount) + " !", "Warning: negative balance", JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		javax.swing.JButton JButton_Exit = new javax.swing.JButton("Exit");
		JButton_Exit.setBounds(468, 248, 96, 31);
		JButton_Exit.addActionListener((e) -> System.exit(0));

		panel.add(JButton_Deposit);
		panel.add(JButton_Withdraw);
		panel.add(JButton_Exit);
	}

	@Override
	public void getButtonsOnTop(JPanel panel) {
		super.getButtonsOnTop(panel);

		javax.swing.JButton JButton_PerAC = new javax.swing.JButton("Add personal account");
		JButton_PerAC.setActionCommand("jbutton");
		JButton_PerAC.setBounds(24, 20, 192, 33);
		JButton_PerAC.addActionListener(e -> {
			/*
			 JDialog_AddPAcc type object is for adding personal information
			 construct a JDialog_AddPAcc type object
			 set the boundaries and show it
			*/

			JDialog_AddPAcc pac = new JDialog_AddPAcc(myframe);
			pac.setBounds(450, 20, 300, 330);
			pac.show();

			if (newaccount) {
				// add row to table
				rowdata[0] = accountnr;
				rowdata[1] = clientName;
				rowdata[2] = city;
				rowdata[3] = "P";
				rowdata[4] = accountType;
				rowdata[5] = "0";
				model.addRow(rowdata);
				JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
				newaccount = false;
			}
		});

		javax.swing.JButton JButton_CompAC = new javax.swing.JButton("Add company account");
		JButton_CompAC.setActionCommand("jbutton");
		JButton_CompAC.setBounds(240, 20, 192, 33);
		JButton_CompAC.addActionListener(e -> {
			/*
			 construct a JDialog_AddCompAcc type object
			 set the boundaries and
			 show it
			*/

			JDialog_AddCompAcc pac = new JDialog_AddCompAcc(myframe, customers);
			pac.setBounds(450, 20, 300, 330);
			pac.show();

			if (newaccount) {
				// add row to table
				rowdata[0] = accountnr;
				rowdata[1] = clientName;
				rowdata[2] = city;
				rowdata[3] = "C";
				rowdata[4] = accountType;
				rowdata[5] = "0";
				model.addRow(rowdata);
				JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
				newaccount = false;
			}
		});

		javax.swing.JButton JButton_Addinterest = new javax.swing.JButton("Add interest");
		JButton_Addinterest.setBounds(448, 20, 106, 33);
		JButton_Addinterest.addActionListener(e -> {
			JOptionPane.showMessageDialog(JButton_Addinterest, "Add interest to all accounts", "Add interest to all accounts", JOptionPane.WARNING_MESSAGE);
		});

		panel.add(JButton_PerAC);
		panel.add(JButton_CompAC);
		panel.add(JButton_Addinterest);

	}

	class SymWindow extends java.awt.event.WindowAdapter {
		public void windowClosing(java.awt.event.WindowEvent event) {
			Object object = event.getSource();
			if (object == BankFrm.this)
				BankFrm_windowClosing(event);
		}
	}

	void BankFrm_windowClosing(java.awt.event.WindowEvent event) {
		// to do: code goes here.

		BankFrm_windowClosing_Interaction1(event);
	}

	void BankFrm_windowClosing_Interaction1(java.awt.event.WindowEvent event) {
		try {
			this.exitApplication();
		} catch (Exception e) {
		}
	}

	class SymAction extends WindowAdapter {
		public void windowClosing(java.awt.event.WindowEvent event) {
			Object object = event.getSource();
			if (object == BankFrm.this)
				MainWindow_windowClosing(event);
		}
	}
}
