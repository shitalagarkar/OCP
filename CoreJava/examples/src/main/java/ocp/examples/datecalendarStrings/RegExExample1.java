package ocp.examples.datecalendarStrings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExExample1 {
 public static void main (String[] args) {
	 
	RegExExample1 regEx = new RegExExample1 ();
	String input = "Markkk24 5 kk45666 k"; //EXAMPLE 1 
	//String input = "#1	_1 35 7"; // EXAMPLE 2 a1 d1 c35 e7
//	 String input = "X12 ####_9876";
	 
	//String reg1 = "\\D"; //non-digit
	//String reg1 = "\\S"; 
	//String reg1 = "\\s"; 
	 
		//String reg1 = "\\w"; 
	
	String reg1 = "\\d";		
	String reg2 = "\\d*";
	String reg3 = "\\d?";
	
	String reg4 = "\\d+"; 
	
	String reg5 = "2*?"; // WHY THIS BEHAVIOR?? .//d*?
/*	String reg6 = "\\d??";  // WHY THIS BEHAVIOR?? .//d*?
	String reg7 = "\\d+?";  // WHY THIS BEHAVIOR?? .//d*? */
	 
	 
	/*String input = "123E";
	 String reg1 = "\\d++";
	 String reg2 = "\\d+";*/
	

	/*	String input = "AAA";
		 String reg1 = "A++."; 
		 String reg2 = "A+.";*/

	// regEx.patternFinder(reg1,input);
	regEx.patternFinder(reg2,input);
	//regEx.patternFinder(reg3,input);
	//regEx.patternFinder(reg4,input);	
	regEx.patternFinder(reg5,input); 
//	regEx.patternFinder(reg6,input);
//	regEx.patternFinder(reg7,input);

	
//***********************************************************************************************
	//RegExExample1 regEx = new RegExExample1 ();
	/*String input = "Markkk245 kk45666 kkkkkkkk"; //EXAMPLE 1 
	String reg1 = "k{4}"; //non-digit {1,4}, {4}
	 regEx.patternFinder(reg1,input);*/
	 

//*************************************************************************************************	
	
	//EXAMPLE - 3
	 /*String input = "STARTEND Marry had a START little lamb END" ;
	 String regGreedy = "START (li)*.* END";
	 String regLazy = "START .*? END";
	 String regLazy1 = "(START)+?";*/
	 
	 
//	 regEx.patternFinder(regGreedy,input);
	//regEx.patternFinder(regLazy1,input);
	
	
//		
 }
 
	public void patternFinder (String pattern, String inputString) {
		Pattern p= Pattern.compile(pattern);
		Matcher m = p.matcher(inputString);
		System.out.println( "**********************Search result for RegEx = "+ pattern  + " And Input = " + inputString+"**********************");
		while (m.find()) {
			System.out.println(" start Position: "+ m.start() +  " Group: " + m.group());
		}

	}
}
