package School;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class AddTeacher {

	private JFrame frame;
	private JTextField nmfield;
	private JTextField admfield;
	private JTextField idfield;
	private JTextField ffield;
	private JTextField efield;
	private JTextField sfield;
	private JTextField adfield;
	private JTextField birthfield;
	private JTextField cfield;
	private JTextField qfield;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTeacher window = new AddTeacher();
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
	public AddTeacher() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 701, 525);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAddTeacher = new JLabel("Add Teacher");
		lblAddTeacher.setForeground(Color.WHITE);
		lblAddTeacher.setFont(new Font("Sitka Display", Font.PLAIN, 36));
		lblAddTeacher.setBounds(284, 0, 224, 96);
		frame.getContentPane().add(lblAddTeacher);
		
		JLabel label_1 = new JLabel("ID:");
		label_1.setForeground(Color.WHITE);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("Dialog", Font.BOLD, 15));
		label_1.setBounds(-15, 141, 82, 36);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Name:");
		label_2.setForeground(Color.WHITE);
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("Dialog", Font.BOLD, 15));
		label_2.setBounds(-5, 177, 82, 36);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Email:");
		label_3.setForeground(Color.WHITE);
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("Dialog", Font.BOLD, 15));
		label_3.setBounds(23, 217, 44, 36);
		frame.getContentPane().add(label_3);
		
		JLabel lblQualification = new JLabel("Qualification:");
		lblQualification.setForeground(Color.WHITE);
		lblQualification.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQualification.setFont(new Font("Dialog", Font.BOLD, 15));
		lblQualification.setBounds(317, 257, 117, 36);
		frame.getContentPane().add(lblQualification);
		
		JLabel label_5 = new JLabel("Gender:");
		label_5.setForeground(Color.WHITE);
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("Dialog", Font.BOLD, 15));
		label_5.setBounds(444, 299, 62, 29);
		frame.getContentPane().add(label_5);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setBounds(516, 301, 144, 20);
		frame.getContentPane().add(comboBox);
		
		nmfield = new JTextField();
		nmfield.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		nmfield.setColumns(10);
		nmfield.setBounds(77, 181, 216, 29);
		frame.getContentPane().add(nmfield);
		
		admfield = new JTextField();
		admfield.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		admfield.setColumns(10);
		admfield.setBounds(444, 141, 216, 29);
		frame.getContentPane().add(admfield);
		
		idfield = new JTextField();
		idfield.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		idfield.setColumns(10);
		idfield.setBounds(77, 141, 216, 29);
		frame.getContentPane().add(idfield);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String admissiondate=admfield.getText();
				String name =nmfield.getText();
				String father=ffield.getText();
				String email=efield.getText();
				String cnic=cfield.getText();
				String salary=sfield.getText();
				String qualification=qfield.getText();
				String address=adfield.getText();
				String gender=comboBox.getSelectedItem().toString();
				String birthday=birthfield.getText();
				
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					String URL="jdbc:mysql://localhost/School";
					Connection con=DriverManager.getConnection(URL,"root","");
					Statement st=con.createStatement();
					
					st.executeUpdate("INSERT INTO teacher(admissiondate,name,father,email,cnic,salary,qualification,address,gender,birthday) Values('"+admissiondate+"','"+name+"','"+father+"','"+email+"','"+cnic+"','"+salary+"','"+qualification+"','"+address+"','"+gender+"','"+birthday+"')");
					con.close();
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		});
		btnSave.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		btnSave.setBounds(77, 423, 89, 50);
		frame.getContentPane().add(btnSave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		btnCancel.setBounds(514, 423, 89, 50);
		frame.getContentPane().add(btnCancel);
		
		JLabel label_6 = new JLabel("Admission Date:");
		label_6.setForeground(Color.WHITE);
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setFont(new Font("Dialog", Font.BOLD, 15));
		label_6.setBounds(303, 137, 131, 36);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel("Father Name:");
		label_7.setForeground(Color.WHITE);
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setFont(new Font("Dialog", Font.BOLD, 15));
		label_7.setBounds(303, 177, 135, 36);
		frame.getContentPane().add(label_7);
		
		ffield = new JTextField();
		ffield.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		ffield.setColumns(10);
		ffield.setBounds(444, 181, 216, 29);
		frame.getContentPane().add(ffield);
		
		efield = new JTextField();
		efield.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		efield.setColumns(10);
		efield.setBounds(77, 221, 216, 29);
		frame.getContentPane().add(efield);
		
		JLabel label_8 = new JLabel("CNIC:");
		label_8.setForeground(Color.WHITE);
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setFont(new Font("Dialog", Font.BOLD, 15));
		label_8.setBounds(340, 217, 94, 36);
		frame.getContentPane().add(label_8);
		
		JLabel lblSalary = new JLabel("Salary:");
		lblSalary.setForeground(Color.WHITE);
		lblSalary.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSalary.setFont(new Font("Dialog", Font.BOLD, 15));
		lblSalary.setBounds(-5, 257, 72, 36);
		frame.getContentPane().add(lblSalary);
		
		sfield = new JTextField();
		sfield.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		sfield.setColumns(10);
		sfield.setBounds(77, 261, 216, 29);
		frame.getContentPane().add(sfield);
		
		JLabel label_10 = new JLabel("Address:");
		label_10.setForeground(Color.WHITE);
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setFont(new Font("Dialog", Font.BOLD, 15));
		label_10.setBounds(-5, 299, 72, 29);
		frame.getContentPane().add(label_10);
		
		adfield = new JTextField();
		adfield.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		adfield.setColumns(10);
		adfield.setBounds(77, 303, 354, 64);
		frame.getContentPane().add(adfield);
		
		JLabel label_11 = new JLabel("Birthday:");
		label_11.setForeground(Color.WHITE);
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		label_11.setFont(new Font("Dialog", Font.BOLD, 15));
		label_11.setBounds(434, 321, 74, 46);
		frame.getContentPane().add(label_11);
		
		birthfield = new JTextField();
		birthfield.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		birthfield.setColumns(10);
		birthfield.setBounds(514, 332, 146, 29);
		frame.getContentPane().add(birthfield);
		
		cfield = new JTextField();
		cfield.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		cfield.setColumns(10);
		cfield.setBounds(444, 219, 216, 29);
		frame.getContentPane().add(cfield);
		
		qfield = new JTextField();
		qfield.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		qfield.setColumns(10);
		qfield.setBounds(444, 259, 216, 29);
		frame.getContentPane().add(qfield);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				admfield.setText("");
				nmfield.setText("");
				ffield.setText("");
				efield.setText("");
				cfield.setText("");
				sfield.setText("");
				qfield.setText("");
				adfield.setText("");
				comboBox.setSelectedItem("Male");
				birthfield.setText("");
				
			}
		});
		btnClear.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		btnClear.setBounds(323, 423, 89, 50);
		frame.getContentPane().add(btnClear);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setIcon(new ImageIcon(AddTeacher.class.getResource("/Images/digital-technology-background_1017-7135.jpg")));
		lblNewLabel.setBounds(5, 0, 680, 486);
		frame.getContentPane().add(lblNewLabel);
	}
}
