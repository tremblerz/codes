class loading extends Thread {
	public void run() {

		 // thread body of execution
		 }
	
}

public class TestThread {
   public static void main(String args[]) {
   
      Loading R1 = new Loading();
      R1.start();
      
      captureInput R2 = new captureInput();
      R2.start();
   }   
}