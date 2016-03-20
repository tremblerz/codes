import java.util.Random;
public class RandomInputGeneration {
	public int burstTime[],numOfProcess,arrivalTime[],quantum;
	private int maxRange;
	
	public RandomInputGeneration(int numOfProcess, int maxRange){
		this.numOfProcess=numOfProcess;
		this.maxRange=maxRange;
		this.burstTime=new int[numOfProcess];
		this.arrivalTime=new int[numOfProcess];
	}
	
	public RandomInputGeneration(){
		numOfProcess=50;
		maxRange=50;
		this.burstTime=new int[numOfProcess];
		this.arrivalTime=new int[numOfProcess];
	}
	public RandomInputGeneration(int numOfProcess){
		this.numOfProcess=numOfProcess;
		maxRange=50;
		this.burstTime=new int[numOfProcess];
		this.arrivalTime=new int[numOfProcess];
		//System.out.println("Working Fine 1");
	}
	public void randomGeneration(){
		quantum=5;
		int max=-1;
		Random randomVariable=new Random();
		for (int idx=0; idx<numOfProcess;idx++){
			int randomTempVar= randomVariable.nextInt(maxRange);
			burstTime[idx]=randomTempVar;
			if(idx==0)
				max=burstTime[0];
			else if(max<burstTime[idx])
				max=burstTime[idx];
			arrivalTime[idx]=randomVariable.nextInt(max);
		//	System.out.println(burstTime[idx] + "-->" + arrivalTime[idx]);
		}
		//System.out.println("Working Fine 2");
	}
}