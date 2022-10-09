package revature.banking_app.ui;

import java.util.HashMap;

public abstract class iUserObject  {



	inputable currentMenu;

	inputable backToMenu;

	String name;

	boolean loggedIn;

	HashMap<String,Object> userInfo;

  MenuNavigation nav = new MenuNavigation(this);


	protected MenuNavigation getNav() {
		return nav;
	}

	protected abstract String getName();

	protected void setLoggedIn(){
		this.loggedIn = true;
	}

	protected boolean isLoggedIn(){
		return loggedIn;
	}

	protected void setUserInfo(HashMap<String,Object> userInfo){
		this.userInfo = userInfo;
	}

	  protected abstract void setName(String name);
	  protected abstract void  setRank(String rank);

	  protected abstract void setUsername(String username);




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
