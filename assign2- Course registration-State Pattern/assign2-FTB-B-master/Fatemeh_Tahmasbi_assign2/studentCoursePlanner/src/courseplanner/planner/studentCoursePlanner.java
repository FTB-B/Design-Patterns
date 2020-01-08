package courseplanner.planner;
//import coursesRegistration.scheduler.Student;
import courseplanner.util.FileProcessor;
//import courseplanner.util.Results;
import java.util.ArrayList;
//import java.util.Collections;
import courseplanner.state.CoursePlannerStateI;

/**
 * @author John Doe
 *
 */
public class studentCoursePlanner  {

	//CoursePlannerStateI stateOne;
    //CoursePlannerStateI stateTwo;
	//CoursePlannerStateI stateThree;
	//CoursePlannerStateI stateFour;
	//CoursePlannerStateI stateFive;

	//CoursePlannerStateI state;
	int registeredCourses = 0;
	int semesterNum = 0;
	//ArrayList<Integer> registeredCoursesPerSemester = new ArrayList<Integer>();
	ArrayList<ArrayList<String>> registeredCoursesPerSemester = new ArrayList<ArrayList<String>>();
	ArrayList<String> currentSemesterCourses = new ArrayList<String>();

	//ArrayList<String> waitedList = new ArrayList<String>();
	//ArrayList<String> registeredList = new ArrayList<String>();
    

	public studentCoursePlanner()
	{
		//stateOne = new stateOne(this);
		//stateTwo = new stateTwo(this);
		//stateThree = new stateThree(this);
		//stateFour = new stateFour(this);
		//stateFive = new stateFive(this);
		//registeredCoursesPerSemester.add(0);


		//state = stateOne;
	}

	// the functions or transitions
	/*
	public void goToStateOne()
	{
		state.goToStateOne();
	}
	public void goToStateTwo()
	{
		state.goToStateTwo();
	}
	public void goToStateThree()
	{
		state.goToStateThree();
	}
	public void goToStateFour()
	{
		state.goToStateFour();
	}
	public void goToStateFive()
	{
		state.goToStateFive();
	}*/
	// this function check the requested courses and 
    public  void registerCourse(ArrayList<String> requesterCoursesIn)
    {
    	//state.registerCourse(requesterCoursesIn);
    	//first check if the graduation requirement is met
    	if(isGraduate())
    	{
    		System.out.println("The student can graduate");
    		return;
    	}
    	
    	

        /*
    	// the student still need to register for courses
    	// first check the wait list
    	if(waitedList.size()!=0)
		{
			//means that there are courses in the waited list
			//check to see if the prerequisted course has been taken before

			for(int i = 0; i < waitedList.size(); i++)
			{
				if(registeredList.contains(checkPreRequisitCourse(waitedList.get(i))))
				{
					// if the student has taken the pre requisit course then he can take the course in the waited list
					if(currentSemesterCourses.size() == 3)
    				{
    					registeredCoursesPerSemester.add(currentSemesterCourses);
    					currentSemesterCourses.clear();

    				}
    				currentSemesterCourses.add(waitedList.get(i));
					registeredList.add(waitedList.get(i));
					waitedList.remove(waitedList.get(i));
					break;

				}
			}

    		for(int i = 0; i< requesterCoursesIn.size(); i++)
    		{
    			//find the group of the course
    			//CoursePlannerStateI courseG = findCourseGroup(requesterCoursesIn.get(i));
    			state.register(requesterCoursesIn.get(i));


    		}
    	}*/
    	

    	


    }
    public  boolean isGraduate()
    {
    	/*
    	int stateOneRegCr = stateOne.getNumberofRegisteredCourses();
    	int stateTwoRegCr = stateTwo.getNumberofRegisteredCourses();
    	int stateThreeRegCr = stateThree.getNumberofRegisteredCourses();
    	int stateFourRegCr = stateFour.getNumberofRegisteredCourses();
    	int stateFiveRegCr = stateFive.getNumberofRegisteredCourses();

    	if(stateOneRegCr>=2 && stateTwoRegCr>=2 && stateThreeRegCr >=2 && stateFourRegCr>=2 && stateFiveRegCr>=2)
    	{
    		// then the student can graduate
    		return true;
    	}
    	else
    		return false;
    	*/
    	return false;	

    }

    //public CoursePlannerStateI findCourseGroup(String course)
    //{
    	/*
    	ArrayList<String> G1Courses = stateOne.getcourseList();
    	ArrayList<String> G2Courses = stateTwo.getcourseList();
    	ArrayList<String> G3Courses = stateThree.getcourseList();
    	ArrayList<String> G4Courses = stateFour.getcourseList();
    	ArrayList<String> G5Courses = stateFive.getcourseList();

    	if(G1Courses.contains(course))
    		return stateOne;
    	else if(G2Courses.contains(course))
    		return stateTwo;
    	else if(G3Courses.contains(course))
    		return stateThree;
    	else if(G4Courses.contains(course))
    		return stateFour;
    	else if(G5Courses.contains(course))
    		return stateFive;
    		*/

    //}
    public String checkPreRequisitCourse(String courseIn)
	{
		if(courseIn.equals("B"))
			return "A";
		else if(courseIn.equals("C"))
			return "B";
		else if(courseIn.equals("D"))
			return "C";
		else if(courseIn.equals("F"))
			return "E";
		else if(courseIn.equals("G"))
			return "F";
		else if(courseIn.equals("H"))
			return "G";
		else if(courseIn.equals("J"))
			return "I";
		else if(courseIn.equals("K"))
			return "J";
		else if(courseIn.equals("L"))
			return "K";
		else if(courseIn.equals("N"))
			return "M";
		else if(courseIn.equals("O"))
			return "N";
		else if(courseIn.equals("P"))
			return "O";
		else 
			return "";

	}
    public  int getNumberofRegisteredCourses()
	{
		return 0;
	}
/*
	void setState(CoursePlannerStateI stateIn)
	{
		state = stateIn;
	}
    //getters for states
    CoursePlannerStateI getStateOne()
    {
    	return stateOne;
    }
    CoursePlannerStateI getStateTwo()
    {
    	return stateTwo;
    }
    CoursePlannerStateI getStateThree()
    {
    	return stateThree;
    }
    CoursePlannerStateI getStateFour()
    {
    	return stateFour;
    }
    CoursePlannerStateI getStateFive()
    {
    	return stateFive;
    }
*/





	
}
