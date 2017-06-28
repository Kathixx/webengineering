package data.h2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import data.CommentDAO;
import data.DAOFactory;
import data.PostDAO;
import data.UserDAO;




public class H2DAOFactory extends DAOFactory {
	
	private static final String DBDRIVER = "org.h2.Driver";
	private static final String DBURL = "jdbc:h2:./build/WebengPro";
	private static final String DBUSER = "v+k";
	private static final String DBPASSWORD = "vickykathi";

	private static Connection openConnection() {
		try {
			Class.forName(DBDRIVER).newInstance();
			connection = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
			System.out.println("Connected to database");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InstantiationException | IllegalAccessException | 	ClassNotFoundException e) {	
			e.printStackTrace();
		}
		return connection;
	}
	
//	private static void closeConnection() throws SQLException {
//		connection.createStatement().execute("SHUTDOWN");
//	}
	
	private static Connection connection;

	public static Connection getConnection() {
		if(connection == null)
			connection = openConnection();
		return connection;
	}


	


	@Override
	public UserDAO getUserDAO() {
		return new H2UserDAO();
	}





	@Override
	public PostDAO getPostDAO() {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public CommentDAO getCommentDAO() {
		// TODO Auto-generated method stub
		return null;
	} 
	
}