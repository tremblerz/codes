public class sjfp {
        public int[] waitingTime,burstTime,arrivalTime;
        public int numOfProcess;
        public double averageWaitingTime;
        public sjfp(RandomInputGeneration r)
        {
        		numOfProcess = r.numOfProcess;
                waitingTime=new int[numOfProcess];
                burstTime=new int[numOfProcess];
                arrivalTime=new int[numOfProcess];
                for(int i=0;i<numOfProcess;i++)
                	burstTime[i]=r.burstTime[i];
                for(int i=0;i<numOfProcess;i++)
                	arrivalTime[i]=r.arrivalTime[i];
               // System.out.println(r.numOfProcess);
        }
        public void averageWaitingTimeCalc()
        {
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
        		burstTime[min]--;
        		sum--;
        		for(int j=0;j<numOfProcess;j++){
        			if(j!=min){
        				if(arrivalTime[j]<=time&&burstTime[j]>0)
        					waitingTime[j]++;
        			}
        		}
        		time++;
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
