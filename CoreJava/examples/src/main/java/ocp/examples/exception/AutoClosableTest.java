package ocp.examples.exception;

import java.io.IOException;

public class AutoClosableTest {
	
	public static void main(String[] args) {
		try ( One o1 = new One();Two t1 = new Two();Three t2 = new Three() ) {
			throw new NullStringException();
		}catch(EmptyStringException e){
			System.out.println("inside EmptyStringException catch");
			e.printStackTrace();
		}catch(Exception e1){
			System.out.println("inside Exception catch");
		}finally {
			System.out.println("insider finally");
		}
	}
}	


class One implements AutoCloseable {
	@Override
	public void close() throws Exception {
		System.out.println("inside one - close");
		throw new EmptyStringException ("Exception from One -Close");
	}
}

class Two implements AutoCloseable {
	@Override
	public void close() throws Exception {
		System.out.println("inside Two - close");
		throw new IOException ("Exception from One -Close");
	}
}

class Three implements AutoCloseable {
	@Override
	public void close() throws Exception {
		System.out.println("inside Three - close");
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