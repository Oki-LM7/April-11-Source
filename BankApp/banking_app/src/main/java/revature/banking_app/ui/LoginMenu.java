package revature.banking_app.ui;

import revature.banking_app.Data.iDataSource;
import revature.banking_app.Logic.CreateUser;
import revature.banking_app.Logic.DefaultUser;
import revature.banking_app.Logic.UserVerification;

import java.util.HashMap;

public class LoginMenu extends inputable {

	  CreateUser createUser = new CreateUser();


	UserVerification verification = new UserVerification();
	iUserObject userObject = new DefaultUser();
	String usernameMessage = "Please type in Your Username or employee id";
	String passwordMessage = "Please type in your password" ;
	
	public void credentials(String username, Long password) {

		if (verification.verify(username) && verification.verify(username,password) ){

			//need to find a way to get rank from the database for objects not made yet
			HashMap<String,Object> user = dataSource.getUser(username, iDataSource.defaultAccount);
			String rank = user.get("rank").toString();
			userObject = createUser.getUser(rank);
			userObject.setUserInfo(user);
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

		Long password = (long) input.promptforInt(passwordMessage);
       credentials(username,password);
	 //need to see if users rank is not customer
	}

	@Override
	public void wrongInputOptions() {
        please();
		register();
	}
}
