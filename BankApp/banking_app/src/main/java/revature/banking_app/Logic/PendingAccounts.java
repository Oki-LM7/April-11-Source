package revature.banking_app.Logic;

import revature.banking_app.Data.SQL_Database;
import revature.banking_app.Data.iDatabase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PendingAccounts {

    SQL_Database sql = new SQL_Database();
    ArrayList<Account> accounts  = new ArrayList<>();
    ArrayList<Account> pending = new ArrayList<>();

    public void getAllAccounts(){

        for ( HashMap user : sql.getAllUsers().values()
             ) {

               String name = (String) user.get("name");
               String accountType = (String) user.get(iDatabase.accountType);


                    Account account = new Account(name,accountType);
                    accounts.add(account);

        }

    }

    public void setPendingAccounts(){

        for (Account account: accounts
             ) {
            if(account.getAccountStatus() != null) {
                if (account.getAccountStatus().equals(iDatabase.pendingStatus)) {

                    pending.add(account);


                }
            }

        }
    }


    public ArrayList<Account> getPendingAccounts(){
        getAllAccounts();
        setPendingAccounts();
        return this.pending;
    }




}
