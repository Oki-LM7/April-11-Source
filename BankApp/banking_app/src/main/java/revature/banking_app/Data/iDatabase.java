package revature.banking_app.Data;

import revature.banking_app.ui.iUserObject;

import java.util.HashMap;

public interface iDatabase {

      String personalInfo = "personal_info";
      String accountInfo = "account_Info";
      String checkings  = "checkings";

      String defaultAccount  = "default";
      String savings  = "savings";
       String joint = "joint";



    iUserObject getUser(String username, String accountType);


    HashMap<String,iUserObject> getAllUsers();



    void saveUserInfo( HashMap<String,String> userStrings,HashMap<String,Integer>userInts ,  String username, String accountType);


}
