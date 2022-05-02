package revature.banking_app.ui;

public class CustomerMainMenu extends MainMenu implements inputable {
   MenuNavigation nav = new MenuNavigation();
	//String customerWelcome = "Hello ";
	String helpMessage = "How can we help you today? Type 1 for applying for an account" +
			"Type 2 for accessing accessing accounts   Type 3 for checking approval status ";

	String anythingElse = "Anything else we can do for you today? Type 1 for yes Type 2 for no";
	void howCanWeHelp(int helpType) {
		if(helpType == 1){
			AccountsApplicationMenu applicationMenu = new AccountsApplicationMenu();
			applicationMenu.menuOptions();
		} else if (helpType == 2) {
			AccountsMenu accountsMenu = new AccountsMenu();
			accountsMenu.menuOptions();
		} else if (helpType == 3) {
			CheckStatusMenu checkStatusMenu = new CheckStatusMenu();
			checkStatusMenu.showPending();
			anythingElse();

		}else if(helpType == 8){
			nav.exitApp();
		}else{
			wrongInputOptions();
		}



	}




	public void anythingElse(){

		if(input.promptforInt(anythingElse) == 1){
			menuOptions();
		}
		else{
			nav.exitApp();
		}


	}

	@Override
	public void menuOptions() {

		MainMenu.welcome();
		//System.out.println(customerWelcome);
		int helpType = input.promptforInt(helpMessage);
		howCanWeHelp(helpType);

	}

	@Override
	public void wrongInputOptions() {
		nav.please();
		int helpType = input.promptforInt(helpMessage);
		howCanWeHelp(helpType);
	}
}
