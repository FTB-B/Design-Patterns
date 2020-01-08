package troubleshootsearch.driver;
import troubleshootsearch.util.FileProcessor;
//import troubleshootsearch.util.Results;
//import troubleshootsearch.util.StdoutDisplayInterface;
//import troubleshootsearch.util.FileDisplayInterface;
import java.util.ArrayList;
import java.util.List;
import troubleshootsearch.ElementVisitor.ExactMatchVisitor;
import troubleshootsearch.ElementVisitor.visitorI;
import troubleshootsearch.ElementVisitor.MyArrayList;
import troubleshootsearch.ElementVisitor.*;
import troubleshootsearch.util.FileDisplayInterface;
import troubleshootsearch.util.Results;

/**
 * @author John Doe
 *
 */
public class Driver {


	public static void main(String[] args) {

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		

		if (args.length != 4 || args[0].equals("${arg0}") || args[1].equals("${arg1}") || args[2].equals("${arg2}") || args[3].equals("${arg3}")){
				
			System.err.println("Error: Incorrect number of arguments. Program accepts 4 argumnets.");
			//System.exit(1);
		}
		if(args[3].equals("${arg3}"))
		{
			//StdoutDisplayInterface writeStdoutInt = new Results();
			//writeStdoutInt.writeStdout("Please identify the out put file");
			System.err.println("Please identify the out put file");
			System.exit(1);
		}
		
		System.out.println("Hello World! Lets get started with the assignment 4");
        
        
		

		
        
	    // reading the input file student request list
	    FileProcessor readInputFiles = new FileProcessor();  
	    //System.out.println("Here1");  
	    ArrayList<String> techInfoLines = new ArrayList<String>();
	    
	    ArrayList<String> userInputLines = new ArrayList<String>();

	    ArrayList<String> synonymsLines = new ArrayList<String>();
	    
	   
	    techInfoLines = readInputFiles.readInputFile(args[0]);
	    
	    userInputLines = readInputFiles.readInputFile(args[1]);

	    synonymsLines = readInputFiles.readInputFile(args[2]);
	   
	    String printResutl = "";


	    //define and make the elements
	    ElementI myList = new MyArrayList(techInfoLines);
	    ElementI myTree = new MyTree(techInfoLines);


	    FileDisplayInterface result;
	    result = new Results(args[3]);


	    

	   
         
	    ExactMatchVisitor exactMVisitor = new ExactMatchVisitor(); 
	    SemanticMatchVisitor semanticMVisitor = new SemanticMatchVisitor(synonymsLines); 
	    NaiveStemmingVisitor stemmingMVisitor = new NaiveStemmingVisitor(); 
	    for(int i = 0; i< userInputLines.size(); i++)
	    {
	    	result.writeResult("user input - " + userInputLines.get(i));
			result.writeResult("Exact Match");
			result.writeResult("----------------------");
	    	printResutl = myList.accept(exactMVisitor, userInputLines.get(i));
	    	result.writeResult(printResutl);

	    	result.writeResult("Semantic Match");
			result.writeResult("----------------------");
	    	printResutl = myList.accept(semanticMVisitor, userInputLines.get(i));
			result.writeResult(printResutl);

			result.writeResult("Naive Stemming Match");
			result.writeResult("----------------------");
	    	printResutl = myTree.accept(stemmingMVisitor, userInputLines.get(i));
	    	result.writeResult(printResutl);

	    }
	   



	    
      
	}
}
