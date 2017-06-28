package data;

import transfer.UserTransferObject;

public interface UserDAO {
	
	/** Methoden */
	public boolean addUser(UserTransferObject newUser);
	
}
