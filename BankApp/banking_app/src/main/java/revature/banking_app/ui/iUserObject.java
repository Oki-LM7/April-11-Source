package revature.banking_app.ui;

import java.util.HashMap;

public abstract class iUserObject  {







	String name;


	HashMap<String,Object> userInfo;

  MenuNavigation nav = new MenuNavigation();


	protected MenuNavigation getNav() {
		return nav;
	}

	protected abstract String getName();



	protected void setUserInfo(HashMap<String,Object> userInfo){
		this.userInfo = userInfo;
	}








	  protected abstract String getRank();




     protected abstract MainMenu getMainMenu();

     //data

    //logic




	//UI


		protected void welcomePrompt() {
			System.out.println("Welcome " + name);
		}

		protected void backGreeting() {
			System.out.println("Hello again " + name);
		}

		protected void exitGreeting() {
			System.out.println("Good bye " + name);
		}


	 protected abstract void startMainMenu();

	 protected abstract HashMap getCurrentUserInfo();




    protected abstract String getUsername();
}
