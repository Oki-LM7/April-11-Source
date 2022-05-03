package revature.banking_app.ui;

import revature.banking_app.Data.SQL_Database;
import revature.banking_app.Data.iDatabase;
import revature.banking_app.Logic.UserVerification;

public class AccountsApplicationMenu implements inputable {

	MenuNavigation nav = new MenuNavigation();
	MainMenu mainMenu = MainMenu.getMainMenu();
	iUserObject userObject = mainMenu.getUserObject();
	public void accountPrompt(int accountType) {

		if(accountType == 1){
			userObject.openCheckingsAccount((String) mainMenu.getCurrentUserInfo().get("username"));
			nav.backToMain();
		} else if (accountType == 2) {
			userObject.openSavingsAccount((String) mainMenu.getCurrentUserInfo().get("username"));
			nav.backToMain();
		}else if (accountType == 3){
		String username = input.promptforString("What is the username of the person " +
				"you are creating a joint account with? ");
		jointUserPrompt(username);

		}else{
			wrongInputOptions();
		}
	}
	
	public void jointPrompt(int yes, String username) {
		if(yes == 1){
			userObject.openJointAccount((String) mainMenu.getCurrentUserInfo().get("username"), username);
		}else {
			nav.backToMain();
		}

	}
	
	public void jointUserPrompt(String username) {
		UserVerification userVerification = new UserVerification();
		if(userVerification.verify(username)){
			SQL_Database sql_database = new SQL_Database();
			String name = (String) sql_database.getUser(username, iDatabase.defaultAccount).get("name");
			int yes = input.promptforInt("Make a joint account with " + name);
			jointPrompt(yes,name);
		}

	}



	@Override
	public void menuOptions() {
       int accountType = input.promptforInt("Which Type of account are you applying for?" +
			   "type 1 for checkings   type 2 for savings    type 3 for joint");
	   accountPrompt(accountType);
	}

	@Override
	public void wrongInputOptions() {
		nav.please();
		int accountType = input.promptforInt("Which Type of account are you applying for?" +
				"type 1 for checkings   type 2 for savings    type 3 for joint");
		accountPrompt(accountType);


	}
}
