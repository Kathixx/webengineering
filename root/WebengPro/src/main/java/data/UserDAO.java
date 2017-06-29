package data;

import transfer.UserTransferObject;

public interface UserDAO {
	
	/** Methoden */
	public boolean addUser(UserTransferObject newUser);
	
	
	public boolean getUserByName(String name);
	
	
	public boolean findName(String name);
}
