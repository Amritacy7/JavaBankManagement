package BankManagementSystem;


import java.sql.*;



public class conn{
	Statement s;
	Connection c;
	
	public conn() {
	//Connection c;
	//public Statement s;
	
		try {
			
			
			c= DriverManager.getConnection("jdbc:mysql:///bankManagementSystem","root","Rocket@1957");
			s= c.createStatement();
			
		}catch(Exception e){
			
			System.out.print(e);
		}
	}
	
	
}