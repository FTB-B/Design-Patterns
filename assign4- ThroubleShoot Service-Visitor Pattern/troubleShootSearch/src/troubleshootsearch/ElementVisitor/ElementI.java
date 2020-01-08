
package troubleshootsearch.ElementVisitor;

public interface ElementI
{ 
    public String accept(ExactMatchVisitor exactMatchvisitorIn, String userwordIn ); 
    public String accept(NaiveStemmingVisitor naivevisitorIn, String userwordIn); 
    public String accept(SemanticMatchVisitor semanticMatchVisitorIn, String userwordIn); 
} 