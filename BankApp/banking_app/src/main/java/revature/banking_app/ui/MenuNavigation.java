package revature.banking_app.ui;

public class MenuNavigation {
 
	iUserObject userObject;
	void back() {
		
	}
	
	void exitApp() {
		MainMenu mainMenu = MainMenu.getMainMenu();
		mainMenu.getUserObject().exitGreeting();
		//reset the app after exiting
		mainMenu.menuOptions();
	}
	
	void backToMain() {
		MainMenu mainMenu = MainMenu.getMainMenu();
		mainMenu.backOptions();
	}
	
	void please() {
		System.out.println("please put in the right input");
	}
}
