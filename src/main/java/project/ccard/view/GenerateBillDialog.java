package project.ccard.view;

import project.framework.model.IAccount;
import project.framework.model.ICustomer;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GenerateBillDialog extends JDialog {
    String billstring = "";
    private final List<IAccount> accounts;
    
	public GenerateBillDialog(Frame parent, List<IAccount> accounts) {
		super(parent);
		this.accounts = accounts;
		getContentPane().setLayout(null);
		setSize(405,367);
		setVisible(false);
		getContentPane().add(JScrollPane1);
		JScrollPane1.setBounds(24,24,358,240);
		JScrollPane1.getViewport().add(JTextField1);
		JTextField1.setBounds(0,0,355,237);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(156,276,96,24);
		for(IAccount a: accounts) {
			billstring += a.generateReport() + "\n";
		}
		JTextField1.setText(billstring);
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
	}

	JScrollPane JScrollPane1 = new JScrollPane();
	JTextField JTextField1 = new JTextField();
	JButton JButton_OK = new JButton();


	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
		}
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		dispose();
	}
}
