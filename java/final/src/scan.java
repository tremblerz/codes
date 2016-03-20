import java.util.Arrays;
public class scan {
	public int head,total,position[],ans[];
	scan(RandomInputGeneration r){
		this.head = 40;
		this.total = r.numOfProcess;
		this.position = new int[r.numOfProcess];
		for(int i=0;i<total;i++){
			this.position[i] = r.ar[i];
		}
		this.ans = new int[total];
	}
	public void makeOrder(){
		int j=0,min=100000,dir=0,index=0;
		boolean flag = true;
		Arrays.sort(position);
		for(int i=0;i<total;i++){
			if(head>position[i] && (min>Math.abs(head-position[i]))){
				min = Math.abs(head-position[i]);
				index = i;
			}
		}
		if(head > position[index])
			dir = -1;
		else
			dir = 1;
		for(int k=index;true;k+=dir){
			if((k>=total || k<0) && flag){
				if(dir == 1){
					if(index>0){
						dir = -1;
						flag = false;
						k = index-1;
					}
					else
						break;
				}
				else{
					if(index<total-1){
						dir = 1;
						flag = false;
						k = index+1;
					}
					else
						break;
				}
			}
			else if((k>=total || k<0) && !flag)
				break;
			//System.out.println(position[k] + " ");
			ans[j++] = position[k];
		}
	}
	public void printOrder(){
		for(int i=0;i<total;i++){
			System.out.print(ans[i] + " ");
		}
		System.out.print("\n");
	}
}