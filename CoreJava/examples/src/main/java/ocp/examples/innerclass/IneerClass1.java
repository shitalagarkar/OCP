package ocp.examples.innerclass;

public class IneerClass1 {
public Integer count;
private String name;
public static String staticString;
public static final String finalString = "FinalString";

public IneerClass1() {
	count =100;
	name="Shital";
	staticString = "Agarkar";
}

 public  class FirstInnerClass { //Inner class can have modifiers public, private, protected and default.
	int abc;
	String innerName;
	Integer count; // VARIABLE SHADOWING happens in inner class.
//	static int staticInt = 500; // COMPILATION ERROR - static field cannot be declared in a non-static inner class.
	public FirstInnerClass (){
		count = 500;
		System.out.println("inside inner class constructor");
	}
	
	public void accessParentFields () {            
		System.out.println("count = " + count);
		System.out.println("Outer count = " + IneerClass1.this.count); // WAY of accessing outer this.
		System.out.println("name = " + name);
		System.out.println("staticString = " + staticString);
		System.out.println("finalString = " + finalString);
	}
}
  
 public static void main (String[] args) {
	 IneerClass1 iC1 = new IneerClass1();
	 IneerClass1.FirstInnerClass fIC = iC1.new FirstInnerClass();
	 fIC.accessParentFields();
 }
	
}
