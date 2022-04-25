package revature.banking_app.ui;

public class MainMenu implements inputable {
	MenuNavigation nav = new MenuNavigation();
	public iUserObject userObject;
	
	String mainMessage = "Hello welcome to the bank app. " ;
	
	String loginMessage = "Please Sign in. Type 1 to login Type 2 to Register: ";
	//LoginOrRegisterPrompt(login,Register)
	
	
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
		
	}

	@Override
	public void menuOptions() {
		// TODO Auto-generated method stub
		System.out.println(mainMessage);
		ScannerInput input = new ScannerInput();

		
		int login = input.promptforInt(loginMessage);
		loginOrRegister(login);
		
		
	}

	@Override
	public void wrongInputOptions() {
		// TODO Auto-generated method stub
		
	}
	
	

}
