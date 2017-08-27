package transfer;

import java.sql.Timestamp;

public class PostTransferObject {
	
	//Instanzvariablen
	
	String title;
	String message;
	Timestamp timestamp;
	String user;
	
	
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

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}
	
}
