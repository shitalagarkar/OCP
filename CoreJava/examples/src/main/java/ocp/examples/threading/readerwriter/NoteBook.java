package ocp.examples.threading.readerwriter;

public class NoteBook {
	StringBuilder data;
	boolean isWritting = true; 
	
	public boolean isWritting() {
		return isWritting;
	}

	public void setWritting(boolean isWritting) {
		this.isWritting = isWritting;
	}

	public NoteBook() {
		data = new StringBuilder();
	}
	
	public String getData() {
		isWritting = false;
		return data.toString();
	}

	public void setData(String data) {
		isWritting = true;
		this.data.append(data);
	}
	
}
