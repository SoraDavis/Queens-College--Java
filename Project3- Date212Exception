
public class Date212Exception extends IllegalArgumentException {

	private String d;

	public Date212Exception(String date) {

		this.d = date;
		printIssue(); // call method to determine which issue caused the exception
	}

	public void printIssue() {

		if (d.length() != 8) {
			System.out.println("You entered: " + d + ". This date is not of length 8.");
		}

		if (Integer.parseInt(d.substring(4, 6)) > 12 || Integer.parseInt(d.substring(4, 6)) == 0) {
			System.out.println("You entered: " + d + ". This date does not contain a month between 1 and 12.");
		}

		if (Integer.parseInt(d.substring(4, 6)) == 4 || Integer.parseInt(d.substring(4, 6)) == 6
				|| Integer.parseInt(d.substring(4, 6)) == 9 || Integer.parseInt(d.substring(4, 6)) == 11) {
			if (Integer.parseInt(d.substring(6, 8)) > 30 || Integer.parseInt(d.substring(6, 8)) == 0)
				System.out.println("You entered: " + d
						+ ". The months of April, June, September, and November only have 30 days.");
		}

		else if (Integer.parseInt(d.substring(4, 6)) == 2) {
			if (Integer.parseInt(d.substring(6, 8)) > 28 || Integer.parseInt(d.substring(6, 8)) == 0) {
				System.out.println("You entered: " + d + ". The month of February only has 28 days.");
			}
		}

		else if (Integer.parseInt(d.substring(6, 8)) > 31 || Integer.parseInt(d.substring(6, 8)) == 0) {
			System.out.println("You entered: " + d
					+ ". The months of January, March, May, July, August, October, and December only have 31 days.");
		}
	}
}
