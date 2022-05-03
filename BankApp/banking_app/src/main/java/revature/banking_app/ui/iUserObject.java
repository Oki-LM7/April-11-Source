package revature.banking_app.ui;

import revature.banking_app.Data.SQL_Database;
import revature.banking_app.Data.iDatabase;

import java.util.HashMap;

public interface iUserObject {



	  String getName();

	  void setName(String name);
	  void  setRank(String rank);

	  String getRank();

	  iDatabase sql = new SQL_Database();


     //data

    //logic





	 void save(String attribute,  String AccountType);


	void cancelAccount(String accountType);

	void openCheckingsAccount(String username);

	void  openSavingsAccount(String username);



	void openJointAccount(String username, String andUsername);

	//UI
	 void welcomePrompt();

	  void backGreeting();

	 void exitGreeting();

	 void startMainMenu();




}
