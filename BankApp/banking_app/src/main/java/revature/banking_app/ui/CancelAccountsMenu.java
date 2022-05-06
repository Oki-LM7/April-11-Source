package revature.banking_app.ui;

import revature.banking_app.Data.iDatabase;
import revature.banking_app.Logic.Account;

public class CancelAccountsMenu implements inputable {
   
	MenuNavigation nav = new MenuNavigation();


	iUserObject userObject;



	public void cancelAccount(String username, String accountType) {
		Account account = new Account(username, accountType);
		account.saveAccountStatus(iDatabase.canceledAccount);

		;
	}
	
    public void cancelAccountsPrompt(String username,int accountType){
		if (accountType == 1){

			cancelAccount(username,iDatabase.checkings);

		} else if (accountType == 2) {
			Account account = new Account(username, iDatabase.savings);
			account.saveAccountStatus(iDatabase.canceledAccount);

			cancelAccount(username,iDatabase.savings);
		} else if (accountType == 3) {

			cancelAccount(username,iDatabase.joint);

		} else if (accountType == 8) {

			nav.exitApp();

		}else{
			wrongInputOptions();
		}
	}

	@Override
	public void menuOptions() {
		// TODO Auto-generated method stub

		String username = input.promptforString("whose account would you like to cancel? Please enter the" +
				"correct username: ");

		int accountType = input.promptforInt("Which Type of account would you like to cancel ?Type 1 for checkings, Type 2 " +
				"for savings, Type 3 for joint.");

		cancelAccountsPrompt(username,accountType);
		nav.backToMain();
		
	}

	@Override
	public void wrongInputOptions() {
		// TODO Auto-generated method stub
		
	}
}
