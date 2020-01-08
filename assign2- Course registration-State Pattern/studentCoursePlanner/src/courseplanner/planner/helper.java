package courseplanner.planner;
import java.util.ArrayList;
import courseplanner.state.*;
import java.util.Collections;



public class helper
{
    
	static ArrayList<String> waitedList = new ArrayList<String>();
	static ArrayList<String> registeredList = new ArrayList<String>();
	static ArrayList<String> courseList = new  ArrayList<String>();
	static ArrayList<String> requestedCourses = new ArrayList<String>();
	int numRegisteredCourses = 0;
	

    public helper()
	{
		//requestedCourses = requestedCoursesIn;
		
	}

	public ArrayList<String> getWaitedList()
	{
		return courseList;
	}
	public ArrayList<String> getcourseList()
	{
		return waitedList;
	}

	public void registerCourse()
	{
		//at first check the waitedList

		if(waitedList.size()!=0)
		{
			//means that there are courses in the waited list
			//check to see if the prerequisted course has been taken before
			//Collections.sort(waitedList);
			for(int i = 0; i < waitedList.size(); i++)
			{
				if(registeredList.contains(checkPreRequisitCourse(waitedList.get(i))))
				{
					// if the student has taken the pre requisit course then he can take the course in the waited list
					registeredList.add(waitedList.get(i));
					waitedList.remove(waitedList.get(i));

					break;
					//return;

				}
			}


		}
		else
		{
			//the waited list is empty
			//first check for the pre req course
			//if(checkPreRequisitCourse)

		}
	}
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
		return registeredList.size();
	}
	
	
}
