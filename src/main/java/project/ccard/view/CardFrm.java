package project.ccard.view;

import project.framework.model.IAccount;
import project.framework.model.ICustomer;
import project.framework.view.MainWindow;

import java.awt.*;
import java.util.List;
import javax.swing.*;

/***
 * A basic JFC based application.
 ***/
public class CardFrm extends MainWindow
{
    /****
     * init variables in the object
     ****/
    String clientName,street,city, zip, state,accountType,amountDeposit,expdate, ccnumber;
    boolean newaccount;

    CardFrm thisframe;
    private Object rowdata[];
    private final List<ICustomer> customers;
    
	public CardFrm(List<ICustomer> customers)
	{
		super(customers);
		this.customers=customers;
		
		setTitle("Credit-card processing Application");
		setDefaultCloseOperation(javax.swing.JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0,0));
		setSize(575,310);
		setVisible(false);
		
	}
	//@TODO implementing Deposit and Charging
	@Override
	public void getButtonsOnRight(JPanel panel) {
		super.getButtonsOnRight(panel);
		JButton JButton_Deposit = new JButton("Deposit");
		JButton_Deposit.setBounds(468,104,96,33);
		JButton_Deposit.addActionListener(e -> {
			// get selected name
			int selection = JTable1.getSelectionModel().getMinSelectionIndex();
			if (selection >=0){
				String name = (String)model.getValueAt(selection, 1);

				//Show the dialog for adding deposit amount for the current mane
				DepositDialog dep = new DepositDialog(this,name);
				dep.setBounds(430, 15, 275, 140);
				dep.show();

				// compute new amount
//				long deposit = 0;

				double deposit = Double.parseDouble(amountDeposit);
				String samount = (String)model.getValueAt(selection, 3);
				double currentamount = Double.parseDouble(samount);
				Double newamount=currentamount+deposit;
				model.setValueAt(String.valueOf(newamount),selection, 3);
			}
		});
		JButton JButton_Withdraw = new JButton("Charge");
		JButton_Withdraw.setBounds(468,164,96,33);
		JButton_Withdraw.addActionListener(e -> {
			// get selected name
			int selection = JTable1.getSelectionModel().getMinSelectionIndex();
			if (selection >=0){
				String name = (String)model.getValueAt(selection, 0);

				//Show the dialog for adding withdraw amount for the current mane
				ChargeDialog wd = new ChargeDialog(thisframe,name);
				wd.setBounds(430, 15, 275, 140);
				wd.show();

				// compute new amount
				long deposit = Long.parseLong(amountDeposit);
				String samount = (String)model.getValueAt(selection, 3);
				long currentamount = Long.parseLong(samount);
				long newamount=currentamount-deposit;
				model.setValueAt(String.valueOf(newamount),selection, 3);
				if (newamount <0){
					JOptionPane.showMessageDialog(JButton_Withdraw, " "+name+" Your balance is negative: $"+String.valueOf(newamount)+" !","Warning: negative balance",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		panel.add(JButton_Deposit);
		panel.add(JButton_Withdraw);
	}

	@Override
	public void getButtonsOnTop(JPanel panel) {

		JButton JButton_NewCCAccount = new JButton("Add Credit-card account");
		JButton_NewCCAccount.setBounds(24,20,192,33);
		JButton_NewCCAccount.addActionListener(e -> {
			AddCreditCardAccountDialog ccac = new AddCreditCardAccountDialog(this,customers);
			ccac.setBounds(450, 20, 300, 380);
			ccac.show();
			if(!ccac.isCancelled()){
				drawTable();
			}
		});
		JButton JButton_GenBill = new JButton("Generate Monthly bills");
		JButton_GenBill.setBounds(240,20,192,33);
		JButton_GenBill.addActionListener(e -> {
			GenerateBillDialog billFrm = new GenerateBillDialog();
			billFrm.setBounds(450, 20, 400, 350);
			billFrm.show();
		});
		panel.add(JButton_NewCCAccount);
		panel.add(JButton_GenBill);
	}
	public void drawTable() {
		JTable1.getSelectionModel().setAnchorSelectionIndex(-1);
		String[] columns = new String[] {
				"CC Number",
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

	
}
