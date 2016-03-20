import java.util.Scanner;

public class Fcfs {
	public int[] burstTime;
	public int[] waitingTime;
	public double averageWaitingTime;
	
	public Fcfs(int n)
	{
		burstTime=new int[n];
		waitingTime=new int[n];		
	}
	public void setValues()
	{
		//set the valuses for burstTime
		System.out.println("Get the input values");
	}
	public void averageWaitingTimeCalc()
	{
		//implement FCFS
		System.out.println("Calculating Average Waiting Time");
	}
	public double printWaitingTime()
	{
		//Print Waiting Time
		System.out.println("Print the Waiting Time");
	
		
		return averageWaitingTime;
	}

}
