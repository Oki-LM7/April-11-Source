package revature.banking_app.ui;

import revature.banking_app.Logic.Account;
import revature.banking_app.Logic.PendingAccounts;

import java.util.ArrayList;
import java.util.List;

public class PendingMenu implements  inputable{

	MenuNavigation nav = new MenuNavigation();

	List<Account> accounts;
	public PendingMenu(){
		PendingAccounts pendingAccounts = new PendingAccounts();
		 accounts = pendingAccounts.getPendingAccounts();
	}





	public void showPending() {
		for (Account account: accounts
			 ) {
			System.out.println(account.getAccountName());
		}

	}

	public void approvePending(){
		while (!accounts.isEmpty()){
			int approve = input.promptforInt("approve " + accounts.get(0).getAccountName()+ "?");

			approve(approve);
		}
		System.out.println("no more pending");
		nav.backToMain();
	}
	public void approve(int yes){
		if(yes == 1){
			accounts.get(0).setApproved(true);
			accounts.remove(0);
		}else if(yes == 8){
			nav.exitApp();
		}
		else{
			//deny it
			accounts.get(0).setDenied(true);
			accounts.remove(0);


		}
	}

	public void addToPending(Account pendingAccount){
		accounts.add(pendingAccount);
	}


	@Override
	public void menuOptions() {
		showPending();
		approvePending();
		nav.back();
	}

	@Override
	public void wrongInputOptions() {

	}
}
