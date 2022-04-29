package revature.banking_app.Data;

import revature.banking_app.ui.iUserObject;

import java.util.HashMap;

public interface iDatabase {

      public  String personalInfo = "personal_Info";
      public   String accountInfo = "account_Info";
      public String checkings  = "checkings";
      public String savings  = "savings";
      public String joint = "joint";



    HashMap getUser(String username, String accountType);


    HashMap<String,HashMap> getAllUsers();



    void saveUserInfo( HashMap user ,  String username);


}
