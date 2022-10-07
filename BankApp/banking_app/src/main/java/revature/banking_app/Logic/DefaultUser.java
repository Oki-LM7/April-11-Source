package revature.banking_app.Logic;

import revature.banking_app.ui.MainMenu;
import revature.banking_app.ui.iUserObject;

import java.util.HashMap;

public class DefaultUser extends iUserObject {

    String name;

    MainMenu mainMenu = new MainMenu(this);


    public DefaultUser(){
        this.name = "friend";
    }
    @Override
    public String getName() {
        return "friend";
    }

    @Override
    public void setName(String name) {

    }

    @Override
    public void setRank(String rank) {

    }

    @Override
    public void setUsername(String username) {

    }

    @Override
    public String getRank() {
        return null;
    }

    @Override
    public MainMenu getMainMenu() {
        MainMenu mainMenu = new MainMenu();
        return mainMenu;
    }

    @Override
    public void welcomePrompt() {
        System.out.println(" Thank you for logging on to the bank app " + name);
    }

    @Override
    public void backGreeting() {

    }

    @Override
    public void exitGreeting() {
        System.out.println(" Thank you for using the bank app " + " We hope you had a great experience");
    }

    @Override
    public void startMainMenu() {

       this.mainMenu.menuOptions();

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
