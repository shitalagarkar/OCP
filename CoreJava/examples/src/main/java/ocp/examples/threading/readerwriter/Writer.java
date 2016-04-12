package ocp.examples.threading.readerwriter;

public class Writer implements Runnable {
	NoteBook nBk;
	int count = 1;
	
	public Writer(NoteBook nBK) {
		this.nBk = nBK;
	}
	
	public void write () {
		this.nBk.setWritting(true);
			this.nBk.setData(count+" ");
			count++;
	}
	
	@Override
	public void run() {
		System.out.println("Writer Thread Run.....");
	while(true) {
		synchronized (nBk) {
			while(!nBk.isWritting) {
				try{
					nBk.wait();
					System.out.println("Writting waiting...");
				}catch(Exception e) {
					System.out.println("Reading interrupted exception." + e.getClass().getName() + " Message: " + e.getMessage());
				}
			}	
				write();
				try {
					Thread.sleep(100000);
				}catch(InterruptedException e) {
					
				}
				nBk.setWritting(false);
				nBk.notifyAll();
				
		}
		
	}
		
	}

}
