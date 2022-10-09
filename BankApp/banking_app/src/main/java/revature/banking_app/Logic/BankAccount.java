package revature.banking_app.Logic;

import revature.banking_app.Data.SQL_DataSource;
import revature.banking_app.Data.iDataSource;

import java.util.ArrayList;
import java.util.HashMap;

public class BankAccount extends Account {

    String username;
    String accountType;

    String accountStatus;

    String activeStatus;

    HashMap user;
    SQL_DataSource sql = new SQL_DataSource();
    boolean approved = false;
    boolean denied = false;



    public BankAccount(String username, String accountType){
        this.username = username;
        this.accountType = accountType;

        //if else block makes sure user will always have account info
        if(sql.getUser(username,accountType) != null) {
            user = sql.getUser(username, accountType);
            this.accountStatus = (String) user.get(iDataSource.accountStatus);
            this.activeStatus = (String) user.get(iDataSource.activeStatus);
        }else {
            // everyone has a default account. If the account they are calling does not exist, then get the
            //user's info from their default

            user = sql.getUser(username, iDataSource.defaultAccount);
            this.activeStatus = iDataSource.inactiveAccount;
            this.accountStatus = iDataSource.pendingStatus;
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
            user.put(iDataSource.accountStatus, iDataSource.pendingStatus);
            user.put(iDataSource.activeStatus, iDataSource.inactiveAccount);
            user.put(iDataSource.accountType, accountType);
            sql.saveAccountInfo(user);
        }


    }



    public void deposit(long money, String accountType){
        if(goodStatus()) {
            long newBalance = 0L;
            newBalance = money + (Long) user.get(iDataSource.accountBalance);
            user.put(iDataSource.accountBalance, newBalance);
            user.put(iDataSource.accountType, accountType);
            sql.saveAccountInfo(user);
            System.out.println(" We changed your balance to: $" + newBalance);
        }else {
            System.out.println("We cannot make a deposit");
        }
    }

    public boolean goodStatus(){
        // both active and approved
        if(! ((activeStatus.equals(iDataSource.activeAccount) && accountStatus.equals(iDataSource.approvedStatus)))){
            System.out.println("your account status is " + accountStatus
                    + " your active status is " + activeStatus);
            return  false;
        };
           return  true;
    }

    public void withdrawal(long money, String accountType ){
         if (goodStatus()) {
             long newBalance = 0L;
             newBalance = (Long) user.get(iDataSource.accountBalance) - money;
             if (newBalance < 0) {
                 System.out.println("You do not have enough money in your account for a withdrawal");
             } else {
                 user.put(iDataSource.accountBalance, newBalance);
                 user.put(iDataSource.accountType, accountType);
                 sql.saveAccountInfo(user);
                 System.out.println("Your new balance is: $" + newBalance);
             }
         }else {
             System.out.println("We cannot make the withdrawal");
         }
    }

    public Long getBalance(){
        if(user == null || user.get(iDataSource.accountBalance) ==null){
            return 0L;
        }

        return  (Long) user.get(iDataSource.accountBalance);
    }

    public void saveAccountStatus(String accountStatus){
        if (user != null){
            user.put(iDataSource.accountStatus, accountStatus);

            sql.saveAccountInfo(user);
            System.out.println(user.get("owners")+ "'s " + user.get(iDataSource.accountType) + " is now"
            + accountStatus);
        }else {
            System.out.println("cannot change status to " + accountStatus + " because this account does not exist " +
                    "for this username");
        }

    }

    public void setActiveStatus(String activeStatus){
        if (user != null){
            user.put(iDataSource.activeStatus,activeStatus);
            sql.saveAccountInfo(user);
            System.out.println(user.get("owners")+ "'s " + user.get(iDataSource.accountType) + " is now"
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
            accountTypes.add(iDataSource.checkings);
            accountTypes.add(iDataSource.joint);
            accountTypes.add(iDataSource.savings);

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
