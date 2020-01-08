package courseplanner.util;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;


public class FileProcessor {

	//static StdoutDisplayInterface resultsStdout = new Results();
	//static LogDisplayInterface resultsLog = new Results();
    
	public static ArrayList<String>  readStudentRequestCourseList( String studentsRequestCoursesFileIn)
	{
        // make an ArrayList of students to store the information and requested course 
		ArrayList<String> studentsRequestCoursesList = new ArrayList<String>();
		//System.out.println("Here2");  
        
		BufferedReader studentPrefsReader;
		try
		{
			try{
				String filePath = "./" + studentsRequestCoursesFileIn;
				//System.out.println(filePath);
				studentPrefsReader = new BufferedReader(new FileReader(filePath));
				//System.out.println("Here3");  

				// reading the file line by line and split each line based on specific characters
				// because it has been mentioned that the input files are well formatted
				String studentPrefLine = studentPrefsReader.readLine();

				if(studentPrefLine != null )
				{
					//System.out.println(studentPrefLine);
					//String temp = " ";

					//first spplit the line by " " to get the student ID

					String[] stdIDS = studentPrefLine.split("\\:");
					studentsRequestCoursesList.add(stdIDS[0]);

                	String[] splitStdIDCourses = stdIDS[1].split("\\ ");
                	
                    
                    for(int i = 0; i< splitStdIDCourses.length; i++)
                    {
                    	studentsRequestCoursesList.add(splitStdIDCourses[i]);

                    }
                	                	


				}
				else
				{
					System.out.println("The file is empty");
				}

				studentPrefsReader.close();

			}
			catch(FileNotFoundException fileExc)
			{
				String LogMessage = studentsRequestCoursesFileIn + " File to read the students requested courses doen't exist ";
				//resultsLog.writeException(LogMessage);
				//resultsStdout.writeStdout(LogMessage);
			    System.exit(1);

			}
			
		}catch(IOException  IOe1)
		{
			//IOe1.printStackTrace();
			String LogMessage = "Error in opening  or reading the file " + studentsRequestCoursesFileIn ;
			//resultsStdout.writeStdout(LogMessage);
			//resultsStdout.writeStdout("Please check the log file");
			System.exit(1);
		}
       
	   return studentsRequestCoursesList;
	}
  

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	


	
}
