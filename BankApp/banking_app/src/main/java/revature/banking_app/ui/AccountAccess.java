package revature.banking_app.ui;

import revature.banking_app.Data.iDataSource;
import revature.banking_app.Logic.Account;
import revature.banking_app.Logic.BankAccount;
import revature.banking_app.Logic.UserVerification;

public class AccountAccess {

    boolean verification;
    String lookUpUsername;





    void infoPrompt(){
        ScannerInput input = new ScannerInput();
        String username = input.promptforString("Whose info would you like to see? Please Type in a customer's username: ");
        whoseInfo(username);
    }
    boolean whoseInfo(String username) {

        this.lookUpUsername = username;
        UserVerification userVerification = new UserVerification();
        if (userVerification.verify(username)){

            Account bankAccount = new BankAccount(username, iDataSource.defaultAccount);
            System.out.println(bankAccount.getAccountName());
            System.out.println(bankAccount.getPassword());
            return true;

        }else{
            System.out.println("verification failed");
           return false;

        }
    }

    public void failedVerification(iUserObject userObject){
        ScannerInput input = new ScannerInput();
        int yes = input.promptforInt("User not found. Would you like to try again? Type 1 for yes" +
                "Type 2 for no");
        if(yes == 1){
            infoPrompt();
        }else{
            userObject.getNav().back();

        }
    }

}
