package project.ccard.view;/*
		A basic implementation of the JDialog class.
*/

import project.ccard.controller.CCardAccountFactory;
import project.framework.model.Address;
import project.framework.model.Customer;
import project.framework.model.IAccount;
import project.framework.model.ICustomer;
import project.framework.view.AddAccountDialog;

import javax.swing.*;
import java.util.List;

public class AddCreditCardAccountDialog extends AddAccountDialog {
	CCardAccountFactory cCardAccountFactory=new CCardAccountFactory();
	public AddCreditCardAccountDialog(CardFrm parent, List<ICustomer> customers)
	{
		super(parent, customers);
		setTitle("Add credit card account");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(301,373);
		setVisible(false);
		JRadioButton_Gold.setText("Gold");
		JRadioButton_Gold.setActionCommand("Gold");
		getContentPane().add(JRadioButton_Gold);
		JRadioButton_Gold.setBounds(36,12,84,24);

		JRadioButton_Silver.setText("Silver");
		JRadioButton_Silver.setActionCommand("Silver");
		getContentPane().add(JRadioButton_Silver);
		JRadioButton_Silver.setBounds(36,36,84,24);

		JRadioButton_Bronze.setText("Bronze");
		JRadioButton_Bronze.setActionCommand("Bronze");
		getContentPane().add(JRadioButton_Bronze);
		JRadioButton_Bronze.setBounds(36,60,84,24);
		getContentPane().remove(JLabel8);
		getContentPane().remove(JTextField_ACNR);

		//Repositioning the inherited labels
		JLabel1.setBounds(12,84,48,24);
		JLabel2.setBounds(12,108,48,24);
		JLabel3.setBounds(12,132,48,24);
		JLabel4.setBounds(12,156,48,24);
		JLabel5.setBounds(12,180,48,24);
		JLabel6.setBounds(12,204,48,24);

		//adding others components
		JLabel7.setText("CC number");
		getContentPane().add(JLabel7);
		JLabel7.setForeground(java.awt.Color.black);
		JLabel7.setBounds(12,228,96,24);

		JLabel9.setText("Exp. Date");
		getContentPane().add(JLabel9);
		JLabel9.setForeground(java.awt.Color.black);
		JLabel9.setBounds(12,252,72,24);

		getContentPane().add(JTextField_CCNR);
		JTextField_CCNR.setBounds(84,JLabel7.getY(),156,20);

		getContentPane().add(JTextField_ExpDate);
		JTextField_ExpDate.setBounds(84,JLabel9.getY(),156,20);

		JButton_OK.setBounds(48,300,84,24);
		JButton_Cancel.setBounds(156,300,84,24);

		//}}
	
		//{{REGISTER_LISTENERS
		SymMouse aSymMouse = new SymMouse();
		JRadioButton_Gold.addMouseListener(aSymMouse);
		JRadioButton_Silver.addMouseListener(aSymMouse);
		JRadioButton_Bronze.addMouseListener(aSymMouse);

		//}}
	}




	//{{DECLARE_CONTROLS
	javax.swing.JRadioButton JRadioButton_Gold = new javax.swing.JRadioButton();
	javax.swing.JRadioButton JRadioButton_Silver = new javax.swing.JRadioButton();
	javax.swing.JRadioButton JRadioButton_Bronze = new javax.swing.JRadioButton();

	javax.swing.JLabel JLabel6 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel7 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel9 = new javax.swing.JLabel();

	javax.swing.JTextField JTextField_CCNR = new javax.swing.JTextField();
	javax.swing.JTextField JTextField_ExpDate = new javax.swing.JTextField();





	class SymMouse extends java.awt.event.MouseAdapter
	{
		public void mouseClicked(java.awt.event.MouseEvent event)
		{
			Object object = event.getSource();
			if (object == JRadioButton_Gold)
				JRadioButtonChk_mouseClicked(event);
			else if (object == JRadioButton_Silver)
				JRadioButtonSav_mouseClicked(event);
			else if (object == JRadioButton_Bronze)
				JRadioButtonBronze_mouseClicked(event);
			
			
		}
	}

	void JRadioButtonChk_mouseClicked(java.awt.event.MouseEvent event)
	{
		JRadioButton_Gold.setSelected(true);
		JRadioButton_Silver.setSelected(false);
		JRadioButton_Bronze.setSelected(false);
	}

	void JRadioButtonSav_mouseClicked(java.awt.event.MouseEvent event)
	{
		JRadioButton_Gold.setSelected(false);
		JRadioButton_Silver.setSelected(true);
		JRadioButton_Bronze.setSelected(false);
	 
	}
	void JRadioButtonBronze_mouseClicked(java.awt.event.MouseEvent event)
	{
		JRadioButton_Gold.setSelected(false);
		JRadioButton_Silver.setSelected(false);
		JRadioButton_Bronze.setSelected(true);
	}

	@Override
	public ICustomer createObjectForCustomer(Address address) {
		return super.createObjectForCustomer(address);
	}

	@Override
	public IAccount createAccount(ICustomer customer) {
		if(JRadioButton_Gold.isSelected()) {
			return 	cCardAccountFactory.createGoldAccount(customer,
					JTextField_CCNR.getText());
		}
		else if(JRadioButton_Bronze.isSelected()){
			return cCardAccountFactory.createBronzeAccount(customer,
					JTextField_CCNR.getText());
		}
		else if(JRadioButton_Silver.isSelected()){
			return cCardAccountFactory.createBronzeAccount(customer,
					JTextField_CCNR.getText());
		}
		return null;
	}
}