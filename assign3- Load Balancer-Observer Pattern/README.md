# CSX42: Assignment 3
## Name: Fatemeh Tahmasbi

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in courseplanner/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile dynamicLoadBalancer/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile dynamicLoadBalancer/src/build.xml all
 
			

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile dynamicLoadBalancer/src/build.xml run -Darg0="input.txt" -Darg1="output.txt" 

Note: The input files should be placed in the courseRegistration folder next to the src folder.


-----------------------------------------------------------------------
## Description: 
This code gets two first files as inputs. The first one is the "input.txt" which contains the courses request by a student and the second one is the "output.txt" which contain the result of the course registerations and the status of the student.
The program contains different Classes and Interfaces. 
CoursePlannerStateI: which is an interface that contain the definition of the functions that is common between different states.
Student: is the context that contain different states based on the number of course of each group.
StateX (X is between One-Five): is a class that implements the functions in the interface. 
FileProcess.java contains a method to read the input file and returns an ArrayList which contains the requested courses.


Why ArrayList: ArrayList is chosen because it is easy to expand and we can easily add and remove items to and from it. Also, because the number of requested courses wouldn't be too many then even if the number of requested course be more than the list capacity then it only grows 50%.

register Function:
in this function the waitList is being checked first. becuase it contains the courses that have been requested earlier and the couldn't be assigned to the students. The data structure used for the waitList is ArrayList for the same reason that is explained above. If the function could assign a course from the waitList then the checkStatus() function is called to see the change for the states and then the new state is being set by calling the setState() function. if the course can't be assigned in the waitList then the system check the courses in the requestedCoursesList. The Algorithm to check and assign the courses in the two lists including waitList and requestedCoursesList is FIFO. but as mentioned the waitList has more priority over the requestedCourseList. 

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: [10/8/2019]


