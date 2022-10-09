package revature.banking_app.ui;

import revature.banking_app.Data.iDataSource;
import revature.banking_app.Logic.Account;
import revature.banking_app.Logic.BankAccount;

public class CancelAccountsMenu extends inputable {
   



	iUserObject userObject;



	public void cancelAccount(String username, String accountType) {
		Account bankAccount = new BankAccount(username, accountType);
		bankAccount.saveAccountStatus(iDataSource.canceledAccount);


	}
	
    public void cancelAccountsPrompt(String username,int accountType){
		if (accountType == 1){

			cancelAccount(username, iDataSource.checkings);

		} else if (accountType == 2) {


			cancelAccount(username, iDataSource.savings);
		} else if (accountType == 3) {

			cancelAccount(username, iDataSource.joint);

		} else if (accountType == 8) {

			exitApp();

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
		backOptions(userObject);
		
	}

	@Override
	public void wrongInputOptions() {
		// TODO Auto-generated method stub
		
	}
}
