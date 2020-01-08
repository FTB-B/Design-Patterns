package coursesRegistration.util;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import coursesRegistration.scheduler.Student;
import coursesRegistration.scheduler.Course;
import java.io.FileNotFoundException;


public class FileProcessor {

	static StdoutDisplayInterface resultsStdout = new Results();
	static LogDisplayInterface resultsLog = new Results();
    
	public static ArrayList<Student>  readStudentRequestCourseList( String studentsRequestCoursesFileIn)
	{
        // make an ArrayList of students to store the information and requested course 
		ArrayList<Student> studentsRequestCoursesList = new ArrayList<Student>();
        
		BufferedReader studentPrefsReader;
		try
		{
			try{
				String filePath = "./" + studentsRequestCoursesFileIn;
				studentPrefsReader = new BufferedReader(new FileReader(filePath));

				// reading the file line by line and split each line based on specific characters
				// because it has been mentioned that the input files are well formatted
				String studentPrefLine = studentPrefsReader.readLine();

				while(studentPrefLine != null )
				{
					//System.out.println(studentPrefLine);
					//String temp = " ";

					//first spplit the line by " " to get the student ID

                	String[] splitStdIDRest = studentPrefLine.split("\\ ");

                	// the first splitString is studentID
                	// the second substring should be splitted again based on "::""
                	int studentID ;
                	try{
                		studentID = Integer.parseInt(splitStdIDRest[0]);

                	}
                	
                	catch(NumberFormatException numExc)
                	{
                		resultsLog.writeException("The studentID in the line is not correct: " + studentPrefLine);
                		resultsStdout.writeStdout("Please check the log file");
                		studentPrefLine  = studentPrefsReader.readLine();
                		continue;
					}
                	
                	
                	

                	// check if the studentID is in the range of [100 999]
                	if(studentID > 999 || studentID < 100 )
                	{
                		resultsLog.writeException("The studentID in the line is not correct: " + studentPrefLine);
                		resultsStdout.writeStdout("Please check the log file");
                		studentPrefLine  = studentPrefsReader.readLine();
                		continue;
                	}
                	                	



                	String[] splitStdCoursesLevel = splitStdIDRest[1].split("\\::");

                	//The second substring is the studentLevel
                	String studentLevel = splitStdCoursesLevel[1];

               
                	String requestedCourses = "";
                	//split the courses based on ','
                	String[] splitCourses = splitStdCoursesLevel[0].split("\\,");
              
                
             	   for (int i=0; i<splitCourses.length; i++)
                	{
            			//System.out.println("splitString["+i+"] is " + splitCourses[i]);
            			requestedCourses += splitCourses[i].charAt(0);
            			requestedCourses += ",";
                	}

                	if(checkStudentExist(studentsRequestCoursesList,studentID) != -1)
                	{
                		// means that the studentID already was in the list
                    	// check if the student Level and the requested courses are the same 
                		if(studentsRequestCoursesList.get(checkStudentExist(studentsRequestCoursesList, studentID)).getStudentLevel().equals(studentLevel) && studentsRequestCoursesList.get(checkStudentExist(studentsRequestCoursesList,studentID)).getRequestedCourses().equals(requestedCourses))
                		{
                			// no need to add this one again.
                			resultsLog.writeException("The studentID with the information are redundant: " + studentPrefLine);
                			resultsStdout.writeStdout("Please check the log file");
                			studentPrefLine  = studentPrefsReader.readLine();
                	    	continue;
                		}
                		else
                		{
                			// need to remove the one already in the list and not add any of them
                			resultsLog.writeException("The information  " + studentPrefLine + " and " + studentsRequestCoursesList.get(checkStudentExist(studentsRequestCoursesList, studentID)).toString() + " has conflict information" );
                			resultsStdout.writeStdout("Please check the log file");
                			studentsRequestCoursesList.remove(checkStudentExist(studentsRequestCoursesList,studentID));
                			studentPrefLine  = studentPrefsReader.readLine();
                	    	continue;
                		}
                	}

                	if(splitCourses.length != 9)
                	{
                		resultsLog.writeException("The student should provide 9 courses: " + studentPrefLine);
                		resultsStdout.writeStdout("Please check the log file");
                		studentPrefLine  = studentPrefsReader.readLine();
                		continue;
                	}
                		//System.out.println(requestedCourses);
                
              		  // we add each student information into the studentsRequestCoursesList ArrayList
                	studentsRequestCoursesList.add(new Student(studentID, studentLevel,requestedCourses));

                	//read the next line of the file
					studentPrefLine  = studentPrefsReader.readLine();
				}

				studentPrefsReader.close();

			}
			catch(FileNotFoundException fileExc)
			{
				String LogMessage = studentsRequestCoursesFileIn + " File to read the students requested courses doen't exist ";
				//resultsLog.writeException(LogMessage);
				resultsStdout.writeStdout(LogMessage);
			    System.exit(1);

			}
			
		}catch(IOException  IOe1)
		{
			//IOe1.printStackTrace();
			String LogMessage = "Error in opening  or reading the file " + studentsRequestCoursesFileIn ;
			resultsStdout.writeStdout(LogMessage);
			//resultsStdout.writeStdout("Please check the log file");
			System.exit(1);
		}
       
	   return studentsRequestCoursesList;
	}
  
