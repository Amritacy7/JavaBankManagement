package BankManagementSystem;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;





public class SignUp2 extends JFrame implements ActionListener {
	JButton next;
	JComboBox religionbox, categorybox, incomebox, occupationbox;
	JTextField   eduqualbox, citnumentrybox, eduqalbox, panentrybox;
	JRadioButton buttoncittype, buttoncittype2, buttonAcctype, buttonAcctype2;
	String formnum;
	
	SignUp2(String formnum){
		
		this.formnum= formnum;
		setLayout(null);
		
		setTitle("Application Page 2");
		
		JLabel title = new JLabel("Page 2: Additionals Details");
		title.setBounds(380,10,400,40);
		title.setFont(new Font ("Thonburi",Font.BOLD,20));
		add(title);
		
		JLabel religion = new JLabel("Religion:");
		religion.setBounds(140,70,200,30);
		religion.setFont(new Font("Thonburi",Font.BOLD,20));
		add(religion);
		
		
		String religionvalue[]= {"Hindu", "Christian","Muslim", "Jews","Buddhism"};
		religionbox= new JComboBox(religionvalue);
		religionbox.setBounds(360,70,300,30);
		religionbox.setBackground(Color.WHITE);
		add(religionbox);
		
		
		
		JLabel category= new JLabel("Category: ");
		category.setBounds(140,120,200,30);
		category.setFont(new Font("Thonburi",Font.BOLD,20));
		add(category);
		
		String categoryvalue[]= {"General", "OBC","SC","ST", "Other"};
		categorybox= new JComboBox(categoryvalue);
		categorybox.setBounds(360,120,300,30);
		categorybox.setBackground(Color.white);
		add(categorybox);
		
		
		JLabel income= new JLabel("Income: ");
		income.setBounds(140,170,200,30);
		income.setFont(new Font("Thonburi",Font.BOLD,20));
		add(income);
		
		
		String incomevalue[]= {"Null", "<50,000","50,000<150,000","150,000> "};
		incomebox= new JComboBox(incomevalue);
		incomebox.setBounds(360,170,300,30);
		incomebox.setBackground(Color.white);
		add(incomebox);
		
		JLabel education= new JLabel("Educational");
		education.setBounds(140,210,200,25);
		education.setFont(new Font("Thonburi",Font.BOLD,20));
		add(education);
		
		JLabel qualification= new JLabel("Qualification:");
		qualification.setBounds(140,230,200,25);
		qualification.setFont(new Font("Thonburi",Font.BOLD,20));
		add(qualification);

		eduqualbox= new JTextField();
		eduqualbox.setBounds(360,220,300,30);
		eduqualbox.setBackground(Color.white);
		eduqualbox.setFont(new Font("Thonburi",Font.BOLD,15));
		add(eduqualbox);
		
		JLabel occupation= new JLabel("Occupation:");
		occupation.setBounds(140,280,200,30);
		occupation.setFont(new Font("Thonburi",Font.BOLD,20));
		add(occupation);
		
		String occupationvalue[]= {"Medical","Information Tech","Computer engineer","Aerospace","Finance","Law", "Other"};
		occupationbox= new JComboBox(occupationvalue);
		occupationbox.setBounds(360,280,300,30);
		occupationbox.setBackground(Color.white);
		add(occupationbox);
		
		
		
		JLabel pan= new JLabel("PAN Number:");
		pan.setBounds(140,330,200,30);
		pan.setFont(new Font("Thonburi",Font.BOLD,20));
		add(pan);
		
		panentrybox = new JTextField();
		panentrybox.setBounds(360,330,300,30);
		panentrybox.setFont(new Font ("Thonburi", Font.BOLD, 15));
		panentrybox.setBackground(Color.white);
		add(panentrybox);
		
		JLabel citizennum= new JLabel("Citizenzhip num:");
		citizennum.setBounds(140,380,200,30);
		citizennum.setFont(new Font("Thonburi",Font.BOLD,20));
		add(citizennum);
		
		citnumentrybox = new JTextField();
		citnumentrybox.setBounds(360,380,300,30);
		citnumentrybox.setFont(new Font ("Thonburi", Font.BOLD, 15));
		citnumentrybox.setBackground(Color.white);
		add(citnumentrybox);
		
		JLabel typeCitizen= new JLabel("Senior Citizen: ");
		typeCitizen.setBounds(140,420,200,30);
		typeCitizen.setFont(new Font("Thonburi",Font.BOLD,20));
		add(typeCitizen);
		
		buttoncittype= new JRadioButton("YES");
		buttoncittype.setBounds(400, 420,50,30);
		add(buttoncittype);
		
		buttoncittype2 = new JRadioButton("NO");
		buttoncittype2.setBounds(550,420,50,30);
		add(buttoncittype2);
		
		ButtonGroup buttoncitizen = new ButtonGroup();
		buttoncitizen.add(buttoncittype2);
		buttoncitizen.add(buttoncittype);
		
		JLabel typeAccount= new JLabel("Existing Account:");
		typeAccount.setBounds(140,450,200,30);
		typeAccount.setFont(new Font("Thonburi",Font.BOLD,20));
		add(typeAccount); 
		
		buttonAcctype = new JRadioButton("YES");
		buttonAcctype.setBounds(400,450,50,30);
		add(buttonAcctype);
		
		buttonAcctype2= new JRadioButton("NO");
		buttonAcctype2.setBounds(550,450,50,30);
		add(buttonAcctype2);
		
		ButtonGroup buttonaccount= new ButtonGroup();
		buttonaccount.add(buttonAcctype2);
		buttonaccount.add(buttonAcctype);
		
		next = new JButton("Next");
		next.setBounds(470,500,80,30);
		next.setBackground(Color.blue);
		next.setForeground(Color.white);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.white);
		setVisible(true);
		setSize(1000,600);
		setLocation(1000,250);
	
	}	
	
	public void actionPerformed(ActionEvent ae) {
		String religion = (String)religionbox.getSelectedItem();
		String category = (String)categorybox.getSelectedItem();
		String Income=   (String) incomebox.getSelectedItem();
		String education = eduqualbox.getText();
		String Occupation= (String)occupationbox.getSelectedItem();
		String pan= panentrybox.getText();
		String citizenshipnum= citnumentrybox.getText();
		
		String seniorcitizen= null;
		if (buttoncittype.isSelected()) {
			seniorcitizen = "Yes";
		}else if (buttoncittype2.isSelected()) {
			seniorcitizen = "NO";
		}
		
		String existingAcctype= null;
		if (buttonAcctype.isSelected()) {
			existingAcctype = "Yes";
		}else if (buttonAcctype2.isSelected()) {
			existingAcctype= "NO";
		}
		
		try {
			if(religion.equals("")|| category.equals("")|| Income.equals("")|| education.equals("")|| Occupation.equals("")|| pan.equals("")|| citizenshipnum.equals("")||seniorcitizen.equals(null)||existingAcctype.equals(null)){
			JOptionPane.showMessageDialog(null, "Fill Out all the information!!");
				
			}
		 if(ae.getSource()==next) {
		 setVisible(false);
		 SignUp3 s3= new SignUp3();
		 s3.setVisible(true);
			
		String query = "insert into SignUp2 values ('"+religion+"','"+category+"', '"+Income+"','"+education+"','"+Occupation+"','"+pan+"','"+citizenshipnum+"','"+seniorcitizen+"','"+existingAcctype+"')";
		conn c= new conn();
		c.s.executeUpdate(query);
		}
		}
		catch(Exception e) {
			System.out.print(e);
		}
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
	 new SignUp2("");

	}

}
