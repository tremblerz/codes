import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class runP {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					runP window = new runP();
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
	public runP() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblPageReplacementAlgorithm = new JLabel("Page Replacement Algorithm");
		lblPageReplacementAlgorithm.setBounds(118, 73, 220, 15);
		frame.getContentPane().add(lblPageReplacementAlgorithm);
		
		JButton btnNewButton = new JButton("FIFO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RandomInputGeneration r = new RandomInputGeneration(20);
				r.randomGeneration();
				JLabel a = new JLabel();
				a.setBounds(30,70,280,15);
				fifo f = new fifo();
				a.setText("Fault Rate = " + " " + f.fault);
			}
		});
		btnNewButton.setBounds(39, 202, 117, 25);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnOptimal = new JButton("Optimal");
		btnOptimal.setBounds(187, 202, 117, 25);
		frame.getContentPane().add(btnOptimal);
		btnOptimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RandomInputGeneration r = new RandomInputGeneration(20);
				r.randomGeneration();

				JLabel a = new JLabel();
				a.setBounds(30,70,280,15);
				fifo f = new fifo();
				a.setText("Fault Rate = " + " " + f.fault);
			}
		});
		
		JButton lru = new JButton("LRU");
		lru.setBounds(320, 202, 117, 25);
		frame.getContentPane().add(lru);
		lru.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RandomInputGeneration r = new RandomInputGeneration(20);
				r.randomGeneration();

				JLabel a = new JLabel();
				a.setBounds(30,70,280,15);
				fifo f = new fifo();
				a.setText("Fault Rate = " + " " + f.fault);
			}
		});

		JButton sc = new JButton("Second Chance");
		sc.setBounds(460, 202, 145, 25);
		frame.getContentPane().add(sc);
		sc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RandomInputGeneration r = new RandomInputGeneration(20);
				r.randomGeneration();

				JLabel a = new JLabel();
				a.setBounds(30,70,280,15);
				fifo f = new fifo();
				a.setText("Fault Rate = " + " " + f.fault);
			}
		});
	}
}
