package transfer;

public class PostTransferObject {
	
	//Instanzvariablen
	
	String title;
	String message;
	
	//Blob image;
	//String user;
	
	public PostTransferObject(){
		//System.out.println("PostTransferObject wurde erstellt.");
	}

	//Getter und Setter
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
