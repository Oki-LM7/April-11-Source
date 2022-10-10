package revature.banking_app.ui;

import java.util.ArrayList;

public class MenuNavigation {
 


	//stack FILO
	private final ArrayList<inputable> menus = new ArrayList<>();



	public MenuNavigation(){

	}

	boolean notEmpty(){
	 return 	!menus.isEmpty();
	}



	void back() {
		inputable currentMenu = menus.get(0);
		//saying menu options might cause a concurrency issue without the local variable
		removeMenu();
		currentMenu.menuOptions();
	}



	void addMenu(inputable menu){
		menus.add(0,menu);
	}

	void removeMenu(){
		menus.remove(0);
	}
	

}
