package data.h2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import data.UserDAO;
import transfer.UserTransferObject;

public class H2UserDAO implements UserDAO {

	// Connection aus H2DAOFactory holen
	Connection con=H2DAOFactory.getConnection();
	
	// SQL-Befehle als String vorbereiten
	
	String stmtInsert="INSERT INTO User ( name, password, sessionid) VALUES (?,?,?)";

	
	// Methoden
	
	@Override
	public boolean addUser(UserTransferObject newUser) {
		try{
			PreparedStatement stmt=con.prepareStatement(stmtInsert);
			stmt.setString(1, newUser.getName());
			stmt.setString(2, newUser.getPassword());
			stmt.setString(3, newUser.getSessionId());
			stmt.execute();
			return true;
		}
		catch (SQLException e){
			e.printStackTrace();
			return false;
		}
	}



	
	
	
	
	
}
