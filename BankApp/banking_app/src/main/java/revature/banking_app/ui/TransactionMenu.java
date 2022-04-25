package revature.banking_app.ui;

public class TransactionMenu implements inputable {
  
	String whichAccountMessage = "Which account would you like to "
			+ "make a transaction with? Type 1 for  checkings  Type 2 for"
			+ "savings: ";
	
	
	
	String tMessage = "What type of transaction would you like to make?:"
			+ "Type 1 for deposit  Type 2 for withdraw  Type 3 for transfer: ";
	
	String accountType = "";
	
	public void whichAccount(int accountType) {
		
		if(accountType == 1) {
			
			this.accountType = "Checkings";
		}else {
			this.accountType = "savings";
		}
			
	}
	
	
	public void transactionType(int TransactionType) {
		
	}


	@Override
	public void menuOptions() {
		// TODO Auto-generated method stub
		int accountType = input.promptforInt(whichAccountMessage);
		whichAccount(accountType);
		int transactionType = input.promptforInt(tMessage);
		transactionType(transactionType);
	}


	@Override
	public void wrongInputOptions() {
		// TODO Auto-generated method stub
		
	}
 
	
	
	
	
}
