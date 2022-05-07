package revature.banking_app.ui;

import revature.banking_app.Data.SQL_Database;
import revature.banking_app.Data.iDatabase;

import java.util.HashMap;

public interface iUserObject {



	  String getName();

	  void setName(String name);
	  void  setRank(String rank);

	  void setUsername(String username);

	  String getRank();




     //data

    //logic











	//UI
	 void welcomePrompt();

	  void backGreeting();

	 void exitGreeting();

	 void startMainMenu();


    String getUsername();
}
