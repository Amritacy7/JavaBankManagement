package BankManagementSystem;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;





public class Transactions extends JFrame implements ActionListener {
	
	
	JButton deposit, withdraw,pinchange,fastcash,ministatement,balanceenquiry,exit;
	String pinnumber;
	
	Transactions(String pinnumber)
	
	{
		this.pinnumber= pinnumber;
		setLayout(null);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("pics/atm.jpg"));
		Image i2= i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);	
		
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel select = new JLabel("Please Select Transaction Type ");
		select.setBounds(225,290,250,50);
		select.setForeground(Color.white);
		select.setFont(new Font("Thonburi", Font.BOLD,15));
		image.add(select);
		
		deposit  = new JButton("Deposit");
		deposit.setBounds(160,420,130,25);
		deposit.setBackground(Color.white);
		deposit.addActionListener(this);
		image.add(deposit);
	
		withdraw  = new JButton("Withdraw");
		withdraw.setBounds(380,420,130,25);
		withdraw.setBackground(Color.white);
		withdraw.addActionListener(this);
		image.add(withdraw);
		
		pinchange  = new JButton("Pin Change");
		pinchange.setBounds(160,455,130,25);
		pinchange.setBackground(Color.white);
		pinchange.addActionListener(this);
		image.add(pinchange);
		
		fastcash  = new JButton("Fast Cash");
		fastcash.setBounds(380,455,130,25);
		fastcash.setBackground(Color.white);
		fastcash.addActionListener(this);
		image.add(fastcash);
		
		ministatement  = new JButton("Mini Statement");
		ministatement.setBounds(160,490,130,25);
		ministatement.setBackground(Color.white);
		ministatement.addActionListener(this);
		image.add(ministatement);
		
		balanceenquiry  = new JButton("Balance Enquiry");
		balanceenquiry.setBounds(380,490,130,25);
		balanceenquiry.setBackground(Color.white);
		balanceenquiry.addActionListener(this);
		image.add(balanceenquiry);
		
		exit  = new JButton("Exit");
		exit.setBounds(380,523,130,25);
		exit.setBackground(Color.white);
		exit.addActionListener(this);
		image.add(exit);
		
		
		
		
	setVisible(true);
	setLocation(500,200);
	setSize(900,900);
	
	}
	

	
	public void actionPerformed(ActionEvent ae) {
		
		
		if (ae.getSource()== exit) {
			setVisible(false);
		
		}else if (ae.getSource()== deposit) {
			
			setVisible(false);
			Deposit d= new Deposit(pinnumber);
			d.setVisible(true);
			
			
		} else if (ae.getSource()== withdraw) {
			
			setVisible(false);
			Withdraw w= new Withdraw(pinnumber);
			w.setVisible(true);
			
		} else if (ae.getSource()== fastcash) {
			setVisible(false);
			Fastcash f = new Fastcash(pinnumber);
			f.setVisible(true);
			
		}else if (ae.getSource()== pinchange) {
			setVisible(false);
			Pinchange p = new Pinchange(pinnumber);
			p.setVisible(true);
		
		}else if (ae.getSource()== balanceenquiry) {
			
			setVisible(false);
			BalanceEnquiry b = new BalanceEnquiry(pinnumber);
			b.setVisible(true);
			
		} else if (ae.getSource()==ministatement) {
			setVisible(false);
			Ministatement m = new Ministatement(pinnumber);
			m.setVisible(true);
			
		}	
	}
	
	
	public static void main(String[] args) {

		
	 new Transactions("");
	}

}
