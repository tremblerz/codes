import java.lang.reflect.InvocationTargetException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;


public class fcfs1 extends Thread{
	private JProgressBar bar;
	private Border border;
	private float completed;
	private int burstTime[],numOfProcess,waitingTime;
	fcfs1(JFrame f,RandomInputGeneration1 r,JProgressBar fcfs){
		border=BorderFactory.createTitledBorder("FCFS");
		bar = fcfs;
		bar.setBounds(100, 400, 400, 50);
		bar.setBorder(border);
		bar.setStringPainted(true);
		burstTime = new int[r.numOfProcess];
		numOfProcess = r.numOfProcess;
		for(int i=0;i<numOfProcess;i++){
			burstTime[i]=r.burstTime[i];
	//		System.out.println(burstTime[i]);
		}
		f.getContentPane().add(bar);
		waitingTime=0;
	}
	public void run() {
	      Runnable runner = new Runnable() {
	        public void run() {
	          bar.setValue((int)completed);
	        }
	      };
	      int prev=0;
	      for(int i=0;i<numOfProcess;i++){
	  		border = BorderFactory.createTitledBorder("FCFS is Executing Process Number " + String.valueOf(i+1));
	      	bar.setBorder(border);
	      	waitingTime+=prev;
	      	int total = burstTime[i];
	      	prev=total;
	      	while(burstTime[i]>0){
	    //  		System.out.println(burstTime[i] + " ==>> " + i);
	      		completed = ((float)(total-burstTime[i])/(float)total)*100;
	      		burstTime[i]--;
	      		try {
	                SwingUtilities.invokeAndWait(runner);
	                Thread.sleep(100);
	            }
	      		catch (InterruptedException ignoredException) {
	            }
	      		catch (InvocationTargetException ignoredException) {
	            }
	      	}
	      	completed=100;
	      	try {
                SwingUtilities.invokeAndWait(runner);
                Thread.sleep(200);
            }
	      	catch (InterruptedException ignoredException) {
            }
	      	catch (InvocationTargetException ignoredException) {
            }
	  	  }
	     System.out.println("FCFS's waiting Time is " + (float)waitingTime/(float)numOfProcess);
	    }
}