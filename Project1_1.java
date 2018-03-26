
public class Project1_1 extends DateGUI1 
{
	public static void main(String[] args)
	{
		//Initialize DateGUI1 and send it all the info it needs to take in the dates, sort them, and print them properly
		//printDateList not needed in this project
		DateGUI1.initialize();
		DateGUI1.readDatesFromFile(inFileName);
		// DateGUI1.printDateList(dateList,dateSize);
		DateGUI1.printDateToJFrame(myFrame, dateList, dateSize);
	}
}
