package data.h2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import data.PostDAO;
import transfer.PostTransferObject;

public class H2PostDAO implements PostDAO{

	// Connection aus H2DAOFactory holen
		Connection con=H2DAOFactory.getConnection();
		
		// SQL-Befehle als String vorbereiten
		String stmtSelectPost="SELECT title, message FROM Post";
		
		// Methoden
		@Override
		public List<PostTransferObject> getAllPost() {
			List <PostTransferObject> postList=new ArrayList<PostTransferObject>();
			try{
				PreparedStatement stmt=con.prepareStatement(stmtSelectPost);
				// Statement ausf�hren
				ResultSet rs= stmt.executeQuery();
				
				while(rs.next()){
					PostTransferObject tempPost= new PostTransferObject();
					
					// neuen tempor�ren Post erstellen 
					System.out.println("REsultSet mit Eintr�gen wurde gefunden.");
					// tempor�ren Post mit Daten aus der Tabelle f�llen
					tempPost.setTitle(rs.getNString("title"));
					tempPost.setMessage(rs.getNString("message"));
					//Post zur Liste hinzuf�gen
					postList.add(tempPost);		
				}
				
				
			}
			catch(SQLException e){
				e.printStackTrace();
				System.out.println("DB fehler.");
				PostTransferObject tempPost=new PostTransferObject();
				tempPost.setTitle("Title");
				tempPost.setMessage("Message");
				postList.add(tempPost);
			}
			return postList;
		}
		
		
}
