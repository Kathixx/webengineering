package businesslogic;

import java.util.List;

import data.DAOFactory;
import data.DAOFactory.Backend;
import data.PostDAO;
import presentation.Post;
import transfer.PostTransferObject;

public class PostManager {


PostDAO postDAO;
	
	public PostManager() {
		super();
		postDAO = DAOFactory.getDAOFactory(Backend.H2).getPostDAO();
		//System.out.println("PostManager wurde erstellt.");
	}
	
	//Liste mit allen Usern
	public List <PostTransferObject> getAllPost (){
		return postDAO.getAllPost();
	}
	
	public List <PostTransferObject> searchPosts (String searchValue){
		return postDAO.searchPosts(searchValue);
	}
}
