package revature.banking_app.ui;

import revature.banking_app.Data.iDataSource;
import revature.banking_app.Logic.Account;
import revature.banking_app.Logic.BankAccount;

import java.util.ArrayList;


    public  class AccountsMenu extends inputable {

        String username;


        iUserObject userObject;

        public AccountsMenu(iUserObject userObject){

            this.userObject = userObject;
            username = userObject.getUsername();

        }

        void showBalance(String username, String accountType) {

            Account bankAccount = new BankAccount(username, accountType);
            if (bankAccount.goodStatus()) {
                System.out.println(username + " " + accountType + " balance: $" + bankAccount.getBalance());
            }
        }

        void showBalances(String username, ArrayList<String> accountTypes){
            if(accountTypes == null){
                System.out.println(username + "has not applied for accounts yet");
            }else{
                for (String accountType: accountTypes
                ) {
                    showBalance(username,accountType);
                }
            }

        }







        public void showInfo(String username, String accountType) {
            Account bankAccount = new BankAccount(username, accountType);
            System.out.println(bankAccount.getAccountName());
            System.out.println(bankAccount.getAccountStatus());
            System.out.println(bankAccount.getActiveStatus());
            showBalances(username, bankAccount.getAllAccountTypes());
        }

        public void changeBalance(int change){
            if (change == 1){

                int accountType = input.promptforInt("Which account would ypu like to deposit money into? :" +
                        "Type 1 for checkings. Type 2 for savings . Type 3 for joint");

                long amount = Long.valueOf(input.promptforInt("How much would you like to deposit? : "));
                Account bankAccount = new BankAccount(username, whichAccount(accountType));
                bankAccount.deposit(amount,whichAccount(accountType));

            } else if(change == 2){

                int accountType = input.promptforInt("Which account would you like to withdrawal money from? :" +
                        "Type 1 for checkings. Type 2 for savings . Type 3 for joint");

                int amount = input.promptforInt("How much would you like to withdrawal? : ");
                Account bankAccount = new BankAccount(username, whichAccount(accountType));
                bankAccount.withdrawal(amount,whichAccount(accountType));

            } else if (change == 3) {
                TransactionMenu transactionMenu = new TransactionMenu();
                transactionMenu.menuOptions();
            } else if (change == 8) {
                exitApp();

            }else {
                wrongInputOptions();
            }
        }

        public String whichAccount(int account){
            if (account == 1){
                return iDataSource.checkings;
            }else if(account == 2){
                return iDataSource.savings;
            }else if(account == 3){
                return iDataSource.joint;
            } else if (account == 8) {
                exitApp();
            }else {
                wrongInputOptions();
            }
            return "";
        }

        @Override
        public void menuOptions() {

            showInfo(username, iDataSource.defaultAccount);



           int change =  input.promptforInt("Type 1 to make a deposit. Type 2 to make a withdrawal . " +
                    "Type 3 to make a transfer ");
           changeBalance(change);

            
        }

        @Override
        public void wrongInputOptions() {
              please();
              menuOptions();
        }
    }

