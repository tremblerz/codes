import java.lang.reflect.InvocationTargetException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

public class Sjf extends Thread{
		private JProgressBar bar;
		private Border border;
		private float completed;
		private int burstTime[],numOfProcess,waitingTime;
        public Sjf(JFrame f,RandomInputGeneration1 r,JProgressBar fcfs){
        	waitingTime=0;
    		border=BorderFactory.createTitledBorder("FCFS");
    		bar = fcfs;
    		bar.setBounds(700, 400, 400, 50);
    		bar.setBorder(border);
    		bar.setStringPainted(true);
    		burstTime = new int[r.numOfProcess];
    		numOfProcess = r.numOfProcess;
    		for(int i=0;i<numOfProcess;i++){
    			burstTime[i]=r.burstTime[i];
    	//		System.out.println(burstTime[i]);
    		}
    		f.getContentPane().add(bar);
    	}
        public void run() {
  	      Runnable runner = new Runnable() {
  	        public void run() {
  	          bar.setValue((int)completed);
  	        }
  	      };
  	      int prev=0;
  	      for(int i=0;i<numOfProcess;i++){
  	    	int min = 1000000;
  	    	int index = -1;
  	    	for(int j=0;j<numOfProcess;j++)
  	    		if(min>burstTime[j]&&burstTime[j]>0){
  	    			index=j;
  	    			min=burstTime[j];
  	    		}
  	  		border = BorderFactory.createTitledBorder("SJF is Executing Process Number " + String.valueOf(index+1));
  	      	bar.setBorder(border);
  	      	if(index!=-1){
  	      	int total = burstTime[index];
  	      	waitingTime+=prev;
  	      	prev=total;
  	      	while(burstTime[index]>0){
  	    //  		System.out.println(burstTime[i] + " ==>> " + i);
  	      		completed = ((float)(total-burstTime[index])/(float)total)*100;
  	      		burstTime[index]--;
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
  	  	  }
  	     System.out.println("SJF's waiting time = " + (float)waitingTime/(float)numOfProcess);
  	    }
}