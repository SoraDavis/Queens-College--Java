import java.awt.Container;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class EditMenuHandler implements ActionListener {

	static JFrame jframe;
	static String date;
	static Date212_1 dateObject;
	static DateNode node;

	public EditMenuHandler(JFrame jf) {
		jframe = jf;
		dateObject = null;
		node = null;
	}

	public void actionPerformed(ActionEvent event) {
		// give actions to each option in Edit Menu
		String menuName;
		menuName = event.getActionCommand();
		if (menuName.equals("Insert"))
			insertDate();
	}

	private void insertDate() {

		String InputDate = JOptionPane.showInputDialog(null, "Enter a date in yyyymmdd format:");

		dateObject = new Date212_1(InputDate);
		DateGUI1.storeDate(dateObject);

		Container myContentPane = jframe.getContentPane();
		myContentPane.removeAll(); // clear out GUI in order to re-print newly edited lists
		jframe.setLayout(new GridLayout(1, 3));

		TextArea originals = new TextArea();
		TextArea unsorted = new TextArea();
		TextArea sorted = new TextArea();

		myContentPane.add(originals);
		myContentPane.add(unsorted);
		myContentPane.add(sorted);

		// create dateNodes containing the date info from the file, using the linked
		// lists created by StoreDate method
		DateNode dN2 = DateGUI1.sortList.getFirst();
		DateNode dN1 = DateGUI1.list.getFirst();

		while (dN1 != null && dN2 != null) {
			originals.append(dN1.data.getOriginal() + "\n");
			unsorted.append(DateGUI1.getValue(dN1) + "\n");
			sorted.append(DateGUI1.getValue(dN2) + "\n");

			// call next nodes

			dN1 = dN1.next;
			dN2 = dN2.next;
		}

		jframe.pack();
		jframe.setVisible(true);
	}
}
