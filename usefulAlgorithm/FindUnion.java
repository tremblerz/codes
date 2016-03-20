import java.lang.*;
public class FindUnion{
	public static void main(String[] args){
		int n = StdIn.readInt();
		FindUnion obj = new FindUnion(n);
		while(!StdIn.isempty()){
			int a = StdIn.readInt();
			int b = StdIn.readInt();
			obj.union(a,b);
			
		}
	}
	public FindUnion(int n){
		private int[] parent = new int[n];
		private int[] height = new int[n];
		for(int i=0;i<n;i++){
			ar[i] = i;
			height[i] = 1;
		}
	}
	public void union(int a,int b){
		private int roota = root(a);
		private int rootb = root(b);
		if(sizea
	}
}
