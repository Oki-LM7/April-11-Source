package revature.banking_app.ui;

public class MainMenu implements inputable {
	MenuNavigation nav = new MenuNavigation();
	public iUserObject userObject;
	
	String whichMessage = "Hello welcome to the bank app. Type 1 if you are a "
			+ "customer Type 2 if you are an employee: ";
	
	String loginMessage = "Please Sign in. Type 1 to login Type 2 to Register: ";
	//LoginOrRegisterPrompt(login,Register)
	
	
	public MainMenu(){
		
	}
	
	public void whichUser(int userType) {
		 if(userType == 1) {
			 CustomerMainMenu cMenu = new CustomerMainMenu();
			 
		 }else if(userType == 2) {
			 
		 }else if(userType == 8) {
		 
		 }else {
			 
		 }
	}
	
	public void loginOrRegister(int login) {
		
		
	}
	
	public void welcome() {
		userObject.welcomePrompt();
	}
	
	public void backOptions() {
		
	}

	@Override
	public void menuOptions() {
		// TODO Auto-generated method stub
		ScannerInput input = new ScannerInput();
		int userType = input.promptforInt(whichMessage);
		
		whichUser(userType);
		
		int login = input.promptforInt(loginMessage);
		loginOrRegister(login);
		
		
	}

	@Override
	public void wrongInputOptions() {
		// TODO Auto-generated method stub
		
	}
	
	

}
