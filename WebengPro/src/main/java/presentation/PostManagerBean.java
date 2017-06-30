package presentation;

@ManagedBean (name="postList")
public class PostManagerBean {

	List <Post> allPost;
	
	public PostManagerBean(){};
	
	
	public List getAllPost(){
		return allPost;
	}
	
	public List setAllPost(List allPost){
		this.allPost= allPost;
	}

	private void getPostFromDB(){
		PostManager manager= new PostManager();
		List allPostFromDB=manager.getAllPost();
		this.setAllPost(allPostFromDB);
	}
}
