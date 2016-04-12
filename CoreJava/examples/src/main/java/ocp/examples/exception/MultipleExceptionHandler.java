package ocp.examples.exception;

import java.io.IOException;
import java.sql.SQLException;

public class MultipleExceptionHandler {
 public static void main (String[] args) throws EmptyStringException , LongerStringException, IOException {
	 ExceptionGenerator gen = new ExceptionGenerator();
	 try {
		 gen.generator("1234");
		 gen.IOGenerator();
	 }catch(Exception e) {
		 System.err .print(" Class: " + e.getClass() + " Message:" + e.getMessage());
		 /*CASE III - re-throwing of Exception. In this case,the called method might be 
		 // throwing EmptyStringException or LongerStringException. 
		 // So  throw e statement works as it assumes that the exceptions thrown as per the called method.  
		 //throw e; //OK in Java 7. But this will give error in Java 6.
		 */
		 
		 //CASE IV - in this case, we are assigning new exception to reference e of type 'Exception'.
		 // As method is not throwing exception of type EXCEPTION, it gives compile time error.
		 
		/* e = new NullStringException();
		throw e; // COMPILATION ERROR - as method signature does not throw Exception.
		*/
	 }
	 
	// catch (EmptyStringException | LongerStringException e) {
		//System.err .print(" Class: " + e.getClass() + " Message:" + e.getMessage());
		//CASE-I
		/* e =  new NullStringException(); // COMPILATION ERROR-- incase of multi-catch, 
		 *Exception e passed to the catch block is final. And hence you cannot assign anyother exception to it.
		 */
	//CASE -II	
		/* new NullStringException(); //Allowed as method signature says that the method can throw
		* EmptyStringException which is a super type of NullStringException
		*/
		
	// } 
	
	 
 }
}


class ExceptionGenerator {
	public void generator(String str) throws  LongerStringException/*, EmptyStringException*/  {
		/*
		 * CASE V - comment EmptyStringException as below and remove it from method signature. I.e make the API more cleaner by throwing less exception.
		 * Now the caller if uses multi-catch, the caller will get COMPILATION ERROR Unreachable catch.
		 * However, if caller has handled exception with single catch block with catch(Exception), no change required.
		 * if(null == str || str.length() == 0 ){
			throw new EmptyStringException("String is Empty");
		}*/
		
		if(str.length() > 5) {
			throw new LongerStringException("String length greater than 5");
		}
	}
	
	public void IOGenerator () throws IOException {
		 throw new IOException("IOException thown");
	}
}
class EmptyStringException extends Exception {
	
	
	public EmptyStringException() {
		super();
	}
	
	public EmptyStringException(String msg) {
		super(msg);
	}
	
}

class NullStringException extends EmptyStringException {
	
	
	public NullStringException() {
		super();
	}
	
	public NullStringException(String msg) {
		super(msg);
	}
	
}

class LongerStringException extends Exception {
	
	
	public LongerStringException() {
		super();
	}
	
	public LongerStringException(String msg) {
		super(msg);
	}
	
}