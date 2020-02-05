package project.bank.view;

import project.bank.model.CheckingAccount;
import project.bank.model.SavingAccount;
import project.framework.model.*;
import project.framework.view.AddAccountDialog;
import java.util.List;

public class JDialog_AddPAcc extends AddAccountDialog {

	public JDialog_AddPAcc(BankFrm parent, List<ICustomer> customers) {
		super(parent, customers);
		setTitle("Add personal account");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(283,303);
		setVisible(false);
		JRadioButton_Chk.setText("Checkings");
		JRadioButton_Chk.setActionCommand("Checkings");
		getContentPane().add(JRadioButton_Chk);
		JRadioButton_Chk.setBounds(36,0,84,24);
		JRadioButton_Sav.setText("Savings");
		JRadioButton_Sav.setActionCommand("Savings");
		getContentPane().add(JRadioButton_Sav);
		JRadioButton_Sav.setBounds(36,24,84,24);

		SymMouse aSymMouse = new SymMouse();
		JRadioButton_Chk.addMouseListener(aSymMouse);
		JRadioButton_Sav.addMouseListener(aSymMouse);
	}

	javax.swing.JRadioButton JRadioButton_Chk = new javax.swing.JRadioButton();
	javax.swing.JRadioButton JRadioButton_Sav = new javax.swing.JRadioButton();

	class SymMouse extends java.awt.event.MouseAdapter {
		public void mouseClicked(java.awt.event.MouseEvent event)
		{
			Object object = event.getSource();
			if (object == JRadioButton_Chk)
				JRadioButtonChk_mouseClicked(event);
			else if (object == JRadioButton_Sav)
				JRadioButtonSav_mouseClicked(event);
		}
	}

	@Override
	public ICustomer createObjectForCustomer(Address address) {
		return super.createObjectForCustomer(address);
	}

	@Override
	public IAccount createAccount(ICustomer customer) {
		return JRadioButton_Chk.isSelected()?
				new CheckingAccount(customer, JTextField_ACNR.getText())
				:
				new SavingAccount(customer, JTextField_ACNR.getText());
	}

	void JRadioButtonChk_mouseClicked(java.awt.event.MouseEvent event) {
		JRadioButton_Chk.setSelected(true);
		JRadioButton_Sav.setSelected(false);
	}

	void JRadioButtonSav_mouseClicked(java.awt.event.MouseEvent event) {
		JRadioButton_Chk.setSelected(false);
		JRadioButton_Sav.setSelected(true);
	 
	}
}