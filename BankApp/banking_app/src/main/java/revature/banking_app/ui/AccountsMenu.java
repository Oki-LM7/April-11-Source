package revature.banking_app.ui;

import revature.banking_app.Logic.Account;

import java.util.ArrayList;

public class AccountsMenu  implements  inputable, infoable{
    
	MenuNavigation nav = new MenuNavigation();
	MainMenu mainMenu = MainMenu.getMainMenu();
	void showBalance(String username, String accountType) {

		       Account account = new Account(username, accountType);
			   account.getBalance();
	}

	void showBalances(String username, ArrayList<String> accountTypes){
		for (String accountType: accountTypes
			 ) {
			showBalance(username,accountType);
		}
	}

	@Override
	public void menuOptions() {

	}

	@Override
	public void wrongInputOptions() {

	}



	@Override
	public void showInfo(String username, String accountType) {
		Account account = new Account(username, accountType);
       System.out.println(account.getAccountName());
	   System.out.println(account.getAccountStatus());
	   System.out.println(account.getActiveStatus());
	   System.out.println(account.getBalance());
	}


	//managerPrompt()
	//cancleAccountsPrompt()

}
