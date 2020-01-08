package troubleshootsearch.ElementVisitor;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;


public class NaiveStemmingVisitor implements visitorI
{
	
    public NaiveStemmingVisitor()
	{
		
	}

	// search MyArrayList Element
	public String visit(MyArrayList myListIn, String wordIn )
	{
		return "";
	}
    public String visit(MyTree myTreeIn, String wordIn)
    {
    	MyTree technoInfoTree = myTreeIn;
       	int countMatch = 1;
       	boolean noMatch = true;
       	
	   	String stemMatchResult = "";

	   	int i = wordIn.indexOf(' ');
	   	String firstWord = wordIn.substring(0, i);
	   	//System.out.println("*******************************************************88");
	   	//System.out.println("firstWord: " + firstWord);
	   	MyNode root = technoInfoTree.getRoot();

	   	String resultS = searchTree(root, firstWord);
	   	if(resultS =="")
	   		stemMatchResult = "No Naive Stemming Match\n";
	   		
	   	else
	   	{
	   	   	String[] r = resultS.split(",");
	   	   	String printResult = "WordCout = "+ r.length + "\nLine Numbers = " ;
	   	   	for(int j = 0; j< r.length; j++)
	   	   		printResult += r[j] + ",";

            printResult +="\n";
            stemMatchResult = printResult;
	   	   	
	   	}

	   	return stemMatchResult;
    	
    }

    public String searchTree(MyNode searchNode, String wordIn)
    {
    	String results = "";
    	//MyNode root = technoInfoTreeIn.getRoot();

    	/*if(root == null)
    	{
    		return "No stemming Match.";
    	}*/
    	//else
    	//{
    		//MyNode searchNode = root;
    		if(searchNode!= null)
    		{
    			int cmpResult = searchNode.getWord().toLowerCase().compareTo(wordIn.toLowerCase());
    			//System.out.println("Node's value is: "+ searchNode.getWord() + " and the wordIn is: " + wordIn + " and cmpResult: " + cmpResult);
    			int distance = calculate(searchNode.getWord().toLowerCase(), wordIn.toLowerCase());
    			//System.out.println("Node's value is: "+ searchNode.getWord() + " and the wordIn is: " + wordIn + " and distance: " + distance);
    			if(Math.abs(cmpResult) == Math.abs(distance) && cmpResult!=0)
				{
					//the same words so add the line number

					ArrayList<Integer> lines = searchNode.getLineNumbers();
					String l = "";
					for(int i = 0; i < lines.size(); i++)
					{
						l += lines.get(i)+1+",";
					}
					results =  l +  searchTree(searchNode.left, wordIn) + searchTree(searchNode.right, wordIn) ;
					return results;
				}
				else if(cmpResult <0)
				{
					//current item < arrWords[i] : so the arrWords[i] should go to the right branch
					//searchNode = searchNode.right;
					return(searchTree(searchNode.right, wordIn));
				}
				else if(cmpResult >0)
				{
					//current item < arrWords[i] : so the arrWords[i] should go to the right branch
					//searchNode = searchNode.left;
					return(searchTree(searchNode.left, wordIn));
				}
    		}
    		//if(searchNode == null)
    		//{
    		//	return "No stemming Match.";
    		//}
    	//}
    	return results;

    }


    // the code has been borrowed from https://www.baeldung.com/java-levenshtein-distance
     public int calculate(String x, String y) {
        if (x.isEmpty()) {
            return y.length();
        }
 
        if (y.isEmpty()) {
            return x.length();
        } 
 
        int substitution = calculate(x.substring(1), y.substring(1)) 
         + costOfSubstitution(x.charAt(0), y.charAt(0));
        int insertion = calculate(x, y.substring(1)) + 1;
        int deletion = calculate(x.substring(1), y) + 1;
 
        return min(substitution, insertion, deletion);
    }
 
    public int costOfSubstitution(char a, char b) {
        return a == b ? 0 : 1;
    }
 
    public  int min(int... numbers) {
        return Arrays.stream(numbers)
          .min().orElse(Integer.MAX_VALUE);
    }
}