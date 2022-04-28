package revature.banking_app.ui;

public class CancelAccountsMenu implements inputable {
   
	MenuNavigation nav = new MenuNavigation();

	iUserObject userObject;
	public void cancelAccount(String accountType) {
		System.out.println("We canceled "+ userObject.getName() + "'s" + accountType);
		userObject.cancelAccount(accountType);
	}
	
    public void cancelAccountsPrompt(int accountType){
		if (accountType == 1){
			cancelAccount(iUserObject.checkings);

		} else if (accountType == 2) {

			cancelAccount(iUserObject.savings);
		} else if (accountType == 3) {

			cancelAccount(iUserObject.joint);

		} else if (accountType == 8) {

			nav.exitApp();

		}else{
			wrongInputOptions();
		}
	}

	@Override
	public void menuOptions() {
		// TODO Auto-generated method stub

		int accountType = input.promptforInt("Which Type of account would you like to cancel ?Type 1 for checkings, Type 2 " +
				"for savings, Type 3 for joint.");

		cancelAccountsPrompt(accountType);
		nav.backToMain();
		
	}

	@Override
	public void wrongInputOptions() {
		// TODO Auto-generated method stub
		
	}
}
