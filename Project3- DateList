
public abstract class DateList 
{

	protected DateNode first;
	protected DateNode last;
	protected int length;

	//constructor creates Node and sets first and last
	public DateList()
	{
		DateNode ln = new DateNode(first);
		first = ln;
		last = ln;
		length = 0;
	}

	//adds a DateNode containing a Date212_1 Object to the end of the linked list
	public void append(Date212_1 d) 
	{
		DateNode n = new DateNode(d);

		if (length == 0) 
		{
			first.next = n;
		}

		last.next = n;
		last = n;
		length++;
	}

}
