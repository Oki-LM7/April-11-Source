package revature.banking_app.Data;

import revature.banking_app.ui.iUserObject;

import java.util.HashMap;

public interface iDatabase {


      String usernameAlready = "This username already exists";
      String passwordAlready = "This password already exists";


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

      String inactiveAccount = "inactive";

      String accountBalance = "balance";
      long defaultBalance = 0;

     String owners = "owners";

     String rank = "rank";
     String admin = "admin";
     String employee = "employee";
     String customer = "customer";


    HashMap<String,Object> getUser(String username, String accountType);


    HashMap<String,HashMap<String,Object>> getAllUsers();



    void saveUserInfo( HashMap<String,Object> userInfo );

    void saveAccountInfo(HashMap<String,Object> userInfo);

}
