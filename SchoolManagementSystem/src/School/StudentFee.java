package School;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;

public class StudentFee {

	private JFrame frame;
	private JTextField name;
	private JTextField adate;
	private JTextField id;
	private JTextField fname;
	private JTextField email;
	private JTextField fees;
	private JTextField cnic;
	private JTextField roll;
	private JTextField amount;
	private JTextField gtotal;

	
	ResultSet rs=null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentFee window = new StudentFee();
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
	public StudentFee() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 743, 472);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("ID:");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Sitka Display", Font.BOLD, 18));
		label.setBounds(10, 87, 82, 36);
		frame.getContentPane().add(label);
		
		JLabel lblStudentFee = new JLabel("Student Fee");
		lblStudentFee.setForeground(Color.BLACK);
		lblStudentFee.setFont(new Font("Sitka Display", Font.PLAIN, 36));
		lblStudentFee.setBounds(309, -24, 224, 96);
		frame.getContentPane().add(lblStudentFee);
		
		JLabel label_4 = new JLabel("Father Name:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Sitka Display", Font.BOLD, 18));
		label_4.setBounds(328, 123, 135, 36);
		frame.getContentPane().add(label_4);
		
		JLabel label_6 = new JLabel("Email:");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("Sitka Display", Font.BOLD, 18));
		label_6.setBounds(30, 163, 62, 36);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("Admission Date:");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setForeground(Color.BLACK);
		label_7.setFont(new Font("Sitka Display", Font.BOLD, 18));
		label_7.setBounds(328, 83, 131, 36);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("Name:");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setForeground(Color.BLACK);
		label_8.setFont(new Font("Sitka Display", Font.BOLD, 18));
		label_8.setBounds(20, 123, 82, 36);
		frame.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("CNIC:");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setForeground(Color.BLACK);
		label_9.setFont(new Font("Sitka Display", Font.BOLD, 18));
		label_9.setBounds(365, 163, 94, 36);
		frame.getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("Fees:");
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setForeground(Color.BLACK);
		label_10.setFont(new Font("Sitka Display", Font.BOLD, 18));
		label_10.setBounds(20, 203, 72, 36);
		frame.getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel("Roll No:");
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		label_11.setForeground(Color.BLACK);
		label_11.setFont(new Font("Sitka Display", Font.BOLD, 18));
		label_11.setBounds(387, 203, 72, 36);
		frame.getContentPane().add(label_11);
		
		name = new JTextField();
		name.setEditable(false);
		name.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		name.setColumns(10);
		name.setBounds(108, 127, 216, 29);
		frame.getContentPane().add(name);
		
		adate = new JTextField();
		adate.setEditable(false);
		adate.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		adate.setColumns(10);
		adate.setBounds(475, 87, 216, 29);
		frame.getContentPane().add(adate);
		
		id = new JTextField();
		id.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		id.setColumns(10);
		id.setBounds(108, 87, 135, 29);
		frame.getContentPane().add(id);
		
		fname = new JTextField();
		fname.setEditable(false);
		fname.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		fname.setColumns(10);
		fname.setBounds(475, 127, 216, 29);
		frame.getContentPane().add(fname);
		
		email = new JTextField();
		email.setEditable(false);
		email.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		email.setColumns(10);
		email.setBounds(108, 167, 216, 29);
		frame.getContentPane().add(email);
		
		fees = new JTextField();
		fees.setEditable(false);
		fees.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		fees.setColumns(10);
		fees.setBounds(108, 207, 216, 29);
		frame.getContentPane().add(fees);
		
		cnic = new JTextField();
		cnic.setEditable(false);
		cnic.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		cnic.setColumns(10);
		cnic.setBounds(475, 170, 216, 29);
		frame.getContentPane().add(cnic);
		
		roll = new JTextField();
		roll.setEditable(false);
		roll.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		roll.setColumns(10);
		roll.setBounds(475, 210, 216, 29);
		frame.getContentPane().add(roll);
		
		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int Id=Integer.parseInt(id.getText());
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					String URL="jdbc:mysql://localhost/School";
					Connection con=DriverManager.getConnection(URL,"root","");
					Statement st=con.createStatement();
					ResultSet ps=null;
					rs=st.executeQuery("SELECT admissiondate,name,father,email,cnic,fees,rollno FROM student Where id="+Id+"");
				    if(rs!=null)
				    {
				    	while(rs.next())
				    	{
					        adate.setText(rs.getString("admissiondate"));
							name.setText(rs.getString("name"));
							fname.setText(rs.getString("father"));
							email.setText(rs.getString("email"));
							cnic.setText(rs.getString("cnic"));
							fees.setText(rs.getString("fees"));
							roll.setText(rs.getString("rollno"));
				    	}
				    }
				}
				
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		});
		button.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		button.setBounds(243, 87, 82, 29);
		frame.getContentPane().add(button);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int Fee=Integer.parseInt(fees.getText());
				int Id=Integer.parseInt(id.getText());
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					String URL="jdbc:mysql://localhost/School";
					Connection con=DriverManager.getConnection(URL,"root","");
					Statement st=con.createStatement();
					
					st.executeUpdate("INSERT INTO fee(ID,Fee) Values('"+Id+"','"+Fee+"')");
					JOptionPane.showConfirmDialog(null, "Record Saved");
					con.close();
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		});
		btnSave.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		btnSave.setBounds(107, 358, 89, 50);
		frame.getContentPane().add(btnSave);
		
		JButton button_2 = new JButton("Clear");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_2.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		button_2.setBounds(314, 358, 89, 50);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("Cancel");
		button_3.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		button_3.setBounds(544, 358, 89, 50);
		frame.getContentPane().add(button_3);
		
		JLabel lblAmount = new JLabel("Amount:");
		lblAmount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAmount.setForeground(Color.BLACK);
		lblAmount.setFont(new Font("Sitka Display", Font.BOLD, 18));
		lblAmount.setBounds(20, 245, 72, 36);
		frame.getContentPane().add(lblAmount);
		
		amount = new JTextField();
		amount.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent arg0) {
				int Fee=Integer.parseInt(fees.getText());
				int Amount=Integer.parseInt(amount.getText());
				
				int GTotal=Amount-Fee;
				gtotal.setText(GTotal+"");
			}
		});
		amount.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		amount.setColumns(10);
		amount.setBounds(108, 249, 216, 29);
		frame.getContentPane().add(amount);
		
		JLabel lblGrandTotal = new JLabel("Grand Total:");
		lblGrandTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGrandTotal.setForeground(Color.BLACK);
		lblGrandTotal.setFont(new Font("Sitka Display", Font.BOLD, 18));
		lblGrandTotal.setBounds(0, 287, 102, 36);
		frame.getContentPane().add(lblGrandTotal);
		
		gtotal = new JTextField();
		gtotal.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		gtotal.setColumns(10);
		gtotal.setBounds(108, 291, 216, 29);
		frame.getContentPane().add(gtotal);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(StudentFee.class.getResource("/Images/StudentFee.jpg")));
		label_1.setBounds(0, 0, 727, 433);
		frame.getContentPane().add(label_1);
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{id, button, fees, amount, btnSave, label, lblStudentFee, label_4, label_6, label_7, label_8, label_9, label_10, label_11, name, adate, fname, email, cnic, roll, button_2, button_3, lblAmount, lblGrandTotal, gtotal}));
	}
}
