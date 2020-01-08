package coursesRegistration.scheduler;
import java.util.ArrayList;
import java.util.HashMap;
import coursesRegistration.util.Results;



public class Course
{
	private int courseCapacity;
	private String courseName;
	private int courseTiming;



	public Course(String courseNameIn, int capacityIn, int courseTimingIn)
	{
		courseName = courseNameIn;
		courseCapacity= capacityIn;
		courseTiming = courseTimingIn;

	}

	public int getCourseCapacity()
	{
		return courseCapacity;
	}

	public String getCourseName()
	{
		return courseName;
	}

	public int getCourseTiming()
	{
		return courseTiming;
	}
   
	public boolean registerStudent(Student studentIn)
	{
		int i;
		String studentInLevel = studentIn.getStudentLevel();//.toUpper();
		// creating a hashmap for checking the timining of the courses
		ArrayList<Course> studentCourseRegisteredList = studentIn.getRegisteredCourses();
		HashMap<Integer, Course> studentRegisteredcourses = new HashMap<Integer, Course>();
		for (Course c : studentCourseRegisteredList ) 
        {
   		    	studentRegisteredcourses.put(c.getCourseTiming(), c);
	    }
	    //check if the course capacity is greater than zero
		if(courseCapacity > 0 && studentCourseRegisteredList.size() < 3)
		{
			
			// now we should check if the student already has a course with the same timing of this course
				  if(!studentRegisteredcourses.containsKey(courseTiming))
				  {
				  	//System.out.println("StudentID: " + studentIn.getStudentID() + " could register in the course " + courseName + " with the timing "+ courseTiming);
                    studentIn.setRegisteredCourses(this);
                    courseCapacity -= 1;
                    return true;
				  }
				  else
				  {
				  	//System.out.println("StudentID: " + studentIn.getStudentID() + " could'nt register in the course " + courseName + " cos of timing conflict!");
				  	return false;
				  }


		}

		// if the course doesn't have capacity then return false
		else
		{
			//System.out.println("StudentID: " + studentIn.getStudentID() + " could'nt register in the course " + courseName + " cos of course capacity!");
			return false;
		}
	}
	

	 @Override
    public String toString() {
        return "[ CourseName=" + courseName + ", CourseCapacity=" + courseCapacity + ", courseTiming= " + courseTiming+"]";
    }


	
}