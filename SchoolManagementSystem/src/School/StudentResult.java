package School;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Canvas;
import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JDesktopPane;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;

public class StudentResult {

	private JFrame frame;
	private JTextField rollf;
	private JTextField namef;
	private JTextField adatef;
	private JTextField fnamef;
	private JTextField o2;
	private JTextField o3;
	private JTextField o4;
	private JTextField o6;
	private JTextField o7;
	private JTextField o1;
	private JTextField p1;
	private JTextField p2;
	private JTextField p3;
	private JTextField p4;
	private JTextField p6;
	private JTextField p7;
	private JTextField ototal;
	private JTextField ptotal;
	private JTextField textField_20;

	ResultSet rs=null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentResult window = new StudentResult();
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
	public StudentResult() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 704, 620);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JDesktopPane desktopPane_5 = new JDesktopPane();
		desktopPane_5.setBounds(0, 0, -659, -43);
		frame.getContentPane().add(desktopPane_5);
		desktopPane_5.setBorder(new MatteBorder(1, 0, 0, 0, (Color) new Color(0, 0, 0)));
		
		JLabel lblStudentResult = new JLabel("Student Result");
		lblStudentResult.setForeground(Color.BLACK);
		lblStudentResult.setFont(new Font("Sitka Display", Font.PLAIN, 36));
		lblStudentResult.setBounds(262, -17, 224, 96);
		frame.getContentPane().add(lblStudentResult);
		
		JLabel lblRollNo = new JLabel("Roll No:");
		lblRollNo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRollNo.setForeground(Color.BLACK);
		lblRollNo.setFont(new Font("Sitka Display", Font.BOLD, 18));
		lblRollNo.setBounds(6, 96, 82, 36);
		frame.getContentPane().add(lblRollNo);
		
		JLabel label_2 = new JLabel("Name:");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("Sitka Display", Font.BOLD, 18));
		label_2.setBounds(16, 132, 82, 36);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Admission Date:");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Sitka Display", Font.BOLD, 18));
		label_3.setBounds(339, 92, 131, 36);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Father Name:");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Sitka Display", Font.BOLD, 18));
		label_4.setBounds(339, 132, 135, 36);
		frame.getContentPane().add(label_4);
		
		rollf = new JTextField();
		rollf.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		rollf.setColumns(10);
		rollf.setBounds(113, 96, 135, 29);
		frame.getContentPane().add(rollf);
		
		namef = new JTextField();
		namef.setEditable(false);
		namef.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		namef.setColumns(10);
		namef.setBounds(113, 136, 216, 29);
		frame.getContentPane().add(namef);
		
		adatef = new JTextField();
		adatef.setEditable(false);
		adatef.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		adatef.setColumns(10);
		adatef.setBounds(495, 96, 172, 29);
		frame.getContentPane().add(adatef);
		
		fnamef = new JTextField();
		fnamef.setEditable(false);
		fnamef.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		fnamef.setColumns(10);
		fnamef.setBounds(495, 136, 172, 29);
		frame.getContentPane().add(fnamef);
		
		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					String rollno=rollf.getText();
					
					try
					{
						Class.forName("com.mysql.jdbc.Driver");
						String URL="jdbc:mysql://localhost/result";
						Connection con=DriverManager.getConnection(URL,"root","");
						Statement st=con.createStatement();
						ResultSet ps=null;
						rs=st.executeQuery("SELECT admissiondate,NAME,father,English,Urdu,Math,Islamiat,Physics,Chemistry,Obtain,Percentage  FROM student,result Where result.RollNo="+rollno+" AND student.rollno=result.RollNo");
					    if(rs!=null)
					    {
					    	while(rs.next())
					    	{
					    		adatef.setText(rs.getString("admissiondate"));
					    		namef.setText(rs.getString("name"));
					    		fnamef.setText(rs.getString("father"));
						        o2.setText(rs.getString("English"));
						        o3.setText(rs.getString("Urdu"));
								o1.setText(rs.getString("Maths"));
								o4.setText(rs.getString("Islamiat"));
								o7.setText(rs.getString("Physics"));
								o6.setText(rs.getString("Chemistry"));
								ototal.setText(rs.getString("Obtain"));
								ptotal.setText(rs.getString("Percentage"));
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
		button.setBounds(247, 96, 82, 29);
		frame.getContentPane().add(button);
		
		JLabel lblMaths = new JLabel("Maths:");
		lblMaths.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaths.setForeground(Color.BLACK);
		lblMaths.setFont(new Font("Sitka Display", Font.BOLD, 18));
		lblMaths.setBounds(21, 228, 82, 36);
		frame.getContentPane().add(lblMaths);
		
		JLabel lblSubject = new JLabel("Subject");
		lblSubject.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSubject.setForeground(Color.BLACK);
		lblSubject.setFont(new Font("Sitka Display", Font.BOLD, 18));
		lblSubject.setBounds(21, 193, 82, 36);
		frame.getContentPane().add(lblSubject);
		
		JLabel lblEnglish = new JLabel("English:");
		lblEnglish.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnglish.setForeground(Color.BLACK);
		lblEnglish.setFont(new Font("Sitka Display", Font.BOLD, 18));
		lblEnglish.setBounds(21, 265, 82, 36);
		frame.getContentPane().add(lblEnglish);
		
		JLabel lblUrdu = new JLabel("Urdu:");
		lblUrdu.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUrdu.setForeground(Color.BLACK);
		lblUrdu.setFont(new Font("Sitka Display", Font.BOLD, 18));
		lblUrdu.setBounds(21, 302, 82, 36);
		frame.getContentPane().add(lblUrdu);
		
		JLabel lblIslamiat = new JLabel("Islamiat:");
		lblIslamiat.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIslamiat.setForeground(Color.BLACK);
		lblIslamiat.setFont(new Font("Sitka Display", Font.BOLD, 18));
		lblIslamiat.setBounds(21, 338, 82, 36);
		frame.getContentPane().add(lblIslamiat);
		
		JLabel lblObtain = new JLabel("Obtain:");
		lblObtain.setHorizontalAlignment(SwingConstants.RIGHT);
		lblObtain.setForeground(Color.BLACK);
		lblObtain.setFont(new Font("Sitka Display", Font.BOLD, 18));
		lblObtain.setBounds(269, 193, 82, 36);
		frame.getContentPane().add(lblObtain);
		
		JLabel lblTotalMarks = new JLabel("Total Marks");
		lblTotalMarks.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalMarks.setForeground(Color.BLACK);
		lblTotalMarks.setFont(new Font("Sitka Display", Font.BOLD, 18));
		lblTotalMarks.setBounds(149, 193, 93, 36);
		frame.getContentPane().add(lblTotalMarks);
		
		JLabel label_7 = new JLabel("100");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setForeground(Color.BLACK);
		label_7.setFont(new Font("Sitka Display", Font.BOLD, 18));
		label_7.setBounds(149, 228, 76, 36);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("100");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setForeground(Color.BLACK);
		label_8.setFont(new Font("Sitka Display", Font.BOLD, 18));
		label_8.setBounds(149, 265, 76, 36);
		frame.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel("100");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setForeground(Color.BLACK);
		label_9.setFont(new Font("Sitka Display", Font.BOLD, 18));
		label_9.setBounds(149, 302, 76, 36);
		frame.getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("100");
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setForeground(Color.BLACK);
		label_10.setFont(new Font("Sitka Display", Font.BOLD, 18));
		label_10.setBounds(149, 338, 76, 36);
		frame.getContentPane().add(label_10);
		
		JLabel lblPercentage_1 = new JLabel("Percentage");
		lblPercentage_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPercentage_1.setForeground(Color.BLACK);
		lblPercentage_1.setFont(new Font("Sitka Display", Font.BOLD, 18));
		lblPercentage_1.setBounds(401, 193, 104, 36);
		frame.getContentPane().add(lblPercentage_1);
		
		JLabel lblGrade = new JLabel("Grade");
		lblGrade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGrade.setForeground(Color.BLACK);
		lblGrade.setFont(new Font("Sitka Display", Font.BOLD, 18));
		lblGrade.setBounds(558, 193, 66, 36);
		frame.getContentPane().add(lblGrade);
		
		o2 = new JTextField();
		o2.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent arg0) {
				p2.setText(Float.parseFloat(o2.getText())+"");
			}
		});
		o2.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		o2.setColumns(10);
		o2.setBounds(289, 272, 94, 29);
		frame.getContentPane().add(o2);
		
		o3 = new JTextField();
		o3.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent arg0) {
				p3.setText(Float.parseFloat(o3.getText())+"");
			}
		});
		o3.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		o3.setColumns(10);
		o3.setBounds(289, 309, 94, 29);
		frame.getContentPane().add(o3);
		
		o4 = new JTextField();
		o4.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent arg0) {
				p4.setText(Float.parseFloat(o4.getText())+"");
			}
		});
		o4.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		o4.setColumns(10);
		o4.setBounds(289, 345, 94, 29);
		frame.getContentPane().add(o4);
		
		o1 = new JTextField();
		o1.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent arg0) {
				p1.setText(Float.parseFloat(o1.getText())+"");
			}
		});
		o1.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		o1.setColumns(10);
		o1.setBounds(289, 235, 94, 29);
		frame.getContentPane().add(o1);
		
		p1 = new JTextField();
		p1.setEditable(false);
		p1.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		p1.setColumns(10);
		p1.setBounds(422, 235, 94, 29);
		frame.getContentPane().add(p1);
		
		p2 = new JTextField();
		p2.setEditable(false);
		p2.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		p2.setColumns(10);
		p2.setBounds(422, 272, 94, 29);
		frame.getContentPane().add(p2);
		
		p3 = new JTextField();
		p3.setEditable(false);
		p3.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		p3.setColumns(10);
		p3.setBounds(422, 309, 94, 29);
		frame.getContentPane().add(p3);
		
		p4 = new JTextField();
		p4.setEditable(false);
		p4.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		p4.setColumns(10);
		p4.setBounds(422, 345, 94, 29);
		frame.getContentPane().add(p4);
		
		JLabel g1 = new JLabel("A");
		g1.setHorizontalAlignment(SwingConstants.RIGHT);
		g1.setForeground(Color.BLACK);
		g1.setFont(new Font("Sitka Display", Font.BOLD, 18));
		g1.setBounds(537, 228, 76, 36);
		frame.getContentPane().add(g1);
		
		JLabel g2 = new JLabel("A");
		g2.setHorizontalAlignment(SwingConstants.RIGHT);
		g2.setForeground(Color.BLACK);
		g2.setFont(new Font("Sitka Display", Font.BOLD, 18));
		g2.setBounds(537, 265, 76, 36);
		frame.getContentPane().add(g2);
		
		JLabel g3 = new JLabel("A");
		g3.setHorizontalAlignment(SwingConstants.RIGHT);
		g3.setForeground(Color.BLACK);
		g3.setFont(new Font("Sitka Display", Font.BOLD, 18));
		g3.setBounds(537, 302, 76, 36);
		frame.getContentPane().add(g3);
		
		JLabel g4 = new JLabel("A");
		g4.setHorizontalAlignment(SwingConstants.RIGHT);
		g4.setForeground(Color.BLACK);
		g4.setFont(new Font("Sitka Display", Font.BOLD, 18));
		g4.setBounds(537, 338, 76, 36);
		frame.getContentPane().add(g4);
		
		JDesktopPane desktopPane_1 = new JDesktopPane();
		desktopPane_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		desktopPane_1.setBounds(10, 193, 129, 312);
		frame.getContentPane().add(desktopPane_1);
		
		JLabel lblChemistry = new JLabel("Chemistry:");
		lblChemistry.setBounds(0, 181, 93, 36);
		desktopPane_1.add(lblChemistry);
		lblChemistry.setHorizontalAlignment(SwingConstants.RIGHT);
		lblChemistry.setForeground(Color.BLACK);
		lblChemistry.setFont(new Font("Sitka Display", Font.BOLD, 18));
		
		JLabel lblPhysics = new JLabel("Physics:");
		lblPhysics.setBounds(11, 217, 82, 36);
		desktopPane_1.add(lblPhysics);
		lblPhysics.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhysics.setForeground(Color.BLACK);
		lblPhysics.setFont(new Font("Sitka Display", Font.BOLD, 18));
		
		JLabel lblPercentage = new JLabel("Total:");
		lblPercentage.setBounds(0, 253, 93, 36);
		desktopPane_1.add(lblPercentage);
		lblPercentage.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPercentage.setForeground(Color.BLACK);
		lblPercentage.setFont(new Font("Sitka Display", Font.BOLD, 18));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		desktopPane.setBounds(138, 193, 129, 312);
		frame.getContentPane().add(desktopPane);
		
		JLabel label_13 = new JLabel("100");
		label_13.setBounds(20, 181, 66, 36);
		desktopPane.add(label_13);
		label_13.setHorizontalAlignment(SwingConstants.RIGHT);
		label_13.setForeground(Color.BLACK);
		label_13.setFont(new Font("Sitka Display", Font.BOLD, 18));
		
		JLabel label_14 = new JLabel("100");
		label_14.setBounds(10, 217, 76, 36);
		desktopPane.add(label_14);
		label_14.setHorizontalAlignment(SwingConstants.RIGHT);
		label_14.setForeground(Color.BLACK);
		label_14.setFont(new Font("Sitka Display", Font.BOLD, 18));
		
		JLabel label_1 = new JLabel("600");
		label_1.setBounds(10, 253, 76, 36);
		desktopPane.add(label_1);
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Sitka Display", Font.BOLD, 18));
		
		JDesktopPane desktopPane_2 = new JDesktopPane();
		desktopPane_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		desktopPane_2.setBounds(262, 193, 135, 312);
		frame.getContentPane().add(desktopPane_2);
		
		o6 = new JTextField();
		o6.setBounds(31, 187, 94, 29);
		desktopPane_2.add(o6);
		o6.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent arg0) {
				p6.setText(Float.parseFloat(o6.getText())+"");
				
			}
			
		});
		o6.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		o6.setColumns(10);
		
		o7 = new JTextField();
		o7.setBounds(31, 223, 94, 29);
		desktopPane_2.add(o7);
		o7.addFocusListener(new FocusAdapter() {
			public void focusLost(FocusEvent arg0) {
				p7.setText(o7.getText()+".00");
				float f=Float.parseFloat(o1.getText())+Float.parseFloat(o2.getText())+Float.parseFloat(o3.getText())+Float.parseFloat(o4.getText())+Float.parseFloat(o6.getText())+Float.parseFloat(o7.getText());
				ototal.setText(f+"");
				ptotal.setText((f/600)+"");
			}
		});
		o7.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		o7.setColumns(10);
		
		ototal = new JTextField();
		ototal.setEditable(false);
		ototal.setBounds(31, 259, 94, 29);
		desktopPane_2.add(ototal);
		ototal.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		ototal.setColumns(10);
		
		JDesktopPane desktopPane_3 = new JDesktopPane();
		desktopPane_3.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 0, 0)));
		desktopPane_3.setBounds(393, 193, 143, 312);
		frame.getContentPane().add(desktopPane_3);
		
		p6 = new JTextField();
		p6.setEditable(false);
		p6.setBounds(28, 189, 94, 29);
		desktopPane_3.add(p6);
		p6.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		p6.setColumns(10);
		
		p7 = new JTextField();
		p7.setEditable(false);
		p7.setBounds(28, 225, 94, 29);
		desktopPane_3.add(p7);
		p7.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		p7.setColumns(10);
		
		ptotal = new JTextField();
		ptotal.setEditable(false);
		ptotal.setBounds(28, 261, 94, 29);
		desktopPane_3.add(ptotal);
		ptotal.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		ptotal.setColumns(10);
		
		JDesktopPane desktopPane_4 = new JDesktopPane();
		desktopPane_4.setBorder(new MatteBorder(1, 0, 1, 1, (Color) new Color(0, 0, 0)));
		desktopPane_4.setBounds(536, 193, 135, 312);
		frame.getContentPane().add(desktopPane_4);
		
		JLabel g6 = new JLabel("A");
		g6.setBounds(0, 185, 76, 36);
		desktopPane_4.add(g6);
		g6.setHorizontalAlignment(SwingConstants.RIGHT);
		g6.setForeground(Color.BLACK);
		g6.setFont(new Font("Sitka Display", Font.BOLD, 18));
		
		JLabel g7 = new JLabel("A");
		g7.setBounds(0, 221, 76, 36);
		desktopPane_4.add(g7);
		g7.setHorizontalAlignment(SwingConstants.RIGHT);
		g7.setForeground(Color.BLACK);
		g7.setFont(new Font("Sitka Display", Font.BOLD, 18));
		
		textField_20 = new JTextField();
		textField_20.setBounds(38, 264, 66, 29);
		desktopPane_4.add(textField_20);
		textField_20.setFont(new Font("Sitka Display", Font.PLAIN, 15));
		textField_20.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String rollno=rollf.getText();
				float english=Float.parseFloat(o2.getText());
				float urdu=Float.parseFloat(o3.getText());
				float math=Float.parseFloat(o1.getText());
				float islamiat=Float.parseFloat(o4.getText());
				float physics=Float.parseFloat(o7.getText());
				float chemistry=Float.parseFloat(o6.getText());
				float obtain=Float.parseFloat(ototal.getText());
				float Percentage=Float.parseFloat(ptotal.getText());
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
					String URL="jdbc:mysql://localhost/result";
					Connection con=DriverManager.getConnection(URL,"root","");
					Statement st=con.createStatement();
					
					st.executeUpdate("INSERT INTO result(RollNo,English,Urdu,Math,Islamiat,Physics,Cemistry,Obtain,Percentage) Values('"+rollno+"','"+english+"','"+urdu+"','"+math+"','"+islamiat+"','"+physics+"','"+chemistry+"','"+obtain+"','"+Percentage+"')");
					con.close();
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
			}
		});
		btnSave.setBounds(21, 516, 123, 41);
		frame.getContentPane().add(btnSave);
		
		JLabel label_12 = new JLabel("");
		label_12.setIcon(new ImageIcon(StudentResult.class.getResource("/Images/StudentResult.jpg")));
		label_12.setForeground(Color.BLACK);
		label_12.setBounds(0, 0, 698, 581);
		frame.getContentPane().add(label_12);
	}
}
