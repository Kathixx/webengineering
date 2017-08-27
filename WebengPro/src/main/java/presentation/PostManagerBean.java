package presentation;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;

import businesslogic.PostManager;
import transfer.PostTransferObject;
import transfer.UserTransferObject;

@ManagedBean (name="postList")
@RequestScoped
public class PostManagerBean {

	List <PostTransferObject> allPost= new ArrayList <PostTransferObject> ();
//	List <String> titleList=new ArrayList <>();
	String searchValue;
	String title; 
	String message; 
	Timestamp timestamp;
//	boolean searchOn=false;
	
	
//	public boolean isSearchOn() {
//		return searchOn;
//	}
//
//
//
//	public void setSearchOn(boolean searchOn) {
//		this.searchOn = searchOn;
//	}
//	
//	
//	public List<String> getTitleList() {
//		return titleList;
//	}
//
//
//
//	public void setTitleList(List<String> titleList) {
//		this.titleList = titleList;
//	}



	public PostManagerBean(){
		//System.out.println("PostManagerBean wurde erstellt");
	};
	
	
	
	public List<PostTransferObject> getAllPost() {
		return allPost;
	}

	
	public void setAllPost(List<PostTransferObject> allPost) {
		this.allPost = allPost;
	}
	
	
	

	public String getSearchValue() {
		return searchValue;
	}



	public void setSearchValue(String searchValue) {
		this.searchValue = searchValue;
	}
	
	public String getTitle (){
		return title;
	}
	
	public void setTitle(String title){
		this.title=title;
	}
	
	public String getMessage(){
		return message;
	}
	
	public void setMessage(String message){
		this.message=message;
	}
	
	
	
	public Timestamp getTimestamp() {
		return timestamp;
	}



	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}



	//Methoden
	public String addPost (){
			PostTransferObject newPost= new PostTransferObject();
			newPost.setTitle(this.title);
			newPost.setMessage(this.message);
			
			PostManager manager = new PostManager();
			manager.addPost(newPost);
			
			return "hinzugefügt";

	}
	



	@PostConstruct
	private void getPostFromDB(){
		//System.out.println("getPostFromDB wird aufgerufen");
		PostManager manager= new PostManager();
		//System.out.println("Postliste: "+manager.getAllPost().size());
		List<PostTransferObject> allPostFromDB=manager.getAllPost();
		this.setAllPost(allPostFromDB);
	}
	
	// AJAX Listener
	public void searchListenerPost (AjaxBehaviorEvent e){
//		searchOn=true;
		System.out.println("searchListener wurde aufgerufen durch Evenet.");
		System.out.println("Wort nachdem gesucht wird: "+this.searchValue);
		PostManager manager= new PostManager();
		this.setAllPost(manager.searchPosts(this.searchValue));
		System.out.println("Länge der aktuellen List: " + allPost.size());
	}
	
//	public void searchListener(AjaxBehaviorEvent e){
//		System.out.println("searchListener wurde aufgerufen, es wird nach folgendem Wort gesucht: "+this.searchValue);
//		PostManager manager=new PostManager();
//		this.setTitleList(manager.searchPostTitle(this.searchValue));
//		System.out.println("Länge der gefundenen TitleListe: "+titleList.size());
//	}

	
	
}
