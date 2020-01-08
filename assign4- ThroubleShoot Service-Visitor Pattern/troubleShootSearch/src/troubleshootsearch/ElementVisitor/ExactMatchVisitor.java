package troubleshootsearch.ElementVisitor;
import java.util.ArrayList;



public class ExactMatchVisitor implements visitorI
{
	// search MyArrayList Element
	ArrayList<String> technoInfoLines;
	ArrayList<String> exacttMatchResults;
	
	public ExactMatchVisitor()
	{
		technoInfoLines = new ArrayList<String>();
		exacttMatchResults = new ArrayList<String>();
		

	}
	public String visit(MyArrayList myListIn, String userWordIn )
	{
		// read the thecnoInfo file and compare each strign in the myListIn to see if they containt it or not

		ArrayList<String> technoInfo = myListIn.getMyList();
		int matchCount = 1;
        boolean noMatch = true;

		String exactMatchResult = "";

	    
	    for(int j = 0 ; j< technoInfo.size();j++)
	    {
	    	boolean isFound = technoInfo.get(j).toLowerCase().indexOf(userWordIn.toLowerCase()) !=-1? true: false; //true
	    	//System.out.println("The techno line is " + technoInfo.get(j).toLowerCase() +  "and isFound: " + isFound);
	    	if(isFound == true)
	    	{
	    		exactMatchResult += matchCount + "- " + technoInfo.get(j) + "\n";
	    		matchCount++;
	    		noMatch = false;
    		}
    	}
    	if(noMatch == true)
    	{
    		exactMatchResult = "No exact match \n";
    		
    	}
   
    return exactMatchResult;

	}
    public String visit(MyTree myTreeIn, String WordIn)
    {
    	return "";

    }

}