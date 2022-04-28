package revature.banking_app.ui;

import revature.banking_app.Data.SQL_Database;
import revature.banking_app.Data.iDatabase;

import java.util.HashMap;

public interface iUserObject {

	public String checkings = "CHECKING";
	public String savings = "SAVINGS";
	public String joint = "JOINT";

	  String getName();

	  String getRank();

	  iDatabase sql = new SQL_Database();


     //data
	 void setPersonalInfo();
	 void setAccountInfo();
	 void setCustomerAccounts(HashMap<String,Object> accountInfo);
    //logic

	 HashMap<String,Object> getPersonalInfo(String username);

	 HashMap<String,Object> getAccountInfo(String username, String accountType);



	 void save(String attribute,  String AccountType);


	void cancelAccount(String accountType);

	//UI
	 void welcomePrompt();

	  void backGreeting();

	 void exitGreeting();

	 void startMainMenu();




}
