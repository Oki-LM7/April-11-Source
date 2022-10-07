package revature.banking_app.Logic;

import revature.banking_app.ui.*;

import java.util.HashMap;

public class EmployeeUser extends iUserObject {

    String name;
    String rank;

    String username;
    boolean adminPrivileges;
    OpenAccounts openAccounts = new OpenAccounts();
    UserVerification userVerification = new UserVerification();
   EmployeeMainMenu employeeMainMenu;

    public EmployeeUser(){


        this.adminPrivileges = false;
        this.employeeMainMenu = new EmployeeMainMenu();


    }

    public EmployeeUser(String name, String rank, String username){
        this();
        this.name = name;
        this.rank = rank;
        this.username = username;


    }




    public boolean hasAdminPrivileges() {
        return adminPrivileges;
    }

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

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public  void setRank(String rank){this.rank = rank;}

    public String getRank() {
        return rank;
    }

    @Override
    public MainMenu getMainMenu() {
        return employeeMainMenu;
    }


    @Override
    public void startMainMenu() {
        EmployeeMainMenu employeeMainMenu = new  EmployeeMainMenu();
        employeeMainMenu.menuOptions();

    }

    @Override
    public HashMap getCurrentUserInfo() {
        return null;
    }

    @Override
    public String getUsername() {
        return username;
    }


}
