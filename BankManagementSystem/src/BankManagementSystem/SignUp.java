package BankManagementSystem;



import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;


public class SignUp extends JFrame implements ActionListener{
	JButton next;
	JTextField nameentrybox , emailentrybox, addressentrybox, cityentrybox, stateentrybox, zipcodeentrybox;
	JRadioButton male, female, married, Unmarried;
	JDateChooser dateChooser;
	Random random;
	SignUp(){
		setLayout(null);
		
		random= new Random();
		int ran = Math.abs(random.nextInt(1000));
		
		JLabel formnum= new JLabel("Form number: "+ ran);
		formnum.setBounds(800,10,200,50);
		formnum.setFont(new Font("Thonburi",Font.BOLD,17));
		add(formnum);
		
		JLabel credential= new JLabel("Page 1- Personal Details");
		credential.setBounds(322,10,400,40);
		credential.setFont(new Font("Thonburi",Font.BOLD,25));
		add(credential);
		
		JLabel name= new JLabel("Name: ");
		name.setBounds(170,70,100,30);
		name.setFont(new Font("Thonburi",Font.BOLD,20));
		add(name);
		
		nameentrybox= new JTextField();
		nameentrybox.setBounds(320,70,300,30);
		nameentrybox.setBackground(Color.white);
		add(nameentrybox);
		
		JLabel gender= new JLabel("Gender: ");
		gender.setBounds(170,110,100,30);
		gender.setFont(new Font("Thonburi",Font.BOLD,20));
		add(gender);
		
		male = new JRadioButton("male");
		male.setBounds(340, 110,100,30);
		male.setForeground(Color.black);
		male.setBackground(Color.white);
		add(male);
		
		female = new JRadioButton("female");
		female.setBounds(500, 110,100,30);
		female.setForeground(Color.black);
		female.setBackground(Color.white);
		add(female);
		
		ButtonGroup gendergroup = new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		
		
	
		JLabel dob= new JLabel("Date of birth: ");
		dob.setBounds(170,150,150,30);
		dob.setFont(new Font("Thonburi",Font.BOLD,20));
		add(dob);
		
		dateChooser= new JDateChooser();
		dateChooser.setBounds(320,150,300,30);
		add(dateChooser);
		
		 
		JLabel email= new JLabel("Email address: ");
		email.setBounds(170,190,150,30);
		email.setFont(new Font("Thonburi",Font.BOLD,20));
		add(email);
		
		emailentrybox= new JTextField();
		emailentrybox.setBounds(320,190,300,30);
		emailentrybox.setBackground(Color.white);
		add(emailentrybox);
		
		JLabel marital= new JLabel("Marital Status: ");
		marital.setBounds(170,230,150,30);
		marital.setFont(new Font("Thonburi",Font.BOLD,20));
		add(marital);
		
		married = new JRadioButton("married");
		married.setBounds(340, 230,100,30);
		married.setForeground(Color.black);
		married.setBackground(Color.white);
		add(married);
		
		Unmarried = new JRadioButton("unmarried");
		Unmarried.setBounds(500, 230,100,30);
		Unmarried.setForeground(Color.black);
		Unmarried.setBackground(Color.white);
		add(Unmarried);
		
		ButtonGroup maritalgroup = new ButtonGroup();
		maritalgroup.add(married);
		maritalgroup.add(Unmarried);
		
		
		
		JLabel address= new JLabel("Address: ");
		address.setBounds(170,270,150,30);
		address.setFont(new Font("Thonburi",Font.BOLD,20));
		add(address);

		addressentrybox= new JTextField();
		addressentrybox.setBounds(320,270,300,30);
		addressentrybox.setBackground(Color.white);
		add(addressentrybox);
		
		JLabel city= new JLabel("City: ");
		city.setBounds(170,310,150,30);
		city.setFont(new Font("Thonburi",Font.BOLD,20));
		add(city);
		
		cityentrybox= new JTextField();
		cityentrybox.setBounds(320,310,300,30);
		cityentrybox.setBackground(Color.white);
		add(cityentrybox);
		
		JLabel state= new JLabel("State: ");
		state.setBounds(170,350,150,30);
		state.setFont(new Font("Thonburi",Font.BOLD,20));
		add(state);
		
		stateentrybox= new JTextField();
		stateentrybox.setBounds(320,350,300,30);
		stateentrybox.setBackground(Color.white);
		add(stateentrybox);
		
		
		JLabel zipCode= new JLabel("Zip Code: ");
		zipCode.setBounds(170,390,150,30);
		zipCode.setFont(new Font("Thonburi",Font.BOLD,20));
		add(zipCode);
		
		zipcodeentrybox= new JTextField();
		zipcodeentrybox.setBounds(320,390,300,30);
		zipcodeentrybox.setBackground(Color.white);
		add(zipcodeentrybox);
		
		next = new JButton("Next");
		next.setBounds(420,450,80,30);
		next.setBackground(Color.black);
		next.setForeground(Color.white);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.white);
		setSize(1000, 600);
		setVisible(true);
		setLocation(1000,250);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		String formnum = ""+ random;
		String nam = nameentrybox.getText();
		String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
		
		String gender = null;
		if(male.isSelected()) {
			gender="Male";
		}else if (female.isSelected()) {
			gender = "Female";
		}
		
		String email = emailentrybox.getText();
		
		String maritalstatus= null;
		if (married.isSelected()) {
			maritalstatus = "married";
		}else if (Unmarried.isSelected()){
			maritalstatus= "unmarried";
		}
		
		String address = addressentrybox.getText();
		String city = cityentrybox.getText();
		String state= stateentrybox.getText();
		String zipcode = zipcodeentrybox.getText();
		
		try {
			if(nam.equals("")|| dob.equals("")|| gender.equals("")|| email.equals("")|| maritalstatus.equals(null)|| address.equals("")) {
				JOptionPane.showMessageDialog(null, "Fill out all the information !!");
			}
				
			
			
			else if (ae.getSource()== next){
				setVisible(false);
				SignUp2 s= new SignUp2(formnum);
				s.setVisible(true);
				
				
				conn C = new conn();
				
				String query = "Insert into signup values('"+email+"','"+nam+"','"+dob+"','"+gender+"','"+maritalstatus+"','"+address+"','"+city+"','"+state+"','"+zipcode+"')";
				C.s.executeUpdate(query);	}
			
		}catch(Exception e) {
			System.out.print(e);
		}	
		
	/*	if (ae.getSource()==next) {
			setVisible(false);
			SignUp2 s= new SignUp2();
			s.setVisible(true);
			
		}*/
				
	}
	

	public static void main(String[] args) {
	new	SignUp();
		
	}

}
