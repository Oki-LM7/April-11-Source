package revature.banking_app.Logic;

import revature.banking_app.ui.EmployeeMainMenu;
import revature.banking_app.ui.iUserObject;

public class EmployeeUser implements iUserObject {

    String name;
    String rank;

    @Override
    public void welcomePrompt() {
       System.out.println("Welcome " + rank + " " + name);
    }

    @Override
    public void backGreeting() {
        System.out.println(" Hello again " + rank + " " + name);
    }

    @Override
    public void exitGreeting() {
        System.out.println(" Great work today " + rank + " " + name);
        System.out.println("remember to fill in your timesheet . Good Night!");
    }

    public String getRank() {
        return rank;
    }

    @Override
    public void startMainMenu() {
        EmployeeMainMenu employeeMainMenu = new  EmployeeMainMenu();
        employeeMainMenu.menuOptions();

    }
}
