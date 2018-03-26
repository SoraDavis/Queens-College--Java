import javax.swing.*;

public class Project0 {

	//Take in input from user (using JOption)
	
	//Parse through string (use CharAt)
	
	//Add to counter1 if find lowercase 'e'
	
	//Add to counter2 if find uppercase 'E'
	
	//Use JOption to tell answer to user
	
	//Exit if STOP is entered
	
	  public static void main(String[] args) {
		   
	        while (true) {
	           
	        String input;
	        int counter1 = 0, counter2 = 0;
	        input = JOptionPane.showInputDialog(null, "Please enter a sentence:");
	       
	            if (input.equals("STOP"))
	            {
	                System.exit(0);
	            }
	
	       
	        // Output to a JOptionPane window whether the word is on the list or not
	        JOptionPane.showMessageDialog(null, "There are " + counter1 + " lowercase letter 'e's, and " + counter2 + " uppercase letter 'E's in your sentence.");
	       
	           
	        }
	       
	} 
}
