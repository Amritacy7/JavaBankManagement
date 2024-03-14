package BankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class Fastcash extends JFrame implements  ActionListener{
	
	JButton one, two, four, six, ten, exit;
	
	String pinnumber;
	Fastcash(String pinnumber){
		setLayout(null);
		this.pinnumber= pinnumber;
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("pics/atm.jpg"));
		Image i2= i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);	
		
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel select = new JLabel("Please Select Amount To Withdraw ");
		select.setBounds(215,290,300,50);
		select.setForeground(Color.white);
		select.setFont(new Font("Thonburi", Font.BOLD,15));
		image.add(select);
		
		one  = new JButton("1000 USD");
		one.setBounds(160,420,130,25);
		one.setBackground(Color.white);
		one.addActionListener(this);
		image.add(one);
	
		two  = new JButton("2000 USD");
		two.setBounds(380,420,130,25);
		two.setBackground(Color.white);
		two.addActionListener(this);
		image.add(two);
		
		four  = new JButton("4000 USD");
		four.setBounds(160,455,130,25);
		four.setBackground(Color.white);
		four.addActionListener(this);
		image.add(four);
		
		six  = new JButton("6000 USD");
		six.setBounds(380,455,130,25);
		six.setBackground(Color.white);
		six.addActionListener(this);
		image.add(six);
		
		ten  = new JButton("10000 USD");
		ten.setBounds(160,490,130,25);
		ten.setBackground(Color.white);
		ten.addActionListener(this);
		image.add(ten);
		
		
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
			Transactions t= new Transactions(pinnumber);
			t.setVisible(false);
			
		}else {
			
		String amount = ((JButton)ae.getSource()).getText().substring(0, ((JButton)ae.getSource()).getText().length()-4 );
		try {
		conn c = new conn();
		int balance = 0;
		String query = "select * from bank where PinNumber='"+pinnumber+"'";
		
		ResultSet rs = c.s.executeQuery(query);
		
		while(rs.next()) {
			if (rs.getString("Transaction_Type").equals("deposit")) {
				
				balance = balance+ Integer.parseInt(rs.getString("Amount"));
		
			} else {
				
				balance = balance - Integer.parseInt(rs.getString("Amount"));
				
			}
			
			if (Integer.parseInt(amount)<balance) {
				
				JOptionPane.showMessageDialog(null,"Your Withraw is successful !");
				String query1 = "insert into bank values('"+pinnumber+"', 'fastcash','"+amount+"')";
				c.s.executeUpdate(query1);
				return;
				
			}else {
				JOptionPane.showMessageDialog(null,"Insufficient funds!");
				return;

				
			}
			
		}
		
		
		
		
		} catch (Exception e) {
			System.out.println(e);
		}
		}
	}
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		new Fastcash("");

	}

}
