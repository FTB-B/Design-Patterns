package loadbalancer.driver;
import loadbalancer.util.FileProcessor;
//import courseplanner.util.Results;
//import courseplanner.util.StdoutDisplayInterface;
//import courseplanner.util.FileDisplayInterface;
import java.util.ArrayList;
import java.util.List;
import loadbalancer.subject.Cluster;



/**
 * @author Fatemeh Tahmasbi
 *
 */
public class Driver {


	public static void main(String[] args) {

		/*
		 * As the build.xml specifies the arguments as argX, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		

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
		
		System.out.println("Hello World! Lets get started with the assignment3");

		

		

	    // reading the input file student request list
	    FileProcessor readInputFiles = new FileProcessor();  
	    //System.out.println("Here1");  
	    ArrayList<String> loadBalancerInputs = new ArrayList<String>();
	    //ArrayList<String> studentsRequestCoursesList = new ArrayList<String>();
	    loadBalancerInputs = readInputFiles.readLoadBalancerInput(args[0]);

	    //List<String> requestCoursesList = studentsRequestCoursesListStdId.subList(2, studentsRequestCoursesListStdId.size()); 
	    //ArrayList<String> studentsRequestCoursesList = new ArrayList<>(requestCoursesList.size());
        //studentsRequestCoursesList.addAll(requestCoursesList);
        Cluster cluster = new Cluster();

        int i = 0;
        while(i< loadBalancerInputs.size())
        {
        	if(loadBalancerInputs.get(i).equals("CLUSTER_OP__SCALE_UP"))
        	{
        		i+=1;
        		String hostName = loadBalancerInputs.get(i);
        		cluster.registerHost(hostName);
        	}
        	else if(loadBalancerInputs.get(i).equals("SERVICE_OP__ADD_SERVICE"))
        	{
        		i+=1;
        		String serviceName = loadBalancerInputs.get(i);
        		i+=1;
        		String serviceUrl = loadBalancerInputs.get(i);
        		i+=1;
        		String hosts = loadBalancerInputs.get(i);

        		String[] hs = hosts.split("\\,"); 

        		cluster.registerService(serviceName, serviceUrl, hs);
        	}
        	else if(loadBalancerInputs.get(i).equals("SERVICE_OP__REMOVE_SERVICE"))
        	{
                i+=1;
        		String serviceName = loadBalancerInputs.get(i);
        		cluster.removeService(serviceName);

        	}
        	else if(loadBalancerInputs.get(i).equals("SERVICE_OP__ADD_INSTANCE"))
        	{
                i+=1;
        		String serviceName = loadBalancerInputs.get(i);
        		cluster.removeService(serviceName);

        	}
        	i+=1;
        }

	    
        /*
	    for(int i = 0; i<studentsRequestCoursesList.size(); i++)
	    	System.out.println(studentsRequestCoursesList.get(i));
	    	*/
        
	    // create an instance of the context
	    //Student student = new Student(studentsRequestCoursesList, args[1], Integer.parseInt(studentsRequestCoursesListStdId.get(0)));

	    //student.registerCourse();

	}
}