package School;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;

public class TeacherDetail {

	private JFrame frame;
	private JTextField namef;
	private JTextField adatef;
	private JTextField idf;
	private JTextField fnamef;
	private JTextField emailf;
	private JTextField salaryf;
	private JTextField addressf;
	private JTextField birthdayf;
	private JTextField cnicf;
	private JTextField qualificationf;
	private JLabel lblSearchTeacher;
	private JLabel label_1;
	private JLabel label_2;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel label_5;
	private JLabel label_6;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel label_9;
	private JLabel label_10;
	private JLabel label_11;

	ResultSet rs=null;
	private JLabel label;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherDetail window = new TeacherDetail();
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
	public TeacherDetail() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 692, 480);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		namef = new JTextField();
		namef.setEditable(false);
		namef.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		namef.setColumns(10);
		namef.setBounds(83, 139, 216, 29);
		frame.getContentPane().add(namef);
		
		adatef = new JTextField();
		adatef.setEditable(false);
		adatef.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		adatef.setColumns(10);
		adatef.setBounds(450, 99, 216, 29);
		frame.getContentPane().add(adatef);
		
		idf = new JTextField();
		idf.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		idf.setColumns(10);
		idf.setBounds(83, 99, 146, 29);
		frame.getContentPane().add(idf);
		
		fnamef = new JTextField();
		fnamef.setEditable(false);
		fnamef.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		fnamef.setColumns(10);
		fnamef.setBounds(450, 139, 216, 29);
		frame.getContentPane().add(fnamef);
		
		emailf = new JTextField();
		emailf.setEditable(false);
		emailf.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		emailf.setColumns(10);
		emailf.setBounds(83, 179, 216, 29);
		frame.getContentPane().add(emailf);
		
		salaryf = new JTextField();
		salaryf.setEditable(false);
		salaryf.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		salaryf.setColumns(10);
		salaryf.setBounds(83, 219, 216, 29);
		frame.getContentPane().add(salaryf);
		
		addressf = new JTextField();
		addressf.setEditable(false);
		addressf.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		addressf.setColumns(10);
		addressf.setBounds(83, 261, 354, 64);
		frame.getContentPane().add(addressf);
		
		birthdayf = new JTextField();
		birthdayf.setEditable(false);
		birthdayf.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		birthdayf.setColumns(10);
		birthdayf.setBounds(520, 290, 146, 29);
		frame.getContentPane().add(birthdayf);
		
		cnicf = new JTextField();
		cnicf.setEditable(false);
		cnicf.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		cnicf.setColumns(10);
		cnicf.setBounds(450, 177, 216, 29);
		frame.getContentPane().add(cnicf);
		
		qualificationf = new JTextField();
		qualificationf.setEditable(false);
		qualificationf.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		qualificationf.setColumns(10);
		qualificationf.setBounds(450, 217, 216, 29);
		frame.getContentPane().add(qualificationf);
		
		lblSearchTeacher = new JLabel("Search Teacher");
		lblSearchTeacher.setForeground(Color.WHITE);
		lblSearchTeacher.setFont(new Font("Sitka Display", Font.PLAIN, 36));
		lblSearchTeacher.setBounds(277, -13, 224, 96);
		frame.getContentPane().add(lblSearchTeacher);
		
		label_1 = new JLabel("ID:");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Dialog", Font.BOLD, 15));
		label_1.setBounds(0, 99, 82, 36);
		frame.getContentPane().add(label_1);
		
		label_2 = new JLabel("Name:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Dialog", Font.BOLD, 15));
		label_2.setBounds(10, 135, 72, 36);
		frame.getContentPane().add(label_2);
		
		label_3 = new JLabel("Email:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Dialog", Font.BOLD, 15));
		label_3.setBounds(38, 175, 44, 36);
		frame.getContentPane().add(label_3);
		
		label_4 = new JLabel("Qualification:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Dialog", Font.BOLD, 15));
		label_4.setBounds(332, 215, 117, 36);
		frame.getContentPane().add(label_4);
		
		label_5 = new JLabel("Gender:");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Dialog", Font.BOLD, 15));
		label_5.setBounds(459, 257, 62, 29);
		frame.getContentPane().add(label_5);
		
		label_6 = new JLabel("Admission Date:");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Dialog", Font.BOLD, 15));
		label_6.setBounds(318, 95, 131, 36);
		frame.getContentPane().add(label_6);
		
		label_7 = new JLabel("Father Name:");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Dialog", Font.BOLD, 15));
		label_7.setBounds(318, 135, 131, 36);
		frame.getContentPane().add(label_7);
		
		label_8 = new JLabel("CNIC:");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("Dialog", Font.BOLD, 15));
		label_8.setBounds(355, 175, 94, 36);
		frame.getContentPane().add(label_8);
		
		label_9 = new JLabel("Salary:");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("Dialog", Font.BOLD, 15));
		label_9.setBounds(10, 215, 72, 36);
		frame.getContentPane().add(label_9);
		
		label_10 = new JLabel("Address:");
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("Dialog", Font.BOLD, 15));
		label_10.setBounds(10, 257, 72, 29);
		frame.getContentPane().add(label_10);
		
		label_11 = new JLabel("Birthday:");
		label_11.setHorizontalAlignment(SwingConstants.RIGHT);
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("Dialog", Font.BOLD, 15));
		label_11.setBounds(449, 279, 74, 46);
		frame.getContentPane().add(label_11);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setBounds(522, 259, 144, 20);
		frame.getContentPane().add(comboBox);
		
		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					int id=Integer.parseInt(idf.getText());
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						String URL="jdbc:mysql://localhost/School";
						Connection con=DriverManager.getConnection(URL,"root","");
						Statement st=con.createStatement();
						ResultSet ps=null;
						rs=st.executeQuery("SELECT * FROM teacher Where id="+id+"");
					    if(rs!=null)
					    {
					    	while(rs.next())
					    	{
						        adatef.setText(rs.getString("admissiondate"));
								namef.setText(rs.getString("name"));
								fnamef.setText(rs.getString("father"));
								emailf.setText(rs.getString("email"));
								cnicf.setText(rs.getString("cnic"));
								salaryf.setText(rs.getString("salary"));
								qualificationf.setText(rs.getString("qualification"));
								addressf.setText(rs.getString("address"));
								comboBox.addItem(rs.getString("gender"));
								birthdayf.setText(rs.getString("birthday"));
								
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
		button.setBounds(229, 99, 82, 29);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Cancel");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Desktop.main(null);
			}
		});
		button_1.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		button_1.setBounds(530, 370, 89, 50);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("Clear");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				idf.setText("");
				adatef.setText("");
				namef.setText("");
				fnamef.setText("");
				emailf.setText("");
				cnicf.setText("");
				salaryf.setText("");
				qualificationf.setText("");
				addressf.setText("");
				birthdayf.setText("");
			}
		});
		button_2.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		button_2.setBounds(300, 370, 89, 50);
		frame.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("Save");
		button_3.setFont(new Font("Sitka Display", Font.PLAIN, 17));
		button_3.setBounds(93, 370, 89, 50);
		frame.getContentPane().add(button_3);
		
		label = new JLabel(" ");
		label.setForeground(Color.WHITE);
		label.setIcon(new ImageIcon(TeacherDetail.class.getResource("/Images/SearchTeacher1.jpg")));
		label.setBounds(0, 0, 676, 441);
		frame.getContentPane().add(label);
	}
}
