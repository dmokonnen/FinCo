package project.bank.view;


import project.framework.model.*;
import project.framework.view.AddAccountDialog;

import javax.swing.*;
import java.util.Date;
import java.util.List;

public class AddOrganizationAccountDialog extends AddAccountDialog {
    private BankFrm parentframe;
    private final List<ICustomer> customers;
    
	public AddOrganizationAccountDialog(BankFrm parent, List<ICustomer> customers) {
		super(parent, customers);
		parentframe=parent;
		this.customers = customers;

		setTitle("Add Company account");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(298,339);
		setVisible(false);
		JRadioButton_Chk.setText("Checkings");
		JRadioButton_Chk.setActionCommand("Checkings");
		getContentPane().add(JRadioButton_Chk);
		JRadioButton_Chk.setBounds(36,12,84,24);
		JRadioButton_Sav.setText("Savings");
		JRadioButton_Sav.setActionCommand("Savings");
		getContentPane().add(JRadioButton_Sav);
		JRadioButton_Sav.setBounds(36,36,84,24);
		JLabel7.setText("NO. emps");
		getContentPane().add(JLabel7);
		JLabel7.setForeground(java.awt.Color.black);
		JLabel7.setBounds(12,228,96,24);
		getContentPane().add(JTextField_NoOfEmp);
		JTextField_NoOfEmp.setBounds(84,228,156,20);
	}

	@Override
	public ICustomer createObjectForCustomer(Address address) {
		ICustomer customer =
				new Organization(JTextField_NAME.getText(), JTextField_EM.getText(), address);
		return customer;
	}

	JRadioButton JRadioButton_Chk = new JRadioButton();
	JRadioButton JRadioButton_Sav = new JRadioButton();
	JTextField JTextField_NoOfEmp = new JTextField();
	public JLabel JLabel7 = new JLabel();
}