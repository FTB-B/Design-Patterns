package coursesRegistration.scheduler;
import java.util.ArrayList;
import java.util.Comparator;


public class Student 
{
	private int studentID;
    enum student_Level
	{
		FIRST_YEAR, SECOND_YEAR, THIRD_YEAR;
	}
	private  student_Level stdntLevel;
	private String requestedCourses;
	private ArrayList<Course> courseRegisteredList;


	public Student(int stdid, String studentLevelIn,String requestedCoursesIn )
	{
		studentID = stdid;
		stdntLevel = student_Level.valueOf(studentLevelIn.toUpperCase());
		requestedCourses = requestedCoursesIn;
		courseRegisteredList = new ArrayList<Course>();
	}

   public int getStudentID()
	{
		return studentID;
	}

   
	public String getStudentLevel()
	{
		return stdntLevel.toString();
	}

	public String getRequestedCourses()
	{
		return requestedCourses;
	}
	public ArrayList getRegisteredCourses()
	{
		return courseRegisteredList;
	}

	public void setRegisteredCourses(Course courseIn)
	{
		 courseRegisteredList.add(courseIn);
		 return;
	}

	public static Comparator<Student> StudentLevelComparator = new Comparator<Student>() {

	public int compare(Student s1, Student s2) {
	   String StudentLevel1 = s1.getStudentLevel().toUpperCase();
	   String StudentLevel2 = s2.getStudentLevel().toUpperCase();

	   //ascending order
	   //return StudentLevel1.compareTo(StudentLevel2);

	   //descending order
	   return StudentLevel2.compareTo(StudentLevel1);
    }};


    

    @Override
    public String toString() {
        return "[ StudentID=" + studentID + ", level=" + stdntLevel + ", requestedCourses= " + requestedCourses+"]";
    }


	
}
