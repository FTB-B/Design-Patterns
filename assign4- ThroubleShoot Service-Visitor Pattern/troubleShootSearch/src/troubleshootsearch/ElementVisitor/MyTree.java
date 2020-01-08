package troubleshootsearch.ElementVisitor;
import java.util.ArrayList; 


// this class is an element
// each element has a method accept to accept different visitors




public class MyTree implements ElementI
{
	MyNode root;
	ArrayList<String> lines;

	public MyTree(ArrayList<String> linesIn)
	{
		lines = new ArrayList<String>();

		lines = linesIn;
		root = null;
		//System.out.println("in Tree constructor");
		buildTree();
	}
	public MyTree()
	{
		root = null;
	}

	public void buildTree()
	{
		ArrayList<String> words =  new ArrayList<String>();
		String l="";
		//System.out.println("in build Tree function");
		for(int i = 0; i<lines.size(); i++)
		{
			//System.out.println(lines.get(i));
			if(lines.get(i).contains("."))
				l = lines.get(i).substring(0, lines.get(i).length() - 1);
			String[] arrWords = l.split(" "); 
			for(int j = 0; j< arrWords.length; j++)
			{
				//System.out.print(arrWords[j] + " ");
				insertNode(arrWords[j].toLowerCase(), i);
				
			}

		}

	}
	public boolean isEmpty()
	{
		if(root == null)
			return true;
		else
			return false;
	}
	public MyNode getRoot()
	{
		return root;
	}
	public void insertNode(String wordIn, int lineIn)
	{
		if(isEmpty())
				{
					//System.out.println("In insertNode function. root is null");
					root = new MyNode(wordIn.toLowerCase(),lineIn);
					return;
				}
				else
				{
					//System.out.println("In insertNode function.");
					MyNode searchWord;
					searchWord = root;
					while(true)
					{
						//System.out.println("in loop");
						int cmpResult = searchWord.getWord().toLowerCase().compareTo(wordIn.toLowerCase());
						//System.out.println("the searchword is: " + searchWord.getWord() + " The wordIn: " + wordIn +" cmpResult: " + cmpResult);
						if(cmpResult == 0)
						{
							//the same words so add the line number
							searchWord.addLineNumbers(lineIn);
							return;
						}
						else if(cmpResult <0)
						{
							//current item < arrWords[i] : so the arrWords[i] should go to the right branch
							//System.out.println("right sub tree");
							if(searchWord.right == null)
							{
								searchWord.right = new MyNode(wordIn.toLowerCase(), lineIn);
								return;
							}
							else
							{
								searchWord = searchWord.right;

							}


						}
						else
						{
							//cmpResult >0
							//current item > arrWords[i] : so the arrWords[i] should go to the left branch
							//System.out.println("left sub tree");
							if(searchWord.left == null)
							{
								searchWord.left = new MyNode(wordIn.toLowerCase(), lineIn);
								return;
							}
							else
							{
								searchWord = searchWord.left;
							
							}

						}

					}
					
					
				}

	}



	public String accept(ExactMatchVisitor exactMatchVisitorIn, String wordIn)
	{
		//exactMatchVisitorIn.visit(this,wordIn);
		return "";

	}

	public String accept(NaiveStemmingVisitor naiveVisitorIn, String wordIn)
	{
		return(naiveVisitorIn.visit(this,wordIn));

	}
    public String accept(SemanticMatchVisitor semanticMatchVisitorIn, String wordIn)
    {
    	//semanticMatchVisitorIn.visit(this, wordIn);
    	return "";

    }
	
}