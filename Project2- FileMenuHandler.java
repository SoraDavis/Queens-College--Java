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

		//read a line of the file into 'date'
		date = inFile.readLine();
		
		while (date != null) 
		{
			//tokenize the line using a comma as a delimiter, and place each token into a dateObject
			myTokens = new StringTokenizer(date, ",");

			while (myTokens.hasMoreTokens()) {

				date = myTokens.nextToken();

				dateObject = new Date212_1(date);

				if (!DateGUI1.isValidDate(dateObject)) 
				{
					throw new IllegalArgumentException("Invalid date");
				}

				DateGUI1.storeDate(dateObject);

			}
			date = inFile.readLine();

		}

		//create a jFrame with ContentPane and TextAreas
		Container myContentPane = jframe.getContentPane();
		jframe.setLayout(new GridLayout(1, 3));

		TextArea originals = new TextArea();
		TextArea unsorted = new TextArea();
		TextArea sorted = new TextArea();

		myContentPane.add(originals);
		myContentPane.add(unsorted);
		myContentPane.add(sorted);

		//create dateNodes containing the date info from the file, using the linked lists created by StoreDate method 
		DateNode dN2 = DateGUI1.sortList.getFirst();
		DateNode dN1 = DateGUI1.list.getFirst();
		
		while (dN1 != null && dN2 != null) 
		{
			originals.append(dN1.data.getOriginal() + "\n");
			unsorted.append(DateGUI1.getValue(dN1) + "\n");
			sorted.append(DateGUI1.getValue(dN2) + "\n");

			//call next nodes
			dN1 = dN1.next;
			dN2 = dN2.next;
		}

		jframe.pack();
		jframe.setVisible(true);
	}

}
