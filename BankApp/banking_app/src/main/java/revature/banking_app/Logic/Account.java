package revature.banking_app.Logic;

import revature.banking_app.Data.SQL_Database;
import revature.banking_app.Data.iDatabase;

import java.util.HashMap;

public class Account {

    String name;
    String accountType;

    String accountStatus;

    String activeStatus;

    HashMap user;
    SQL_Database sql = new SQL_Database();
    boolean approved = false;
    boolean denied = false;



    public  Account(String name, String accountType){
        this.name = name;
        this.accountType = accountType;

        user = sql.getUser(name,accountType);
        this.accountStatus = (String) user.get(iDatabase.accountStatus);
        this.activeStatus = (String) user.get(iDatabase.activeStatus);
    }



    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public void setDenied(boolean denied) {
        this.denied = denied;
    }

    public String getAccountName(){
        return  name+ " " + accountType;
    }

    public void applyForAccount(String accountType){

        user.put(iDatabase.accountType, accountType);
        sql.saveAccountInfo(user);

    }

    public void deposit(long money, String accountType){

        long newBalance = 0L;
        newBalance = money +  (Long) user.get(iDatabase.accountBalance);
        user.put(iDatabase.accountBalance, newBalance);
        user.put(iDatabase.accountType, accountType);
        sql.saveAccountInfo(user);
    }

    public void withdrawal(long money ){

        long newBalance = 0L;
        newBalance =  (Long) user.get(iDatabase.accountBalance) - money;
        if (newBalance<0){
            System.out.println("You do not have enough money in your account for a withdrawal");
        }else {
            user.put(iDatabase.accountBalance, newBalance);
            user.put(iDatabase.accountType, accountType);
            sql.saveAccountInfo(user);
        }

    }

    public String getBalance(){

        return (String) user.get(iDatabase.accountBalance);
    }

    public void saveAccountStatus(String accountStatus){
         user.put(iDatabase.accountStatus, accountStatus);

         sql.saveAccountInfo(user);
    }

    public void setActiveStatus(String activeStatus){
        user.put(iDatabase.activeStatus,activeStatus);
        sql.saveAccountInfo(user);
    }

    public String getAccountStatus(){
        return this.accountStatus;
    }
    public String getActiveStatus(){
        return  this.activeStatus;
    }
}
