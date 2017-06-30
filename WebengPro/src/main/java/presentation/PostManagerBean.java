package presentation;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import businesslogic.PostManager;
import transfer.PostTransferObject;

@ManagedBean (name="postList")
@RequestScoped
public class PostManagerBean {

	List <PostTransferObject> allPost= new ArrayList <PostTransferObject> ();
	
	public PostManagerBean(){
		System.out.println("PostManagerBean wurde erstellt");
	};
	
	
	
	public List<PostTransferObject> getAllPost() {
		return allPost;
	}

	
	public void setAllPost(List<PostTransferObject> allPost) {
		this.allPost = allPost;
	}

	@PostConstruct
	private void getPostFromDB(){
		System.out.println("getPostFromDB wird aufgerufen");
		PostManager manager= new PostManager();
		System.out.println("Postliste: "+manager.getAllPost().size());
		List<PostTransferObject> allPostFromDB=manager.getAllPost();
		this.setAllPost(allPostFromDB);
	}
}
