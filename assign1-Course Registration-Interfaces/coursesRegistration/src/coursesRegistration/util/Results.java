package coursesRegistration.util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Results implements FileDisplayInterface, StdoutDisplayInterface, LogDisplayInterface {

	String registerationResultFile;
	File RegisterResults;    // File to write the registration results
	File ExceptionFile;      // File to write the logs

	public Results()
	{
		//registerationResultFile = "./registration_results.txt";
		//File RegisterResults = new File(registerationResultFile);
		//System.out.println("1!!!!!!!!!!!!!!!!!!!");

	}
  public Results(String outputFileNameIn)
  {
    registerationResultFile = "./" + outputFileNameIn;
  }
	

	public void writeResult(String textIn)
	{
		
		//registerationResultFile = "./registration_results.txt";
    File RegisterResults = new File(registerationResultFile);
    FileWriter ResultsFileWriter = null;
		//check if the file was already exsists or not
		RegisterResults = new File(registerationResultFile);
		//System.out.println("2!!!!!!!!!!!!!!!!!!!");
		
		try{
              if(!RegisterResults.exists()){
                    RegisterResults.createNewFile();
     			}
     			//System.out.println("1!!!!!!!!!!!!!!!!!!!");
     			ResultsFileWriter = new FileWriter(RegisterResults, true);
     			BufferedWriter bufferedWriter = new BufferedWriter(ResultsFileWriter);
     			bufferedWriter.write(textIn);
     			bufferedWriter.write("\n");
     			bufferedWriter.close();
     			

            } 
            catch(IOException exp1)
            {
    			writeException("Exception in Writing the Registration File. Couldn't write in the registration_results.txt");
			}       
			finally 
			{
  			 try 
  			 {
  			 	ResultsFileWriter.close();
  			 } 
  			 catch (Exception exp2) 
  			 {
  			 	writeException("Exception in Writing the Registration File. Can't close the file");
  			 }
			}
			


	}


	public void writeException(String ExceptionTextIn)
	{

		FileWriter LogFileWriter = null;

		//check if the file was already exsists or not
		ExceptionFile = new File("./log.txt");

		try{
              if(!ExceptionFile.exists()){
                    ExceptionFile.createNewFile();
     			}
     			//System.out.println("1!!!!!!!!!!!!!!!!!!!");
     			LogFileWriter = new FileWriter(ExceptionFile, true);
     			BufferedWriter bufferedWriterLog = new BufferedWriter(LogFileWriter);
     			bufferedWriterLog.write(ExceptionTextIn);
     			bufferedWriterLog.write("\n");
     			bufferedWriterLog.close();
     			

            } 
            catch(IOException exp1)
            {
    			//writeException("Exception in Writing the Log File. Couldn't write in the log file");
			}       
			finally 
			{
  			 try 
  			 {
  			 	LogFileWriter.close();
  			 } 
  			 catch (Exception exp2) 
  			 {
  			 	//writeException("Exception in Writing the Registration File. Can't close the file");
  			 }
			}


	}

  public void writeStdout(String textIn)
  {
    System.out.println(textIn);
  }
}
