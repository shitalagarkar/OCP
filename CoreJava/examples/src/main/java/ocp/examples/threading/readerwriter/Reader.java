package ocp.examples.threading.readerwriter;

public class Reader implements Runnable {

	NoteBook nBk;
	public Reader(NoteBook nBk) {
		this.nBk = nBk;
	}
	
	public String read () {
		this.nBk.setWritting(false);
		return this.nBk.getData();
	}
	
	@Override
	public void run() {
	System.out.println("Reader Thread Run.....");
	while(true) {	
		synchronized (nBk) {
			while(nBk.isWritting) {
				try{
					nBk.wait();
					System.out.println("Reading waiting...");
				}catch(Exception e) {
					System.out.println("Reading interrupted exception." + e.getClass().getName() + " Message: " + e.getMessage());
				}
			}	
				System.out.println(" Read Data: " + read());
				nBk.notifyAll();
			
		}
	}
	}

}
