package revature.banking_app.ui;

public  abstract class inputable {


	iUserObject userObject;
	ScannerInput input = new ScannerInput();
	public abstract void menuOptions();

	public abstract void wrongInputOptions();


	public void backOptions() {
		String continueMessage = " Would you like to continue using the app? Type 1 for yes Type 2 for no";
		userObject.backGreeting();

		int continueOptions = input.promptforInt(continueMessage);
		if(continueOptions == 1){
			userObject.startMainMenu();
		}else{
			exitApp();
		}
	}

	public void backOptions(iUserObject userObject){
      this.userObject = userObject;
	  backOptions();
	}

	void please() {
		System.out.println("please put in the right input");
	}

	void exitApp(){
		userObject.exitGreeting();
		MainMenu mainMenu = new MainMenu();
	}

}
