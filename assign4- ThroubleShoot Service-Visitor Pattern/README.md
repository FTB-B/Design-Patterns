# CSX42: Assignment 4
## Name: Fatemeh Tahmasbi

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in troubleShootSearch/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile troubleShootSearch/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile troubleShootSearch/src/build.xml all
 
			

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile troubleShootSearch/src/build.xml run -Darg0="technicalInfo.txt" -Darg1="userInput.txt" -Darg2="synonyms.txt" -Darg3="output.txt" 

Note: The input files should be placed in the courseRegistration folder next to the src folder.


-----------------------------------------------------------------------
## Description: 
This code gets three first files as inputs. The first one is the "technicalInfo.txt" which contains thethechnical inforamtions which should be stored in two different data structure such as ArrayList and Tree. The second input the "userInput.txt" which contains the user's problem. This file is being processed and being stored in an arraylist. The third file is "synosyms.txt" which also being stored in an arraylist and being used for the semantic match. The "output.txt" which contain the result of the different matching.
The program contains different Classes and Interfaces. 
ElemntI: which is an interface that contain the definition of the functions that is common between elements (MyArrayList and MyTree)
visitorI: which is an interface that contain the definition of the functions that is common between visitors including ExactMatchVisitor, SemanticMatchVisitor, NaiveStemmingVisistor

FileProcess.java contains a method to read the input file and returns an ArrayList which contains the input lines.


Why ArrayList: ArrayList is chosen because it is easy to expand and we can easily add and remove items to and from it. Also, because the number of requested courses wouldn't be too many then even if the number of requested course be more than the list capacity then it only grows 50%.

 For stemmingMatch the levenshtein-distance algorithm is being used and the code is borrowed from https://www.baeldung.com/java-levenshtein-distance

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: [11/17/2019]


