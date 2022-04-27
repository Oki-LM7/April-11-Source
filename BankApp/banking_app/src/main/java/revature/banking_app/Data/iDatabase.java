package revature.banking_app.Data;

import revature.banking_app.ui.iUserObject;

import java.util.HashMap;

public interface iDatabase {




    iUserObject getUser(String username);


    HashMap<String,iUserObject> getAllUsers();

    void saveUser(HashMap<String, iUserObject> userInfo ,  String username, String infoType);


}
