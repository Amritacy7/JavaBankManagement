


package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Withdraw extends JFrame implements ActionListener{
	
	JButton withdrawbutton, back;
	JTextField entrybox;
	String pinnumber;
	
	Withdraw (String pinnumber){
		this.pinnumber= pinnumber;
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("pics/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,9000,900);
		add(image);
		
		JLabel text = new JLabel("Please Enter Withdraw Amount");
		text.setBounds(220,280,300,50);
		text.setFont(new Font("Thonburi",Font.BOLD,15));
		text.setForeground(Color.white);
		image.add(text);		
		
		entrybox= new JTextField();
		entrybox.setBounds(230,350,200,30);	
		entrybox.setBackground(Color.white);
		image.add(entrybox);		
		
		withdrawbutton= new JButton("Withdraw");
		withdrawbutton.setBounds(400,450,100,30);
		withdrawbutton.setBackground(Color.blue);
		withdrawbutton.setForeground(Color.white);
		withdrawbutton.addActionListener(this);
		image.add(withdrawbutton);
		
		
		back= new JButton("Back");
		back.setBounds(180,450,100,30);
		back.setBackground(Color.blue);
		back.setForeground(Color.white);
		back.addActionListener(this);
		image.add(back);
		
		
		
		setVisible(true);
		setSize(900,900);
		setLocation(500,200);
	}
	
	
	public void actionPerformed(ActionEvent ae) {
		
		String amount = entrybox.getText();
		
		if (ae.getSource()== back) {
			setVisible(false);
			Transactions t = new Transactions(pinnumber);
			t.setVisible(true);
			
		}else if (ae.getSource()==withdrawbutton) {
		
	
			try {
				
			conn c = new conn();
			int balance=0;
			String query1 = "select * from bank where PinNumber = '"+pinnumber+"'";
			ResultSet rs = c.s.executeQuery(query1);
			while(rs.next()) {
				 if (rs.getString("Transaction_Type").equals("deposit")) {
					 
					 balance = balance +Integer.parseInt(rs.getString("Amount"));
				
				 }else {
					 
					 balance = balance - Integer.parseInt(rs.getString("Amount"));
				 }
				  
				
			}
			
			if(Integer.parseInt(amount)< balance ) {
				
				String query2 = "insert into bank values('"+pinnumber+"', 'withdraw','"+amount+"')";
				c.s.executeUpdate(query2);
				
				JOptionPane.showMessageDialog(null, "You have successfully withddrawn USD "+ amount + " !");
				
			} else{
				
				JOptionPane.showMessageDialog(null, "Insufficient Funds !!");
				return;
				
			}
			

			
			} catch(Exception e) {
				System.out.println(e);
			}
			
			
		}
		
	}
	
	
	

	public static void main(String[] args) {
		new Withdraw("");
	}

}
