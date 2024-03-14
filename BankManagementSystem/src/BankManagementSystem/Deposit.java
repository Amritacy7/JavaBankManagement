package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Deposit extends JFrame implements ActionListener{
	
	JButton depositbutton, back;
	JTextField entrybox;
	String pinnumber;
	
	Deposit(String pinnumber){
		this.pinnumber= pinnumber;
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("pics/atm.jpg"));
		Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,9000,900);
		add(image);
		
		JLabel text = new JLabel("Please Enter Deposit Amount");
		text.setBounds(220,280,300,50);
		text.setFont(new Font("Thonburi",Font.BOLD,15));
		text.setForeground(Color.white);
		image.add(text);		
		
		entrybox= new JTextField();
		entrybox.setBounds(230,350,200,30);	
		entrybox.setBackground(Color.white);
		image.add(entrybox);		
		
		depositbutton= new JButton("Deposit");
		depositbutton.setBounds(400,450,100,30);
		depositbutton.setBackground(Color.blue);
		depositbutton.setForeground(Color.white);
		depositbutton.addActionListener(this);
		image.add(depositbutton);
		
		
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
			
		}else if (ae.getSource()==depositbutton) {
			try {

			conn c = new conn();
			String query = "insert into bank values('"+pinnumber+"', 'deposit','"+amount+"')";
			c.s.executeUpdate(query);
			
			JOptionPane.showMessageDialog(null, "You have successfully depsoited USD "+ amount);

			
			} catch(Exception e) {
				System.out.println(e);
			}
			
			
		}
		
	}
	
	
	

	public static void main(String[] args) {
		new Deposit("");
	}

}
