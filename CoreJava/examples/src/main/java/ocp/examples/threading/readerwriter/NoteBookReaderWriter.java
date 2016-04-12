package ocp.examples.threading.readerwriter;

public class NoteBookReaderWriter {

	public static void main (String args[]) {
		NoteBook noteBook = new NoteBook();
		Reader reader = new Reader(noteBook);
		Writer writer = new Writer(noteBook);
		
		Thread readerT = new Thread(reader);
		Thread writerT = new Thread(writer);
		
		
		writerT.start();
		readerT.start();
	}
	
}
