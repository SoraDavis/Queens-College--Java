
public class Date212_1 
{
	private int day;
	private int month;
	private int year;
	private String allInfo;

	public Date212_1(String dateInfo)
	{
		//Split String dateInfo into sections so we can set year/month/day
		//Set a variable for entire string, so we can easily access the original string
		String first = dateInfo.substring(0, 4);
		String second = dateInfo.substring(4, 6);
		String third = dateInfo.substring(6, 8);
		String original = dateInfo;

		year = Integer.parseInt(first);
		month = Integer.parseInt(second);
		day = Integer.parseInt(third);
		allInfo = original;
	}

	public void setDay(int d)
	{
		day = d;
	}

	public int getDay() 
	{
		return day;
	}

	public void setMonth(int m) 
	{
		month = m;
	}

	public int getMonth() 
	{
		return month;
	}

	public void setYear(int y) 
	{
		year = y;
	}

	public int getYear() 
	{
		return year;
	}

	public String getOriginal() 
	{
		return allInfo;
	}

	public boolean equals(Object other) 
	{
		if (this == other) 
		{
			return true;
		}

		//Check that 'other' is of same class type
		if (other != null && this.getClass().equals(other.getClass())) 
		{
			Date212_1 o = (Date212_1) other;

			if (year == o.year && month == o.month && day == o.day) 
			{
				return true;
			}

			else
			{
				return false;
			}

		}
		return false;
	}

	public boolean compareTo(Object other) 
	{
		int diff;

		Date212_1 o = (Date212_1) other;

		//Compare two Date212_1 objects using subtraction and converting to days, to check which is an earlier date
		diff = (this.year - o.year) * 365;
		diff += (this.month - o.month) * 30;
		diff += (this.day - o.day);

		if (diff > 0) 
		{
			return false;
		} 
		else 
		{
			return true;
		}

	}

	public String toString(int year, int month, int day) 
	{
		String monthToString;

		//Convert month number to name of month and return all info written that way
		switch (month) 
		{
		case 1:
			monthToString = "January";
			break;
		case 2:
			monthToString = "February";
			break;
		case 3:
			monthToString = "March";
			break;
		case 4:
			monthToString = "April";
			break;
		case 5:
			monthToString = "May";
			break;
		case 6:
			monthToString = "June";
			break;
		case 7:
			monthToString = "July";
			break;
		case 8:
			monthToString = "August";
			break;
		case 9:
			monthToString = "September";
			break;
		case 10:
			monthToString = "October";
			break;
		case 11:
			monthToString = "November";
			break;
		case 12:
			monthToString = "December";
			break;
		default:
			monthToString = "Invalid month";
			break;
		}

		return monthToString + " " + day + ", " + year;
	}

}
