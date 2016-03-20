import java.util.Random;
public class RandomInputGeneration1 {
	public int burstTime[],numOfProcess,arrivalTime[];
	private int maxRange;
	
	public RandomInputGeneration1(int numOfProcess, int maxRange){
		this.numOfProcess=numOfProcess;
		this.maxRange=maxRange;
		this.burstTime=new int[numOfProcess];
		this.arrivalTime=new int[numOfProcess];
	}
	
	public RandomInputGeneration1(){
		numOfProcess=50;
		maxRange=50;
		this.burstTime=new int[numOfProcess];
	}
	public RandomInputGeneration1(int numOfProcess){
		this.numOfProcess=numOfProcess;
		maxRange=50;
		this.burstTime=new int[numOfProcess];
		//System.out.println("Working Fine 1");
	}
	public void randomGeneration(){
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
		}
		//System.out.println("Working Fine 2");
	}
}