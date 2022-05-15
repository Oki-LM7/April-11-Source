package revature.banking_app.ui;

import revature.banking_app.Data.iDatabase;

public class AdminAccountsMenu extends AccountsMenu {
	
	MenuNavigation nav = new MenuNavigation();
	
	String managerMessage= "What account actions would you like to make?"
			+ "Type 1 for view accounts Type 2 for cancel accounts "
			+ "Type 3 for make transactions";
			
	String username;

	public void setUsername(String username) {
		this.username = username;
	}

	public void managerPrompt(int action) {
		if(action == 1) {

			AccountsMenu accountsMenu = new AccountsMenu();
			accountsMenu.showInfo(username, iDatabase.defaultAccount);
			
		}else if(action == 2) {
			
			CancelAccountsMenu cMenu = new CancelAccountsMenu();
			cMenu.menuOptions();
			
		}else if(action ==3) {
			TransactionMenu tMenu = new TransactionMenu();
			tMenu.menuOptions();
		}else if(action == 8) {
			
			nav.exitApp();
		}else {
			
			wrongInputOptions();
		}
		
		
	}
	
	@Override
	public void menuOptions() {
		
	int action = input.promptforInt(managerMessage);
	managerPrompt(action);
		
	}
	
	@Override
	public void wrongInputOptions() {
		int action = input.promptforInt(managerMessage);
		managerPrompt(action);
	}

}
