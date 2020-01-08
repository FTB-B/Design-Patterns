package troubleshootsearch.util;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;


public class FileProcessor {

	//static StdoutDisplayInterface resultsStdout = new Results();
	//static LogDisplayInterface resultsLog = new Results();
    
	public static ArrayList<String>  readInputFile( String userInputFileIn)
	{
        // make an ArrayList of students to store the information and requested course 
		ArrayList<String> userInputList = new ArrayList<String>();
		//System.out.println("Here2");  
        
		BufferedReader userInputReader;
		try
		{
			try{
				String filePath = "./" + userInputFileIn;
				//System.out.println(filePath);
				userInputReader = new BufferedReader(new FileReader(filePath));
				//System.out.println("Here3");  

				// reading the file line by line 
				String inputLine = userInputReader.readLine();

				while(inputLine != null )
				{
					userInputList.add(inputLine);
					inputLine  = userInputReader.readLine();

                }
				

				userInputReader.close();

			}
			catch(FileNotFoundException fileExc)
			{
				String LogMessage = userInputFileIn + " File to read the user inputs doen't exist ";
				//resultsLog.writeException(LogMessage);
				//resultsStdout.writeStdout(LogMessage);
				System.out.println(LogMessage);
			    System.exit(1);

			}
			
		}catch(IOException  IOe1)
		{
			//IOe1.printStackTrace();
			String LogMessage = "Error in opening  or reading the file " + userInputFileIn ;
			//resultsStdout.writeStdout(LogMessage);
			//resultsStdout.writeStdout("Please check the log file");
			System.out.println(LogMessage);
			System.exit(1);
		}
       
	   return userInputList;
	}
  

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	


	
}
