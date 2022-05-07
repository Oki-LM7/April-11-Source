package revature.banking_app.ui;

import revature.banking_app.Data.iDatabase;
import revature.banking_app.Logic.Account;
import revature.banking_app.ui.MainMenu;
import revature.banking_app.ui.MenuNavigation;
import revature.banking_app.ui.inputable;

import java.util.ArrayList;


    public  class AccountsMenu implements  inputable {

        String username = (String) MainMenu.getMainMenu().getCurrentUserInfo().get("username");

        void showBalance(String username, String accountType) {

            Account account = new Account(username, accountType);
            System.out.println(username+ " " + accountType + " balance: $" + account.getBalance());
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





        @Override
        public void menuOptions() {

            showInfo(username, iDatabase.defaultAccount);

            input.promptforInt("Type 1 to make a deposit. Type 2 to make a withdrawal . " +
                    "Type 3 to make a transfer ");

            
        }

        @Override
        public void wrongInputOptions() {

        }
    }

