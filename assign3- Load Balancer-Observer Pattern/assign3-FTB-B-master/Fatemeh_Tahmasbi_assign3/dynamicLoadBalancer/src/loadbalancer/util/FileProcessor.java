//FileProcessor
package loadbalancer.util;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;


public class FileProcessor {

	//static StdoutDisplayInterface resultsStdout = new Results();
	//static LogDisplayInterface resultsLog = new Results();
    
	public static ArrayList<String>  readLoadBalancerInput( String loadbalancerInputFileIn)
	{
        // make an ArrayList of students to store the information and requested course 
		ArrayList<String> loadBalancerInputList = new ArrayList<String>();
		System.out.println("Here2");  
        
		BufferedReader loadbalancerReader;
		try
		{
			try{
				String filePath = "./" + loadbalancerInputFileIn;
				//System.out.println(filePath);
				loadbalancerReader = new BufferedReader(new FileReader(filePath));
				//System.out.println("Here3");  

				// reading the file line by line and split each line based on specific characters
				// because it has been mentioned that the input files are well formatted
				String loadBalancerLine = loadbalancerReader.readLine();

				 //ArrayList<ArrayList<String> > inputList =  new ArrayList<ArrayList<String> >(n); 


				while(loadBalancerLine != null )
				{
					//System.out.println(loadBalancerLine);
					//String temp = " ";

				
            
					String[] loadbalancerReq = loadBalancerLine.split("\\ ");
					//loadBalancerInputList.add(loadbalancerReq[0]);
					//System.out.println(loadbalancerReq[0]);
					//System.out.println("1111111111111111111111111111111");
					//System.out.println(loadbalancerReq[1]);
					//inputList.add()

                	String[] loadbalancerReqOpt = loadbalancerReq[1].split("\\ ");
                	
                    //System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");

                    for(int i = 0; i< loadbalancerReq.length; i++)
                    {
                    	System.out.println("22222222222222222222222222222222222222");
                    	System.out.println(loadbalancerReq[i]);
                    	loadBalancerInputList.add(loadbalancerReq[i]);

                    }
                	                	
                System.out.println("********************************************");
                loadBalancerLine = loadbalancerReader.readLine();
				}
				
				loadbalancerReader.close();

			}
			catch(FileNotFoundException fileExc)
			{
				String LogMessage = loadbalancerInputFileIn + " File to read the students requested courses doen't exist ";
				//resultsLog.writeException(LogMessage);
				//resultsStdout.writeStdout(LogMessage);
				System.out.println(LogMessage);
			    System.exit(1);

			}
			
		}catch(IOException  IOe1)
		{
			//IOe1.printStackTrace();
			String LogMessage = "Error in opening  or reading the file " + loadbalancerInputFileIn ;
			//resultsStdout.writeStdout(LogMessage);
			//resultsStdout.writeStdout("Please check the log file");
			System.out.println(LogMessage);
			System.exit(1);
		}
       
	   return loadBalancerInputList;
	}
  

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	


	
}