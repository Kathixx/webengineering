package data;

import transfer.PostTransferObject;

public interface PostDAO {

	
	/** Methode zum Auslesen aller Posts */
	public List<PostTransferObject> getAllPosts();
}
