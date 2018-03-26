
public class DateNode 
{
	protected Date212_1 data;
	protected DateNode next;

	//constructor 1 takes in a Date212_1 object to use as data in Node
	public DateNode(Date212_1 d) 
	{
		this.data = d;
	}

	//constructor 2 takes in a DateNode to point to as next
	public DateNode(DateNode dN) 
	{
		this.next = dN;
	}

}
