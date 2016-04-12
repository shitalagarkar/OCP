package ocp.examples.datecalendarStrings;

import java.util.Calendar;

public class CalendarExample {

	public static void main (String[] args) {
		Calendar cal = Calendar.getInstance();
		System.out.println("Current time = " + cal.getTime());
		System.out.println("Current timezone = " + cal.getTimeZone());
		
		cal.set(Calendar.MONTH, Calendar.MARCH);
		cal.set(Calendar.DAY_OF_MONTH, 31);
		System.out.println("Changed time = " + cal.getTime());
		cal.set(Calendar.MONTH, Calendar.APRIL);
		System.out.println("Changed time = " + cal.getTime());
		
		// Add rule 1 applied. Day Of month value exceeds it's limit 
		// and hence next larger field is incremented. Hence MOnth is changed to June. 
		cal.add(Calendar.DAY_OF_MONTH, 31);
		System.out.println("Changed time = " + cal.getTime());
		
		cal.add(Calendar.DAY_OF_MONTH, 29);
		System.out.println("Changed time = " + cal.getTime());
		// Add rule 2 applied here. 
		// In this example, day of month is supposed to be invarient.
		// However, due to change in the value of month, this field is adjusted to the nearest value.
		cal.add(Calendar.MONTH, -4);
		System.out.println("Changed time = " + cal.getTime());
		
		//In case of Roll - larger field is not adjusted. The changes would be applied only to the '
		//specified field.
		cal.roll(Calendar.DAY_OF_MONTH, -2);
		System.out.println("Changed time after roll= " + cal.getTime());
		cal.roll(Calendar.DAY_OF_MONTH, 30);
	
		
		
		Calendar cal1 = Calendar.getInstance();
		System.out.println("Calndar status= " + cal1.getTime());
		cal1.set(Calendar.DAY_OF_MONTH, -27);
		cal1.set(Calendar.DAY_OF_MONTH, -30);
		System.out.println("Changed time after multiple set= " + cal1.getTime());

		
	}
	
}
