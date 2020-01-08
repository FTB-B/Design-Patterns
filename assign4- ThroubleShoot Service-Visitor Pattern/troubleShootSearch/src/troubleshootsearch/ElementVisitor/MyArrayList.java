package troubleshootsearch.ElementVisitor;
import java.util.ArrayList; 
//

// this class is an element
// each element has a method accept to accept different visitors
public class MyArrayList implements ElementI
{
	ArrayList<String> userInputsArrayList;

	public MyArrayList(ArrayList<String> arrayListIn)
	{
		userInputsArrayList = arrayListIn;
	}
	public ArrayList<String> getMyList()
	{
		return userInputsArrayList;
	}
	public String accept(ExactMatchVisitor exactMatchVisitorIn, String userWordIn)
	{
		return (exactMatchVisitorIn.visit(this, userWordIn));

	}

	public void accept(NaiveStemmingVisitor naiveVisitorIn, String wordIn)
	{
		naiveVisitorIn.visit(this, wordIn);

	}
    public String accept(SemanticMatchVisitor semanticMatchVisitor, String userWordIn)
    {
    	return(semanticMatchVisitor.visit(this, userWordIn));

    }
	
}
