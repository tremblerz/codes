import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.BoxLayout;
import javax.swing.JProgressBar;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.border.Border;

import com.sun.java.swing.plaf.motif.MotifBorders.ToggleButtonBorder;
import javax.swing.AbstractAction;
import javax.swing.Action;


public class myGUI implements ActionListener {

	private JFrame frame;
	private JTextField textField;
	private JLabel result,lblWelcomeToOs,numberOf;
	private JProgressBar progressBarFcfs,progressBarSjf,progressBarSjfP,progressBarRoundRobin;
	private JToggleButton tglbtnNewToggleButton;
	private boolean isRunning;
	private int noOfProcess;
	private Border border;
	Thread f;
	private final Action action = new SwingAction();
	static class fcfs extends Thread{
		private JProgressBar bar;
		private JToggleButton btn;
		private RandomInputGeneration r;
		private Border border;
		private float completed;
		fcfs(RandomInputGeneration r,JProgressBar b,Border border,JToggleButton btn){
			this.r=r;
			this.bar=b;
			this.border=border;
			this.btn=btn;
			this.bar.setStringPainted(true);
		}
		public void run() {
		      Runnable runner = new Runnable() {
		        public void run() {
		          bar.setValue((int)completed);
		        }
		      };
		      r.randomGeneration();
		      for(int i=0;i<r.numOfProcess;i++){
		  		border = BorderFactory.createTitledBorder("Executing Process Number " + String.valueOf(i+1));
		      	bar.setBorder(border);
		      	int total = r.burstTime[i];
		      	while(r.burstTime[i]>0){
		      		completed = ((float)(total-r.burstTime[i])/(float)total)*100;
		      		r.burstTime[i]--;
		      		try {
		                SwingUtilities.invokeAndWait(runner);
		                Thread.sleep(30);
		            } catch (InterruptedException ignoredException) {
		              } catch (InvocationTargetException ignoredException) {
		              	}
		      	}
		      	completed=100;
		      	try {
	                SwingUtilities.invokeAndWait(runner);
	                Thread.sleep(1000);
	            } catch (InterruptedException ignoredException) {
	              } catch (InvocationTargetException ignoredException) {
	              	}
		  	  }
		      bar.setBorder(BorderFactory.createTitledBorder("FCFS"));
		      bar.setValue(0);
		      btn.doClick();
			  bar.setStringPainted(false);
		    }
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try{
					myGUI window = new myGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public myGUI() {
		initialize();
		isRunning=false;
	}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(30, 30, 600, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		//frame.setBackground(Color.CYAN);
		
		lblWelcomeToOs = new JLabel("Welcome To OS Simulator ");
		lblWelcomeToOs.setFont(new Font("Arial", Font.ITALIC, 24));
		lblWelcomeToOs.setForeground(Color.ORANGE);
		lblWelcomeToOs.setBackground(Color.CYAN);
		lblWelcomeToOs.setBounds(150, 12, 303, 55);
		frame.getContentPane().add(lblWelcomeToOs);
		
		textField = new JTextField();
		textField.setBounds(243, 122, 114, 19);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		numberOf = new JLabel("Enter Number of processes");
		numberOf.setBounds(12, 122, 197, 15);
		frame.getContentPane().add(numberOf);
		
		result = new JLabel("");
		result.setBounds(12,122,300,15);
		frame.getContentPane().add(result);
		result.setVisible(false);
		
		tglbtnNewToggleButton = new JToggleButton("Start");
		tglbtnNewToggleButton.setBounds(64, 209, 167, 25);
		frame.getContentPane().add(tglbtnNewToggleButton);
		

		progressBarFcfs = new JProgressBar();
		progressBarFcfs.setBounds(64, 298, 410, 55);
		frame.getContentPane().add(progressBarFcfs);
		Border border = BorderFactory.createTitledBorder("FCFS");
	    progressBarFcfs.setBorder(border);
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setBounds(64, 560, 410, 55);
		frame.getContentPane().add(progressBar_1);
		
		JProgressBar progressBar_2 = new JProgressBar();
		progressBar_2.setBounds(64, 470, 410, 55);
		frame.getContentPane().add(progressBar_2);
		
		JProgressBar progressBar_3 = new JProgressBar();
		progressBar_3.setBounds(64, 380, 410, 55);
		frame.getContentPane().add(progressBar_3);
		tglbtnNewToggleButton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		if(isRunning){
			isRunning=false;
			textField.setVisible(true);
			numberOf.setVisible(true);
			result.setVisible(false);
			tglbtnNewToggleButton.setText("Start");
			f.stop();
			progressBarFcfs.setBorder(BorderFactory.createTitledBorder("FCFS"));
			progressBarFcfs.setValue(0);
			progressBarFcfs.setStringPainted(false);

		}
		else{
			String input = textField.getText();
			boolean flag=false;
			try{
		        noOfProcess=Integer.parseInt(input);
		        
		    }catch(NumberFormatException e1){
				flag=true;
		    }
			if((noOfProcess>0&&noOfProcess<1000)||flag){
				isRunning=true;
				textField.setVisible(false);
				numberOf.setVisible(false);
				result.setVisible(true);
				result.setText("Number of process entered = " + String.valueOf(noOfProcess));
				tglbtnNewToggleButton.setText("Stop");
				RandomInputGeneration r = new RandomInputGeneration(noOfProcess);
				r.randomGeneration();
				f = new fcfs(r,progressBarFcfs,border,tglbtnNewToggleButton);
				f.start();
			}
			else{
				JOptionPane.showMessageDialog(frame, "Please Enter valid number of process (0-1000)");
				textField.setText("");
				tglbtnNewToggleButton.setText("");
				tglbtnNewToggleButton.setSelected(false);
				tglbtnNewToggleButton.setText("Start");
				//tglbtnNewToggleButton.doClick();
			}
		}
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}