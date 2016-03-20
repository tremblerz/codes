import java.util.Random;
import java.io.*;
public class RandomInputGeneration {
	public int numOfProcess,ar[];
	private int maxRange;
	
	public RandomInputGeneration(int numOfProcess, int maxRange)
	{
		this.numOfProcess=numOfProcess;
		this.maxRange=maxRange;
		this.ar = new int[numOfProcess];
	}
	
	public RandomInputGeneration()
	{
		numOfProcess=50;
		maxRange=50;
		this.ar = new int[numOfProcess];
	}
	public RandomInputGeneration(int numOfProcess)
	{
		this.numOfProcess=numOfProcess;
		maxRange=50;
		this.ar = new int[numOfProcess];
	}
	public void randomGeneration()
	{
		Random randomVariable=new Random();
		//create random generator here
		for (int idx=0; idx<numOfProcess;idx++)
		{
			int randomTempVar= randomVariable.nextInt(maxRange);
			ar[idx] = randomTempVar;
			// another random generator
			System.out.println(randomTempVar);
			// edit here
		}
	}
	public void randomGenerationToFile()
	{
		//fill your code so that 
	}

}