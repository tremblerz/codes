public class fcfs {
	public int head,total,position[],ans[];
	fcfs(RandomInputGeneration r){
		this.head = 40;
		this.total = r.numOfProcess;
		this.position = new int[total];
		for(int i=0;i<total;i++)
			this.position[i] = r.ar[i];
		this.ans = new int[total];
	}
	public void makeOrder(){
		for(int i=0;i<total;i++){
			ans[i] = position[i];
		}
	}
	public void printOrder(){
		for(int i=0;i<total;i++){
	//		System.out.print(ans[i] + " ");
		}
	//	System.out.print("\n");
	}
}