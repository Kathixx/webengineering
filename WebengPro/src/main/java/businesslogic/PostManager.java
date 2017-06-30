package businesslogic;

public class PostManager {


PostDAO postDAO;
	
	public PostManager() {
		super();
		postDAO = DAOFactory.getDAOFactory(Backend.H2).getPostDAO();
	}
	
	//Liste mit allen Usern
	public List getAllPost (){
		return PostDAO.getAllPosts();
	}
}
