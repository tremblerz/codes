import java.io.*;
import static java.nio.file.StandardOpenOption.*;
import java.nio.file.*;

public class ShortJobFirstPreemptive 
{
	//Declaration of varibales
	double averageWaitingTime;
	
	
	public ShortJobFirstPreemptive()
	{
		//constructor
		//initialization 
	}
	public void setValues()
	{
		//set the valuses for burstTime
		String csvSplitBy = ",";
		
		System.out.println("Get the input values from files");
		try (BufferedReader br = new BufferedReader(new FileReader("/home/bharathi/Desktop/input.csv")))
		{

			String line;
			int temp1,temp2;

			while ((line = br.readLine()) != null) {
				String[] valuelineString=line.split(csvSplitBy);
				temp1= Integer.valueOf(valuelineString[0]);
				temp2=Integer.valueOf(valuelineString[1]);
				System.out.println(temp1+" "+temp2);
				//System.out.println(line);
				

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void calcAverageWaitingTime()
	{
		//implement SJF and set the value to averageWaitingTime variable
		System.out.println("Calculating Average Waiting Time");
	}
	public double getWaitingTime()
	{
		
		System.out.println("return average Waiting Time");
	
		
		return averageWaitingTime;
	}
	public void writingAveWaitTimeFile()
	{
		try {

			String printstring = "Average Waiting of the Shortest Job First ";
			String aveWaitTimeString= Double.toString(averageWaitingTime);
			File file = new File("/home/bharathi/Desktop/output.txt");			
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(printstring);
			bw.write(aveWaitTimeString);
			bw.close();

			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public double printWaitingTime()
	{
		//Print Waiting Time
		System.out.println("Print the Waiting Time");
	
		
		return averageWaitingTime;
	}
}

	
