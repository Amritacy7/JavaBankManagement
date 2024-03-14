package BankManagementSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;



public class Pinchange extends JFrame implements ActionListener{
	JButton  		submit, back;
	JPasswordField 	enterpinbox, reenterpinbox;
	
	String pinnumber;
	Pinchange(String pinnumber){
		this.pinnumber= pinnumber;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("pics/atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text1 = new JLabel("Please Enter New Pin");
		text1.setBounds(240,300,200,50);
		text1.setForeground(Color.white);
		text1.setFont(new Font("Thonburi",Font.BOLD,18));
		image.add(text1);
		
		enterpinbox = new JPasswordField();
		enterpinbox.setBounds(260,350,150,30);
		enterpinbox.setBackground(Color.white);
		image.add(enterpinbox);
		
		
		JLabel text2 = new JLabel("Please Re-Enter New Pin");
		text2.setBounds(230,390,250,50);
		text2.setForeground(Color.white);
		text2.setFont(new Font("Thonburi",Font.BOLD,18));
		image.add(text2);
		
		reenterpinbox = new JPasswordField();
		reenterpinbox.setBounds(260,440,150,30);
		reenterpinbox.setBackground(Color.white);
		image.add(reenterpinbox);
		
		submit = new JButton("Submit");
		submit.setBounds(400,500,100,30);
		submit.setBackground(Color.blue);
		submit.setForeground(Color.white);
		submit.addActionListener(this);
		image.add(submit);
		
		back = new JButton("Back");
		back.setBounds(170,500,100,30);
		back.setBackground(Color.blue);
		back.setForeground(Color.white);
		back.addActionListener(this);
		image.add(back);
		
		
		
		
		setVisible(true);
		setSize(900,900);
		setLocation(500,200);
		setUndecorated(true);
		
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource()==back) {
			
			setVisible(false);
			Transactions t= new Transactions(pinnumber);
			t.setVisible(true);
			
		}else if (ae.getSource()== submit) {
			
			String newpin	 =	 enterpinbox.getText();
			String renewpin	 = 	reenterpinbox.getText();
			
			if (newpin.equals("")|| renewpin.equals("")) {
				
				JOptionPane.showMessageDialog(null, "Pin Field Cannot Be Empty !");
				return;
			}else if (!newpin.equals(renewpin)) {
				
				JOptionPane.showMessageDialog(null, "Your Pin Did Not Match !");
				return;
				
			}else {
				try {
					
				conn c = new conn();
				
				String query1 = "update bank set PinNumber = '"+newpin+"' where PinNumber= '"+pinnumber+"'";
				String query2 = "update Login set PinNumber = '"+newpin+"' where PinNumber = '"+pinnumber+"'";
				String query3= "update SignUp3 set PinNumber = '"+newpin+"' where PinNumber = '"+pinnumber+"'";
				
				c.s.executeUpdate(query1);
				c.s.executeUpdate(query2);
				c.s.executeUpdate(query3);
				
				JOptionPane.showMessageDialog(null, "Pin Change Successful !!");
				
				setVisible(false);
				Transactions t = new Transactions(newpin);
				t.setVisible(true);
				
				
			}catch (Exception e){
				
				System.out.println(e);
				
			}
			
			
		}
		 
	}
	
	}
	

	public static void main(String[] args) {
		
		new Pinchange("");
		

	}

}
