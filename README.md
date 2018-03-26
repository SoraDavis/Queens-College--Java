# Queens-College--Java

*Project0- CS212*

Write a Java program that will
1.   Ask the user to type in a sentence, using a JOptionPane.showInputDialog().
2.   The program will examine 
each letter in the string and count how many time the upper
-case 
letter 'E' appears, and how many times the lower
-case letter 'e' appears.
 The key here is to use 
the 
charAt
 method in class String.
3.   Using a JOptionPane.showMessageDialog(), tell the user how many upper and lower case e's 
were in the string.
4.   Repeat this process until the user types the word "Stop".
 (Check out the method 
equalsIgnoreCase
in class String to cover all upper/lower case possibilities of the word 
"STOP"
). 

*Project1- CS212*


Create a class called 
Date212
to represent a date. It will store the year, month and day as integers
 so 
you will need three private instance variables. 
One
 constructor
 should be provided 
that takes
 a String 
representing the date in 
yyyymmdd
 format
. The constructor 
should 
use the 
substring
method of class 
String
 to pull out the month, day and year, parse them as integers put them in the instance variables
.  
The 
Date212
class should have the usual set and get methods, and 
equals, compareTo and 
toString
 methods. The 
toString
 method should print the date in 
“mm dd, yyyy
” format (for example, 
20171002 would be returned as 
“October 2, 2017
”. 

Given an input file of dates represented as Strings, read the dates from the file and display them in a 
GUI. The dates will be in the form 
yyyymmdd
 (such as 2017
1001 for October 1, 2017
). The GUI should 
have a GridLayout with one row and two columns. The l
eft column should display the dates
 in the 
format read from the file, 
and the right column should display the dates
 as 
Date212
object
 in sorted 
order (using Selection Sort).

The input file
Each line of the input file may contain several
 dates separated by commas. You will need to use a 
StringTokenizer to separate out the individual dates. So, an example of the input file would be:
20141001 

20080912,20131120,19980927 

20020202 

20120104 

*Project2- CS212*

Create a class called 
Date
Node
which has fields for the 
data
(a Date212) and 
next
 (Date
Node
)
instance variables. Include a one-argument 
constructor which takes a Date
212 
as a parameter.
      public 
DateNode (Date212 
d) {  . . } 
The instance variables should 
have 
protected 
access. There 
will not be 
any get and set methods for the 
two instance variables.
Create 
an abstract linked list class
 called 
Date
List.
 This 
should be
 a linked list with head node
 as 
described in lecture. Modify it so that the data 
type 
in the nodes
 is 
Date212. The no-argument 
constructor should create an empty list with 
first
 and 
last
 pointing to an empty head node, and 
length
equal to zero. Include an append method in this class.
Create two more linked list classes that extend the abstract class DataList: One called 
UnsortedDateList and one called SortedDateList, each with appropriate no-argument constructors. 
Each of these classes should have a method called 
add(Date212)
that will add a new node to the list. In 
the case of the UnsortedDateList it will add it to the end of the list by calling the append method in the 
super class. In the case of the SortedDateList it will insert the node in the proper position to keep the 
list sorted.
Instantiate two linked lists, and for every date read from the file, add it to the unsorted and sorted lists 
using the 
add
 method.
 You
 will end up with the first list having the dates from the input file in the order 
they were read, and in the second list the dates will be in sorted order. Display the unsorted and sorted 
dates in the GUI just as in project 1.

Add a file menu to your DateGUI with options to open a file for reading, and one to Quit the program.

*CS313-HW1*

public E remove(int index):
Removes and returns the element at the specified index,
or throws an IndexOutOfBoundsException if the index is out of range.
Like an array, the first element (after the dummy node) should be at index 0.
If the node you removed is the last node, don't forget to update last.

public void push(E e):
Adds element e to the top of the stack.
It's your choice which side of the linked list is the "top", but push and pop must happen on the same side.
You'll probably want the top to be at the beginning of the list, because there's no efficient way to remove the last node of a singly-linked list.

public E pop():
Removes and returns the top element of the stack, or returns null if the stack is empty.

Note: If you push onto an empty stack, or pop the last node from the stack, don't forget to update last.

public E top():
Returns but does not remove the top element of the stack, or returns null if the stack is empty.

public void reverse():
Reverses the order of all the elements of the stack, for example if the stack looked like [1, 2, 3], it should be changed to [3, 2, 1].
There are several ways to do this, but probably the easiest way is to move the elements to another list or stack, then move them back.

public String toString():
Returns a String representation of the linked list.
The exact format is your choice, but the String should include every element (not including the dummy node).
Examples of acceptable formats are "[1, 2, 3]", "[1,2,3]", "[ 1 2 3 ]", "1 2 3". 

*CS313-HW2*

public static void intersection(String filename1, String filename2):
Reads the two files and prints every word that occurs at least once in both files (the order is not important).
The runtime must be O(n) where n is the total number of words in both files.
Do not sort the words because it is too slow. Use a HashSet to store the words.
You may assume that a string can be inserted into a hash table in O(1) time.

public static void frequentWords(String filename, int k):
Reads the file and prints every word that occurs at least k times (the order is not important).
Print the word followed by the number of occurrences in parentheses, as in the sample output.
The runtime must be O(n) where n is the total number of words in the file.
Do not sort the words. Use a HashMap to count the occurrences of each word (the key is the word, the value is the number of occurrences).
If the key is already in the map, update its value (using the get and put methods), otherwise add a new entry to the map.
Then iterate through the map to find the frequent words. See UsingSetsMaps for an example of how use a for-each loop with a map.

public static void anagrams(String filename):
Reads the file and prints all sets of anagrams, one set per line (the order is not important). Only print sets that contain 2 or more words.
In a set of anagrams, you can rearrange the letters of one word to form any other word, for example [now, own, won].
You have been given a sortString method that takes a string as a parameter, sorts the characters alphabetically, and returns the result.
If two strings are equal to each other after sorting both strings, they are anagrams.
There is no runtime requirement, so you may solve it however you want, but I think the easiest solution is to use a map (the key is the sorted word, the value is either a list or a set of all words that are anagrams with the sorted word). 

