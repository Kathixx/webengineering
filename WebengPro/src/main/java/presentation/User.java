
package presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
	private List <String> errors=new ArrayList <String>();;
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
	
	
	public List <String> getErrors() {
		return errors;
	}


	public void setError(String error) {
		this.errors.add(error);
	}
	
	

	// Methoden
	
	// f�gt beim Registriervorgang einen neuen User in die Datenbank ein
	//TODO �berpr�fung ob beide Passw�rter gleich sind, sonst fehlermeldung auswerfen
	// TODO best�tigung dass Registrierung erfolgreich war und man sich jetzt einloggen kann
	public String add (){
		if (!nameAlreadyExists(this.name)){
			UserTransferObject newUser= new UserTransferObject();
			newUser.setName(this.name);
				//if(this.password.equals(password2)){
					newUser.setPassword(this.password);
					manager.addUserData(newUser);
					setSuccess("<b>Herzlich willkommen!</b> Du wurdest erfolgreich registriert.");
					return "Login.xhtml";
				//}  else errors="Passw�rter stimmen nicht �berein";
		}
		else{
			setError("Benutzername bereits vergeben.Bitte suche dir einen anderen Benutzernamen aus!");
			return "Register.xhtml";
		}
	}
	
	// Methode die checkt ob Login erfolgreich war
	// leitet an hauptseite weiter
	public String checkLogin(String name){
		System.out.println("aktueller UserName: "+this.name);
		System.out.println("User ind DB gefunden: "+manager.getUserByName(this.name));
		System.out.println("Passwort in DB gefunden: " +manager.getPassword(this.name));
		//Überprüfung ob User in DB existiert
		if (!manager.getUserByName(this.name)){
			setError("Der Benutzername exisitiert nicht.");
		}
		else{
			//Überprüfung Passwort
			if(!manager.getPassword(this.name).equals(this.password)){
				setError("Das eingegebene Passwort stimmt nicht überein.");
			}
			else
				//Hauptseite, die nach login kommt aufrufen
				return "MainPage.xhtml";
		}
		
		return "";
	}
	
	
	public boolean nameAlreadyExists(String newName){
		System.out.println("Benutzername bereits vergeben?: "+manager.findName(newName));
		return manager.findName(newName);
	}

}