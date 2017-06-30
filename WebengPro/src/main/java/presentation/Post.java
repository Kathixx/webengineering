package presentation;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import businesslogic.PostManager;
import transfer.PostTransferObject;

@ManagedBean (name="post")
@RequestScoped
public class Post {
	
	// private Variablen 
	private String title;
	private String message;
	private String errors;
	private String success;
	
	// Manager
	PostManager manager= new PostManager();

	// Constructor ohne Argumente
	public Post(){}


	//public Getter und Setter 
	// RM >> Source >> GENERATE SOURCE CODE 
	public String getTitle() {
		return title;
	}

	public void setTitle (String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}



	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public String getSuccess() {
		return success;
	}


	public void setSuccess(String success) {
		this.success = success;
	}
	
	
	public String getErrors() {
		return errors;
	}


	public void setErrors(String errors) {
		this.errors = errors;
	}

	// Methoden
	/*Liste mit allen Posts
	public String allPostsToString(List <PostTransferObject>postList){
		String postString="";
		for (PostTransferObject post:postList){
			//Liste aller hinzugefügten Posts
			postString=postString+"<tr> <td>"+post.getTitle()+"</td><td>"+post.getMessage()+"</td></tr>";
		}
		return postString;
		
	}*/

}
