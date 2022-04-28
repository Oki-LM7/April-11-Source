package revature.banking_app.Logic;

import revature.banking_app.Data.iDatabase;
import revature.banking_app.ui.EmployeeMainMenu;
import revature.banking_app.ui.iUserObject;

import java.util.HashMap;

public class EmployeeUser implements iUserObject {

    String name;
    String rank;

    String username;
    boolean adminPrivilages = false;

    public boolean hasAdminPrivilages() {
        return adminPrivilages;
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

    public String getRank() {
        return rank;
    }

    @Override
    public void setPersonalInfo() {

    }

    @Override
    public void setAccountInfo() {

    }

    @Override
    public void setCustomerAccounts(HashMap<String, Object> accountInfo) {
    }

    @Override
    public HashMap<String,Object> getPersonalInfo(String username) {
       return    sql.getUser(username);
    }

    @Override
    public HashMap<String,Object> getAccountInfo(String username, String accountType) {
         return customerAccounts.get(username).get(iDatabase.accountInfo).;
    }



    @Override
    public void save(String attribute,  String AccountType) {

    }

    @Override
    public void cancelAccount(String accountType) {

    }

    @Override
    public void startMainMenu() {
        EmployeeMainMenu employeeMainMenu = new  EmployeeMainMenu();
        employeeMainMenu.menuOptions();

    }
}
