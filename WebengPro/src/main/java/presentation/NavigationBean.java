package presentation;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean (name="navigation")
@RequestScoped
public class NavigationBean {

	
	
	public static final int LOGIN = 0;
	public static final int MENU1 = 1;
	
	int navigationStatus = LOGIN;
	
	//Constructor
	public NavigationBean(){
	}
	
	//Methoden
	public int getNavigationStatus() {
	return navigationStatus;
	}
	public void setNavigationStatus(int navigationStatus) {
	this.navigationStatus = navigationStatus;
	}
	public boolean getLoginVisible() {
	if (navigationStatus==LOGIN) return true;
	else return false;
	}
	public boolean getLogoutVisible() {
	if (navigationStatus==LOGIN) return false;
	else return true;
	}
	
}