    // a function to check if there are several of students with the same studentID so 
    // if the requested courses and the student level are the same keep the last one and don't add the
    // new one. if they are different then remove the last one from the list and don't add this one
    
	private static int checkStudentExist(ArrayList<Student> studentsRequestCoursesListIn , int studentIDIn)
	{
		int studentExist = -1;

		for(int i = 0;i<studentsRequestCoursesListIn.size();i++)
		{
			if(studentsRequestCoursesListIn.get(i).getStudentID() == studentIDIn)
			{
				studentExist = i;
			}
		}


			
		

		return studentExist;

	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


	public static ArrayList<Course> readCourseInfo(String courseInfoFileIn)
	{
		ArrayList<Course> courseInfoList= new ArrayList<Course>();
       BufferedReader courseInfoReader;
		try
		{
			try
			{

				String courseInfoPath = "./" + courseInfoFileIn;
			
				//reading the courseInfoFile line by line and save the information about each course
				courseInfoReader = new BufferedReader(new FileReader(courseInfoPath));
				String courseInfoLine = courseInfoReader.readLine();

				while(courseInfoLine != null )
				{
					//we pass an empty line
					if(courseInfoLine.equals(""))
					{
						courseInfoLine  = courseInfoReader.readLine();
						continue;
					}
					//System.out.println(courseInfoLine);
				
					//Since it mentioned that the input files are well fomratted so I use this format

					// split the line based on " "
					// it split the line into the CourseName and the rest of the line
                	String[] splitCourseNameRest = courseInfoLine.split("\\ ");

                	// the first splitString is courseName
                
                	String courseName = splitCourseNameRest[0];

               
                	// the second substring should be splitted again based on ';'
                	// the fist subString contains Capacity Information 
                	// the second subString contains CourseTiming information

                	String[] splitCapacityTiming = splitCourseNameRest[1].split("\\;");

                	//again each of the substring should be split based on :
                
                	String[] splitCapacity = splitCapacityTiming[0].split("\\:");

                	// course capacity is the second substring 

                	int courseCapacity = Integer.parseInt(splitCapacity[1]);
    
                	String[] splitTiming = splitCapacityTiming[1].split("\\:");

                 	// course timing is the second substring 
                	int courseTiming = Integer.parseInt(splitTiming[1]);

               		// making new objects of each course and adding the course object to the list of courses.
                	courseInfoList.add(new Course(courseName, courseCapacity ,courseTiming));

                	// reading the next line of the file
					courseInfoLine  = courseInfoReader.readLine();
				}
				courseInfoReader.close();
			}
			catch(FileNotFoundException fileExc)
			{
				String LogMessage = courseInfoFileIn + " file to read the courses information doen't exist ";
				//resultsLog.writeException(LogMessage);
				resultsStdout.writeStdout(LogMessage);
			    System.exit(1);

			}
		}catch(IOException IOe1)
		{
			String LogMessage = "Error in opening  or reading the file " + courseInfoFileIn ;
			resultsStdout.writeStdout(LogMessage);
			IOe1.printStackTrace();
		}
		

	   return courseInfoList;
	}


	
}
