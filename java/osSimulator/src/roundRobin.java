public class roundRobin {
        public int[] waitingTime,burstTime,arrivalTime;
        public int numOfProcess,timeQuantum;
        public double averageWaitingTime;
        public roundRobin(RandomInputGeneration r)
        {
        		numOfProcess = r.numOfProcess;
                waitingTime=new int[numOfProcess];
                burstTime=new int[numOfProcess];
                arrivalTime=new int[numOfProcess];
                for(int i=0;i<numOfProcess;i++){
                	burstTime[i]=r.burstTime[i];
                	waitingTime[i]=0;
                	arrivalTime[i]=r.arrivalTime[i];
                }
                timeQuantum=r.quantum;
               // System.out.println(r.numOfProcess);
        }
        public void averageWaitingTimeCalc()
        {
        	int[] q = new int[100000];
        	int min=0,front=0,rear=0,time=0,temp=0;
        	for(int i=0;i<numOfProcess;i++)
      //  		if(arrivalTime[i]<arrivalTime[min])
      //  			min=i;
        		q[rear++]=i;
      //  	q[rear++]=min;
        	while(front!=rear){
        		if(burstTime[q[front]]<timeQuantum)
        			temp=burstTime[q[front]];
        		else
        			temp=timeQuantum;
        		//System.out.println(temp);
        		time+=temp;
        		for(int i=front+1;i<rear;i++)
        				waitingTime[q[i]]+=temp;
        //		if(temp==timeQuantum)
        //		for(int i=0;i<numOfProcess;i++)
        //			if(arrivalTime[i]>(time-timeQuantum)&&arrivalTime[i]<=time&&i!=q[front]){
        //				q[rear++]=i;
        //				waitingTime[q[rear-1]]=time-arrivalTime[q[i]];
        //			}
        		burstTime[q[front]]-=timeQuantum;
        		if(burstTime[q[front]]>0)
        			q[rear++]=q[front];
        		front++;
        	}
  //      	for(int i=0;i<numOfProcess;i++)
  //      		System.out.println(burstTime[i]);
        	//System.out.println();
        }
        public double printWaitingTime()
        {
                //Print Waiting Time
                //System.out.println("Print the Waiting Time");
                int s=0;
                for(int i=0;i<numOfProcess;i++)
                        s+=waitingTime[i];
                //System.out.println(s);
                averageWaitingTime=(double)s/(double)numOfProcess;
                return averageWaitingTime;
        }
}