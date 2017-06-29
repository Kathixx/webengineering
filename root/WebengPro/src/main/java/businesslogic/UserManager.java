package businesslogic;

import java.util.List;

import data.DAOFactory;
import data.DAOFactory.Backend;
import data.UserDAO;
import transfer.UserTransferObject;



public class UserManager {
	
	
	UserDAO userDAO;

	public UserManager() {
		super();
		userDAO = DAOFactory.getDAOFactory(Backend.H2).getUserDAO();
	}
	
	public boolean addUserData(UserTransferObject newUser){
		return userDAO.addUser(newUser);
	}
	
	public boolean getUserByName(String name){
		return userDAO.getUserByName(name);
	}
	
	public boolean findName (String name){
		return userDAO.findName(name);
	}
	

}
