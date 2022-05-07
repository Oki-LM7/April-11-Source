package revature.banking_app.ui;

import revature.banking_app.Data.iDatabase;

import static revature.banking_app.ui.MainMenu.mainMenu;

public class CustomerAccountsMenu implements inputable {
	
	MenuNavigation nav = new MenuNavigation();
	String tMessage = "Would you like to make a transaction?"
			+ "Type 1 for yes  Type 2 for no: ";
	String username = (String) mainMenu.getCurrentUserInfo().get("username");
	
	
	public void transactionPrompt(int answer) {
		// makeaTransaction 
		if(answer == 1 ) {
			TransactionMenu tmenu = new TransactionMenu();
			tmenu.menuOptions();
			
		}else if(answer == 2) {
		  nav.backToMain();
		  
		}else if(answer ==8 ) {
			nav.exitApp();
			
		}else {
			nav.please();
			wrongInputOptions();
			
		}
		
	}
	
	

	@Override
	public void menuOptions() {
		// TODO Auto-generated method stub

		AccountsMenu accountsMenu = new AccountsMenu();

		accountsMenu.showInfo(username, iDatabase.defaultAccount);

		int answer = input.promptforInt(tMessage);

		transactionPrompt(answer);
	}



	@Override
	public void wrongInputOptions() {
		// TODO Auto-generated method stub
        int answer = input.promptforInt(tMessage);
		
		transactionPrompt(answer);
	}

}
