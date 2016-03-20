import java.lang.reflect.InvocationTargetException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
//import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;


public class sjfp extends Thread{
	private JProgressBar bar;
	private Border border;
	private float completed,averageWaitingTime;
	private int burstTime[],numOfProcess,arrivalTime[],total[],waitingTime[];
	sjfp(JFrame f,RandomInputGeneration r,JProgressBar fcfs){
		border=BorderFactory.createTitledBorder("FCFS");
		bar = fcfs;
		bar.setBounds(100, 550, 400, 50);
		bar.setBorder(border);
		bar.setStringPainted(true);
		averageWaitingTime=0;
		burstTime = new int[r.numOfProcess];
		arrivalTime = new int[r.numOfProcess];
		total = new int[r.numOfProcess];
		waitingTime = new int[r.numOfProcess];
		numOfProcess = r.numOfProcess;
		for(int i=0;i<numOfProcess;i++){
			total[i]=burstTime[i]=r.burstTime[i];
			arrivalTime[i]=r.arrivalTime[i];
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
	
        //public void averageWaitingTimeCalc()
        //{
        	int min=0,sum=0,i,time=0;
        	for(i=0;i<numOfProcess;i++){
        		sum+=burstTime[i];
        	}
        	while(sum!=0){
        		for(i=0;i<numOfProcess;i++){
        			if(arrivalTime[i]<=time&&burstTime[i]>0){
        				min=i;
        				break;
        			}
        		}
        		for(i=0;i<numOfProcess;i++){
        			if(arrivalTime[i]<=time){
        				if(burstTime[min]>burstTime[i]&&burstTime[i]>0){
        					min=i;
        				}
        			}
        		}
    	  		border = BorderFactory.createTitledBorder("SJF Preemptive is Executing Process Number " + String.valueOf(min+1));
    	      	bar.setBorder(border);
        		burstTime[min]--;
	      		completed = ((float)(total[min]-burstTime[min])/(float)total[min])*100;
        		sum--;
        		try {
	                SwingUtilities.invokeAndWait(runner);
	                Thread.sleep(100);
	            }
	      		catch (InterruptedException ignoredException) {
	            }
	      		catch (InvocationTargetException ignoredException) {
	            }
        		for(int j=0;j<numOfProcess;j++){
        			if(j!=min){
        				if(arrivalTime[j]<=time&&burstTime[j]>0)
        					waitingTime[j]++;
        			}
        		}
        		time++;
        	}

            //Print Waiting Time
            //System.out.println("Print the Waiting Time");
            int s=0;
            for(i=0;i<numOfProcess;i++)
                    s+=waitingTime[i];
            averageWaitingTime=(float) ((double)s/(double)numOfProcess);
            System.out.println("SJF Preemptive " + averageWaitingTime);
        }
  /*      public double printWaitingTime()
        {
                //Print Waiting Time
                //System.out.println("Print the Waiting Time");
                int s=0;
                for(int i=0;i<numOfProcess;i++)
                        s+=waitingTime[i];
                averageWaitingTime=(double)s/(double)numOfProcess;
                return averageWaitingTime;
        }*/
}
