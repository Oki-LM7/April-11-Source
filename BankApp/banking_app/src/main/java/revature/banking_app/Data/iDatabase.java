package revature.banking_app.Data;

import revature.banking_app.ui.iUserObject;

import java.util.HashMap;

public interface iDatabase {

      String personalInfo = "personal_Info";
      String accountInfo = "account_Info";
      String checkings  = "checkings";
      String savings  = "savings";
       String joint = "joint";



    HashMap getUser(String username, String accountType);


    HashMap<String,HashMap> getAllUsers();



    void saveUserInfo( HashMap user ,  String username);


}
