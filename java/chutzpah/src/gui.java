import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.*;
import javax.swing.JTable;

public class gui {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
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
	public gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Yo");
		frame.setBackground(new Color(12, 204,153));
		
		table = new JTable();
		frame.getContentPane().add(table, BorderLayout.NORTH);
		//Container c = frame.getContentPane();
		//c.add(c1,"Test1");
		//c.add(c2,"Test2");
	}

}
