import java.util.Scanner;


public class CpuScheduling {


	public static void main(String[] args) {
		
		System.out.println("Enter the number of Process");
		Scanner in=new Scanner(System.in);
		int numOfProcess=in.nextInt();
		System.out.println("Number of Process "+numOfProcess);
		
		Fcfs fcfsInstance1=new Fcfs(numOfProcess);
		fcfsInstance1.setValues();
		fcfsInstance1.averageWaitingTimeCalc();
		double fcfsAveWaitingTime=fcfsInstance1.printWaitingTime();
		
		RandomInputGeneration ranInGen1= new RandomInputGeneration();
		RandomInputGeneration ranInGen2= new RandomInputGeneration(numOfProcess);
		RandomInputGeneration ranInGen3= new RandomInputGeneration(numOfProcess,100);
		
		ranInGen1.randomGeneration();
		ranInGen2.randomGeneration();
		ranInGen3.randomGeneration();

		ShortJobFirstPreemptive sjfInstance1=new ShortJobFirstPreemptive();
		sjfInstance1.setValues();
		sjfInstance1.calcAverageWaitingTime();
		sjfInstance1.writingAveWaitTimeFile();
		double sjfAveWaitingTime=sjfInstance1.printWaitingTime();
	
		
		
		in.close();
		
	}

}
