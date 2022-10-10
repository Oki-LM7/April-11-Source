package revature.banking_app.ui;

import revature.banking_app.Logic.Account;
import revature.banking_app.Logic.PendingAccounts;

import java.util.List;

public class PendingMenu extends inputable {



	List<Account> accounts;
	public PendingMenu(iUserObject userObject){
		PendingAccounts pendingAccounts = new PendingAccounts();
		 accounts = pendingAccounts.getPendingAccounts();
		 this.userObject = userObject;
	}





	public void showPending() {
		for (Account account : accounts
			 ) {
			System.out.println(account.getAccountName());
		}

	}

	public void approvePending(){
		while (!accounts.isEmpty()){
			int approve = input.promptforInt("approve " + accounts.get(0).getAccountName()+ "?   Type 1 to approve  Type 2 to deny" );

			approve(approve);
		}
		System.out.println("no more pending");
		backOptions(userObject);
	}
	public void approve(int yes){
		if(yes == 1){
			accounts.get(0).setApproved(true);
			accounts.remove(0);
		}else if(yes == 8){
			exitApp();
		}
		else{
			//deny it
			accounts.get(0).setDenied(true);
			accounts.remove(0);


		}
	}



	@Override
	public void menuOptions() {
		showPending();
		approvePending();
		userObject.getNav().back();
	}

	@Override
	public void wrongInputOptions() {

	}
}
