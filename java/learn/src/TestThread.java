import java.util.Scanner;
class Loading extends Thread {
	int x;
	Loading(int id){
		x=id;
	}
	public void run() {
		int c=0;
		while(x==-1)
		{
			System.out.print('=');
				if (c>=20){
					c=0;
					System.out.print('\b');
				}
				c++;
		 // thread body of execution
		 }
	
	}
}	

class captureInput extends Thread{
	int x;
	captureInput(int val){
		x=val;
	}
	public void run(){
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		x = in.nextInt();
	}
}
public class TestThread {
	static int x=-1;
   public static void main(String args[]) {
   
      Loading load = new Loading(x);
      load.start();
      
      captureInput inp = new captureInput(x);
      inp.start();
   }
}