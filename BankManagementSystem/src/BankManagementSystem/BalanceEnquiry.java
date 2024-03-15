package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.*;



public class BalanceEnquiry extends JFrame implements  ActionListener{
	int balance = 0;
	
	JButton back;
	String pinnumber;
	BalanceEnquiry(String pinnumber ){
		this.pinnumber = pinnumber;
		setLayout(null);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("pics/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
	
		back = new JButton("Back");
		back.setBounds(380,500,100,30);
		back.setBackground(Color.blue);
		back.setForeground(Color.white);
		back.addActionListener(this);
		image.add(back);
		
		conn c = new conn();
	
		try {
		String query = "select * from bank where PinNumber='"+pinnumber+"'";
		ResultSet rs = c.s.executeQuery(query);
		
		while(rs.next()) {
			
			if (rs.getString("Transaction_Type").equals("deposit")) {
				
				balance = balance + Integer.parseInt(rs.getString("Amount"));
				
			}else {
				balance = balance - Integer.parseInt(rs.getString("Amount"));
			}
			
		}
		
		
		} catch(Exception e) {
			
			System.out.println(e);
		}
		
		JLabel text = new JLabel("Your Account Balance is "+ balance +" USD" );
		text.setBounds(195,350,300,50);
		text.setFont(new Font("Thonburi", Font.BOLD,16));
		text.setForeground(Color.white);
		image.add(text);
		
		
		setVisible(true);
		setLocation(500,200);
		setSize(900,900);
	
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource()==back) {
			
			setVisible(false);
			Transactions t = new Transactions(pinnumber);
			t.setVisible(true);
		}
	}
	
	
	
	
	
	
	


	public static void main(String[] Args  ) {
		new BalanceEnquiry("");
	}


}