import java.util.Random;
import java.io.*;
public class RandomInputGeneration {
	private int numOfProcess;
	private int maxRange;
	
	public RandomInputGeneration(int numOfProcess, int maxRange)
	{
		this.numOfProcess=numOfProcess;
		this.maxRange=maxRange;
	}
	
	public RandomInputGeneration()
	{
		numOfProcess=50;
		maxRange=50;
	}
	public RandomInputGeneration(int numOfProcess)
	{
		this.numOfProcess=numOfProcess;
		maxRange=50;
	}
	public void randomGeneration()
	{
		Random randomVariable=new Random();
		//create random generator here
		for (int idx=0; idx<numOfProcess;idx++)
		{
			int randomTempVar= randomVariable.nextInt(maxRange);
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
