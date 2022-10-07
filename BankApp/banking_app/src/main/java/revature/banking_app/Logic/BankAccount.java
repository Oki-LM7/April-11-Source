package revature.banking_app.Logic;

import revature.banking_app.Data.SQL_Database;
import revature.banking_app.Data.iDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class BankAccount extends Account {

    String username;
    String accountType;

    String accountStatus;

    String activeStatus;

    HashMap user;
    SQL_Database sql = new SQL_Database();
    boolean approved = false;
    boolean denied = false;



    public BankAccount(String username, String accountType){
        this.username = username;
        this.accountType = accountType;

        //if else block makes sure user will always have account info
        if(sql.getUser(username,accountType) != null) {
            user = sql.getUser(username, accountType);
            this.accountStatus = (String) user.get(iDatabase.accountStatus);
            this.activeStatus = (String) user.get(iDatabase.activeStatus);
        }else {
            // everyone has a default account. If the account they are calling does not exist, then get the
            //user's info from their default

            user = sql.getUser(username, iDatabase.defaultAccount);
            this.activeStatus = iDatabase.inactiveAccount;
            this.accountStatus = iDatabase.pendingStatus;
            System.out.println("There is no " + accountType + " yet for " + username);
        }

    }

    public Long getPassword(){
        return (Long) user.get("password");
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

        if(user != null){
            // user being null crashes the program
            user.put(iDatabase.accountStatus, iDatabase.pendingStatus);
            user.put(iDatabase.activeStatus, iDatabase.inactiveAccount);
            user.put(iDatabase.accountType, accountType);
            sql.saveAccountInfo(user);
        }


    }



    public void deposit(long money, String accountType){
        if(goodStatus()) {
            long newBalance = 0L;
            newBalance = money + (Long) user.get(iDatabase.accountBalance);
            user.put(iDatabase.accountBalance, newBalance);
            user.put(iDatabase.accountType, accountType);
            sql.saveAccountInfo(user);
            System.out.println(" We changed your balance to: $" + newBalance);
        }else {
            System.out.println("We cannot make a deposit");
        }
    }

    public boolean goodStatus(){
        // both active and approved
        if(! ((activeStatus.equals(iDatabase.activeAccount) && accountStatus.equals(iDatabase.approvedStatus)))){
            System.out.println("your account status is " + accountStatus
                    + " your active status is " + activeStatus);
            return  false;
        };
           return  true;
    }

    public void withdrawal(long money, String accountType ){
         if (goodStatus()) {
             long newBalance = 0L;
             newBalance = (Long) user.get(iDatabase.accountBalance) - money;
             if (newBalance < 0) {
                 System.out.println("You do not have enough money in your account for a withdrawal");
             } else {
                 user.put(iDatabase.accountBalance, newBalance);
                 user.put(iDatabase.accountType, accountType);
                 sql.saveAccountInfo(user);
                 System.out.println("Your new balance is: $" + newBalance);
             }
         }else {
             System.out.println("We cannot make the withdrawal");
         }
    }

    public Long getBalance(){
        if(user == null || user.get(iDatabase.accountBalance) ==null){
            return 0L;
        }

        return  (Long) user.get(iDatabase.accountBalance);
    }

    public void saveAccountStatus(String accountStatus){
        if (user != null){
            user.put(iDatabase.accountStatus, accountStatus);

            sql.saveAccountInfo(user);
            System.out.println(user.get("owners")+ "'s " + user.get(iDatabase.accountType) + " is now"
            + accountStatus);
        }else {
            System.out.println("cannot change status to " + accountStatus + " because this account does not exist " +
                    "for this username");
        }

    }

    public void setActiveStatus(String activeStatus){
        if (user != null){
            user.put(iDatabase.activeStatus,activeStatus);
            sql.saveAccountInfo(user);
            System.out.println(user.get("owners")+ "'s " + user.get(iDatabase.accountType) + " is now"
                    + activeStatus);
        }else{
            System.out.println("We  cannot change status to " + activeStatus + " because this account does not exist " +
                    "for this username");
        }

    }

    public ArrayList<String> getAllAccountTypes(){

        if(user == null){
            System.out.println("This username has not applied for any accounts");
            return  null;
        }else {
            ArrayList<String> accountTypes = new ArrayList<>();
            accountTypes.add(iDatabase.checkings);
            accountTypes.add(iDatabase.joint);
            accountTypes.add(iDatabase.savings);

            ArrayList<String> actualAccounts = new ArrayList<>();

            for (String accountType :
                    accountTypes) {
                // if the database can't find this account then remove it from the returning list
                if (sql.getUser((String) user.get("username"), accountType) == null) {
                    actualAccounts.add(accountType);

                }

            }
            return actualAccounts;
        }
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
