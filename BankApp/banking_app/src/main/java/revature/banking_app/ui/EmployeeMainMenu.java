package revature.banking_app.ui;

import revature.banking_app.Data.iDatabase;
import revature.banking_app.Logic.Account;
import revature.banking_app.Logic.EmployeeUser;
import revature.banking_app.Logic.UserVerification;

public class EmployeeMainMenu extends MainMenu implements inputable {

	EmployeeUser employeeUser ;

	void pendingApplications(int yes) {
		if(yes == 1){
			PendingMenu pendingMenu = new PendingMenu();
			pendingMenu.showPending();

		} else if ( yes == 2) {
			infoPrompt();
		}else if(yes == 8){
			nav.exitApp();
		}else {
			wrongInputOptions();
		}
	}

   public void setEmployeeUser(EmployeeUser employeeUser){
		this.employeeUser = employeeUser;
   }



     void infoPrompt(){
		 String name = input.promptforString("Whose info would you like to see? Please Type in a customer's username: ");
		 whoseInfo(name);
	 }

	 void accountActions(int accountAction){
		  if (accountAction == 1){
			  CancelAccountsMenu cancelAccountsMenu = new CancelAccountsMenu();
			  cancelAccountsMenu.menuOptions();
		  }else if(accountAction == 2){
			  TransactionMenu transactionMenu = new TransactionMenu();
			  transactionMenu.menuOptions();
		  }else  if(accountAction == 8){
			  nav.exitApp();
		  }else{
			  wrongInputOptions();
		  }
	 }
	 void adminPrompt(String customerName){
		if (employeeUser.hasAdminPrivilages()){
			int accountAction = input.promptforInt("What actions would you like to take for "
					+ customerName + "'s" +
					" accounts? Type 1 to cancel accounts. Type 2 to make transactions ");
			accountActions(accountAction);
		}
	 }
	void accountsPrompt(String username){
		int yes = input.promptforInt("Would you like to see " + username + "'s " + " account info?" +
				"Type 1 for yes, Type 2 for no");
		if (yes == 1){
			AccountsMenu accountsMenu = new AccountsMenu();
			accountsMenu.showInfo(username, iDatabase.defaultAccount);
		}else if (yes == 8){
			nav.exitApp();
		}else{
			nav.backToMain();
		}
	}
   void whoseInfo(String username) {
	   UserVerification userVerification = new UserVerification();
		if (userVerification.verify(username)){
			Account account = new Account(username, iDatabase.defaultAccount);
			System.out.println(account.getAccountName());
			System.out.println(account.getPassword());


		}else{
			failedVerification();
		}
   }

   public void failedVerification(){
	   int yes = input.promptforInt("User not found. Would you like to try again? Type 1 for yes" +
			   "Type 2 for no");
	   if(yes == 1){
		   infoPrompt();
	   }else{
		   nav.backToMain();
	   }
   }

	@Override
	public void menuOptions() {
       MainMenu.welcome();
	  int yes = input.promptforInt("Would you like to see pending applications? Type 1 for yes.  Type 2 for no");
	  pendingApplications(yes);
	}

	@Override
	public void wrongInputOptions() {
        nav.please();
		infoPrompt();
	}
	//managerWelcome()

}
