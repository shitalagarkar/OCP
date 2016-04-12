package ocp.examples.exception;

import java.io.IOException;

public class SupressExceptions {
	public static void main (String[] args) throws Exception{
		SupressExceptions exp = new SupressExceptions();
		try {
			exp.method2();
		}catch(Exception e) {
			System.out.println("Main Exception");
			e.printStackTrace();
			//throw new Exception ("Main Exception thrown");
		}
	}

public void method1 () throws IOException {
	System.out.println("method1");
	throw new IOException ("Method1 Exception");
}

public void method2 () throws Exception {
	System.out.println("method2");
	try {
		method1();
	} catch(IOException e){
		System.out.println("method2 catch");
		throw  new AppException ("Method1 Exception",e); // ADDS Clause to stack trace. 

	/*Exception e1 =  new AppException ("Method1 Exception");
	e1.addSuppressed(e);
	throw e1;*/ //SUPRESSED EXCEPTION
	}
}

}
class AppException extends Exception {
	
	
	public AppException() {
		super();
	}
	
	public AppException(String msg) {
		super(msg);
	}
	
	public AppException(String msg, Throwable e) {
		super(msg, e);
	}
}