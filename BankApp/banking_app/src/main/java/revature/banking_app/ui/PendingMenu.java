package revature.banking_app.ui;

import revature.banking_app.Logic.Account;

import java.util.ArrayList;
import java.util.List;

public class PendingMenu implements  inputable{

	MenuNavigation nav = new MenuNavigation();
	List<Account> accounts = new ArrayList<>();

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
		approvePending();
		nav.back();
	}

	@Override
	public void wrongInputOptions() {

	}
}
