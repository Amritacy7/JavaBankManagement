package BankManagementSystem;

import javax.swing.*;
import java.awt.*;

public class SignUp3 extends JFrame  {
	
	
	SignUp3(){
		
		setLayout(null);
		JLabel headline = new JLabel("Page 3: Account Details");
		headline.setBounds(400,20,300,50);
		headline.setFont(new Font("Thonburi",Font.BOLD,18));
		add(headline);
		
		JLabel acctype = new JLabel("Account Type");
		acctype.setBounds(200,50,200,40);
		acctype.setFont(new Font("Thonburi",Font.BOLD,17));
		add(acctype);
		
		JRadioButton checking = new JRadioButton("Checking");
		checking.setBounds(200,80,120,30);
		checking.setFont(new Font("Thonburi",Font.PLAIN, 15));	
		add(checking);
	
		JRadioButton saving = new JRadioButton("Saving");
		saving.setBounds(400,80,120,30);
		saving.setFont(new Font("Thonburi",Font.PLAIN, 15));	
		add(saving);
	
		JRadioButton fdaccount = new JRadioButton("Fix Deposit");
		fdaccount.setBounds(200,110,120,30);
		fdaccount.setFont(new Font("Thonburi",Font.PLAIN, 15));	
		add(fdaccount);
		
		JRadioButton credit = new JRadioButton(" Credit ");
		credit.setBounds (400,110,120,30);
		credit.setFont(new Font("Thonburi",Font.PLAIN, 15));	
		add(credit);


		
		
		
		
		
		
		
		
		getContentPane().setBackground(Color.white);
		setSize(1000,600);
		setLocation(1000,250);
		setVisible(true);
		
		
	}

	public static void main(String[] args) {
		new SignUp3();

	}

}
