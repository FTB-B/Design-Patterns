package troubleshootsearch.ElementVisitor;
import java.util.ArrayList; 

public class MyNode
{
	private String word;
	// Line numbers of the lines in the input file in which the word was present.
	// Feel free to use a collection other than List.
	private ArrayList<Integer> lineNumbersFoundIn;

	MyNode left, right; 
	
	// rest of the code.
	public MyNode(String wordIn, int lineIn) 
    { 
        if(lineNumbersFoundIn == null)
        	lineNumbersFoundIn = new ArrayList<Integer>();
        
        word =  wordIn;
        lineNumbersFoundIn.add(lineIn);
        left = right = null; 
    } 

    public String getWord()
    {
    	return word;
    }
    public ArrayList<Integer> getLineNumbers()
    {
    	return lineNumbersFoundIn;
    }
    public void addLineNumbers(int lineIn)
    {
    	lineNumbersFoundIn.add(lineIn);
    }
}
