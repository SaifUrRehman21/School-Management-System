package School;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.*;

import com.mysql.jdbc.PreparedStatement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.Color;

public class StudentDetail {

	private JFrame frame;
	private JTextField nmfield;
	private JTextField admfield;
	private JTextField idfield;
	private JTextField ffield;
	private JTextField efield;
	private JTextField feefield;
	private JTextField afield;
	private JTextField birthfield;
	private JTextField cfield;
	private JTextField rfield;

	ResultSet rs=null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDetail window = new StudentDetail();
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
	public StudentDetail() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 716, 499);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblStudentDetail = new JLabel("Student Detail");
		lblStudentDetail.setForeground(Color.WHITE);
		lblStudentDetail.setFont(new Font("Sitka Display", Font.PLAIN, 36));
		lblStudentDetail.setBounds(288, -13, 224, 96);
		frame.getContentPane().add(lblStudentDetail);
		
		JLabel label_1 = new JLabel("ID:");
		label_1.setForeground(Color.WHITE);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Sitka Display", Font.BOLD, 18));
		label_1.setBounds(-11, 128, 82, 36);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Name:");
		label_2.setForeground(Color.WHITE);
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Sitka Display", Font.BOLD, 18));
		label_2.setBounds(-1, 164, 82, 36);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Email:");
		label_3.setForeground(Color.WHITE);
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Sitka Display", Font.BOLD, 18));
		label_3.setBounds(9, 204, 62, 36);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Roll No:");
		label_4.setForeground(Color.WHITE);
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("Sitka Display", Font.BOLD, 18));
		label_4.setBounds(366, 244, 72, 36);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("Gender:");
		label_5.setForeground(Color.WHITE);
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("Sitka Display", Font.BOLD, 18));
		label_5.setBounds(493, 286, 62, 29);
		frame.getContentPane().add(label_5);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setBounds(565, 288, 99, 20);
		frame.getContentPane().add(comboBox);
		
		nmfield = new JTextField();
		nmfield.setEditable(false);
		nmfield.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		nmfield.setColumns(10);
		nmfield.setBounds(81, 168, 216, 29);
		frame.getContentPane().add(nmfield);
		
		admfield = new JTextField();
		admfield.setEditable(false);
		admfield.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		admfield.setColumns(10);
		admfield.setBounds(448, 128, 216, 29);
		frame.getContentPane().add(admfield);
		
		idfield = new JTextField();
		idfield.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		idfield.setColumns(10);
		idfield.setBounds(81, 128, 135, 29);
		frame.getContentPane().add(idfield);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				String id=idfield.getText();
				/*String admissiondate=admfield.getText();
				String name =nmfield.getText();
				String father=ffield.getText();
				String email=efield.getText();
				String cnic=cfield.getText();
				String fees=feefield.getText();
				String rollno=rfield.getText();
				String address=afield.getText();
				String gender="Male";
				String birthday=birthfield.getText();
				*/
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					String URL="jdbc:mysql://localhost/School";
					Connection con=DriverManager.getConnection(URL,"root","");
					Statement st=con.createStatement();
					ResultSet ps=null;
					rs=st.executeQuery("SELECT * FROM student Where id=1");
					
					

					//String sql = "SELECT EmployeeID,FirstName,LastName,Designation,BasicSalary FROM EmployeeInfo WHERE EmployeeID =?";
				    if(rs!=null)
				    {
				    	while(rs.next())
				    	{
					        //idfield.setText(rs.getString("id"));
					        admfield.setText(rs.getString("admissiondate"));
							nmfield.setText(rs.getString("name"));
							ffield.setText(rs.getString("father"));
							efield.setText(rs.getString("email"));
							cfield.setText(rs.getString("cnic"));
							feefield.setText(rs.getString("fees"));
							rfield.setText(rs.getString("rollno"));
							afield.setText(rs.getString("address"));
							//comboBox.addItem(rs.getString("gender"));
							birthfield.setText(rs.getString("birthday"));
				    	}
				    }
					
					
				}
				catch(Exception ex)
				{
					System.out.println(ex);
				}
			}
		});
		
		btnSearch.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		btnSearch.setBounds(217, 128, 82, 29);
		frame.getContentPane().add(btnSearch);
		
		JButton bt_Cancel = new JButton("Cancel");
		bt_Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				idfield.setText("");
				admfield.setText("");
				nmfield.setText("");
				ffield.setText("");
				efield.setText("");
				cfield.setText("");
				feefield.setText("");
				rfield.setText("");
				afield.setText("");
				
				birthfield.setText("");
			}
		});
		bt_Cancel.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		bt_Cancel.setBounds(518, 399, 89, 50);
		frame.getContentPane().add(bt_Cancel);
		
		JLabel label_6 = new JLabel("Admission Date:");
		label_6.setForeground(Color.WHITE);
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setFont(new Font("Sitka Display", Font.BOLD, 18));
		label_6.setBounds(307, 124, 131, 36);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("Father Name:");
		label_7.setForeground(Color.WHITE);
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setFont(new Font("Sitka Display", Font.BOLD, 18));
		label_7.setBounds(307, 164, 135, 36);
		frame.getContentPane().add(label_7);
		
		ffield = new JTextField();
		ffield.setEditable(false);
		ffield.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		ffield.setColumns(10);
		ffield.setBounds(448, 168, 216, 29);
		frame.getContentPane().add(ffield);
		
		efield = new JTextField();
		efield.setEditable(false);
		efield.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		efield.setColumns(10);
		efield.setBounds(81, 208, 216, 29);
		frame.getContentPane().add(efield);
		
		JLabel label_8 = new JLabel("CNIC:");
		label_8.setForeground(Color.WHITE);
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setFont(new Font("Sitka Display", Font.BOLD, 18));
		label_8.setBounds(344, 204, 94, 36);
		frame.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("Fees:");
		label_9.setForeground(Color.WHITE);
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setFont(new Font("Sitka Display", Font.BOLD, 18));
		label_9.setBounds(-1, 244, 72, 36);
		frame.getContentPane().add(label_9);
		
		feefield = new JTextField();
		feefield.setEditable(false);
		feefield.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		feefield.setColumns(10);
		feefield.setBounds(81, 248, 216, 29);
		frame.getContentPane().add(feefield);
		
		JLabel label_10 = new JLabel("Address:");
		label_10.setForeground(Color.WHITE);
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setFont(new Font("Sitka Display", Font.BOLD, 18));
		label_10.setBounds(-1, 286, 72, 29);
		frame.getContentPane().add(label_10);
		
		afield = new JTextField();
		afield.setEditable(false);
		afield.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		afield.setColumns(10);
		afield.setBounds(81, 290, 354, 64);
		frame.getContentPane().add(afield);
		
		JLabel label_11 = new JLabel("Birthday:");
		label_11.setForeground(Color.WHITE);
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		label_11.setFont(new Font("Sitka Display", Font.BOLD, 18));
		label_11.setBounds(438, 308, 74, 46);
		frame.getContentPane().add(label_11);
		
		birthfield = new JTextField();
		birthfield.setEditable(false);
		birthfield.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		birthfield.setColumns(10);
		birthfield.setBounds(518, 319, 146, 29);
		frame.getContentPane().add(birthfield);
		
		cfield = new JTextField();
		cfield.setEditable(false);
		cfield.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		cfield.setColumns(10);
		cfield.setBounds(448, 211, 216, 29);
		frame.getContentPane().add(cfield);
		
		rfield = new JTextField();
		rfield.setEditable(false);
		rfield.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		rfield.setColumns(10);
		rfield.setBounds(448, 251, 216, 29);
		frame.getContentPane().add(rfield);
		
		JButton bt_clear = new JButton("Clear");
		bt_clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				idfield.setText("");
				admfield.setText("");
				nmfield.setText("");
				ffield.setText("");
				efield.setText("");
				cfield.setText("");
				feefield.setText("");
				rfield.setText("");
				afield.setText("");
				comboBox.setSelectedIndex(0);
				birthfield.setText("");
			}
		});
		bt_clear.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		bt_clear.setBounds(288, 399, 89, 50);
		frame.getContentPane().add(bt_clear);
		
		JButton btnSave = new JButton("Save");
		btnSave.setEnabled(false);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSave.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		btnSave.setBounds(81, 399, 89, 50);
		frame.getContentPane().add(btnSave);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon(StudentDetail.class.getResource("/Images/StudentDetail.jpg")));
		lblNewLabel.setBounds(-1, 0, 701, 460);
		frame.getContentPane().add(lblNewLabel);
	}
}
