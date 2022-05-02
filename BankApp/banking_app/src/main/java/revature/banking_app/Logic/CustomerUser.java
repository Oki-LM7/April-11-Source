package revature.banking_app.Logic;

import revature.banking_app.Data.iDatabase;
import revature.banking_app.ui.CustomerMainMenu;
import revature.banking_app.ui.iUserObject;

import java.util.HashMap;

public class CustomerUser implements iUserObject {

    String name;
    OpenAccounts openAccounts = new OpenAccounts();
    UserVerification userVerification = new UserVerification();

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String getRank() {
        return null;
    }


    @Override
    public void save(String attribute,  String AccountType) {

    }

    @Override
    public void cancelAccount(String accountType) {

    }

    @Override
    public void openCheckingsAccount(String username) {
          openAccounts.openAccount(username, iDatabase.checkings);
    }

    @Override
    public void openSavingsAccount(String username) {
        openAccounts.openAccount(username, iDatabase.savings);
    }

    @Override
    public void openJointAccount(String username, String and) {
        if (userVerification.verify(and)){
            openAccounts.openAccount(username,iDatabase.joint);
            openAccounts.openAccount(and,iDatabase.joint);
        }

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
