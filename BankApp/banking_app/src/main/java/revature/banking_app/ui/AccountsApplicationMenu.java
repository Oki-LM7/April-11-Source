package revature.banking_app.ui;

import revature.banking_app.Data.SQL_DataSource;
import revature.banking_app.Data.iDataSource;
import revature.banking_app.Logic.Account;
import revature.banking_app.Logic.BankAccount;
import revature.banking_app.Logic.UserVerification;



    public  class AccountsApplicationMenu extends inputable {




        iUserObject userObject;

        String username ;

       public AccountsApplicationMenu(iUserObject userObject){

          this.userObject = userObject;
           username = userObject.getUsername();
       }


        public void accountPrompt(int accountType) {

            if(accountType == 1){
                //account.checkings()
                Account bankAccount = new BankAccount(username, iDataSource.checkings);
                bankAccount.applyForAccount(iDataSource.checkings);
                backOptions(userObject);
            } else if (accountType == 2) {
                //account.savings()
                Account bankAccount = new BankAccount(username, iDataSource.savings);
                bankAccount.applyForAccount(iDataSource.savings);
                backOptions(userObject);
            }else if (accountType == 3){
                String usernameJoint = input.promptforString("What is the username of the person " +
                        "you are creating a joint account with? ");
                jointUserPrompt(iDataSource.joint);

            }else{
                wrongInputOptions();
            }
        }

        public void jointPrompt(int yes, String username) {
            if(yes == 1){
                Account bankAccount = new BankAccount(username, iDataSource.joint);
                bankAccount.applyForAccount(username);

            }else {
                backOptions(userObject);
            }

        }

        public void jointUserPrompt(String username) {
            UserVerification userVerification = new UserVerification();
            if(userVerification.verify(username)){
                SQL_DataSource sql_database = new SQL_DataSource();
                String name = (String) sql_database.getUser(username, iDataSource.defaultAccount).get("name");
                int yes = input.promptforInt("Make a joint account with " + name);
                jointPrompt(yes,name);
            }

        }



        @Override
        public void menuOptions() {
            int accountType = input.promptforInt("Which Type of account are you applying for?" +
                    "type 1 for checkings   type 2 for savings    type 3 for joint");
            accountPrompt(accountType);
        }

        @Override
        public void wrongInputOptions() {
            please();
            int accountType = input.promptforInt("Which Type of account are you applying for?" +
                    "type 1 for checkings   type 2 for savings    type 3 for joint");
            accountPrompt(accountType);


        }

}
