package revature.banking_app.ui;

import revature.banking_app.Logic.DefaultUser;

import java.util.HashMap;

public  class MainMenu extends inputable {




	  iUserObject userObject;


	String mainMessage = "Hello welcome to the bank app. " ;

	String loginMessage = "Please Sign in. Type 1 to login Type 2 to Register: ";
	//LoginOrRegisterPrompt(login,Register)



	public MainMenu(){
       this.userObject = new DefaultUser();

	}








	

	
	public void  loginOrRegister(int login) {
	    if(login == 1){
			LoginMenu loginMenu = new LoginMenu();
			loginMenu.menuOptions();
		} else if (login == 2) {
			RegisterMenu registerMenu = new RegisterMenu();
			registerMenu.menuOptions();
		} else if (login == 8) {
			exitApp();

		}else {
			wrongInputOptions();
		}
	}
	
	public void welcome() {
		userObject.welcomePrompt();
		System.out.println("remember you can always log out by inputting 8 into question prompts");
	}




	@Override
	public void menuOptions() {
		// TODO Auto-generated method stub
		System.out.println(mainMessage);

     if(userObject.getNav().notEmpty()){
		 backOptions();
	 }
		
		int login = input.promptforInt(loginMessage);
		loginOrRegister(login);


		
		
	}



	@Override
	public void wrongInputOptions() {
		// TODO Auto-generated method stub
		please();
		int login = input.promptforInt(loginMessage);
		loginOrRegister(login);
		
	}
	
	

}
