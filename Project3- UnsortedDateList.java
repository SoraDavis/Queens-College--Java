
public class UnsortedDateList extends DateList 
{
	public UnsortedDateList() 
	{
		super();
	}

	//call append function from DateList class to add node to end of list in regular fashion
	public void add(Date212_1 d) 
	{
		super.append(d);
	}

	public int getLength() 
	{
		return length;
	}

	public DateNode getFirst() 
	{
		return first.next;
	}

}
