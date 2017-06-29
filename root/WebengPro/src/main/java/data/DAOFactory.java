package data;

import data.h2.H2DAOFactory;

public abstract class DAOFactory {
	// List of DAO types supported by the factory
	public enum Backend
	{
		H2
	}
		

	public static DAOFactory getDAOFactory(Backend whichFactory) {
		switch (whichFactory) {
		case H2:
			return new H2DAOFactory();
		default:
			return null;
		}
	}
	


	public abstract UserDAO getUserDAO();
	public abstract PostDAO getPostDAO();
	public abstract CommentDAO getCommentDAO();
	
}