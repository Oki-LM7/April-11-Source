package revature.banking_app.Logic;

import revature.banking_app.ui.CustomerMainMenu;
import revature.banking_app.ui.iUserObject;

import java.util.HashMap;

public class CustomerUser implements iUserObject {

    String name;

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getRank() {
        return null;
    }

    @Override
    public void setPersonalInfo() {

    }

    @Override
    public void setAccountInfo() {

    }

    @Override
    public void cancelAccount(String accountType) {

    }

    @Override
    public void welcomePrompt() {
        System.out.println(" Thank you for logging on to the bank app " + name);
    }

    @Override
    public void backGreeting() {
        System.out.println(" Hello again "  + name);
    }

    @Override
    public void exitGreeting() {
        System.out.println(" Thank you for using the bank app " + name + " We hope you had a great experience");
    }

    @Override
    public void startMainMenu() {
        CustomerMainMenu customerMainMenu = new CustomerMainMenu();
        customerMainMenu.menuOptions();
    }


}
