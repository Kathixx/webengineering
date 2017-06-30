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
				// Statement ausführen
				ResultSet rs= stmt.executeQuery();
				// Inhalte auslesen
				while(rs.next()){
					// neuen temporären Post erstellen 
					PostTransferObject tempPost= new PostTransferObject();
					// temporären Post mit Daten aus der Tabelle füllen
					tempPost.setTitle(rs.getInt("id"));
					tempPost.setMessage(rs.getString("name"));
					//Post zur Liste hinzufügen
					postList.add(tempPost);		
				}	
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			return postList;
		}
		
		
}
