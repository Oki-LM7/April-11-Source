package revature.banking_app.ui;

import revature.banking_app.Logic.CustomerUser;
import revature.banking_app.Logic.EmployeeUser;
import revature.banking_app.Logic.UserVerification;

public class LoginMenu implements inputable {
      MenuNavigation nav = new MenuNavigation();

	UserVerification verification = new UserVerification();
	String usernameMessage = "Please type in Your Username or employee id";
	String passwordMessage = "Please type in your password" ;
	
	public void credentials(String username, int password) {

		if (verification.verify(username) && verification.verify(password) ){

			MainMenu main = new MainMenu();
			CustomerUser customer  = new CustomerUser();
			main.setUserObject(customer);
			CustomerMainMenu customerMainMenu = new CustomerMainMenu();
			customerMainMenu.menuOptions();
		}
		 register();
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
			nav.exitApp();
		}else {
			wrongInputOptions();
		}

	}



	



	@Override
	public void menuOptions() {

	   String username = input.promptforString(usernameMessage);

	  if( !employeeLogedIn(username)){
		  int password = input.promptforInt(passwordMessage);
		  credentials(username,password);
	  }else{
		  MainMenu main = new MainMenu();
		  EmployeeUser employeeUser = new EmployeeUser();
		  main.setUserObject(employeeUser);

		  EmployeeMainMenu employeeMainMenu = new EmployeeMainMenu();
		  employeeMainMenu.menuOptions();
	  }

	}

	@Override
	public void wrongInputOptions() {
        nav.please();
	}
}
