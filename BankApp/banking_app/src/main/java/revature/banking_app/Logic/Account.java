package revature.banking_app.Logic;

import revature.banking_app.Data.SQL_Database;
import revature.banking_app.Data.iDatabase;

import java.util.HashMap;

public class Account {

    String username;
    String accountType;

    String accountStatus;

    String activeStatus;

    HashMap user;
    SQL_Database sql = new SQL_Database();
    boolean approved = false;
    boolean denied = false;



    public  Account(String username, String accountType){
        this.username = username;
        this.accountType = accountType;
        if(sql.getUser(username,accountType) != null) {
            user = sql.getUser(username, accountType);
            this.accountStatus = (String) user.get(iDatabase.accountStatus);
            this.activeStatus = (String) user.get(iDatabase.activeStatus);
        }else {
            System.out.println("There is no " + accountType + "yet for " + username);
        }

    }

    public String getPassword(){
        return (String) user.get("password");
    }

    public String getUsername() {
        return username;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public void setDenied(boolean denied) {
        this.denied = denied;
    }

    public String getAccountName(){
        return  user.get("owners") + " " + accountType;
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

        return "$"+ (String) user.get(iDatabase.accountBalance);
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

    public String getAccountType(){
        return  this.accountType;
    }


}
