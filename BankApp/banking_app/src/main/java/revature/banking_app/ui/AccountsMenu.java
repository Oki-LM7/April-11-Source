package revature.banking_app.ui;

import revature.banking_app.Data.iDatabase;
import revature.banking_app.Logic.Account;
import revature.banking_app.ui.MainMenu;
import revature.banking_app.ui.MenuNavigation;
import revature.banking_app.ui.inputable;

import java.util.ArrayList;


    public  class AccountsMenu implements  inputable {

        String username = (String) MainMenu.getMainMenu().getCurrentUserInfo().get("username");
        MenuNavigation nav = new MenuNavigation();

        void showBalance(String username, String accountType) {

            Account account = new Account(username, accountType);
            if (account.goodStatus()) {
                System.out.println(username + " " + accountType + " balance: $" + account.getBalance());
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
            Account account = new Account(username, accountType);
            System.out.println(account.getAccountName());
            System.out.println(account.getAccountStatus());
            System.out.println(account.getActiveStatus());
            showBalances(username, account.getAllAccountTypes());
        }

        public void changeBalance(int change){
            if (change == 1){

                int accountType = input.promptforInt("Which account would ypu like to deposit money into? :" +
                        "Type 1 for checkings. Type 2 for savings . Type 3 for joint");

                int amount = input.promptforInt("How much would you like to deposit? : ");
                Account account = new Account(username, whichAccount(accountType));
                account.deposit(amount,whichAccount(accountType));

            } else if(change == 2){

                int accountType = input.promptforInt("Which account would you like to withdrawal money from? :" +
                        "Type 1 for checkings. Type 2 for savings . Type 3 for joint");

                int amount = input.promptforInt("How much would you like to withdrawal? : ");
                Account account = new Account(username, whichAccount(accountType));
                account.withdrawal(amount,whichAccount(accountType));

            } else if (change == 3) {
                TransactionMenu transactionMenu = new TransactionMenu();
                transactionMenu.menuOptions();
            } else if (change == 8) {
                nav.exitApp();

            }else {
                wrongInputOptions();
            }
        }

        public String whichAccount(int account){
            if (account == 1){
                return iDatabase.checkings;
            }else if(account == 2){
                return iDatabase.savings;
            }else if(account == 3){
                return iDatabase.joint;
            } else if (account == 8) {
                nav.exitApp();
            }else {
                wrongInputOptions();
            }
            return "";
        }

        @Override
        public void menuOptions() {

            showInfo(username, iDatabase.defaultAccount);



           int change =  input.promptforInt("Type 1 to make a deposit. Type 2 to make a withdrawal . " +
                    "Type 3 to make a transfer ");
           changeBalance(change);

            
        }

        @Override
        public void wrongInputOptions() {
              nav.please();
              menuOptions();
        }
    }

