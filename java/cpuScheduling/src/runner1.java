import java.util.Scanner;


public class runner1 {
	public int[] burstTime,arrivalTime,priority;
	public int numOfProcess,quantum;
	public void setvalues(){
		System.out.println("Enter the number of Process");
		Scanner in=new Scanner(System.in);
		numOfProcess=in.nextInt();
		burstTime=new int[numOfProcess];
		arrivalTime=new int[numOfProcess];
		priority=new int[numOfProcess];
		System.out.println("Enter the arrival time of "+numOfProcess+" processes");
		for(int i=0;i<numOfProcess;i++)
			arrivalTime[i]=in.nextInt();
		System.out.println("Enter the burst time of "+numOfProcess+" processes");
		for(int i=0;i<numOfProcess;i++)
			burstTime[i]=in.nextInt();
		System.out.println("Enter the priority of "+numOfProcess+" processes");
		for(int i=0;i<numOfProcess;i++)
			priority[i]=in.nextInt();
		System.out.println("Enter the value of Time Quantum");
			quantum=in.nextInt();
		//System.out.println(burstTime[i]);
		//System.out.println(arrivalTime[i]);
		in.close();
	}
}