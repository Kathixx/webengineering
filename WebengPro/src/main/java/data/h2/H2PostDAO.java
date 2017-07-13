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
		String stmtSearchPost="Select title, message FROM Post WHERE message CONTAINS ? OR title CONTAINS ?";
		String stmtInsertPost="INSERT INTO Post (title, message, user) VALUES (?,?,?)";
		
		// Methoden
		@Override
		public List<PostTransferObject> getAllPost() {
			List <PostTransferObject> postList=new ArrayList<PostTransferObject>();
			try{
				PreparedStatement stmt=con.prepareStatement(stmtSelectPost);
				// Statement ausführen
				ResultSet rs= stmt.executeQuery();
				
				while(rs.next()){
					// neuen temporären Post erstellen 
					PostTransferObject tempPost= new PostTransferObject();
					// temporären Post mit Daten aus der Tabelle füllen
					tempPost.setTitle(rs.getNString("title"));
					tempPost.setMessage(rs.getNString("message"));
					//Post zur Liste hinzufügen
					postList.add(tempPost);		
				}
				
				
			}
			catch(SQLException e){
				e.printStackTrace();
				PostTransferObject tempPost=new PostTransferObject();
				tempPost.setTitle("Title");
				tempPost.setMessage("Message");
				postList.add(tempPost);
			}
			return postList;
		}

		
		public List<PostTransferObject> searchPosts(String searchValue) {
			List <PostTransferObject> postList=new ArrayList<PostTransferObject>();
			try{
				PreparedStatement stmt=con.prepareStatement(stmtSearchPost);
				stmt.setString(1, searchValue);
				stmt.setString(2, searchValue);
				// Statement ausführen
				ResultSet rs= stmt.executeQuery();
				System.out.println("Stmt wurde ausgeführt!");
				while(rs.next()){
					PostTransferObject tempPost= new PostTransferObject();
					// neuen temporären Post erstellen 
					System.out.println("Suche nach: "+searchValue+"war erfolgreich.");
					// temporären Post mit Daten aus der Tabelle füllen
					tempPost.setTitle(rs.getNString("title"));
					tempPost.setMessage(rs.getNString("message"));
					//Post zur Liste hinzufügen
					postList.add(tempPost);		
				}
				
				
			}
			catch(SQLException e){
				e.printStackTrace();
				System.out.println("DB fehler bei der Suche.");
				PostTransferObject tempPost=new PostTransferObject();
				tempPost.setTitle("Title");
				tempPost.setMessage("Message");
				postList.add(tempPost);
			}
			return postList;
		}
		
		
		@Override
		public boolean addPost(PostTransferObject newPost) {
				try {
					
					PreparedStatement stmt=con.prepareStatement(stmtInsertPost);
					stmt.setString(1, newPost.getTitle());
					stmt.setString(2, newPost.getMessage());
					stmt.setInt(3, 2);
					stmt.execute();
					return true;
				}
				catch (SQLException e){
					e.printStackTrace();
					return false;
				}
			
		}


		
		
		
		
}
