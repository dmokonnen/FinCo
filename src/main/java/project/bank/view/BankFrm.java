package project.bank.view;

import project.framework.model.ICustomer;
import project.framework.view.MainWindow;

import java.awt.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;


public class BankFrm extends MainWindow {
	private DefaultTableModel model;
	private JTable JTable1;
	private JScrollPane JScrollPane1;

	private final List<ICustomer> customers;

	public BankFrm(java.util.List<ICustomer> customers) {
		super(customers);
		this.customers = customers;

		setTitle("Bank Application");
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		setSize(575, 310);
		setVisible(false);
	}

	@Override
	public void getButtonsOnRight(JPanel panel) {
		super.getButtonsOnRight(panel);
		JButton JButton_Deposit = new JButton("Deposit");
		JButton_Deposit.setBounds(468, 104, 96, 33);
		JButton_Deposit.addActionListener(e -> {
			// get selected name
			int selection = JTable1.getSelectionModel().getMinSelectionIndex();
			if (selection >= 0) {
				String accnr = (String) model.getValueAt(selection, 0);

				//Show the dialog for adding deposit amount for the current mane
				DepositDialog dep = new DepositDialog(this, accnr);
				dep.setBounds(430, 15, 275, 140);
				dep.show();

				// compute new amount
				long deposit = 0;//Long.parseLong(amountDeposit);
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
				WithdrawDialog wd = new WithdrawDialog(this, accnr);
				wd.setBounds(430, 15, 275, 140);
				wd.show();

				// compute new amount
				long deposit = 0;//Long.parseLong(amountDeposit);
				String samount = (String) model.getValueAt(selection, 5);
				long currentamount = Long.parseLong(samount);
				long newamount = currentamount - deposit;
				model.setValueAt(String.valueOf(newamount), selection, 5);
				if (newamount < 0) {
					JOptionPane.showMessageDialog(JButton_Withdraw, " Account " + accnr + " : balance is negative: $" + String.valueOf(newamount) + " !", "Warning: negative balance", JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		panel.add(JButton_Deposit);
		panel.add(JButton_Withdraw);
	}

	@Override
	public void getButtonsOnTop(JPanel panel) {
		JButton JButton_PerAC = new JButton("Add personal account");
		JButton_PerAC.setBounds(24, 20, 192, 33);
		JButton_PerAC.addActionListener(e -> {
			AddPersonalAccountDialog pac = new AddPersonalAccountDialog(this, customers);
			pac.setBounds(450, 20, 300, 330);
			pac.show();

			if (!pac.isCancelled()) {
				drawTable();
			}
		});

		javax.swing.JButton JButton_CompAC = new javax.swing.JButton("Add organization account");
		JButton_CompAC.setBounds(240, 20, 192, 33);
		JButton_CompAC.addActionListener(e -> {
			AddOrganizationAccountDialog pac = new AddOrganizationAccountDialog(this, customers);
			pac.setBounds(450, 20, 300, 330);
			pac.show();

			if (pac.isCancelled()) {
				drawTable();
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
}
