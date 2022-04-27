package revature.banking_app.ui;

import java.util.HashMap;

public class RegisterMenu implements inputable {
	MenuNavigation nav = new MenuNavigation();
	HashMap<String,HashMap> user = new HashMap<>();
	HashMap<String, Object> personalInfo = new HashMap<>();

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


	@Override
	public void menuOptions() {
         int rankType = input.promptforInt("Are you a customer or employee? Type 1 for customer Type 2 for " +
				 "employee");

		 rankPrompt(rankType);

		 //
	}

	@Override
	public void wrongInputOptions() {

	}

}
