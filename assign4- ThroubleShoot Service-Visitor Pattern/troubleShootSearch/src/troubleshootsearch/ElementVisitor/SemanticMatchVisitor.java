package troubleshootsearch.ElementVisitor;
import java.util.ArrayList;


public class SemanticMatchVisitor implements visitorI
{
	// search MyArrayList Element
	ArrayList<String> technoInfoLines;
	ArrayList<String> synonymsInputs;
    public SemanticMatchVisitor(ArrayList<String> synonymsIn)
	{
		technoInfoLines = new ArrayList<String>();
		synonymsInputs = new ArrayList<String>();
		synonymsInputs = synonymsIn;
	

	}


	public String visit(MyArrayList myListIn, String wordIn )
	{

       ArrayList<String> technoInfoLines = myListIn.getMyList();
       int countMatch = 1;
       boolean noMatch = true;
       String sematicMatchResult = "";
       
       String lastWord = wordIn.substring(wordIn.lastIndexOf(" ")+1);

	   ArrayList<String> synonyms = findSynonym(lastWord);

		for(int k = 0; k< synonyms.size(); k++)
		{
			for(int j = 0 ; j< technoInfoLines.size();j++)
	    	{
	    		boolean isFound = technoInfoLines.get(j).toLowerCase().indexOf(synonyms.get(k).toLowerCase()) !=-1? true: false; //true
	    		if(isFound == true)
	    		{
	    			sematicMatchResult += countMatch + "- "  + technoInfoLines.get(j) + "\n";
	    			noMatch = false;
	    		}
    		}
		}
		if(noMatch == true)
		{
			sematicMatchResult = "No Semantic match \n";
		}
      
    return sematicMatchResult;


	}
	
	public ArrayList<String> findSynonym(String wordIn)
	{
		
        
		ArrayList<String> synonyms = new ArrayList<String>();
		for(int i = 0; i< synonymsInputs.size(); i++)
		{
			String synLine = synonymsInputs.get(i);
			synLine = synLine.toLowerCase();
			boolean isFound = synLine.indexOf(wordIn.toLowerCase()) !=-1? true: false; //true
			if(isFound)
			{
				String[] words = synLine.split("=");
				if(words[0].equals(wordIn))
					synonyms.add(words[1]);
				else
					synonyms.add(words[0]);
			}

		}
		return synonyms;
       
	}
    public void visit(MyTree myTreeIn, String wordIn)
    {
    	
    }

}