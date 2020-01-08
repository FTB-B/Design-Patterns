package coursesRegistration.driver;
import coursesRegistration.scheduler.Student;
import coursesRegistration.scheduler.Course;
import coursesRegistration.scheduler.Register;
import coursesRegistration.util.FileProcessor;
import coursesRegistration.util.Results;
import coursesRegistration.util.StdoutDisplayInterface;
import coursesRegistration.util.LogDisplayInterface;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author John Doe
 *
 */
public class Driver {


	public static void main(String[] args) {

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		

		if (args.length != 3 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}")){
				
			System.err.println("Error: Incorrect number of arguments. Program accepts 3 argumnets.");
			//System.exit(1);
		}
		if(args[2].equals("${arg2}"))
		{
			StdoutDisplayInterface writeStdoutInt = new Results();
			writeStdoutInt.writeStdout("Please identify the out put file");
			System.exit(1);
		}
		
		System.out.println("Hello World! Lets get started with the assignment");

		

		

	    // reading the input file student request list
	    FileProcessor readInputFiles = new FileProcessor();    
	    ArrayList<Student> studentsRequestCoursesList = new ArrayList<Student>();
	    studentsRequestCoursesList = readInputFiles.readStudentRequestCourseList(args[0]);

	    // sorting the students based on their level in the descending order
	    // because it is said that the student with higher LEVEL should take courses first than the other students
	    try{
	    	Collections.sort(studentsRequestCoursesList, Student.StudentLevelComparator);
	    }
	    catch(ClassCastException | UnsupportedOperationException exp)
        {
        	LogDisplayInterface writeLogFile = new Results();
        	writeLogFile.writeException("Exception in sorting the list of students based on their Level");
        	StdoutDisplayInterface writeStdout = new Results();
        	writeStdout.writeStdout("Please check the log file");
        	System.exit(1);

        }
	    
	   //reading the courseInfo.txt file 
       String courseInfoFile = args[1];
	   ArrayList<Course> courseInfoList = readInputFiles.readCourseInfo(courseInfoFile);
	   


       //define the Results class
       Register registerCourses = new Register();
       
       // in this class we register the courses for students.
       registerCourses.registerStudentsCourses(courseInfoList,studentsRequestCoursesList, args[2]);
	   
	   

	}
}
