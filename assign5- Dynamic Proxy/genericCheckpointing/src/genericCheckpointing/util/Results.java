package genericCheckpointing.util;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Results implements FileDisplayInterface, LogDisplayInterface {

	
	File ExceptionFile;      // File to write the logs
  String seriliazeFile = "./" + "AllUserTypes.txt";
  File RegisterResults;
  FileWriter ResultsFileWriter;
  BufferedWriter bufferedWriter;
	public Results()
	{
		//registerationResultFile = "./registration_results.txt";
		//File RegisterResults = new File(registerationResultFile);
		//System.out.println("RRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
    seriliazeFile = "./" + "AllUserTypes.txt";
    RegisterResults = new File(seriliazeFile);
    ResultsFileWriter = null;
    try
    {
      if(!RegisterResults.exists())
      {
          RegisterResults.createNewFile();
      }
      ResultsFileWriter = new FileWriter(RegisterResults, true);
      bufferedWriter = new BufferedWriter(ResultsFileWriter);
    }
    catch(Exception e)
    {
      //System.out.println("EXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }
          
    
    

	}
  
	

	public void writeResult(String textSerializeIn)
	{ 
    try{
        if(!textSerializeIn.equals("end"))
        {
          bufferedWriter.write(textSerializeIn);
          bufferedWriter.write("\n");
        }
        else
        {
          bufferedWriter.close();
        }
      }
    catch(Exception e)
    {

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
