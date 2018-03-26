
public abstract class DateList {
	//not sure about date212 vs dateNodes here
	 private Date212 first; 
	 private Date212 last; 
	 private int length;
	   
	   public DateList () 
	   {
	       DateNode ln = new DateNode();
	       first = ln;
	       last = ln;
	       length = 0;
	    }
	   
	   public void append (String s)
	   {
	      DateNode n = new DateNode(s);
	      last.next = n;
	      last = n;
	      length++;
	   }

}
