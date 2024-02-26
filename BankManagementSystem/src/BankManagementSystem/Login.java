package BankManagementSystem;
import java.awt.Image;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Login extends JFrame implements ActionListener {
	JButton signin, clear, signUp;
	JTextField getentrybox;
	JPasswordField getentryBox;
	
	Login(){
		setTitle("ATM MACHINE");
		setLayout(null);
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("Pics/logo.jpg"));
		Image i2 = i1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label= new JLabel(i3);
		label.setBounds(30,30,100,100);
		add(label);
		JLabel text = new JLabel("WELCOME TO ATM" );
		text.setFont(new Font("Helvetica", Font.BOLD, 33));
		text.setBounds(340,10,400,100);
		add(text);
		
		JLabel cardnum= new JLabel("Card Number: ");
		cardnum.setBounds(200,160,150,50);
		cardnum.setFont(new Font("cochin",Font.BOLD,20));
		add(cardnum);
		
		getentrybox = new JTextField();
		getentrybox.setBounds(350, 170,300,35);
		getentrybox.setBackground(Color.white);
		getentrybox.setFont(new Font("Arial",Font.BOLD,20));
		add(getentrybox);
		
		JLabel pin= new JLabel("PIN: ");
		pin.setBounds(200,250,200,50);
		pin.setFont(new Font("cochin",Font.BOLD, 20));
		add(pin);
		
		getentryBox= new JPasswordField();
		getentryBox.setBounds(350,260,300,35);
		getentryBox.setBackground(Color.white);
		getentryBox.setFont(new Font("Arial",Font.BOLD,20));
		add(getentryBox);
		
		JButton signin = new JButton("Sign In");
		signin.setBounds(445,340,100,30);
		signin.setBackground(Color.BLUE);
		signin.setFont(new Font("cochin",Font.BOLD,15));
		signin.setForeground(Color.WHITE);
		signin.addActionListener(this);
		add(signin);
		
		clear= new JButton("Clear");
		clear.setBounds(465,305,60,25);
		clear.setBackground(Color.black);
		clear.setFont(new Font("cochin",Font.BOLD,10));
		clear.setForeground(Color.white);
		clear.addActionListener(this);
		add(clear);
		
		JLabel notSignedText= new JLabel("Haven't Signed Up Yet?");
		notSignedText.setBounds(400,430,300,50);
		notSignedText.setFont(new Font("Thonburi",Font.ROMAN_BASELINE,20));
		notSignedText.setForeground(Color.black);
		add(notSignedText);
		
		signUp= new JButton("Sign Up");
		signUp.setBounds(445,480,100,30);
		signUp.setFont(new Font("cochin", Font.BOLD,15));
		signUp.setForeground(Color.black);
		signUp.setBackground(Color.yellow);
		signUp.addActionListener(this);
		add(signUp);
		
		getContentPane().setBackground(Color.lightGray);
		setSize(1000, 600);
		setVisible(true);
		setLocation(1000,250);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource()==clear) {
			getentrybox.setText("");
			getentryBox.setText("");
			
		}else if(ae.getSource()==signin) {
			
			
		} else if (ae.getSource()==signUp) {
			setVisible(false);
			SignUp s= new SignUp();
			s.setVisible(true);
			
		}
		
	}

	public static void main (String Args[]) {
		
		Login login = new Login();
		
	}
	
	
}
