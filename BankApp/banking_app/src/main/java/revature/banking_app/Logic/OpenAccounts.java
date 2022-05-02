package revature.banking_app.Logic;

import revature.banking_app.Data.SQL_Database;
import revature.banking_app.Data.iDatabase;
import revature.banking_app.ui.MainMenu;

import java.util.HashMap;

public class OpenAccounts {
    SQL_Database sql = new SQL_Database();






    public boolean openAccount(String username, String accountType){
        // no users so don't open accounts
        if(sql.getAllUsers()==null){
            System.out.println("no users have been made yet");
            return false;
        }

        // there are users but this user does not have an account yet
        if(sql.getUser(username, iDatabase.defaultAccount) == null){
            System.out.println(" you have not signed up yet");
            return  false;
        }
        System.out.println("opening a "+ accountType + " for " + username);
        // get user since they exist
        HashMap user = sql.getUser(username,iDatabase.defaultAccount);
        //change account type
        user.put(iDatabase.accountType, accountType);
        user.put(iDatabase.owners,user.get("name"));
        sql.saveAccountInfo(user);
        return true;
    }
}
