package data.h2;

import java.sql.Connection;

public class H2PostDAO {

	// Connection aus H2DAOFactory holen
		Connection con=H2DAOFactory.getConnection();
		
		// SQL-Befehle als String vorbereiten
		String stmtSelectPost="SELECT title, message FROM Post";
		
		// Methoden
		@Override
		public List<PostTransferObject> getAllPosts() {
			List <PostTransferObject> postList=new LinkedList<PostTransferObject>();
			try{
				PreparedStatement stmt=con.prepareStatement(stmtSelectPost);
				// Statement ausf�hren
				ResultSet rs= stmt.executeQuery();
				// Inhalte auslesen
				while(rs.next()){
					// neuen tempor�ren Post erstellen 
					PostTransferObject tempPost= new PostTransferObject();
					// tempor�ren Post mit Daten aus der Tabelle f�llen
					tempPost.setTitle(rs.getInt("id"));
					tempPost.setMessage(rs.getString("name"));
					//Post zur Liste hinzuf�gen
					postList.add(tempPost);		
				}	
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			return postList;
		}
		
		
}
