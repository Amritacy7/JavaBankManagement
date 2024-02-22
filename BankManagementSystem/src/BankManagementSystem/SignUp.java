package BankManagementSystem;
import java.awt.*;
import javax.swing.*;
import java.util.*;


public class SignUp extends JFrame {
	
	SignUp(){
		setLayout(null);
		
		Random random= new Random();
		int ran = Math.abs(random.nextInt(1000));
		
		JLabel formnum= new JLabel("Form number: "+ ran);
		formnum.setBounds(700,20,200,50);
		formnum.setFont(new Font("Thonburi",Font.BOLD,17));
		add(formnum);
		
		JLabel credential= new JLabel("ENTER CREDENTIALS ");
		credential.setBounds(350,30,400,40);
		credential.setFont(new Font("Thonburi",Font.BOLD,20));
		add(credential);
		
		JLabel name= new JLabel("Name: ");
		name.setBounds(200,70,100,30);
		name.setFont(new Font("Thonburi",Font.PLAIN,20));
		add(name);
		
		JTextField nameentrybox= new JTextField();
		nameentrybox.setBounds(300,70,300,30);
		nameentrybox.setBackground(Color.white);
		add(nameentrybox);
		
		getContentPane().setBackground(Color.white);
		setSize(1000, 600);
		setVisible(true);
		setLocation(1000,250);
		
	}
	

	public static void main(String[] args) {
	new	SignUp();
		
	}

}
