
package data.h2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.UserDAO;
import transfer.UserTransferObject;

public class H2UserDAO implements UserDAO {

	// Connection aus H2DAOFactory holen
	Connection con=H2DAOFactory.getConnection();
	
	// SQL-Befehle als String vorbereiten
	
	String stmtInsert="INSERT INTO User ( name, password) VALUES (?,?)";
	String stmtGetUserByName="SELECT * FROM User WHERE name=?";
	String stmtFindName="SELECT * FROM User WHERE name=?";
	String stmtGetPassword="SELECT password FROM User WHERE name=?";

	
	// Methoden
	
	@Override
	public boolean addUser(UserTransferObject newUser) {
		try{
			PreparedStatement stmt=con.prepareStatement(stmtInsert);
			stmt.setString(1, newUser.getName());
			stmt.setString(2, newUser.getPassword());
			stmt.execute();
			return true;
		}
		catch (SQLException e){
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public boolean getUserByName(String name) {
		try{
			PreparedStatement stmt=con.prepareStatement(stmtGetUserByName);
			stmt.setString(1, name);
			ResultSet rs=stmt.executeQuery();
			if(!rs.next())return false;
			else return true;
		}
		catch(SQLException e){
			e.printStackTrace();
			return false;
		}
		
	}


	@Override
	public boolean findName(String name) {
		try{
			PreparedStatement stmt=con.prepareStatement(stmtFindName);
			stmt.setString(1, name);
			ResultSet rs=stmt.executeQuery();
			if (!rs.next())return false;
			else return true;
		}
		catch (SQLException e){
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public String getPassword (String name) {
		String password=null;
		try{
			PreparedStatement stmt=con.prepareStatement(stmtGetPassword);
			stmt.setString(1, name);
			ResultSet rs= stmt.executeQuery();
			if (rs.next())password=rs.getNString(1);
			return password;
			
		}
		catch (SQLException e){
			e.printStackTrace();
			return password;
		}
	}
	
	
	



	
	
	
	
	
}