package revature.banking_app.ui;

public  class MainMenu implements inputable {
	MenuNavigation nav = new MenuNavigation();

	static MainMenu  mainMenu = new MainMenu();



	 static  MainMenu  getMainMenu(){
		return mainMenu;
	}
	public iUserObject userObject;
	
	String mainMessage = "Hello welcome to the bank app. " ;
	
	String loginMessage = "Please Sign in. Type 1 to login Type 2 to Register: ";
	//LoginOrRegisterPrompt(login,Register)
	
	String continueMessage = " Would you like to continue using the app? Type 1 for yes Type 2 for no";

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
	
	public void welcome() {
		userObject.welcomePrompt();
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
		
	}
	
	

}
