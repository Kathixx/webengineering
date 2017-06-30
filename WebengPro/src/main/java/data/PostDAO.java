package data;

import java.util.List;

import transfer.PostTransferObject;

public interface PostDAO {

	
	/** Methode zum Auslesen aller Posts */
	public List<PostTransferObject> getAllPost();
}
