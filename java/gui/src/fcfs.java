public class fcfs {
	public int[] waitingTime,burstTime;
	public int numOfProcess;
	public double averageWaitingTime;
	public fcfs(RandomInputGeneration r)
	{
		numOfProcess = r.numOfProcess;
        waitingTime=new int[numOfProcess];
        burstTime=new int[numOfProcess];
        for(int i=0;i<numOfProcess;i++)
        	burstTime[i]=r.burstTime[i];
	}
	public void averageWaitingTimeCalc()
	{
		//implement FCFS
		//System.out.println("Calculating Average Waiting Time");
		waitingTime[0]=0;
		for(int i=1;i<numOfProcess;i++){
			waitingTime[i]=burstTime[i-1]+waitingTime[i-1];
		}
	}
	public double printWaitingTime()
	{
		//Print Waiting Time
		//System.out.println("Print the Waiting Time");
		int s=0;
		for(int i=0;i<numOfProcess;i++)
			s+=waitingTime[i];
		averageWaitingTime=(double)s/(double)numOfProcess;
		return averageWaitingTime;
	}
}