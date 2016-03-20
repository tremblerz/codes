import java.util.Scanner;


public class CpuScheduling {


	public static void main(String[] args) {
		
		System.out.println("Enter the number of Process");
		Scanner in=new Scanner(System.in);
		int numOfProcess=in.nextInt();
		System.out.println("Number of Process "+numOfProcess);
		Fcfs example1=new Fcfs(numOfProcess);
		example1.setValues();
		example1.averageWaitingTimeCalc();
		double fcfsAveWaitingTime=example1.printWaitingTime();
		//code for other algorithms goes down here
		ShortJobFirstPreemptive example2=new ShortJobFirstPreemptive();
		example2.setValues();
		example2.writingAveWaitTimeFile();
		
		// finish it
		in.close();
		
	}

}
