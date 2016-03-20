import java.lang.reflect.InvocationTargetException;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
//import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;


public class roundRobin extends Thread{
	private JProgressBar bar;
	private Border border;
	private float completed;
	private int burstTime[],numOfProcess,timeQuantum,total[],waitingTime[];
	private float averageWaitingTime;
	roundRobin(JFrame f,RandomInputGeneration1 r,JProgressBar fcfs){
		border=BorderFactory.createTitledBorder("FCFS");
		bar = fcfs;
		bar.setBounds(700, 550, 400, 50);
		bar.setBorder(border);
		bar.setStringPainted(true);
		burstTime = new int[r.numOfProcess];
		total = new int[r.numOfProcess];
		numOfProcess = r.numOfProcess;
		for(int i=0;i<numOfProcess;i++){
			total[i]=burstTime[i]=r.burstTime[i];
	//		System.out.println(burstTime[i]);
		}
		f.getContentPane().add(bar);
		timeQuantum=8;
		waitingTime=new int[r.numOfProcess];
	}        

	public void run() {
	      Runnable runner = new Runnable() {
	        public void run() {
	          bar.setValue((int)completed);
	        }
	      };
	      int[] q = new int[100000];
        	int min=0,front=0,rear=0,time=0,temp=0;
        	for(int i=0;i<numOfProcess;i++)
      //  		if(arrivalTime[i]<arrivalTime[min])
      //  			min=i;
        		q[rear++]=i;
      //  	q[rear++]=min;
        	while(front<=rear){
    	//		System.out.println("Debugging - " + q[front] + " " + front + " " + rear);
        		if(burstTime[q[front]]<timeQuantum)
        			temp=burstTime[q[front]];
        		else
        			temp=timeQuantum;
        		//System.out.println(temp);
        		time+=temp;
        //		if(temp==timeQuantum)
        //		for(int i=0;i<numOfProcess;i++)
        //			if(arrivalTime[i]>(time-timeQuantum)&&arrivalTime[i]<=time&&i!=q[front]){
        //				q[rear++]=i;
        //				waitingTime[q[rear-1]]=time-arrivalTime[q[i]];
        //			}
        //		burstTime[q[front]]-=timeQuantum;
        		for(int i=0;i<timeQuantum;i++){
       // 			System.out.println("Debugging - inside quantum" + q[front] + " " + front + " " + rear);
        			if(burstTime[q[front]]>0){
        				burstTime[q[front]]--;
        		  		border = BorderFactory.createTitledBorder("Round Robin is Executing Process Number " + String.valueOf(q[front]+1));
        		      	bar.setBorder(border);
        	      		completed = ((float)(total[q[front]]-burstTime[q[front]])/(float)total[q[front]])*100;

                		try {
        	                SwingUtilities.invokeAndWait(runner);
        	                Thread.sleep(100);
        	            }
        	      		catch (InterruptedException ignoredException) {
        	            }
        	      		catch (InvocationTargetException ignoredException) {
        	            }
        			}
        			else{
        				if(rear!=front){
        					front++;
        					i--;
        				}
        				else
        					break;
        			}
        		}

        		for(int i=front+1;i<rear;i++)
        				waitingTime[q[i]]+=temp;
        		if(burstTime[q[front]]>0)
        			q[rear++]=q[front];
        		front++;
        	}
  //      	for(int i=0;i<numOfProcess;i++)
  //      		System.out.println(burstTime[i]);
        	//System.out.println();
        	

            //Print Waiting Time
            //System.out.println("Print the Waiting Time");
            int s=0;
            for(int i=0;i<numOfProcess;i++)
                    s+=waitingTime[i];
            //System.out.println(s);
            averageWaitingTime=(float) ((double)s/(double)numOfProcess);
            System.out.println("RoundRobin's waiting time is " + (averageWaitingTime ));
        }
       /* public double printWaitingTime()
        {
                //Print Waiting Time
                //System.out.println("Print the Waiting Time");
                int s=0;
                for(int i=0;i<numOfProcess;i++)
                        s+=waitingTime[i];
                //System.out.println(s);
                averageWaitingTime=(double)s/(double)numOfProcess;
                return averageWaitingTime;
        }*/
}