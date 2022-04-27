package revature.banking_app.ui;

import revature.banking_app.Logic.AdminUser;
import revature.banking_app.Logic.CreateUser;
import revature.banking_app.Logic.EmployeeUser;

import java.util.HashMap;

public class RegisterMenu implements inputable {
	MenuNavigation nav = new MenuNavigation();
	HashMap<String,HashMap> user = new HashMap<>();
	iUserObject userObject;
	HashMap<String, Object> personalInfo = new HashMap<>();

	CreateUser createUser = new CreateUser();

	public void rankPrompt(int rankType){
		if(rankType == 1 ){

			personalInfo.put("rank", "customer" );
		}else{
			int empRankType = input.promptforInt("Are you an admin? Type Admin code for yes Type 2 for no");
			//admin code is 1
			employeeRank(empRankType);
		}
	}

	public void employeeRank(int rankType){
		if(rankType == 1){

			personalInfo.put("rank", "admin" );
		}else if(rankType == 2) {

			personalInfo.put("rank", "employee" );
		} else{
			System.out.println("Wrong admin code. Please try again");
			menuOptions();
		}

	}

	public void stringInfoPrompt(String attribute,String value){

		personalInfo.put(attribute,value);
	}

	public void intInfoPrompt( String attribute, int value){
		personalInfo.put(attribute,value);
	}


	@Override
	public void menuOptions() {
         int rankType = input.promptforInt("Are you a customer or employee? Type 1 for customer Type 2 for " +
				 "employee");

		 rankPrompt(rankType);

          //maybe need to say in parenthesies to make sure the scanner always gets a string
		 String username = input.promptforString("Please add your username: ");
		 stringInfoPrompt("username",username);

		 int password = input.promptforInt("Please use numbers only for your password. " +
				 "Type the password here: ");
		 intInfoPrompt("password",password);

		 String fullname = input.promptforString("Please type you full legal name: ");
		 stringInfoPrompt("name", fullname);

		 int ssn = input.promptforInt("Please add you three digit  social security number: ");
		 intInfoPrompt("ssn",ssn);

		 // send personal info to database

		System.out.println("Thankyou for registering. You will now be sent to our homepage");
		userObject = createUser.getUser(personalInfo.get("rank").toString());
		userObject.startMainMenu();


	}

	@Override
	public void wrongInputOptions() {

	}

}
