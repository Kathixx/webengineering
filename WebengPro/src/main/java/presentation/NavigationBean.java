package presentation;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean (name="navigation")
@RequestScoped
public class NavigationBean {

	
	
	public static final int LOGIN = 0;
	public static final int MENU1 = 1;
	
	
	static boolean loggedIn=false;

	
	//Methoden


	public boolean isLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(boolean loginPermitted) {
		this.loggedIn = loggedIn;
	}
	
	public static void changePermission() {
		if (loggedIn) loggedIn=false;
		else loggedIn= true;
		System.out.println("Permission Change, new Value: "+loggedIn);
	}
	
	public String goToMainPage() throws IOException{
		return "ok";
	}
	
	public String goToLogin(){
		loggedIn=false;
		System.out.println("Login aufgerufen: "+loggedIn);
		return "ok";
		
	}
	
	public String goToCreatePost() throws IOException{
		return "ok";
	}
	
	public String goToRegister() throws IOException{
		return "ok";
	}
	
}
