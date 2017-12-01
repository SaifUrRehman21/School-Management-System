package School;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Desktop {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Desktop window = new Desktop();
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
	public Desktop() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 498);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAddStudent = new JButton("");
		btnAddStudent.setToolTipText("Add Student");
		btnAddStudent.setIcon(new ImageIcon(Desktop.class.getResource("/Images/AddStudenticon.jpg")));
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddStudent.main(null);
			}
		});
		btnAddStudent.setBounds(141, 110, 171, 105);
		frame.getContentPane().add(btnAddStudent);
		
		JButton btnAddTeacher = new JButton("");
		btnAddTeacher.setToolTipText("Add Teacher");
		btnAddTeacher.setIcon(new ImageIcon(Desktop.class.getResource("/Images/AddTeachericon.jpg")));
		btnAddTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddTeacher.main(null);
			}
		});
		btnAddTeacher.setBounds(141, 231, 170, 105);
		frame.getContentPane().add(btnAddTeacher);
		
		JButton btnSearchStudent = new JButton("");
		btnSearchStudent.setToolTipText("Serach Student");
		btnSearchStudent.setIcon(new ImageIcon(Desktop.class.getResource("/Images/StudentDetailicon.jpg")));
		btnSearchStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentDetail.main(null);
			}
		});
		btnSearchStudent.setBounds(343, 110, 170, 105);
		frame.getContentPane().add(btnSearchStudent);
		
		JButton btnSearchTeacher = new JButton("");
		btnSearchTeacher.setToolTipText("Search Teacher");
		btnSearchTeacher.setIcon(new ImageIcon(Desktop.class.getResource("/Images/Teachericon.jpg")));
		btnSearchTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TeacherDetail.main(null);
			}
		});
		btnSearchTeacher.setBounds(343, 231, 171, 105);
		frame.getContentPane().add(btnSearchTeacher);
		
		JButton btnFeeStatus = new JButton("");
		btnFeeStatus.setToolTipText("Fee");
		btnFeeStatus.setIcon(new ImageIcon(Desktop.class.getResource("/Images/Feeicon.jpg")));
		btnFeeStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentFee.main(null);
			}
		});
		btnFeeStatus.setBounds(537, 110, 170, 105);
		frame.getContentPane().add(btnFeeStatus);
		
		JButton btnStudentResult = new JButton("");
		btnStudentResult.setToolTipText("Result");
		btnStudentResult.setIcon(new ImageIcon(Desktop.class.getResource("/Images/Result.jpg")));
		btnStudentResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentResult.main(null);
			}
		});
		btnStudentResult.setBounds(536, 231, 171, 105);
		frame.getContentPane().add(btnStudentResult);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Desktop.class.getResource("/Images/Desktop.jpg")));
		lblNewLabel.setBounds(0, 0, 884, 459);
		frame.getContentPane().add(lblNewLabel);
	}
}
