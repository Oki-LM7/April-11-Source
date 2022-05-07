package revature.banking_app.Logic;

import revature.banking_app.Data.SQL_Database;
import revature.banking_app.Data.iDatabase;
import revature.banking_app.ui.*;

public class EmployeeUser implements iUserObject {

    String name;
    String rank;

    String username;
    boolean adminPrivilages = false;

    OpenAccounts openAccounts = new OpenAccounts();
    UserVerification userVerification = new UserVerification();


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

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public  void setRank(String rank){this.rank = rank;}

    public String getRank() {
        return rank;
    }






    @Override
    public void startMainMenu() {
        EmployeeMainMenu employeeMainMenu = new  EmployeeMainMenu();
        employeeMainMenu.menuOptions();

    }


}
