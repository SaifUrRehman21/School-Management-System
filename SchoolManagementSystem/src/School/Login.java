package School;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Login {

	private JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				String user=textField.getText();
				String pass=passwordField.getText();
				
				if (user.isEmpty() ||pass.isEmpty()) 
				{
					JOptionPane.showConfirmDialog(null, "Username & Password must not be empty.");
				}
				else
				{
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						String URL="jdbc:mysql://localhost/School";
						Connection con=DriverManager.getConnection(URL,"root","");
						Statement st=con.createStatement();
						
						PreparedStatement pst = con.prepareStatement("select * from signup where Username=? and Password=?");
						pst.setString(1, user);
			            pst.setString(2, pass);
			            ResultSet rs = pst.executeQuery();
			            if (rs.next()) 
			            {
			            	JOptionPane.showConfirmDialog(null, "Login Successfull");
			            	textField.setText("");
							passwordField.setText("");
							Desktop ob=new Desktop();
							ob.main(null);
			            } 
			            else 
			            {		            	
			            	JOptionPane.showConfirmDialog(null, "Login Unsuccessfull");
			                textField.setText("");
							passwordField.setText("");
			            }
					}
					catch(Exception e)
					{
						System.out.println(e);
					}
				}
			}
		});
		
		JButton btnCreateAccount = new JButton("");
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				SignUp signup=new SignUp();
				signup.main(null);
				
				
			}
		});
		btnCreateAccount.setIcon(new ImageIcon(Login.class.getResource("/Images/Create Account.jpg")));
		btnCreateAccount.setBounds(225, 277, 257, 36);
		frame.getContentPane().add(btnCreateAccount);
		button.setIcon(new ImageIcon(Login.class.getResource("/Images/LoginButton.jpg")));
		button.setBounds(491, 222, 96, 53);
		frame.getContentPane().add(button);
		
		JLabel lblSdfsfd = new JLabel("");
		lblSdfsfd.setIcon(new ImageIcon(Login.class.getResource("/Images/Login.jpg")));
		lblSdfsfd.setBounds(0, 0, 684, 411);
		frame.getContentPane().add(lblSdfsfd);
		
		textField = new JTextField();
		textField.setBounds(225, 176, 257, 36);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(225, 230, 257, 36);
		frame.getContentPane().add(passwordField);
	}
}
