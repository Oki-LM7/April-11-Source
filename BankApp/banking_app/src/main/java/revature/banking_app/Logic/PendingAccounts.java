package revature.banking_app.Logic;

import revature.banking_app.Data.SQL_DataSource;
import revature.banking_app.Data.iDataSource;

import java.util.ArrayList;
import java.util.HashMap;

public class PendingAccounts {

    SQL_DataSource sql = new SQL_DataSource();
    ArrayList<Account> bankAccounts = new ArrayList<>();
    ArrayList<Account> pending = new ArrayList<>();

    public void getAllAccounts(){

        for ( HashMap user : sql.getAllUsers().values()
             ) {

               String name = (String) user.get("name");
               String accountType = (String) user.get(iDataSource.accountType);


                    Account bankAccount = new BankAccount(name,accountType);
                    bankAccounts.add(bankAccount);

        }

    }

    public void setPendingAccounts(){

        for (Account bankAccount : bankAccounts
             ) {
            if(bankAccount.getAccountStatus() != null) {
                if (bankAccount.getAccountStatus().equals(iDataSource.pendingStatus)) {

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
