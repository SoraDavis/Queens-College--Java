
import javax.swing.*;
import java.awt.*;
import java.util.StringTokenizer;

public class DateGUI1 
{

	static final int LIST_SIZE = 20;

	static String date;
	static Date212_1[] dateList;
	static int dateSize;
	static TextFileInput inFile;
	static String inFileName = "DateTest.txt";
	static JFrame myFrame;
	static Date212_1 dateObject;
	public static StringTokenizer myTokens;

	public static void initialize() 
	{
		date = "";
		dateList = new Date212_1[LIST_SIZE];
		dateSize = 0;
		dateObject = null;
		inFile = new TextFileInput(inFileName);
		myFrame = new JFrame();
		myFrame.setSize(400, 200);
		myFrame.setLocation(100, 100);
		myFrame.setTitle("Dates");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void readDatesFromFile(String fileName) 
	{

		String date;

		date = inFile.readLine();

		//While there are still more lines, read in from file and tokenize to seperate each date
		//Store dates into dateList array as they are read in
		while (date != null) {

			myTokens = new StringTokenizer(date, ",");

			while (myTokens.hasMoreTokens()) 
			{

				date = myTokens.nextToken();

				dateObject = new Date212_1(date);

				if (!isValidDate(dateObject)) 
				{
					throw new IllegalArgumentException("Invalid date");
				}

				storeDate(dateObject, dateList);

			}
			
			date = inFile.readLine();
		}
	}

	public static void storeDate(Date212_1 d, Date212_1[] list) 
	{
		//Check that the date and the list are valid
		if (isValidDate(d) && isValidList(list)) 
		{
			list[dateSize++] = d;
		}
	}

	public static void printDateList(Date212_1[] list, int size)
	{

		if (!isValidList(list)) 
		{
			throw new IllegalArgumentException("Invalid list)");
		}

		//Check date for validity, and then use the toString and getters (both from Date212_1 class) to print to console
		//This method is just for checking- it does not need to be called from the main method, in this particular project
		for (int i = 0; i < size; i++) 
		{
			if (!isValidDate(list[i])) 
			{
				System.out.println("Invalid Date: " + list[i].getOriginal());
				
			} 
			else 
			{
				System.out.println(list[i].toString(list[i].getYear(), list[i].getMonth(), list[i].getDay()));
			}
		}
	}

	public static void printDateToJFrame(JFrame jf, Date212_1[] list, int size)
	{

		//Create a new jFrame with a ContentPane, adding two textAreas to the grid
		//Call the sort and print the sorted array to the JFrame (append to textArea)- Also print original string
		if (!isValidList(list)) 
		{
			throw new IllegalArgumentException("Invalid list)");
		}

		Container myContentPane = jf.getContentPane();
		jf.setLayout(new GridLayout(1, 2));

		TextArea tA1 = new TextArea();
		TextArea tA2 = new TextArea();

		myContentPane.add(tA1);
		myContentPane.add(tA2);

		Date212_1[] sortedArray = selectionSort(list, dateSize);

		for (int i = 0; i < size; i++) 
		{
			if (!isValidDate(list[i])) 
			{
				tA2.append("Invalid Date: " + sortedArray[i].getOriginal() + "\n");
			}

			else 
			{
				tA1.append(sortedArray[i].getOriginal() + "\n");
				tA2.append(sortedArray[i].toString(sortedArray[i].getYear(), sortedArray[i].getMonth(),
						sortedArray[i].getDay()) + "\n");
			}
		}
		jf.setVisible(true);
	}

	public static boolean isValidDate(Date212_1 d) 
	{
		//Make sure date is 8 digits in length (use getOriginal to check original string sent to Date212_1)
		if (d.getOriginal().length() != 8) 
		{
			throw new IllegalArgumentException("The date length must be 8.");
		}

		return true;
	}

	public static boolean isValidList(Date212_1[] list) 
	{
		if (list == null) 
		{
			return false;
		}

		if (dateSize == list.length)
		{
			return false;
		}

		return true;
	}

	private static Date212_1[] selectionSort(Date212_1[] array, int length) 
	{
		//Compare two dates in the array and set lowest one to new indexLowest variable
		//Swap new lowest with old lowest
		//Use compareTo and equals methods from Date212_1 class
		//Return the now sorted array
		for (int i = 0; i < length - 1; i++) 
		{
			int indexLowest = i;

			for (int j = i + 1; j < length; j++)
			{

				if (array[j].compareTo(array[indexLowest]))
				{
					indexLowest = j;
				}
			}

			if (!array[indexLowest].equals(array[i])) 
			{
				Date212_1 temp = array[indexLowest];
				array[indexLowest] = array[i];
				array[i] = temp;
			}
		}

		return array;
	}

}
