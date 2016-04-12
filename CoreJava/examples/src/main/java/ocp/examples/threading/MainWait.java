/*
 * Write a program such that main thread waits until all the running threads are done.
 */
package ocp.examples.threading;

public class MainWait {
	
	public static void main(String[] args) {
		Thread currentThread = Thread.currentThread();
		RunThread r1 = new RunThread();
		RunThread r2 = new RunThread();
		RunThread r3 = new RunThread();
		
		Thread t1 = new Thread (r1 , "Thread R1");
		Thread t2 = new Thread (r2 , "Thread R2");
		Thread t3 = new Thread (r3 , "Thread R3");
		
		t1.start();
		t2.start();
		t3.start();
		try {
			t1.join();
			t2.join();
			t3.join();
		}catch (InterruptedException e) {
			
		}
		System.out.println("Main Thread Ending...");
	}

}

class RunThread implements Runnable {

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " Running...");
		try {
			Thread.sleep(10);
		}catch (InterruptedException e) {
			
		}
	}
	
	
}