package BankManagementSystem;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;


public class SignUp extends JFrame {
	
	SignUp(){
		setLayout(null);
		
		JLabel credential= new JLabel("ENTER CREDENTIALS ");
		credential.setBounds(350,30,400,40);
		credential.setFont(new Font("Thonburi",Font.BOLD,20));
		add(credential);
		
		JLabel name= new JLabel("Name: ");
		name.setBounds(200,70,100,50);
		name.setFont(new Font("Thonburi",Font.PLAIN,20));
		add(name);
		
		getContentPane().setBackground(Color.white);
		setSize(1000, 600);
		setVisible(true);
		setLocation(1000,250);
		
	}
	

	public static void main(String[] args) {
	new	SignUp();
		
	}

}
