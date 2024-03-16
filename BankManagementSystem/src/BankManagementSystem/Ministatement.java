package BankManagementSystem;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Objects;
import java.util.Vector;


public class Ministatement extends JFrame  {
	
	String pinnumber;
	Object[][] data;
	Ministatement(String pinnumber){
		
	this.pinnumber= pinnumber;
		
	setTitle("Mini Statement");
	setVisible(true);
	setSize(700,900);
	setLocation(500,200);
	getContentPane().setLayout(null);
	 
	JLabel text = new JLabel(" My Own Bank ");
	text.setBounds(220,30,250,50);
	text.setFont(new Font("Thonburi",Font.BOLD,30));
	text.setForeground(Color.DARK_GRAY);
	add(text);
	
	JLabel text1 = new JLabel(" Statement ");
	text1.setBounds(270,70,200,50);
	text1.setFont(new Font("Railway ",Font.BOLD,20));
	text1.setForeground(Color.black);
	add(text1);
	
	JLabel balancetext = new JLabel();
	balancetext.setBounds(170,600,350,50);
	balancetext.setFont(new Font("Railway ",Font.BOLD,15));
	balancetext.setForeground(Color.black);
	add(balancetext);
	
	String[] columns = new String[] {"Date And Time", "Transaction_Type", "Amount" };
	DefaultTableModel dtm = new DefaultTableModel(data, columns);
	
	
	JTable table = new JTable(dtm);
	JScrollPane jpane = new JScrollPane(table);
	jpane.setBounds(50,150,600,400);
	getContentPane().add(jpane);
	setVisible(true);
	
	Object[] data = new Object[3];
	
	
	conn c = new conn();
	 int balance = 0;
	try {
	
	ResultSet rs = c.s.executeQuery("select * from bank where PinNumber= '"+pinnumber+"'");
	
	while(rs.next()) {
		data[0]= rs.getString("Time_date");
		data[1] = rs.getString("Transaction_type");
		data[2] = rs.getString("Amount");
		
		dtm.addRow(data);
		
	
		 if (rs.getString("Transaction_Type").equals("deposit")) {
			 
			 balance = balance + Integer.parseInt(rs.getString("Amount"));
			 
		 }else {
			 
			 balance = balance - Integer.parseInt(rs.getString("Amount"));
			
		 }

	}

	} catch(Exception e) {
		
		System.out.println(e);
	 }
	
	
	balancetext.setText("Your Current Account Balance is "+ balance+ " USD");
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	}
	


	public static void main(String[] args) {

		new Ministatement("");
		
	}

}
