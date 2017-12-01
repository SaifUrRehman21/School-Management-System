package School;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JProgressBar;
import javax.swing.JLabel;

public class Logo extends JFrame {
	private JFrame frame;
	JProgressBar	pb;
	
	//Constructor
	public Logo()
	{
		initialize();
		this.setSize(450,450);
		getContentPane().setLayout(null);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(130, 312, 200, 50);
		getContentPane().add(progressBar);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 200, 50);
		getContentPane().add(lblNewLabel);
	}
	
	
	public void update()
	{
		int i=0;
		while(i<101)
		{
			pb.setValue(i);
			i++;
			try
			{
				Thread.sleep(100);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		Login l=new Login();
		l.main(null);
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		Logo window = new Logo();
		window.frame.setVisible(true);
		window.update();
	}
	/**
	 * Create the application.
	 */

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 775, 398);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		pb=new JProgressBar();
		pb.setBounds(148, 281, 200, 50);
		pb.setValue(0);
		pb.setStringPainted(true);
		frame.getContentPane().add(pb);
		this.setSize(450,450);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Logo.class.getResource("/Images/Logo1.jpg")));
		lblNewLabel_1.setBounds(0, 0, 759, 359);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
