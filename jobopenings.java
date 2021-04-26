import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;



import javax.swing.JPasswordField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollBar;

public class JobOpenings {

	private JFrame frmJobOpenings;
	private JTextField username_text;
	private JTextField email_text;
	private JTextField qualification_text;
	private JPasswordField password_text;

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JobOpenings window = new JobOpenings();
					window.frmJobOpenings.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	int userId;
	String  email, userpassword, userName, qualification;
	
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement pst = null;
	private JTable table;
	
	
	public JobOpenings() {
		initialize();
	}
	
	public void Connect() throws SQLException {
	
	 // variables
      final String url = "http://cs.neiu.edu/phpmyadmin/";
      final String user = "CS3151SP21_msheth1";
      final String password = "msheth1671678";


      // send and execute SQL query in Database software
      // establish the connection
      Connection con = DriverManager.getConnection(url, user, password);

      // display status message
      if (con == null) {
         System.out.println("JDBC connection is not established");
         return;
      } else
         System.out.println("Congratulations," + 
              " JDBC connection is established successfully.\n");

      // close JDBC connection
      con.close();
   } 
	
	public void getData() {
	 String qr = "SELECT * FROM CS3151SP21_msheth1";
	 try {
		pst=con.prepareStatement(qr);
		rs=pst.executeQuery( );
		
	
	} catch (SQLException e) {
		JOptionPane.showMessageDialog(null, e);
	}
	 
	 
	 
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJobOpenings = new JFrame();
		frmJobOpenings.getContentPane().setBackground(Color.PINK);
		frmJobOpenings.setBackground(Color.RED);
		frmJobOpenings.setTitle("Job Openings");
		frmJobOpenings.setBounds(100, 100, 450, 302);
		frmJobOpenings.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJobOpenings.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					Connect();
					
				} catch (SQLException e1) {
					
				}
				
				email = email_text.getText();
				userpassword = password_text.getText(); 
				userName = username_text.getText();
				qualification = qualification_text.getText();
				JOptionPane.showMessageDialog(null, "user info saved");
				
				
				email_text = null;
				password_text = null;
				username_text =null;
				qualification_text= null;

			}
		});
		btnNewButton.setBounds(42, 191, 114, 23);
		frmJobOpenings.getContentPane().add(btnNewButton);
		
		username_text = new JTextField();
		username_text.setBounds(104, 46, 86, 20);
		frmJobOpenings.getContentPane().add(username_text);
		username_text.setColumns(10);
		
		email_text = new JTextField();
		email_text.setBounds(104, 77, 86, 20);
		frmJobOpenings.getContentPane().add(email_text);
		email_text.setColumns(10);
		
		qualification_text = new JTextField();
		qualification_text.setBounds(104, 142, 86, 20);
		frmJobOpenings.getContentPane().add(qualification_text);
		qualification_text.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User Name");
		lblNewLabel.setBounds(10, 49, 84, 14);
		frmJobOpenings.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setBounds(10, 80, 46, 14);
		frmJobOpenings.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(10, 111, 84, 14);
		frmJobOpenings.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Qualification");
		lblNewLabel_3.setBounds(10, 145, 84, 17);
		frmJobOpenings.getContentPane().add(lblNewLabel_3);
		
		JTextPane data_view = new JTextPane();
		data_view.setBackground(Color.WHITE);
		data_view.setEditable(false);
		data_view.setBounds(246, 19, 163, 161);
		frmJobOpenings.getContentPane().add(data_view);
		
		password_text = new JPasswordField();
		password_text.setBounds(104, 108, 86, 20);
		frmJobOpenings.getContentPane().add(password_text);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("View");
		comboBox.addItem("users");
		comboBox.addItem("Job Openings");
		comboBox.setSelectedItem(null);
		
		comboBox.setBounds(279, 191, 145, 23);
		frmJobOpenings.getContentPane().add(comboBox);
		
		JButton btnNewButton_1 = new JButton("View");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String value = (String)comboBox.getSelectedItem();
				if (value == "users") {
					String dt = ("Users \n Abel Mutua \n Anita Davies \n Belinda Michaels \nCharles Obongo \nMikel Orji \nPubi precious \nQuincy Brown \nWhite James \nZubi Kingsley \nZainab fumn");
				data_view.setText(dt);
				}
				else if(value == "Job Openings") {
					String dt1 = ("Available jobs \nSoftware Engineer \nJuniorDeveloper \nDev-Ops \nWeb Designer \nBodygaurd \npublic prosecutor \nNurse \nSeniour chef \nTailors \nComputer Technicians \nWriters \nPersonal Assistants");
					data_view.setText(dt1);
				}
				
			
			}
		});
		btnNewButton_1.setBounds(302, 225, 89, 23);
		frmJobOpenings.getContentPane().add(btnNewButton_1);
		
		table = new JTable();
		table.setBounds(302, 159, -66, -78);
		frmJobOpenings.getContentPane().add(table);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(407, 19, 17, 161);
		frmJobOpenings.getContentPane().add(scrollBar);
	}
}
