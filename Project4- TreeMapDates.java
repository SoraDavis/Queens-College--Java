
import java.util.Map;
import java.util.TreeMap;

import javax.swing.JFrame;

import java.util.Set;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.util.HashMap;
import java.util.Iterator;

public class TreeMapDates 
{

	//create a new treeMap
	static TreeMap<Integer, String> sorted = new TreeMap<>(new Date212Comparator());

	public static void store(Integer date_int, Date212_1 date_object) 
	{
		//store the date info into the treeMap
		String dateLine;
		dateLine = Date212_1.getValue(date_object);
		sorted.put(date_int, dateLine);
	}

	public static void print(JFrame jframe) 
	{
		Container myContentPane = jframe.getContentPane();

		TextArea sortList = new TextArea();

		myContentPane.add(sortList);

		for (Map.Entry me : sorted.entrySet()) { // for each entry in the map's entry set

			sortList.append(me.getValue().toString() + "\n");
		}

	}
}
