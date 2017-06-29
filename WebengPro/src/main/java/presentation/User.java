
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
	private String errors;
	private String success;
	
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
	
	
	public String getSuccess() {
		return success;
	}


	public void setSuccess(String success) {
		this.success = success;
	}
	
	
	public String getErrors() {
		return errors;
	}


	public void setErrors(String errors) {
		this.errors = errors;
	}

	// Methoden
	
	// f�gt beim Registriervorgang einen neuen User in die Datenbank ein
	//TODO �berpr�fung ob beide Passw�rter gleich sind, sonst fehlermeldung auswerfen
	// TODO best�tigung dass Registrierung erfolgreich war und man sich jetzt einloggen kann
	public String add (){
		if (!nameAlreadyExists(this.name)){
		UserTransferObject newUser= new UserTransferObject();
		newUser.setName(this.name);
		newUser.setPassword(this.password);
		manager.addUserData(newUser);
		setSuccess("<b>Herzlich willkommen!</b> Du wurdest erfolgreich registriert.");
		return "Login.xhtml";
		}
		else{
			errors="Benutzername bereits vergeben.Bitte suche dir einen anderen Benutzernamen aus!";
			return "Register.xhtml";
		}
	}
	
	// Methode die checkt ob Login erfolgreich war
	public String checkLogin(){
		
		return "";
		
	}
	
	public boolean nameAlreadyExists(String newName){
		System.out.println("CHeckicheck!"+manager.findName(newName));
		return manager.findName(newName);
	}


	
	
	
	
}