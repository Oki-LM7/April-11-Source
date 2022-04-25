package revature.banking_app.ui;

public class LoginMenu implements inputable {

	String usernameMessage = "Please type in Your Username or employee id";
	String passwordMessage = "Please type in your password" ;
	
	public void credentials(String username, int password) {


		CustomerMainMenu customerMainMenu = new CustomerMainMenu();
		customerMainMenu.menuOptions();

	}

	public boolean employeeLogedIn(String employeeID){
       if(employeeID == true){

		   return  true;
	   }
		return false;
	}
	
	public void goToMain() {
		
	}


	@Override
	public void menuOptions() {
       ScannerInput input = new ScannerInput();

	   String username = input.promptforString(usernameMessage);

	  if( employeeLogedIn(username) == false){
		  int password = input.promptforInt(passwordMessage);
		  credentials(username,password);
	  }else{
		  EmployeeMainMenu employeeMainMenu = new EmployeeMainMenu();
		  employeeMainMenu.menuOptions();
	  }

	}

	@Override
	public void wrongInputOptions() {

	}
}
