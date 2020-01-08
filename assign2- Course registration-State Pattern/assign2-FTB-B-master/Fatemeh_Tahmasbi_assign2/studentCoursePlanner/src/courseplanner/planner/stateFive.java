package courseplanner.planner;
import java.util.ArrayList;
import courseplanner.state.*;
import java.util.Collections;



public class stateFive implements CoursePlannerStateI
{
    
	ArrayList<String> waitedList = new ArrayList<String>();
	ArrayList<String> registeredList = new ArrayList<String>();
	ArrayList<String> courseList = new  ArrayList<String>();
	ArrayList<String> requestedCourseList = new  ArrayList<String>();
	ArrayList<String> currentSemCourses = new ArrayList<String>();
	int numRegisteredCourses = 0;

	Student student;

    public stateFive(Student studentIn)
	{

		student = studentIn;

	}

	public void registerCourse()
	{
		//at first check the waitedList
		//helper hp = new helper();
		//hp.registerCourse();
		//check the number of courses the student can take in this semester
		//check the graduate requirements
        System.out.println("In State Five register course");


        registeredList = student.getRegisteredCourses();
        printRegisteredList(registeredList);   

        waitedList = student.getWaitedListCourses();
        printWaitedList(waitedList);

		requestedCourseList = student.getRequestedCourses();
		printRequestedList(requestedCourseList);


	    currentSemCourses = student.getCurrentSemCourses();
	    printCurrentSemList(currentSemCourses);
       

   
        //     
		//int eligNumCourse = numberCourseTakenSem(registeredList);
		int numCourseTaken = 0;
		boolean checkWaitList = false;
		boolean courseTaken = false;
		String recentCourse = "";
		

        //first check the waitedlist
        //while(courseTaken == false)
        //{
        	if(waitedList.size()>0)
        	{
        		//there is courses in the waited list
        		//check to see if their pre-req is met
        		System.out.println("State5 on register function 1111111");
        		checkWaitList = true;
        		for(int i = 0; i<waitedList.size(); i++)
        		{
        			System.out.println("State5: waitlist loop, waited item: " + waitedList.get(i));
        			System.out.println("State5: waitlist loop, the pre req course for waited item: " + checkPreRequisitCourse(waitedList.get(i)));

        			if(registeredList.contains(checkPreRequisitCourse(waitedList.get(i)))  && !currentSemCourses.contains(checkPreRequisitCourse(waitedList.get(i))))
        			{
        				//the student has taken the pre-req course
        				//so the course can be added to the current semester courses
        				System.out.println("HERERERERERRERERERRERRERERER");
        				currentSemCourses.add(waitedList.get(i));
        				recentCourse = waitedList.get(i);
        				waitedList.remove(waitedList.get(i));
        				
        				numCourseTaken++;
        				courseTaken = true;
        				break;

        				/*if(currentSemCourses.size()==eligNumCourse) 
        			    //the student can not take more courses this semeste
        				break;
        				}*/
          			}	
       			}

            }
            if(waitedList.size()<0 || !courseTaken)
       		{
       			System.out.println("State5 on register function 2222222");
       			//there is no course in the waited list or we can't assign more courses from the waited list to the student
       			for(int i = 0 ; i< requestedCourseList.size(); i++)
            	{
       				System.out.println("State5: requestList loop, requestd item: " + requestedCourseList.get(i));
       				System.out.println("State5: requestList loop, the pre req course for requested item: " + checkPreRequisitCourse(requestedCourseList.get(i)));
       				if(checkPreRequisitCourse(requestedCourseList.get(i)).equals(""))
       				{
       					// the course doesn't have any pre-req
       					currentSemCourses.add(requestedCourseList.get(i));
       					recentCourse = requestedCourseList.get(i);
       					requestedCourseList.remove(requestedCourseList.get(i));
       					
       					numCourseTaken++;
       					courseTaken = true;
       					break;
        			}
       				else if(registeredList.contains(checkPreRequisitCourse(requestedCourseList.get(i))) && !currentSemCourses.contains(checkPreRequisitCourse(requestedCourseList.get(i))))
       				{
       					System.out.println("State5: requestedlist, No pre-requisit, the current semestercontains pre-req? "+ currentSemCourses.contains(checkPreRequisitCourse(requestedCourseList.get(i))));
       					// the course has prereq but the student has already taken it.
       					currentSemCourses.add(requestedCourseList.get(i));
       					recentCourse = requestedCourseList.get(i);
       					requestedCourseList.remove(requestedCourseList.get(i));

       					numCourseTaken++;
       					courseTaken = true;
       					break;
       				}
       				else
       				{
       					System.out.println("State5: the student should wait for the course: " + requestedCourseList.get(i));
       					// the student can't take the course
       					waitedList.add(requestedCourseList.get(i));
       					//requestedCoursesIn.remove(i);
       					//requestedCourseList.remove(requestedCourseList.get(i));
        			}
       			}
       		}
        //}
        
       
        // adding the courses that have been taken this semester to the registered list
        for(int i = 0; i< currentSemCourses.size(); i++)
        {
        	if(!registeredList.contains(currentSemCourses.get(i)))
        		registeredList.add(currentSemCourses.get(i));

        }
        for(int i = 0; i< waitedList.size(); i++)
        {
        	if(requestedCourseList.contains(waitedList.get(i)))
        		requestedCourseList.remove(waitedList.get(i));

        }

        System.out.println("State5: After checking everything: the result for this round: ");

        printRegisteredList(registeredList);        
        printWaitedList(waitedList);	
		printRequestedList(requestedCourseList);	    
	    printCurrentSemList(currentSemCourses);

      student.setCurrentSemCourses(currentSemCourses);
      student.setWaitedListCourses(waitedList);
      student.setRegisteredCourses(registeredList);
      student.setRequestedCourses(requestedCourseList);


       if(courseTaken == true)
       {
       	  int courseGroup = student.checkCourseGroup(recentCourse);
       	  System.out.println("State5: the taken course " + recentCourse + " and its group is: " + courseGroup );
       	  student.updateGroupCourseNumbers(courseGroup);
       	  int stateNum = student.checkState();
       	  System.out.println("State5: the new state is: "+ (stateNum+1));

       	  if(stateNum == 0)
       	  	student.setState(student.getStateOne());
       	  else if(stateNum == 1)
       	  	student.setState(student.getStateTwo());
       	  else if(stateNum == 2)
       	  	student.setState(student.getStateThree());
       	  else if(stateNum == 3)
       	  	student.setState(student.getStateFour());
       	  else if(stateNum == 4)
       	  	student.setState(student.getStateFive());

       }
       else
       {
       	 student.sendError();

       }
        return;




		
	}
	public void printRegisteredList(ArrayList<String> registerCoursesIn)
	{
		System.out.println("State 5: The registered Courses: ");
		if(registerCoursesIn.size() > 0)
		{
			for(int i = 0; i < registerCoursesIn.size(); i++)
			{
				System.out.print(registerCoursesIn.get(i) + ", ");
			}
		}
		else
		{
			System.out.print("");
		}

	}
	public void printWaitedList(ArrayList<String> waitedListIn)
	{
		System.out.println("State 5: The waited List: ");
		if(waitedListIn.size() > 0)
		{
			for(int i = 0; i < waitedListIn.size(); i++)
			{
				System.out.print(waitedListIn.get(i) + ", ");
			}
		}
		else
		{
			System.out.print("");
		}

	}
	public void printRequestedList(ArrayList<String> requestedListIn)
	{
		System.out.println("State 5: The requested List: ");
		if(requestedListIn.size() > 0)
		{
			for(int i = 0; i < requestedListIn.size(); i++)
			{
				System.out.print(requestedListIn.get(i) + ", ");
			}
		}
		else
		{
			System.out.print("");
		}

	}

	public void printCurrentSemList(ArrayList<String> currenSemesterListIn)
	{
		System.out.println("State 5: The currentSemCourses: ");
		if(currenSemesterListIn.size() > 0)
		{
			for(int i = 0; i < currenSemesterListIn.size(); i++)
			{
				System.out.print(currenSemesterListIn.get(i) + ", ");
			}
		}
		else
		{
			System.out.print("");
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

	public int CourseGroup(String courseIn)
	{
		if(courseIn.equals("A") || courseIn.equals("B") || courseIn.equals("C") || courseIn.equals("D"))
			return 1;
		else if (courseIn.equals("E") || courseIn.equals("F") || courseIn.equals("G") || courseIn.equals("H"))
			return 2;
		else if (courseIn.equals("I") || courseIn.equals("G") || courseIn.equals("K") || courseIn.equals("L"))
			return 3;
		else if (courseIn.equals("M") || courseIn.equals("N") || courseIn.equals("O") || courseIn.equals("P"))
			return 4;
		else 
			return 5;



	}

	public int getStateNumber()
	{
		return 5;
	}
	
	
}
