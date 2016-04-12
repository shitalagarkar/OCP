package ocp.examples.datecalendarStrings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharClassExamples {
public static void main (String[] args) {
	
	CharClassExamples ch = new CharClassExamples();
	//[abc]
	String input = "lxak _346nx XXmacb" ;
	//String reg = "[abc]"		;
	
	//[^abc]
	//String reg = "[^abc]"	; // negate
	
	//[a-zA-Z]
	//String reg = "[[a-zA-Z]]"	; // range

	//[a-d[m-p]]
	//String reg = "[a-b[l-p]]"; // union -  a to b and l to p
	
	//[a-z&&[def]]	d, e, or f (intersection)
	//String reg = "[a-l&&k-q]"; 
	
	//[a-z&&[^bc]]	a through z, except for b and c: [ad-z] (subtraction)
	//String reg = "[a-z&&[^bc]]";
	
	//[a-z&&[^m-p]]	a through z, and not m through p: [a-lq-z](subtraction)
	String reg = "[a-z&&[^m-p]]"; 
		 
	ch.patternFinder(reg, input);
	
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
