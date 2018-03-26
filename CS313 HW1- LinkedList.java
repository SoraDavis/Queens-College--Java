
public class LinkedList<E> implements List<E>, Stack<E> {
   private Node<E> first, last;
   private int size = 0;
   
   // Construct a new empty list.
   public LinkedList() {
      first = last = new Node<>(null, null);
   }
   
   // Adds element e to the end of the list.
   public void add(E e) {
      last.next = new Node<>(e, null);
      last = last.next;
      size++;
   }
   
   // Returns the element at the specified index,
   // or throws an IndexOutOfBoundsException if the index is out of range.
   public E get(int index) {
      if (index < 0 || index >= size)
         throw new IndexOutOfBoundsException();
      Node<E> t = first.next;
      for (int i = 0; i < index; ++i)
         t = t.next;
      return t.data;
   }
   
   // Removes and returns the element at the specified index,
   // or throws an IndexOutOfBoundsException if the index is out of range.
   public E remove(int index) {
	   
	   //debug: for some reason the first remove removes the 5.....that should be index 1, not 0
	   if (index < 0 || index > size-1)
	         throw new IndexOutOfBoundsException();
      
	   Node<E> t = first;
	   
	   
	   for(int i = 0; i < index; i++)
	   {
		   t = t.next;
	   }
	   
	   Node<E> removed = t.next;
	   
	   if (removed == last)
	   {
		   last = t;
		   size--;
		   return removed.data;
	   }
	   
	   else
		   t.next = t.next.next;
	   
	   size--;
	   
	   return removed.data;
   }
   
   // Adds element e to the top of the stack.
   public void push(E e) {

	   Node<E> newNode = new Node<E> (e, null);
	   newNode.next = first.next;
	   first.next = newNode;

	   if(size == 0)
	   {
		   last = newNode;
	   }
	   
	   size++;
   }
   
   // Removes and returns the top element of the stack, or returns null if the stack is empty.
   public E pop() {

	   if(size == 0)
		   return null;
	   
	   if(size == 1)
	   {
		   last = first;
	   }
	   Node<E> removed = first.next;
	   first.next = first.next.next;
	   
	   size--;
	   
	   return removed.data;
	
   }
   
   // Returns but does not remove the top element of the stack, or returns null if the stack is empty.
   public E top() {

	   if(size == 0)
		   return null;
	   
	   return first.next.data;
   }
   
   // Reverses the order of all the elements of the stack.
   public void reverse() {
	   
	   LinkedList<E> temp = new LinkedList<E>(); 
	   Node<E> current = first.next;
	   
	   int sizeHolder = size;
	   for(int i = 0; i < sizeHolder; i++)
	   {
		 E holder = this.pop();
		 temp.push(holder);
		 //temp.last.next = temp.last;
		 current = current.next; 
	   }
	   
	   for(int i = 0; i < sizeHolder; i++)
	   {
		  E holder = temp.pop();
		  this.add(holder);
	   }

   }
   
   // Returns a string representation of the linked list.
   public String toString() {

	   //debug: it is printing "null" before e/t
	   String string = "[ ";
	   Node<E> s = first.next;
	   
	   for (int i = 0; i < size; i++)
	   {
		   string += s.data + " ";
		   s = s.next;
	   }
	   
	   string += "]";
	   
	   return string;
   }
   
   // Returns the number of elements.
   public int size() {
      return size;
   }
   
   private static class Node<E> {
      E data;
      Node<E> next;
      Node(E data, Node<E> next) {
         this.data = data;
         this.next = next;
      }
   }
}

