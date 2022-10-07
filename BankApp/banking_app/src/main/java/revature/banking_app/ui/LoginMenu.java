package revature.banking_app.ui;

import revature.banking_app.Data.SQL_Database;
import revature.banking_app.Data.iDatabase;
import revature.banking_app.Logic.CreateUser;
import revature.banking_app.Logic.DefaultUser;
import revature.banking_app.Logic.UserVerification;

public class LoginMenu extends inputable {

	  CreateUser createUser = new CreateUser();
	iDatabase sqlDatabase =  new SQL_Database();

	UserVerification verification = new UserVerification();
	iUserObject userObject = new DefaultUser();
	MenuNavigation nav = new MenuNavigation(userObject);
	String usernameMessage = "Please type in Your Username or employee id";
	String passwordMessage = "Please type in your password" ;
	
	public void credentials(String username, Long password) {

		if (verification.verify(username) && verification.verify(username,password) ){

			//need to find a way to get rank from the database for objects not made yet
			String rank = sqlDatabase.getUser(username, iDatabase.defaultAccount).get("rank").toString();
			userObject = createUser.getUser(rank);
			userObject.setName((String) mainMenu.currentUserInfo.get("name"));
			userObject.setRank((String) mainMenu.getCurrentUserInfo().get("rank"));
			userObject.setUsername(username);
			userObject.startMainMenu();

		}else{
			register();
		}

	}

	public void register(){
		System.out.println("Either username or password was wrong");
		int options = input.promptforInt("Type 1 to register. Type 2 to try to login again" );
		if (options == 1){
			RegisterMenu registerMenu = new RegisterMenu();
			registerMenu.menuOptions();
		} else if (options == 2) {
			menuOptions();
		}else if (options == 8){
			exitApp();
		}else {
			wrongInputOptions();
		}

	}



	



	@Override
	public void menuOptions() {

		String username = input.promptforString(usernameMessage);

		Long password = Long.valueOf(input.promptforInt(passwordMessage));
       credentials(username,password);
	 //need to see if users rank is not customer
	}

	@Override
	public void wrongInputOptions() {
        please();
		register();
	}
}
