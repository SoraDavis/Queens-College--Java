
public class SortedDateList extends DateList 
{
	private DateNode current;

	public SortedDateList() 
	{
		super();
	}

	public void add(Date212_1 d) 
	{
		DateNode node = new DateNode(d);

		// insert node into proper spot to keep sorted
		current = first;

		//compare to check if the node should be placed there
		while (current.next != null && current.next.data.compareTo(d) == false)
		{
			current = current.next;
		}

		node.next = current.next;
		current.next = node;
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
