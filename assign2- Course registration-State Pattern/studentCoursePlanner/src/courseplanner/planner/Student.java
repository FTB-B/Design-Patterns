package courseplanner.planner;
import courseplanner.util.FileProcessor;
import java.util.ArrayList;
import courseplanner.state.CoursePlannerStateI;
import courseplanner.util.Results;
import courseplanner.util.StdoutDisplayInterface;
import courseplanner.util.FileDisplayInterface;

/**
 * @author Fatemeh Tahmasbi
 *
 */
public class Student  {

	CoursePlannerStateI stateOne;
    CoursePlannerStateI stateTwo;
	CoursePlannerStateI stateThree;
	CoursePlannerStateI stateFour;
	CoursePlannerStateI stateFive;
	CoursePlannerStateI state;
	FileDisplayInterface printResults;

	
	int semesterNum;
	//static helper hp;

	ArrayList<String> currentSemesterCourses = new ArrayList<String>();
	ArrayList<String> registeredCourses = new ArrayList<String>();
	ArrayList<String> waitedListCourses = new ArrayList<String>();
	ArrayList<String> requestedCourses = new ArrayList<String>();
	int numGroupOneCourse;
	int numGroupTwoCourse;
	int numGroupThreeCourse;
	int numGroupFourCourse;
	int numGroupFiveCourse;
	int stdID;



	public Student(ArrayList<String> requestedCoursesIn, String outputFileNameIn, int stdIDIn)
	{
		stateOne = new stateOne(this);
		stateTwo = new stateTwo(this);
		stateThree = new stateThree(this);
		stateFour = new stateFour(this);
		stateFive = new stateFive(this);
		printResults = new Results(outputFileNameIn);
		requestedCourses = requestedCoursesIn;
		stdID = stdIDIn;


		numGroupOneCourse = 0;
		numGroupTwoCourse = 0;
		numGroupThreeCourse = 0;
		numGroupFourCourse = 0;
		numGroupFiveCourse = 0;
		semesterNum = 1;


		state = stateOne;
		System.out.println("In the student constructor");
	}
	//functions for getting the ArrayLists
	public ArrayList<String> getRequestedCourses()
	{
		return requestedCourses;
	}
	public ArrayList<String> getRegisteredCourses()
	{
		return registeredCourses;
	}
	public ArrayList<String> getWaitedListCourses()
	{
		return waitedListCourses;
	}
	public ArrayList<String> getCurrentSemCourses()
	{
		return currentSemesterCourses;
	}


