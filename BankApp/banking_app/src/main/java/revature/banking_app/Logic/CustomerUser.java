package revature.banking_app.Logic;

import revature.banking_app.Data.iDatabase;
import revature.banking_app.ui.CustomerMainMenu;
import revature.banking_app.ui.iUserObject;

import java.util.HashMap;

public class CustomerUser implements iUserObject {

    String name;
    String rank;
    OpenAccounts openAccounts = new OpenAccounts();
    UserVerification userVerification = new UserVerification();

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getRank() {
        return rank;
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
