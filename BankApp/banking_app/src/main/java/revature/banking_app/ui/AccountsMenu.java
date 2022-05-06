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

	void showBalances(ArrayList<String> accountTypes){

	}

	@Override
	public void menuOptions() {

	}

	@Override
	public void wrongInputOptions() {

	}



	@Override
	public void showInfo(String name) {

	}


	//managerPrompt()
	//cancleAccountsPrompt()

}
