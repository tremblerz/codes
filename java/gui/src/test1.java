import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.border.Border;

public class test1 {
  public static void main(String args[]) {
    JFrame f = new JFrame("JProgressBar Sample");
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container content = f.getContentPane();
    JProgressBar progressBar = new JProgressBar();
    //progressBar.setValue(25);
    progressBar.setStringPainted(true);
    Border border;
    //progressBar.setBorder(border);
    content.add(progressBar, BorderLayout.NORTH);
    f.setSize(300, 100);
    f.setVisible(true);
    int n=10;
    RandomInputGeneration r = new RandomInputGeneration(n);
	r.randomGeneration();
	System.out.println("Working Fine 3");
	for(int i=0;i<n;i++){
		border = BorderFactory.createTitledBorder("Executing Process Number " + String.valueOf(i+1));
    	progressBar.setBorder(border);
		System.out.println("Working Fine 4");
    	int total = r.burstTime[i],completed;
    	while(r.burstTime[i]>0){
    		System.out.println(String.valueOf(r.burstTime[i]));
    		completed = ((total-r.burstTime[i])/total)*100;
    		int x=1000000;
    		for(int k=0;k<1000000;k++)
    			for(int j=0;j<1000000;j++)
    				//for(int l=0;l<10;l++)
    	    			progressBar.setValue(completed);
    		//try {
    		//    Thread.sleep(100);                 //1000 milliseconds is one second.
    		//} catch(InterruptedException ex) {
    		//    Thread.currentThread().interrupt();
    		//}
    		r.burstTime[i]--;
    	}
	}
}
  }