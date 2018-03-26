import javax.swing.*;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.*;
import java.io.*;
import java.util.StringTokenizer;

public class FileMenuHandler implements ActionListener
{
	static JFrame jframe;
	static String date;
	static TextFileInput inFile;
	static Date212_1 dateObject;
	public static StringTokenizer myTokens;
	public static TextArea originals;
	public static TextArea sorted;
	public static TextArea unsorted;

	public FileMenuHandler(JFrame jf) 
	{
		jframe = jf;
		dateObject = null;
	}

	public void actionPerformed(ActionEvent event) 
	{
		//give actions to each option in File Menu
		String menuName;
		menuName = event.getActionCommand();
		if (menuName.equals("Open"))
			openFile();
		else if (menuName.equals("Quit"))
			System.exit(0);
	}

	private void openFile() 
	{
		//open a File Chooser and send the file to readSource method to read the contents
		JFileChooser chooser;
		int status;
		chooser = new JFileChooser();
		status = chooser.showOpenDialog(null);
		if (status == JFileChooser.APPROVE_OPTION)
			readSource(chooser.getSelectedFile());
		else
			JOptionPane.showMessageDialog(null, "Open File dialog canceled");
	}

	private void readSource(File chosenFile) 
	{
		//get path of chosen file and use as input for TextFileInput
		String chosenFileName = chosenFile.getPath();
		TextFileInput inFile = new TextFileInput(chosenFileName);
		String date;
		TreeMapDates.sorted.clear();

		//read a line of the file into 'date'
		date = inFile.readLine();
		
		Container myContentPane = jframe.getContentPane();
   		myContentPane.removeAll();
   		jframe.setLayout(new GridLayout(1, 3));

   		TextArea originals = new TextArea();
   		TextArea unsortList = new TextArea();

   		myContentPane.add(originals);
   		myContentPane.add(unsortList);

			while (date != null) 
			{
					//tokenize the line using a comma as a delimiter, and place each token into a dateObject
					myTokens = new StringTokenizer(date, ",");
		
					while (myTokens.hasMoreTokens()) {
		
						date = myTokens.nextToken();
		
						dateObject = new Date212_1(date);
		
						// Check that the date is valid
						if (DateGUI1.isValidDate(dateObject)) 
						{
							//call 'store' function in TreeMapDates class to store this date in the two Maps
							TreeMapDates.store(Integer.parseInt(date), dateObject);
						}
						
						
				   		originals.append(dateObject.getOriginal() + "\n");
				   		unsortList.append(getValue(dateObject) + "\n");

				}
					
				date = inFile.readLine();
	
			}
			
		TreeMapDates.print(jframe);
		jframe.pack();
		jframe.setVisible(true);
	}

	public static String getValue(Date212_1 d) 
	{

		return d.toString(d.getYear(), d.getMonth(), d.getDay());
	}
}
