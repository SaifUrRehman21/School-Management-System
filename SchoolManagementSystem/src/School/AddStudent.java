package School;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class AddStudent {

	private JFrame frame;
	private JTextField nmfield;
	private JTextField ffield;
	private JTextField efield;
	private JTextField feefield;
	private JTextField afield;
	private JTextField birthfield;
	private JTextField admfield;
	private JTextField cfield;
	private JTextField rfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudent window = new AddStudent();
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
	public AddStudent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 728, 530);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAddStudent = new JLabel("Add Student");
		lblAddStudent.setForeground(Color.WHITE);
		lblAddStudent.setFont(new Font("Sitka Display", Font.PLAIN, 36));
		lblAddStudent.setBounds(309, 12, 224, 96);
		frame.getContentPane().add(lblAddStudent);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(Color.WHITE);
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		lblName.setBounds(20, 144, 82, 36);
		frame.getContentPane().add(lblName);
		
		JLabel label_3 = new JLabel("Email:");
		label_3.setForeground(Color.WHITE);
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		label_3.setBounds(48, 184, 44, 36);
		frame.getContentPane().add(label_3);
		
		JLabel lblRollNo = new JLabel("Roll No:");
		lblRollNo.setForeground(Color.WHITE);
		lblRollNo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRollNo.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		lblRollNo.setBounds(387, 224, 72, 36);
		frame.getContentPane().add(lblRollNo);
		
		JLabel label_5 = new JLabel("Gender:");
		label_5.setForeground(Color.WHITE);
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		label_5.setBounds(469, 266, 62, 29);
		frame.getContentPane().add(label_5);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setBounds(541, 268, 144, 20);
		frame.getContentPane().add(comboBox);
		
		nmfield = new JTextField();
		nmfield.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		nmfield.setColumns(10);
		nmfield.setBounds(102, 148, 216, 29);
		frame.getContentPane().add(nmfield);
		
		JButton btnAdd = new JButton("Save");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			String admissiondate=admfield.getText();
			String name =nmfield.getText();
			String father=ffield.getText();
			String email=efield.getText();
			String cnic=cfield.getText();
			String fees=feefield.getText();
			String rollno=rfield.getText();
			String address=afield.getText();
			String gender=comboBox.getSelectedItem().toString();
			String birthday=birthfield.getText();
			
			
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				String URL="jdbc:mysql://localhost/School";
				Connection con=DriverManager.getConnection(URL,"root","");
				Statement st=con.createStatement();
				
				st.executeUpdate("INSERT INTO student(admissiondate,name,father,email,cnic,fees,rollno,address,gender,birthday) Values('"+admissiondate+"','"+name+"','"+father+"','"+email+"','"+cnic+"','"+fees+"','"+rollno+"','"+address+"','"+gender+"','"+birthday+"')");
				con.close();
			}
			catch(Exception e)
			{
				System.out.println(e);
			}

			}
		});
		btnAdd.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		btnAdd.setBounds(102, 379, 89, 50);
		frame.getContentPane().add(btnAdd);
		
		JButton button_1 = new JButton("Cancel");
		button_1.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		button_1.setBounds(539, 379, 89, 50);
		frame.getContentPane().add(button_1);
		
		JLabel lblFatherName = new JLabel("Father Name:");
		lblFatherName.setForeground(Color.WHITE);
		lblFatherName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFatherName.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		lblFatherName.setBounds(328, 144, 135, 36);
		frame.getContentPane().add(lblFatherName);
		
		ffield = new JTextField();
		ffield.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		ffield.setColumns(10);
		ffield.setBounds(469, 148, 216, 29);
		frame.getContentPane().add(ffield);
		
		efield = new JTextField();
		efield.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		efield.setColumns(10);
		efield.setBounds(102, 188, 216, 29);
		frame.getContentPane().add(efield);
		
		JLabel lblCnic = new JLabel("CNIC:");
		lblCnic.setForeground(Color.WHITE);
		lblCnic.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCnic.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		lblCnic.setBounds(365, 184, 94, 36);
		frame.getContentPane().add(lblCnic);
		
		JLabel lblFees = new JLabel("Fees:");
		lblFees.setForeground(Color.WHITE);
		lblFees.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFees.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		lblFees.setBounds(20, 224, 72, 36);
		frame.getContentPane().add(lblFees);
		
		feefield = new JTextField();
		feefield.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		feefield.setColumns(10);
		feefield.setBounds(102, 228, 216, 29);
		frame.getContentPane().add(feefield);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setForeground(Color.WHITE);
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		lblAddress.setBounds(20, 266, 72, 29);
		frame.getContentPane().add(lblAddress);
		
		afield = new JTextField();
		afield.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		afield.setColumns(10);
		afield.setBounds(102, 270, 354, 64);
		frame.getContentPane().add(afield);
		
		JLabel lblBirthday = new JLabel("Birthday:");
		lblBirthday.setForeground(Color.WHITE);
		lblBirthday.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBirthday.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		lblBirthday.setBounds(459, 288, 74, 46);
		frame.getContentPane().add(lblBirthday);
		
		birthfield = new JTextField();
		birthfield.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		birthfield.setColumns(10);
		birthfield.setBounds(539, 299, 146, 29);
		frame.getContentPane().add(birthfield);
		
		JLabel label = new JLabel("Admission Date:");
		label.setForeground(Color.WHITE);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		label.setBounds(328, 97, 131, 36);
		frame.getContentPane().add(label);
		
		admfield = new JTextField();
		admfield.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		admfield.setColumns(10);
		admfield.setBounds(469, 101, 216, 29);
		frame.getContentPane().add(admfield);
		
		cfield = new JTextField();
		cfield.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		cfield.setColumns(10);
		cfield.setBounds(469, 188, 216, 29);
		frame.getContentPane().add(cfield);
		
		rfield = new JTextField();
		rfield.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		rfield.setColumns(10);
		rfield.setBounds(469, 228, 216, 29);
		frame.getContentPane().add(rfield);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnClear.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		btnClear.setBounds(287, 379, 89, 50);
		frame.getContentPane().add(btnClear);
		
		JLabel label_1 = new JLabel("");
		label_1.setForeground(Color.WHITE);
		label_1.setIcon(new ImageIcon(AddStudent.class.getResource("/Images/AddStudent.jpg")));
		label_1.setBounds(0, 0, 712, 485);
		frame.getContentPane().add(label_1);
		frame.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{nmfield, lblAddStudent, lblName, label_3, lblRollNo, label_5, comboBox, btnAdd, button_1, lblFatherName}));
	}
}
