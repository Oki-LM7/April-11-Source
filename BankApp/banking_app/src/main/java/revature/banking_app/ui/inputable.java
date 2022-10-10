package revature.banking_app.ui;

import revature.banking_app.App;
import revature.banking_app.Data.SQL_DataSource;
import revature.banking_app.Data.iDataSource;

public  abstract class inputable {


	iUserObject userObject;

	iDataSource dataSource = new SQL_DataSource();

	ScannerInput input = new ScannerInput();
	public abstract void menuOptions();

	public abstract void wrongInputOptions();


	public void backOptions() {
		String continueMessage = " Would you like to continue using the app? Type 1 for yes Type 2 for no";
		userObject.backGreeting();

		int continueOptions = input.promptforInt(continueMessage);
		if(continueOptions == 1){
			userObject.startMainMenu();
		}else{
			exitApp();
		}
	}

	public void backOptions(iUserObject userObject){
      this.userObject = userObject;
	  backOptions();
	}

	void please() {
		System.out.println("please put in the right input");
	}

	void exitApp(){
		userObject.exitGreeting();
		App.main(null);

	}

}
