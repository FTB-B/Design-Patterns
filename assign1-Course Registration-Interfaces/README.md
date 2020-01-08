# CSX42: Assignment 1
## Name: Fatemeh Tahmasbi

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in coursesRegistration/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile coursesRegistration/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile coursesRegistration/src/build.xml all 
			

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile coursesRegistration/src/build.xml run -Darg0="student_coursePrefs.txt" -Darg1="courseInfo.txt" -Darg2="registration_results.txt" 

Note: The input files should be placed in the courseRegistration folder next to the src folder.


-----------------------------------------------------------------------
## Description: 
This code gets two first files as inputs. The first one is the "studetn_coursePref.txt" and the second one is the "courseInfo.txt" which shows the information about the courses. The third argument is the output file. 
The program contains different Classes and Interfaces. 
Student: which save the students informations including studentID, student_Level, requestedCourses, and courseRegisteredList.
Course: which save the courses information including courseCapacity, courseName, courseTiming. This class also have a method for registering a student in the corresponding class.
FileProcess.java contains two methods including readStudentRequestCourseList()eadCourseInfo.  readStudentRequestCourseList()takes the name "studetn_coursePref.txt" as input and make an ArrayList of students information and their requested courses. First it read the file one line by one line and segments teach line based on its format and gets the studentID, requestedCourses and StudentLevel.  readCourseInfo method gets the "courseInfo.txt" as input and create an ArrayList of courses. )

Why ArrayList: ArrayList is chosen because it is easy to expand and we can easily add the new items in the ArrayList and iterate through its items.

Register: is used to register the students in their requested courses. This class contains a method called registerStudentsCourses which gets three inputs including two arraylists containing the students and the courses and the third argument is the name of the output file. A HashMap is created in the method to check easily if a requested course by a student is in the list of courses or not. 

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: [9/18/2019]


