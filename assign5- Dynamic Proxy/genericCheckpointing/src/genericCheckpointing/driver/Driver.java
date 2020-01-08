
package genericCheckpointing.driver;

import genericCheckpointing.util.ProxyCreator;
import genericCheckpointing.server.StoreI;
import genericCheckpointing.server.RestoreI;
import genericCheckpointing.server.StoreRestoreI;
import java.lang.reflect.InvocationHandler;
import genericCheckpointing.util.StoreRestoreHandler;
import genericCheckpointing.util.SerializableObject;
import java.util.ArrayList;

// import the other types used in this file

public class Driver {
    
    public static void main(String[] args) 
    {
	
		// FIXME: read the value of checkpointFile from the command line 
    	// read the	filename
    	if (args.length != 2 || args[0].equals("${arg0}") || args[1].equals("${arg1}") ){
				
			System.err.println("Error: Incorrect number of arguments. Program accepts 2 argumnets.");
			//System.exit(1);
		}
		if(args[1].equals("${arg1}"))
		{
			//StdoutDisplayInterface writeStdoutInt = new Results();
			//writeStdoutInt.writeStdout("Please identify the out put file");
			System.err.println("Please identify the out put file");
			System.exit(1);
		}
		
		System.out.println("Hello World! Lets get started with the assignment5");

    	String inputFile = args[0];	
    	String outputFile = args[1];
	
		ProxyCreator pc = new ProxyCreator();
	
		// create an instance of StoreRestoreHandler (which implements
		// the InvocationHandler
		InvocationHandler storeRestoreHandler = new StoreRestoreHandler();
	
		// create a proxy
		StoreRestoreI cpointRef = (StoreRestoreI) pc.createProxy(
								 new Class[] {
								     StoreI.class, RestoreI.class
								 }, 
								 storeRestoreHandler
								 );
		
	
	
		ArrayList<SerializableObject> myRecord = new ArrayList<>();

    	myRecord = ((RestoreI) cpointRef).readObj(inputFile);
    	//System.out.println("WWWWWWWWWWWWWWWW " + myRecord.size());
    
    	int NUM_OF_OBJECTS = myRecord.size(); 
		for (int i=0; i<NUM_OF_OBJECTS; i++) 
		{
	    	SerializableObject recObject = myRecord.get(i);
	    	//System.out.println("RECORD: " + recObject.toString());
	    	((StoreI) cpointRef).writeObj(recObject,"XML", outputFile);
	    	
		}
    
    }
}
