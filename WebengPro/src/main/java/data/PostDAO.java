package data;

import java.util.List;

import transfer.PostTransferObject;

public interface PostDAO {

	
	/** Methode zum Auslesen aller Posts */
	public List<PostTransferObject> getAllPost();
	
	public List <PostTransferObject> searchPosts(String searchValue);
	
	public boolean addPost (PostTransferObject newPost);
}
