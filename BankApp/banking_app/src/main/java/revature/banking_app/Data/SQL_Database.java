package revature.banking_app.Data;

import revature.banking_app.ui.iUserObject;

import java.util.HashMap;

public class SQL_Database implements  iDatabase {

    public iUserObject getUser(String username){

         return    getAllUsers().get(username);

    }


    @Override
    public HashMap<String, iUserObject> getAllUsers() {
        return null;
    }

    @Override
    public void saveUserInfo(iUserObject user, String username, String infoType) {

    }
}
