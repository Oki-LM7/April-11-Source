package revature.banking_app.Logic;

import revature.banking_app.ui.CustomerMainMenu;
import revature.banking_app.ui.MainMenu;
import revature.banking_app.ui.iUserObject;

import java.util.HashMap;

public class CustomerUser extends iUserObject {

    String name;
    String rank;

    CustomerMainMenu customerMainMenu = new CustomerMainMenu();
    OpenAccounts openAccounts = new OpenAccounts();
    UserVerification userVerification = new UserVerification();

    public CustomerUser( String name, String rank){

        this.name = name;
        this.rank = rank;
    }

    public  CustomerUser(){

    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void setRank(String rank) {
        this.rank = rank;
    }

    @Override
    public void setUsername(String username) {

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
    public MainMenu getMainMenu() {
        return  customerMainMenu;
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
        this.customerMainMenu.menuOptions();
    }

    @Override
    public HashMap getCurrentUserInfo() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }


}
