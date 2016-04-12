package ocp.examples.datecalendarStrings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleCharRegEx {
	public static void main(String[] args) {
		/*// digit [0-9]. This pattern should find all the digits in the input
		String str = "\\d" ; 
		String input = "hsj2228wewe23";
		*/
		
	/*//CASE II - find  
		
		String str = "\\d[5-8]" ; 
		String input = "hsj2258wewe26";*/
		
		
		/*//CASE III - Find non-digits		
		String str = "\\D" ; 
		String input = "hsj2258wewe26";
				
		SimpleCharRegEx regEx = new SimpleCharRegEx ();
		regEx.patternFinder(str,input);*/
		
		/*//CASE IV - Find one or more digits in a row. This is greedy implementation
		
		String str = "\\d+" ; 
		String input = "hsj2258wewe26";
		String input2 = "hsj2as2se5tr8wewe2rr6";
		String input3 = "hsj225889";
		
		SimpleCharRegEx regEx = new SimpleCharRegEx ();
		regEx.patternFinder(str,input);
		regEx.patternFinder(str,input2);
		regEx.patternFinder(str,input3);
*/		
		/*//CASE V - Find elements such that thre is some char before digits[5-8]
		
		String str = ".[5-8]" ; 
		String input = "hsj2258wewe26";
*/				
		
/*		//CASE VI - Find elements such that there is some char before digits[22]
		
				String str = ".22" ; 
				String input = "hsj2222wewe22";
*/				
		
		//CASE VII - not 
		// in this case, the matcher will try to find all the occurances
		// for 222. However, it will never re-consier already considered char.
		// check for all 3 different variabnces (222)+, (222)*, (222)?, (222)+?, (222)*?, (222)??, 
		// (222) = Positions = 3 6 14
		// (222)+ (one or more) = Position = 3 14
		// (222)* (zero or more) = position = all positions starting from 0 1 2 3 9 10 11 12 13 14 
		// (222)? (zero or one) = position = all positions starting from 0 1 2 3  6 9 10 11 12 13 14
		/*String str = "(222)*?"  ;  
		String input = "hsj2222222wewe222"; 
		*/
	/*	String str = "x*?foo"  ;  //x*foo gives different output. why? the behaviour is same as reluctant 
		String input = "xfooxxxxxxfoo"; */
		
		/*
		//CASE VII - not 
		String str = "[^(222)]"  ;  
		String input = "hsj2222222wewe222";
		*/

		String str = "\\d*";
		String input  = "ab34ef";
				
		SimpleCharRegEx regEx = new SimpleCharRegEx ();
		regEx.patternFinder(str,input);
		/*regEx.patternFinder(str,input2);
		regEx.patternFinder(str,input3);*/
				
		
		
	}
	
	public void patternFinder (String pattern, String inputString) {
		Pattern p= Pattern.compile(pattern);
		Matcher m = p.matcher(inputString);
		System.out.println("Match positions: ");
		while (m.find()) {
			System.out.print(" start Position: "+ m.start() +  " Group: " + m.group());
			//System.out.print(m.start() + m.group());
		}
	}
}
