package revature.banking_app.Data;

import revature.banking_app.ui.iUserObject;

import java.util.HashMap;

public interface iDatabase {

      String personalInfo = "personal_info";
      String accountInfo = "account_info";

    String accountType = "accountType";
      String checkings  = "checkings";
    String savings  = "savings";
    String joint = "joint";




      String defaultAccount  = "default";



    String accountStatus = "accountStatus";

      String pendingStatus = "pending";

      String approvedStatus = "approved";

      String deniedStatus = "denied";


      String activeStatus = "activeStatus";

      String activeAccount = "active";

      String canceledAccount = "canceled";

      String accountBalance = "balance";
      int defaultBalance = 0;

     String owners = "owners";


    HashMap<String,Object> getUser(String username, String accountType);


    HashMap<String,HashMap<String,Object>> getAllUsers();



    void saveUserInfo( HashMap<String,Object> userInfo );

    void saveAccountInfo(HashMap<String,Object> userInfo);

}
