package revature.banking_app.Logic;

import revature.banking_app.Data.SQL_Database;
import revature.banking_app.Data.iDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class PendingAccounts {

    SQL_Database sql = new SQL_Database();
    ArrayList<Account> bankAccounts = new ArrayList<>();
    ArrayList<Account> pending = new ArrayList<>();

    public void getAllAccounts(){

        for ( HashMap user : sql.getAllUsers().values()
             ) {

               String name = (String) user.get("name");
               String accountType = (String) user.get(iDatabase.accountType);


                    Account bankAccount = new BankAccount(name,accountType);
                    bankAccounts.add(bankAccount);

        }

    }

    public void setPendingAccounts(){

        for (Account bankAccount : bankAccounts
             ) {
            if(bankAccount.getAccountStatus() != null) {
                if (bankAccount.getAccountStatus().equals(iDatabase.pendingStatus)) {

                    pending.add(bankAccount);


                }
            }

        }
    }


    public ArrayList<Account> getPendingAccounts(){
        getAllAccounts();
        // not really a setter just filters and adds to an arraylist
        setPendingAccounts();
        return this.pending;
    }




}
