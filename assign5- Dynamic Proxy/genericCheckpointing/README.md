# CSX42: Assignment 5
## Name: Fatemeh Tahmasbi

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in genericCheckpointing/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile genericCheckpointing/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile genericCheckpointing/src/build.xml all
 
			

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile genericCheckpointing/src/build.xml run -Darg0="MyALlTypes2.txt" -Darg1="AllUserTypes.txt"


-----------------------------------------------------------------------
## Description: 
The program gets two input arguments. the first one is the input file which is the file that the different objects which their field are represented in XML format while the name of output file which the results of serilization is written in it. First the program Deserilize the input files object using the proxy and invocation handler. in the program an arraylist of the objects returns. Then the program goes trough this arraylist and serilize them in the output file with the XML format.

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: [12/4/2019]


