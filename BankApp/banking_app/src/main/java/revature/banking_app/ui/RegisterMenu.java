package revature.banking_app.ui;

import revature.banking_app.Data.SQL_DataSource;
import revature.banking_app.Data.iDataSource;
import revature.banking_app.Logic.CreateUser;

import java.util.HashMap;

public class RegisterMenu extends inputable {

	HashMap<String,Object> user = new HashMap<>();
	iUserObject userObject;


	CreateUser createUser = new CreateUser();

	public void rankPrompt(int rankType){
		if(rankType == 1 ){

			user.put("rank", "customer" );
		}else{
			int empRankType = input.promptforInt("Are you an admin? Type Admin code for yes Type 2 for no");
			//admin code is 1
			employeeRank(empRankType);
		}
	}

	public void employeeRank(int rankType){
		if(rankType == 1){

			user.put("rank", "admin" );
		}else if(rankType == 2) {

			user.put("rank", "employee" );
		} else{
			System.out.println("Wrong admin code. Please try again");
			menuOptions();
		}

	}




	@Override
	public void menuOptions() {
         int rankType = input.promptforInt("Are you a customer or employee? Type 1 for customer Type 2 for " +
				 "employee");

		 rankPrompt(rankType);

          //maybe need to say in parenthesies to make sure the scanner always gets a string
		 String username = input.promptforString("Please add your username: ");

		 //adds in username
		 user.put("username",username);

		 Long password = Long.valueOf(input.promptforInt("Please use numbers only for your password. " +
				 "Type the password here: "));
		 user.put("password",password);

		 String fullname = input.promptforString("Please type you full legal name: ");
		 user.put("name", fullname);



		 // send personal info to database and give them a default account
		user.put(iDataSource.accountType, iDataSource.defaultAccount);
		user.put(iDataSource.accountBalance, iDataSource.defaultBalance);
        user.put(iDataSource.owners, user.get("name"));
		user.put(iDataSource.activeStatus, iDataSource.activeAccount);

		System.out.println("Thankyou for registering. You will now be sent to our homepage");

		userObject = createUser.getUser((String) user.get("rank"));
		userObject.setUserInfo(user);

		//send personal data to database
		dataSource.saveUserInfo(user);
		//save default account
		dataSource.saveAccountInfo(user);



	}

	@Override
	public void wrongInputOptions() {

	}

}
