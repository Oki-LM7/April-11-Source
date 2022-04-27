package revature.banking_app.ui;

import revature.banking_app.Logic.EmployeeUser;
import revature.banking_app.Logic.UserVerification;

public class EmployeeMainMenu extends MainMenu implements inputable {

	EmployeeUser employeeUser ;
	infoable infoMenu ;
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


	boolean adminPrivilages(){
		UserVerification userVerification = new UserVerification();
		return userVerification.verifyAdmin(employeeUser.getRank());
	}
     void infoPrompt(){
		 String name = input.promptforString("Whose info would you like to see? Please Type in a customer's username: ");
		 whoseInfo(name);
	 }
	 void adminPrompt(){
		if (adminPrivilages()){
			input.promptforInt("Would you like ")
		}
	 }
	void accountsPrompt(String customerName){
		int yes = input.promptforInt("Would you like to see " + customerName + "'s " + " account info?" +
				"Type 1 for yes, Type 2 for no");
		if (yes == 1){
			infoMenu = new AccountsMenu();
			infoMenu.showInfo(customerName);
		}else if (yes == 8){
			nav.exitApp();
		}else{
			nav.backToMain();
		}
	}
   void whoseInfo(String customerName) {
	   UserVerification userVerification = new UserVerification();
		if (userVerification.verify(customerName)){
			infoMenu = new PersonalInfoMenu();
			 infoMenu.showInfo(customerName);
			 accountsPrompt(customerName);


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
       welcome();
	  int yes = input.promptforInt("Would you like to see pending applications? Type 1 for yes.  Type 2 for no");
	  pendingApplications(yes);
	}

	@Override
	public void wrongInputOptions() {

	}
	//managerWelcome()

}
