package coursesRegistration.scheduler;
import java.util.ArrayList;
import java.util.HashMap;
import coursesRegistration.util.Results;
import coursesRegistration.util.FileDisplayInterface;
import coursesRegistration.util.StdoutDisplayInterface;


public class Register
{
    public ArrayList<Student> ThirdLevelStudetns = new ArrayList<Student>();
    public ArrayList<Student> SecondLevelStudetns = new ArrayList<Student>();
    public ArrayList<Student> FirstLevelStudetns = new ArrayList<Student>();


	public static void registerStudentsCourses(ArrayList<Course> courseInfoListIn, ArrayList<Student> studentsRequestCoursesListIn, String outputFileNameIn)
	{
		
        
        FileDisplayInterface writeOutPutFile = new Results(outputFileNameIn);
        StdoutDisplayInterface writeStdoutInt = new Results();

        //HashMap<Integer, ArrayList<String[][]> >StudentsRegistration = new HashMap<>();

        // An ArrayList to store the registered courses for a specific student.
        ArrayList<String> RegisterdCoursesList = new ArrayList<String>();
        // An ArrayList to store the statisfactory value of the each registred course
        ArrayList<Integer> RegisterdSatisfactionList = new ArrayList<Integer>();

        // An ArrayList to store the average Satisfactory for all the students.
        ArrayList<Double> AllStudentsSatisfactionList = new ArrayList<Double>();


        // A HashMap to be able to identify if the request courses from a specific student are in the list of suggested courses
        // The key is the courseName 
	    HashMap<String, Course> courses = new HashMap<String, Course>();
       for (Course c : courseInfoListIn) 
       {
   			courses.put(c.getCourseName(), c);
   			//System.out.println(c.getCourseName());
	   }
	   //System.out.println(studentsRequestCoursesListIn.size());

	   // Loop through the list of students to check their requested courses
	   for(int i = 0 ; i < studentsRequestCoursesListIn.size(); i++)
	    {

	   	    Student sampleStudent = studentsRequestCoursesListIn.get(i);
	   	    //System.out.println(sampleStudent.getStudentID());


	   	 	// now we have to find the requested course 
	   	 	// get the list of requested courses by spliting the String of requested courses  based on ','
	   	 	String[] stdRequestedCourses = sampleStudent.getRequestedCourses().split("\\,");

            //loop through the requsted courses for the specific student
	   	 	for (int j=0; j<stdRequestedCourses.length; j++)
            {
            	//System.out.println("splitString["+j+"] is " + stdRequestedCourses[j]);
            	String requestedCourseName = stdRequestedCourses[j];
            	//System.out.println("1.The course name is: " + requestedCourseName);

            	//using hashmap we easily can get access to the course object
            	Course course = courses.get(requestedCourseName);  
                // System.out.println("2.The course name is: " + course.getCourseName());
                // System.out.println("2.The course capacity is: " + course.getCourseCapacity());

                 if(course == null){
                    writeStdoutInt.writeStdout(sampleStudent.getStudentID() + " requested course " + requestedCourseName + " which is not suggested in the course lists.");
                    //System.out.println("Course  "+ requestedCourseName + " is not suggested this semester!");
                    // we should log that this course is not suggested
                    //resultsStdout.writeStdout(LogMessage);
                    continue;
                }
                // Here we should call the registeration for each course
                
                boolean courseRegistered = course.registerStudent(sampleStudent);
                if(courseRegistered) 
                {
                    //if the course could be registered then we add it to courseList and the SatisfactionList
                    RegisterdCoursesList.add(requestedCourseName);
                    RegisterdSatisfactionList.add((9-j));

                }


            }

            // Make the line format to be written in the output file as follow:
            // <student1_id>:<course_1>,<course_2>,<course_3>::SatisfactionRating=<value>
            String outPutPrint = "";
            String RegistredCourse = "";
            String RegistedSatisfaction = "";
            
            // <student1_id>:
            outPutPrint += Integer.toString(sampleStudent.getStudentID());
            outPutPrint +=":";
            // <student1_id>:<course_1>,<course_2>,<course_3>
            for(int r=0; r<RegisterdCoursesList.size(); r++)
            {
            	outPutPrint += RegisterdCoursesList.get(r);
            	outPutPrint += ","; 
            }
            // replacing the last ',' with nothing
            String outPutPrintNew = outPutPrint.substring(0, outPutPrint.length()-1);

            // <student1_id>:<course_1>,<course_2>,<course_3>::SatisfactionRating=
            outPutPrintNew +="::SatisfactionRating=";

            // Calculating the satisfactory for the student
            double satisfactoryValue = 0.0;
            for(int r=0; r<RegisterdSatisfactionList.size(); r++)
            {
            	satisfactoryValue += RegisterdSatisfactionList.get(r);
            }
            if(RegisterdSatisfactionList.size()>0)
                satisfactoryValue = satisfactoryValue;///stdRequestedCourses.length;

            outPutPrintNew+= satisfactoryValue;
            AllStudentsSatisfactionList.add(satisfactoryValue);
            //System.out.println(outPutPrintNew);
            writeOutPutFile.writeResult(outPutPrintNew);
            
            RegisterdSatisfactionList.clear();
            RegisterdCoursesList.clear();

	   }
       double totalSatisfactory = 0;
	   for(int s = 0; s< AllStudentsSatisfactionList.size(); s++)
	   		totalSatisfactory+= AllStudentsSatisfactionList.get(s);

	   	totalSatisfactory /= AllStudentsSatisfactionList.size();


	   	String TotalSatisfactoryText = "AverageSatisfactionRating=" + totalSatisfactory; 
        writeOutPutFile.writeResult(TotalSatisfactoryText);



	}
    
    /*
    // function to get the course that has the minimum capacity

    String getCourseMinimumCapacity();(ArrayList<Course> courseListIn)
    {
        int miniCourseCapacity = courseListIn.get(0).getCourseCapacity();
        String minCapCourseName = courseListIn.get(0).getCourseName();

        for(int i = 1; i<courseListIn.size(); i++)
        {
            if(courseListIn.get(i).getCourseCapacity() < miniCourseCapacity)
            {
                miniCourseCapacity = courseListIn.get(i).getCourseCapacity();
                minCapCourseName = courseListIn.get(i).getCourseName();

            }

        }

        return minCapCourseName;
    }

    // function to make different lists for different level of students

    void makeLevelLists(ArrayList<Student> studentListIn)
    {
        for(int i = 0; i < studentListIn.size(); i++)
        {
            if(studentListIn.get(i).getStudentLevel()..toUpperCase().equals("THIRD_YEAR"))
                ThirdLevelStudetns.add(studentListIn.get(i));
            else if (studentListIn.get(i).getStudentLevel()..toUpperCase().equals("SECOND_YEAR"))
                SecondLevelStudetns.add(studentListIn.get(i));
            else if (studentListIn.get(i).getStudentLevel()..toUpperCase().equals("FIRST_YEAR"))
                FirstLevelStudetns.add(studentListIn.get(i));

        }

    }

    // function to sort the students at each level based on the course that has minimum capacity and is the requested by students

    void SortStudentsLevel(ArrayList<Student> studentLevelListIn, ArrayList<Course> courseListIn )
    {
        String minCapCourseName = getCourseMinimumCapacity(courseListIn);
        String requestedCourse = "";

        for(int i = 0 ; i < studentLevelListIn.size(); i++)
        {
            requestedCourse = studentLevelListIn.get(i).getRequestedCourses();
            String[] stdRequestedCourses = requestedCourse.split("\\,");
            if(stdRequestedCourses[0].equals(minCapCourseName))


        }


    }*/

}