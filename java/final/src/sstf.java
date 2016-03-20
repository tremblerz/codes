public class sstf {
	public int head,total,position[],ans[];
	sstf(RandomInputGeneration r){
		this.head = 40;
		this.total = r.numOfProcess;
		this.position = new int[r.numOfProcess];
		for(int i=0;i<total;i++){
			this.position[i] = r.ar[i];
		}
		this.ans = new int[total];
	}
	public void makeOrder(){
		int min,j=0,index=0;
		for(int i=0;i<total;i++){
			min = 10000;
			for(int k=0;k<total;k++){
				if(min>Math.abs(head-position[k])){
					min = Math.abs(head-position[k]);
					index = k;
				}
			}
			ans[j] = position[index];
			j++;
			head = position[index];
			position[index] = 100000;
		}
	}
	public void printOrder(){
		for(int i=0;i<total;i++){
			System.out.print(ans[i] + " ");
		}
		System.out.print("\n");
	}
}
