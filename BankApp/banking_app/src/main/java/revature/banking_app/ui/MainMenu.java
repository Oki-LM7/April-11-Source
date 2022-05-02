package revature.banking_app.ui;

import java.util.HashMap;

public  class MainMenu implements inputable {
	MenuNavigation nav = new MenuNavigation();

	static MainMenu  mainMenu = new MainMenu();

	public static iUserObject userObject;

     HashMap currentUserInfo ;
	String mainMessage = "Hello welcome to the bank app. " ;

	String loginMessage = "Please Sign in. Type 1 to login Type 2 to Register: ";
	//LoginOrRegisterPrompt(login,Register)

	String continueMessage = " Would you like to continue using the app? Type 1 for yes Type 2 for no";


	static  MainMenu  getMainMenu(){
		return mainMenu;
	}


	public void setCurrentUserInfo(HashMap currentUserInfo) {
		this.currentUserInfo = currentUserInfo;
	}

	public HashMap getCurrentUserInfo() {
		return currentUserInfo;
	}

	public MainMenu(){
		
	}
	

	
	public void  loginOrRegister(int login) {
	    if(login == 1){
			LoginMenu loginMenu = new LoginMenu();
			loginMenu.menuOptions();
		} else if (login == 2) {
			RegisterMenu registerMenu = new RegisterMenu();
			registerMenu.menuOptions();
		} else if (login == 8) {
			nav.exitApp();

		}else {
			wrongInputOptions();
		}
	}
	
	public static void welcome() {
		userObject.welcomePrompt();
		System.out.println("remember you can always log out by inputting 8 into question prompts");
	}
	
	public void backOptions() {
		userObject.backGreeting();

		int continueOptions = input.promptforInt(continueMessage);
		if(continueOptions == 1){
			userObject.startMainMenu();
		}else{
			nav.exitApp();
		}
	}


	public  iUserObject getUserObject(){
		return userObject;
	}

	@Override
	public void menuOptions() {
		// TODO Auto-generated method stub
		System.out.println(mainMessage);


		
		int login = input.promptforInt(loginMessage);
		loginOrRegister(login);
		
		
	}

	public void setUserObject(iUserObject userObject) {
		this.userObject = userObject;
	}

	@Override
	public void wrongInputOptions() {
		// TODO Auto-generated method stub
		System.out.println("please add in the right input");
		int login = input.promptforInt(loginMessage);
		loginOrRegister(login);
		
	}
	
	

}
