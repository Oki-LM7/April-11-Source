package revature.banking_app.ui;

import revature.banking_app.Data.SQL_Database;
import revature.banking_app.Data.iDatabase;

import java.util.HashMap;

public interface iUserObject {



	  String getName();

	  String getRank();

	  iDatabase sql = new SQL_Database();


     //data
     HashMap<String, String> userStrings = new HashMap();
	 HashMap<String, Integer> userInts = new HashMap<>();

    //logic





	 void save(String attribute,  String AccountType);


	void cancelAccount(String accountType);

	//UI
	 void welcomePrompt();

	  void backGreeting();

	 void exitGreeting();

	 void startMainMenu();




}