	public void setRequestedCourses(ArrayList<String> requestedCoursesIn)
	{
		requestedCourses = requestedCoursesIn;
	}
	public void setRegisteredCourses(ArrayList<String> registeredCoursesIn)
	{
		registeredCourses = registeredCoursesIn;
	}
	public void setWaitedListCourses(ArrayList<String> waitedListCoursesIn)
	{
		waitedListCourses = waitedListCoursesIn;
	}
	public void setCurrentSemCourses(ArrayList<String> currentSemesterCoursesIn)
	{
		currentSemesterCourses = currentSemesterCoursesIn;
	}

	
	// this function check the requested courses and 
    public  void registerCourse()
    {
    	
		// a loop over the requestedCourseList until there is no course or the student can graduate
		while(requestedCourses.size()>0 || waitedListCourses.size()>0 )
		{

		    if(isGraduate() == true)
		    {
		    	break;
		    }
		    // check the number of courses can be taken by the student in the current semester
		    /*
		    System.out.println("####################################################################################");
		    System.out.println("In student registerCourse function");
		    System.out.println("The semseter number is: " + semesterNum);
		    */

		   if(currentSemesterCourses.size() < 3)
		    	state.registerCourse();
		    else
		    {
		    	semesterNum++;
		    	currentSemesterCourses.clear();
		    	state.registerCourse();
		    }
		}
		if(isGraduate() == true)
		{

			System.out.println("The student can graduate");
			System.out.println("The number of courses the student took was: " + registeredCourses.size());
			System.out.println("The semester is : " + semesterNum);
			System.out.println("The state number is: "+ state.getStateNumber());
			// preparing the text to print in the out put file
			String resultText = Integer.toString(stdID);
			resultText += ": ";
			for(int i = 0; i<registeredCourses.size();i++)
			{
				resultText += registeredCourses.get(i);
				resultText += " ";

			}
			resultText += "--";
			resultText += " ";
			resultText += Integer.toString(semesterNum);
			resultText += " ";
			resultText += Integer.toString(state.getStateNumber());
			printResults.writeResult(resultText);
            

		}
		else
		{
			String resultText = Integer.toString(stdID);
			resultText += ": ";
			for(int i = 0; i<registeredCourses.size();i++)
			{
				resultText += registeredCourses.get(i);
				resultText += " ";

			}
			resultText += "--";
			resultText += " ";
			resultText += Integer.toString(semesterNum);
			resultText += " ";
			resultText += Integer.toString(0);
			printResults.writeResult(resultText);

		}


    	
      return ;
    	


    }
    public void sendError()
    {
    	//System.out.println("The student can't register for any course and can't graduate");
    	String resultText = Integer.toString(stdID);
    	resultText += ": ";
		for(int i = 0; i<registeredCourses.size();i++)
		{
			resultText += registeredCourses.get(i);
			resultText += " ";
		}
		resultText += "--";
		resultText += " ";
		resultText += Integer.toString(semesterNum);
		resultText += " ";
		resultText += Integer.toString(0); 
		resultText += " ";
		printResults.writeResult(resultText);
    	System.exit(1);
    }
    public  boolean isGraduate()
    {
    	
    	if(numGroupOneCourse>=2 && numGroupTwoCourse>=2 && numGroupThreeCourse >=2 && numGroupFourCourse>=2 && numGroupFiveCourse>=2)
    	{
    		// then the student can graduate
    		return true;
    	}
    	else
    		return false;

    }


	int checkState()
	{
		// count the number of course from each group in the registered courses list.
		System.out.println("Student checkState: ");
		int[] groupsNum = new int[5];
		groupsNum[0] = numGroupOneCourse;
		groupsNum[1] = numGroupTwoCourse;
		groupsNum[2] = numGroupThreeCourse;
		groupsNum[3] = numGroupFourCourse;
		groupsNum[4] = numGroupFiveCourse;

		for(int i = 0; i <groupsNum.length; i++)
		{
			System.out.println(groupsNum[i]);
		}


		int maxAt = 0;

		for (int i = 0; i < groupsNum.length; i++) 
		{
    		maxAt = groupsNum[i] > groupsNum[maxAt] ? i : maxAt;
		}

		System.out.print(" The state is " + (maxAt+1));

		return maxAt;

	}
	public void updateGroupCourseNumbers(int groupIn)
	{
		System.out.println("Student in updating group numbers " + groupIn);
		if(groupIn == 1)
			IncGroupOneNum();
		else if(groupIn == 2)
			IncGroupTwoNum();
		else if(groupIn == 3)
			IncGroupThreeNum();
		else if(groupIn == 4)
			IncGroupFourNum();
		else
			IncGroupFiveNum();


	}
	public void IncGroupOneNum()
	{
		numGroupOneCourse++;

	}
	public void IncGroupTwoNum()
	{
		numGroupTwoCourse++;

	}
	public void IncGroupThreeNum()
	{
		numGroupThreeCourse++;

	}
	public void IncGroupFourNum()
	{
		numGroupFourCourse++;

	}
	public void IncGroupFiveNum()
	{
		numGroupFiveCourse++;

	}
	public int checkCourseGroup(String courseIn)
	{
		if(courseIn.equals("A") || courseIn.equals("B") || courseIn.equals("C") || courseIn.equals("D"))
			return 1;
		else if(courseIn.equals("E") || courseIn.equals("F") || courseIn.equals("G") || courseIn.equals("H"))
			return 2;
		else if(courseIn.equals("I") || courseIn.equals("J") || courseIn.equals("K") || courseIn.equals("L"))
			return 3;
		else if(courseIn.equals("M") || courseIn.equals("N") || courseIn.equals("O") || courseIn.equals("P"))
			return 4;
		else
			return 5;
	}

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






	
}
