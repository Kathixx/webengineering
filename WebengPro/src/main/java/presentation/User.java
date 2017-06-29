package presentation;

import java.io.Serializable;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import businesslogic.UserManager;
import transfer.UserTransferObject;
// Geben Daten zwischen den Seiten weiter (nicht in die Datenbank)
// Mittel dazu JSF Expression Language
//https://www.youtube.com/watch?v=0MR0ONn5J3c

@ManagedBean (name="user")
@RequestScoped
public class User implements Serializable {
	
	// private Variablen 
	private String name;
	private String password;
	
	// Manager
	UserManager manager= new UserManager();

	// Constructor ohne Argumente
	public User(){}


	//public Getter und Setter 
	// RM >> Source >> GENERATE SOURCE CODE 
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}
	
	// Methoden
	public String add (){
		UserTransferObject newUser= new UserTransferObject();
		newUser.setName(this.name);
		newUser.setPassword(this.password);
		manager.addUserData(newUser);
		return "";
	}
	
	
	
}
