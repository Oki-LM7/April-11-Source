package revature.banking_app.ui;

public class CustomerAccountsMenu extends AccountsMenu implements inputable {
	
	MenuNavigation nav = new MenuNavigation();
	String tMessage = "Would you like to make a transaction?"
			+ "Type 1 for yes  Type 2 for no: ";
	
	
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
		showBalances();
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
