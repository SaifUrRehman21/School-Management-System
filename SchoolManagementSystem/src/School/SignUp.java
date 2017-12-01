package School;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Choice;
import java.awt.List;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.SwingConstants;

public class SignUp extends JFrame {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try 
				{
					SignUp window = new SignUp();
					window.frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 793, 583);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCreateAccount = new JLabel("Create Account");
		lblCreateAccount.setFont(new Font("Sitka Display", Font.PLAIN, 36));
		lblCreateAccount.setBounds(331, 0, 224, 96);
		frame.getContentPane().add(lblCreateAccount);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(SignUp.class.getResource("/Images/SignUp.jpg")));
		lblNewLabel.setBounds(0, 0, 300, 543);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblUserName = new JLabel("Full Name:");
		lblUserName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUserName.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		lblUserName.setBounds(370, 146, 82, 36);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblLastName = new JLabel("Username:");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		lblLastName.setBounds(331, 193, 121, 36);
		frame.getContentPane().add(lblLastName);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		lblEmail.setBounds(408, 240, 44, 36);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Enter Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPassword.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		lblPassword.setBounds(331, 287, 121, 36);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGender.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		lblGender.setBounds(390, 381, 62, 29);
		frame.getContentPane().add(lblGender);
		
		textField = new JTextField();
		textField.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		textField.setBounds(455, 146, 250, 36);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		textField_1.setColumns(10);
		textField_1.setBounds(455, 193, 250, 36);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		textField_2.setColumns(10);
		textField_2.setBounds(455, 240, 250, 36);
		frame.getContentPane().add(textField_2);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		passwordField.setBounds(455, 287, 250, 36);
		frame.getContentPane().add(passwordField);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox.setBounds(455, 383, 250, 20);
		frame.getContentPane().add(comboBox);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login.main(null);		        
		        }
		});
		btnCancel.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		btnCancel.setBounds(616, 421, 89, 50);
		frame.getContentPane().add(btnCancel);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String fullname=textField.getText();
				String username=textField_1.getText().trim();
				String email=textField_2.getText();
				String password=passwordField.getText();
				String cpassword=passwordField_1.getText();
				String gender=comboBox.getSelectedItem().toString();
				//String gender=comboBox
				
				
				//Connection
				if(password.equals(cpassword))
				{
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						String URL="jdbc:mysql://localhost/School";
						Connection con=DriverManager.getConnection(URL,"root","");
						Statement st=con.createStatement();
						
						st.executeUpdate("INSERT INTO signup(Name,Username,Email,Password,Gender) Values('"+fullname+"','"+username+"','"+email+"','"+password+"','"+gender+"')");
						con.close();
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
				}
				else
				{
					JOptionPane.showConfirmDialog(null, "Password does not match");
					passwordField.setText("");
					passwordField_1.setText("");
				}
			}
		});
		btnCreate.setBounds(455, 421, 89, 50);
		frame.getContentPane().add(btnCreate);
		
		JLabel lblConformPassword = new JLabel("Conform Password:");
		lblConformPassword.setHorizontalAlignment(SwingConstants.RIGHT);
		lblConformPassword.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		lblConformPassword.setBounds(315, 334, 137, 36);
		frame.getContentPane().add(lblConformPassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		passwordField_1.setBounds(455, 334, 250, 36);
		frame.getContentPane().add(passwordField_1);
	}
}
