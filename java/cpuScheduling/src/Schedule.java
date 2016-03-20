public class Schedule{
	public static void main(String[] args) {
		runner1 r1=new runner1();
		r1.setvalues();
		Sjf ex1 = new Sjf(r1);
		fcfs ex2 = new fcfs(r1);
		sjfp ex3 = new sjfp(r1);
		priority ex4 = new priority(r1);
		roundRobin ex5 = new roundRobin(r1);
		ex1.averageWaitingTimeCalc();
		ex2.averageWaitingTimeCalc();
		ex3.averageWaitingTimeCalc();
		ex4.averageWaitingTimeCalc();
		ex5.averageWaitingTimeCalc();
		System.out.println("Total Waiting Time for SJF Non-Preemptive is " + ex1.printWaitingTime());
		System.out.println("Total Waiting Time for FCFS is "+ ex2.printWaitingTime());
		System.out.println("Total Waiting Time for SJF Preemptive is "+ex3.printWaitingTime());
		System.out.println("Total Waiting Time for Priority is "+ex4.printWaitingTime());
		System.out.println("Total Waiting Time for Round Robin is "+ex5.printWaitingTime());
	}
}