import javax.swing.JMenuBar;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.util.HashMap;

import javax.swing.*;

public class DateGUI1 extends JFrame 
{

	static String date;
	static JFrame myFrame;
	//static TreeMapDates unsorted;
	//static TreeMapDates sorted;
	static JMenuBar menuBar;
	static JMenu fileMenu;
	static FileMenuHandler fmh;

	public DateGUI1() 
	{
		date = "";
		//list = new UnsortedDateList();
		//sortList = new SortedDateList();
		myFrame = new JFrame();
		myFrame.setSize(400, 200);
		myFrame.setLocation(100, 100);
		myFrame.setTitle("Dates");
		createMenu();
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	public void createMenu() 
	{
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem item;
		FileMenuHandler fmh = new FileMenuHandler(this);

		//create an item with an action listener (File Menu Handler) and add to File Menu
		item = new JMenuItem("Open");
		item.addActionListener(fmh);
		fileMenu.add(item);

		fileMenu.addSeparator();

		//create another item with action listener and add
		item = new JMenuItem("Quit");
		item.addActionListener(fmh);
		fileMenu.add(item);
		
		//add a JMenuBar to the current jFrame and add the file menu to it
		this.setJMenuBar(menuBar);
		menuBar.add(fileMenu);


		this.setSize(400, 200);
		this.setLocation(100, 100);
		this.setTitle("Dates");
		setVisible(true);
	}

	public static boolean isValidDate(Date212_1 d)  throws Date212Exception
	{
		// Make sure date is 8 digits in length (use getOriginal to check original
		// string sent to Date212_1)
		if (d.getOriginal().length() != 8) {
			throw new Date212Exception(d.getOriginal());
		}

		return true;
	}

	public static String getValue(Date212_1 d) 
	{

		return d.toString(d.getYear(), d.getMonth(), d.getDay());
	}
	
}
