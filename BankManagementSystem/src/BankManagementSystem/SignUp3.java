package BankManagementSystem;

import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.awt.*;

public class SignUp3 extends JFrame implements ActionListener {
	
	JButton submit, cancel;
	JRadioButton checking, saving, credit, fdaccount;
	JCheckBox agree;
	
	SignUp3(){
		
		setLayout(null);
		JLabel headline = new JLabel("Page 3: Account Details");
		headline.setBounds(380,10,300,50);
		headline.setFont(new Font("Thonburi",Font.BOLD,18));
		add(headline);
		
		JLabel acctype = new JLabel("Account Type");
		acctype.setBounds(200,50,200,40);
		acctype.setFont(new Font("Thonburi",Font.BOLD,17));
		add(acctype);
		
		checking = new JRadioButton("Checking");
		checking.setBounds(200,80,120,30);
		checking.setFont(new Font("Thonburi",Font.PLAIN, 15));	
		add(checking);
	
		saving = new JRadioButton("Saving");
		saving.setBounds(400,80,120,30);
		saving.setFont(new Font("Thonburi",Font.PLAIN, 15));	
		add(saving);
	
		fdaccount = new JRadioButton("Fix Deposit");
		fdaccount.setBounds(200,110,120,30);
		fdaccount.setFont(new Font("Thonburi",Font.PLAIN,  15));	
		add(fdaccount);
		
		credit = new JRadioButton(" Credit ");
		credit.setBounds (400,110,120,30);
		credit.setFont(new Font("Thonburi",Font.PLAIN, 15));	
		add(credit);
		
		ButtonGroup buttons = new ButtonGroup();
		buttons.add(checking);
		buttons.add(credit);
		buttons.add(fdaccount);
		buttons.add(saving);
		
		
		
		JLabel cardnumber = new JLabel("Card Number");
		cardnumber.setBounds(200,160,200,30);    
		cardnumber.setFont(new Font("Thonburi",Font.BOLD,18));
		add(cardnumber);
		
		JLabel xxxx = new JLabel("9250-XXXX-XXXX-XXXX");
		xxxx.setBounds(390,160,200,30);
		xxxx.setFont(new Font("Thonburi",Font.BOLD,15));
		add(xxxx);
		
		JLabel cardnum1 = new JLabel("Your 16 Digits Card Number");
		cardnum1.setBounds(200,180,200,30);    
		cardnum1.setFont(new Font("Thonburi",Font.BOLD,12));
		add(cardnum1);
		
		JLabel pinnumber = new JLabel("PIN");
		pinnumber.setBounds(200,220,200,30);    
		pinnumber.setFont(new Font("Thonburi",Font.BOLD,18));
		add(pinnumber);
		
		JLabel XXXX = new JLabel("XXXX");
		XXXX.setBounds(390,220,200,30);    
		XXXX.setFont(new Font("Thonburi",Font.BOLD,15));
		add(XXXX);
		
		JLabel pinnum1 = new JLabel("Your 4 Digits Pin Number");
		pinnum1.setBounds(200,240,200,30);    
		pinnum1.setFont(new Font("Thonburi",Font.BOLD,12));
		add(pinnum1);
		
		JLabel services = new JLabel("Services Required");
		services.setBounds(200,280,200,30);    
		services.setFont(new Font("Thonburi",Font.BOLD,18));
		add(services);
		
		JCheckBox atm = new JCheckBox("ATM card");
		atm.setBounds(200,310,200,30);    
		atm.setFont(new Font("Thonburi",Font.BOLD,15));
		add(atm);
		
		JCheckBox internetbanking = new JCheckBox("Internet Banking");
		internetbanking.setBounds(400,310,200,30);    
		internetbanking.setFont(new Font("Thonburi",Font.BOLD,15));
		add(internetbanking);
		
		JCheckBox mobilebanking = new JCheckBox("Mobile Banking");
		mobilebanking.setBounds(200,340,200,30);    
		mobilebanking.setFont(new Font("Thonburi",Font.BOLD,15));
		add(mobilebanking);
		
		JCheckBox email = new JCheckBox("Email & SMS Alerts");
		email.setBounds(400,340,200,30);    
		email.setFont(new Font("Thonburi",Font.BOLD,15));
		add(email);
		
		JCheckBox chequebook = new JCheckBox("Cheque Book");
		chequebook.setBounds(200,370,200,30);    
		chequebook.setFont(new Font("Thonburi",Font.BOLD,15));
		add(chequebook);
		
		agree = new JCheckBox("I hereby agree and accepts that the above details provided are correct !!");
		agree.setBounds(230,440,500,30);    
		agree.setFont(new Font("Thonburi",Font.BOLD,13));
		add(agree);

		submit = new JButton("Submit");
		submit.setBounds(500,510,100,30);    
		submit.setFont(new Font("Thonburi",Font.BOLD,13));
		submit.setBackground(Color.black);
		submit.setForeground(Color.white);
		submit.addActionListener(this);
		add(submit);
		
		cancel = new JButton("Cancel");
		cancel.setBounds(350,510,100,30);    
		cancel.setFont(new Font("Thonburi",Font.BOLD,13));
		cancel.setBackground(Color.black);
		cancel.setForeground(Color.white);
		cancel.addActionListener(this);
		add(cancel);
		
		
		getContentPane().setBackground(Color.white);
		setSize(1000,600);
		setLocation(1000,250);
		setVisible(true);
		
		
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		
		if (ae.getSource()==cancel) {
			setVisible(false);
			
		}else if (ae.getSource()== submit){
			
			String Accounttype ="";
			if (checking.isSelected()) {
				Accounttype = "Checking";
			}else if (saving.isSelected()) {
				Accounttype = "checking";
			}else if (credit.isSelected()) {
				Accounttype = "Credit";
			}else if (fdaccount.isSelected()) {
				Accounttype = "Fixed Deposit";
			}
			Random ran = new Random();
			String cardnum=  ""+ Math.abs(ran.nextLong()%900000000000L+9250L);
			String pinnum = ""+ Math.abs((ran.nextLong()%9000L)+1000L);
			
			
			String Agree = "";
			if (agree.isSelected()) {
				Agree = "Agreed";
			}
			
			try {
				
			if(Accounttype.equals("") || Agree.equals("")){
				
				JOptionPane.showMessageDialog(null, "Please select all required information and click the agree button !!");
				
			}else {
				
				conn c = new conn();
				String query1 = "insert into SignUp3 values('"+Accounttype+"','"+cardnum+"', '"+pinnum+"')";
				String query2 = "insert into Login values('"+cardnum+"', '"+pinnum+"')";

				c.s.executeUpdate(query1);
				c.s.executeUpdate(query2);
				
				
				
				JOptionPane.showMessageDialog(null, "Save Your Login Details "+"\n Cardnumber: "+ cardnum  +"\n Pin: " + pinnum );
				 
				
				setVisible(false);
				Login l = new Login();
				l.setVisible(true);
				
			}
		
			} catch(Exception e ) {
				System.out.println(e);
			}
			
			
			
		}
	}
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		new SignUp3();

	}

}
