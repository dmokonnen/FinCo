package project.framework.view;

import project.framework.model.*;

import javax.swing.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Jonathan on 2/3/2020.
 */

public class AddAccountDialog extends JDialog {
	private boolean cancelled = true;
	private final List<ICustomer> customers;
	public AddAccountDialog(MainWindow parent, List<ICustomer> customers) {
		super(parent);
		this.customers = customers;
		setTitle("Add Account");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(283,303);
		setVisible(false);
		JLabel1.setText("Name");
		getContentPane().add(JLabel1);
		JLabel1.setForeground(java.awt.Color.black);
		JLabel1.setBounds(12,84,48,24);
		JLabel2.setText("Street");
		getContentPane().add(JLabel2);
		JLabel2.setForeground(java.awt.Color.black);
		JLabel2.setBounds(12,108,48,24);
		JLabel3.setText("City");
		getContentPane().add(JLabel3);
		JLabel3.setForeground(java.awt.Color.black);
		JLabel3.setBounds(12,132,48,24);
		JLabel4.setText("State");
		getContentPane().add(JLabel4);
		JLabel4.setForeground(java.awt.Color.black);
		JLabel4.setBounds(12,156,48,24);
		JLabel5.setText("Zip");
		getContentPane().add(JLabel5);
		JLabel5.setForeground(java.awt.Color.black);
		JLabel5.setBounds(12,180,48,24);
		JLabel6.setText("Email");
		getContentPane().add(JLabel6);
		JLabel6.setForeground(java.awt.Color.black);
		JLabel6.setBounds(12,204,96,24);
		getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(84,84,156,20);
		getContentPane().add(JTextField_CT);
		JTextField_CT.setBounds(84,132,156,20);
		getContentPane().add(JTextField_ST);
		JTextField_ST.setBounds(84,156,156,20);
		getContentPane().add(JTextField_STR);
		JTextField_STR.setBounds(84,108,156,20);
		getContentPane().add(JTextField_ZIP);
		JTextField_ZIP.setBounds(84,180,156,20);
		getContentPane().add(JTextField_EM);
		JTextField_EM.setBounds(84,204,156,20);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(48,264,84,24);
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156,264,84,24);
		getContentPane().add(JTextField_ACNR);
		JTextField_ACNR.setBounds(84,60,156,20);
		JLabel8.setText("Acc Nr");
		getContentPane().add(JLabel8);
		JLabel8.setForeground(java.awt.Color.black);
		JLabel8.setBounds(12,60,48,24);

		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Cancel.addActionListener(lSymAction);
	}

	public JLabel JLabel1 = new JLabel();
	public JLabel JLabel2 = new JLabel();
	public JLabel JLabel3 = new JLabel();
	public JLabel JLabel4 = new JLabel();
	public JLabel JLabel5 = new JLabel();
	public JLabel JLabel6 = new JLabel();
	public JTextField JTextField_NAME = new JTextField();
	public JTextField JTextField_CT = new JTextField();
	public JTextField JTextField_ST = new JTextField();
	public JTextField JTextField_STR = new JTextField();
	public JTextField JTextField_ZIP = new JTextField();
	public JTextField JTextField_EM = new JTextField();
	public JButton JButton_OK = new JButton();
	public JButton JButton_Cancel = new JButton();
	public JTextField JTextField_ACNR = new JTextField();
	public JLabel JLabel8 = new JLabel();


	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
			else if (object == JButton_Cancel)
				JButtonCalcel_actionPerformed(event);
		}
	}

	private void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		addTheAccount();
		cancelled = false;
		dispose();
	}

	private ICustomer getCustomer() {
		Address address = getAddress();
		ICustomer c = createObjectForCustomer(address);
		ICustomer customer = customers.stream().filter((mc)->mc.equals(c)).findAny().orElse(c);
		if(!customers.contains(customer)) {
			customers.add(customer);
		}
		return customer;
	}

	private Address getAddress() {
		return new Address(JTextField_ST.getText(), JTextField_CT.getText(), JTextField_STR.getText() , JTextField_ZIP.getText());
	}

	public ICustomer createObjectForCustomer(Address address) {
		ICustomer customer =
				new Person(JTextField_NAME.getText(), new Date(), JTextField_EM.getText(), address);
		return customer;
	}

	public IAccount createAccount(ICustomer customer) {
		IAccount account = new Account(customer, JTextField_ACNR.getText());
		return account;
	}

	private void addTheAccount() {
		ICustomer customer = getCustomer();
		IAccount account = createAccount(customer);
		customer.addAccount(account);
	}

	public boolean isCancelled() {
		return cancelled;
	}

	private void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event) {
		cancelled = true;
		dispose();
	}
}
