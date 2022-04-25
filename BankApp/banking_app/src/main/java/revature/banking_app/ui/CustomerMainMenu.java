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

		}else if(helpType == 8){
			nav.exitApp();
		}else{
			wrongInputOptions();
		}



	}

	public void anythingElse(){

	}

	@Override
	public void menuOptions() {
		//System.out.println(customerWelcome);
		ScannerInput input = new ScannerInput();
		int helpType = input.promptforInt(helpMessage);
		howCanWeHelp(helpType);

	}
}
