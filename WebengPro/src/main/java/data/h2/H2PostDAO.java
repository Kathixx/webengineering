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
		String stmtSelectPost="SELECT Post.title, Post.message, Post.timestamp, User.name From Post, User WHERE  User.id=Post.user";
		String stmtSearchPosts="SELECT Post.title, Post.message, Post.timestamp, User.name From Post, User WHERE  User.id=Post.user AND (INSTR(title, ?) OR INSTR (message, ?)) " ;
		String stmtSelectUser="SELECT name FROM User WHERE id=?";
		String stmtSearchPostTitle="Select title FROM Post WHERE INSTR (message, ?) OR INSTR (title,?)";
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
					tempPost.setTitle(rs.getNString("Post.title"));
					tempPost.setMessage(rs.getNString("Post.message"));
					tempPost.setUser(rs.getNString("User.name"));
					tempPost.setTimestamp(rs.getTimestamp("Post.timestamp"));
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
				PreparedStatement stmt=con.prepareStatement(stmtSearchPosts);
				stmt.setString(1, searchValue);
				stmt.setString(2, searchValue);
				// Statement ausführen
				ResultSet rs= stmt.executeQuery();
				System.out.println("Stmt wurde ausgeführt!");
				while(rs.next()){
					PostTransferObject tempPost= new PostTransferObject();
					// neuen temporären Post erstellen 
					System.out.println("Suche nach: "+searchValue+" war erfolgreich.");
					// temporären Post mit Daten aus der Tabelle füllen
					tempPost.setTitle(rs.getNString("Post.title"));
					tempPost.setMessage(rs.getNString("Post.message"));
					tempPost.setTimestamp(rs.getTimestamp("Post.timestamp"));
					tempPost.setUser(rs.getNString("User.name"));
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
		
		public List<String> searchPostTitle(String searchValue) {
			List <String> titleList=new ArrayList<>();
			try{
				PreparedStatement stmt=con.prepareStatement(stmtSearchPostTitle);
				stmt.setString(1, searchValue);
				stmt.setString(2, searchValue);
				// Statement ausführen
				ResultSet rs= stmt.executeQuery();
				System.out.println("Stmt wurde ausgeführt!");
				while(rs.next()){
					//Title zur Liste hinzufügen
					titleList.add(rs.getNString("title"));		
				}
				
				
			}
			catch(SQLException e){
				e.printStackTrace();
				System.out.println("DB fehler bei der Suche.");
				titleList.add("ERROR");
			}
			return titleList;
		}
		
		
		@Override
		public boolean addPost(PostTransferObject newPost) {
				try {
					
					PreparedStatement stmt=con.prepareStatement(stmtInsertPost);
					stmt.setString(1, newPost.getTitle());
					stmt.setString(2, newPost.getMessage());
					stmt.setInt(3,1);
					stmt.execute();
					return true;
				}
				catch (SQLException e){
					e.printStackTrace();
					return false;
				}
			
		}

		
		@Override
		public String findUserName(int id) {
				try {
					PreparedStatement stmt2=con.prepareStatement(stmtSelectUser);
					ResultSet rs2=stmt2.executeQuery();
					while(rs2.next()){
						System.out.println("ResultSet2 wurde gefunden");
						return rs2.getString("name");
					}
					return "Error";
				}
				catch (SQLException e){
					e.printStackTrace();
					return "ERROR";
				}
			
		}


	


		
		
		
		
}
