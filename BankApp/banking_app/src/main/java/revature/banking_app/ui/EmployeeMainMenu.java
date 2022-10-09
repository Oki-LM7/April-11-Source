package revature.banking_app.ui;

import revature.banking_app.Data.iDataSource;
import revature.banking_app.Logic.*;

public class EmployeeMainMenu extends MainMenu  {



    CreateUser createUser = new CreateUser();
	EmployeeUser employeeUser = createUser.getEmployeeUser() ;


   AccountAccess accountAccess = new AccountAccess();
	String lookUpUsername;


	void pendingApplications(int pending) {
		if(pending == 1){
			PendingMenu pendingMenu = new PendingMenu(employeeUser);
			pendingMenu.menuOptions();

		} else if ( pending == 2) {
			accountAccess.infoPrompt();
		}else if(pending == 8){
			// the main menu dosen't call exit app because exit app sends you to the main menu
			exitApp();
		}else {
			wrongInputOptions();
		}
	}



	 void adminPrompt(){
		if (employeeUser.hasAdminPrivileges()){
			int accountAction = input.promptforInt("What actions would you like to take for "
					+ lookUpUsername + "'s" +
					" accounts? Type 1 to cancel accounts. Type 2 to make transactions ");
			AdminAccountsMenu adminAccountsMenu = new AdminAccountsMenu(employeeUser, lookUpUsername);
			adminAccountsMenu.menuOptions();
		}else{
			backOptions(userObject);
		}
	 }
	void accountsPrompt(){
		int yes = input.promptforInt("Would you like to see " + lookUpUsername + "'s " + " account info?" +
				"Type 1 for yes, Type 2 for no");
		if (yes == 1){
			AccountsMenu accountsMenu = new AccountsMenu(userObject);
			accountsMenu.showInfo(lookUpUsername, iDataSource.defaultAccount);
		}else if (yes == 8){
			exitApp();
		}else {
			backOptions(userObject);
		}
	}



	@Override
	public void menuOptions() {
       welcome();
	  int pending = input.promptforInt(" Type 1 for Pending Applications Type 2 for Accessing Accounts");
	  pendingApplications(pending);
	  accountsPrompt();
	  adminPrompt();

	}

	@Override
	public void wrongInputOptions() {
        please();
		accountAccess.infoPrompt();
	}
	//managerWelcome()

}
