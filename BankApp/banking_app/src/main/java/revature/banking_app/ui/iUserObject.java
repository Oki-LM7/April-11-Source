package revature.banking_app.ui;

import java.util.HashMap;

public interface iUserObject {

	public String checkings = "CHECKING";
	public String savings = "SAVINGS";
	public String joint = "JOINT";

	  String getName();

	  String getRank();

	  HashMap<String,Object> personalInfo = new HashMap<>();
	  HashMap<String, Object> accountInfo = new HashMap<>();
	  HashMap<String,HashMap<String, Object>> customerAccounts = new HashMap<>();


	 void setPersonalInfo();
	 void setAccountInfo();
	 void setCustomerAccounts(HashMap<String,Object> accountInfo);


	void cancelAccount(String accountType);
	 void welcomePrompt();

	  void backGreeting();

	 void exitGreeting();

	 void startMainMenu();




}
