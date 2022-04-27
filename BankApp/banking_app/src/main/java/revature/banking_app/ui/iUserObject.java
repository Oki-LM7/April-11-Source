package revature.banking_app.ui;

import java.util.HashMap;

public interface iUserObject {

	public String checkings = "CHECKING";
	public String savings = "SAVINGS";
	public String joint = "JOINT";

	  String getName();

	  String getRank();

	  void cancelAccount(String accountType);
	 void welcomePrompt();

	  void backGreeting();

	 void exitGreeting();

	 void startMainMenu();

	 HashMap<String,Object> getInfo(String infoType);


}
