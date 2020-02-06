package project.bank.view;

import project.bank.model.DepositCommand;
import project.framework.model.IAccount;
import project.framework.model.IAccountCommand;
import project.framework.model.IAccountManager;

import javax.swing.*;

public class DepositDialog extends JDialog {
	private final IAccount account;
	private final IAccountManager accountManager;
    
	public DepositDialog(BankFrm parent, IAccount account, IAccountManager accountManager) {
		super(parent);
		this.accountManager = accountManager;
		this.account = account;
		setTitle("Deposit");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(268,126);
		setVisible(false);
		JLabel1.setText("Acc Nr");
		getContentPane().add(JLabel1);
		JLabel1.setForeground(java.awt.Color.black);
		JLabel1.setBounds(12,12,48,24);
		JLabel2.setText("Amount");
		getContentPane().add(JLabel2);
		JLabel2.setForeground(java.awt.Color.black);
		JLabel2.setBounds(12,48,48,24);
		JTextField_NAME.setEditable(false);
		getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(84,12,144,24);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(36,84,84,24);
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156,84,84,24);
		getContentPane().add(JTextField_Deposit);
		JTextField_Deposit.setBounds(84,48,144,24);
	    JTextField_NAME.setText(account.getAccountNo());
	    
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Cancel.addActionListener(lSymAction);
	}

	JLabel JLabel1 = new JLabel();
	JLabel JLabel2 = new JLabel();
	JTextField JTextField_NAME = new JTextField();
	JButton JButton_OK = new JButton();
	JButton JButton_Cancel = new JButton();
	JTextField JTextField_Deposit = new JTextField();

	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
			else if (object == JButton_Cancel)
				JButtonCalcel_actionPerformed(event);
		}
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		IAccountCommand command = new DepositCommand(account, Double.parseDouble(JTextField_Deposit.getText()));
		accountManager.executeCommand(command);
        dispose();
	}

	void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event)
	{
		dispose();
	}

}