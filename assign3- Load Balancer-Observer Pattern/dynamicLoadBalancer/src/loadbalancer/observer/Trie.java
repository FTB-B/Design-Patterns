package loadbalancer.observer;
import java.util.HashMap;

public class Trie {
		// Code for Trie data structure.
		// Used as a key value store.
		// Key is the service name. Value is an instance of ServiceManager.
     /*
	    static class TrieNode
	    {
	    	private HashMap<Character, TrieNode> children;
    		private String content;
    		

	    }
	    private TrieNode root;

		// Rest of the code.

	    public void insert(String hostNameIn)
	    {
	   		TrieNode current = root;
 
           for (int i = 0; i < hostNameIn.length(); i++)
           {
        		current = current.getChildren().computeIfAbsent(hostNameIn.charAt(i), c -> new TrieNode());
    	   }
    	   current.setEndOfWord(true);
		}

		public boolean find(String hostNameIn) 
		{
    		TrieNode current = root;
    		for (int i = 0; i < hostNameIn.length(); i++) 
    		{
       		    char ch = hostNameIn.charAt(i);
        	    TrieNode node = current.getChildren().get(ch);
        		if (node == null) 
        		{
            		return false;
        		}
        		current = node;
   			 }
    		return current.isEndOfWord();
		}
    */
	}