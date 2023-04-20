package courseplanner.driver;
import courseplanner.util.FileProcessor;
//import courseplanner.util.Results;
//import courseplanner.util.StdoutDisplayInterface;
//import courseplanner.util.FileDisplayInterface;
import java.util.ArrayList;
import java.util.List;
import courseplanner.planner.Student;



public class Driver {


	public static void main(String[] args) {

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		

		if (args.length != 2 || args[0].equals("${arg0}") || args[1].equals("${arg1}") ){
				
			System.err.println("Error: Incorrect number of arguments. Program accepts 2 argumnets.");
			//System.exit(1);
		}
		if(args[1].equals("${arg1}"))
		{
			//StdoutDisplayInterface writeStdoutInt = new Results();
			//writeStdoutInt.writeStdout("Please identify the out put file");
			System.err.println("Please identify the out put file");
			System.exit(1);
		}
		
		System.out.println("Hello World! Lets get started with the assignment");

		

		

	    // reading the input file student request list
	    FileProcessor readInputFiles = new FileProcessor();  
	    //System.out.println("Here1");  
	    ArrayList<String> studentsRequestCoursesListStdId = new ArrayList<String>();
	    //ArrayList<String> studentsRequestCoursesList = new ArrayList<String>();
	    studentsRequestCoursesListStdId = readInputFiles.readStudentRequestCourseList(args[0]);

	    List<String> requestCoursesList = studentsRequestCoursesListStdId.subList(2, studentsRequestCoursesListStdId.size()-1); 
	    ArrayList<String> studentsRequestCoursesList = new ArrayList<>(requestCoursesList.size());
        studentsRequestCoursesList.addAll(requestCoursesList);

	    

	    for(int i = 0; i<studentsRequestCoursesList.size(); i++)
	    	System.out.println(studentsRequestCoursesList.get(i));

	    // create an instance of the context
	    Student student = new Student(studentsRequestCoursesList, args[1], Integer.parseInt(studentsRequestCoursesListStdId.get(0)));

	    student.registerCourse();

	}
}
