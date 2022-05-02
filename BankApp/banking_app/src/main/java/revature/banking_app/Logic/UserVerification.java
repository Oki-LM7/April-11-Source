package revature.banking_app.Logic;

import revature.banking_app.Data.SQL_Database;
import revature.banking_app.Data.iDatabase;
import revature.banking_app.ui.iUserObject;

public class UserVerification {

    iDatabase sql = new SQL_Database();
    public boolean verify(String username){
        // if the user dosen't exist then you cannot login
       if(sql.getUser(username, iDatabase.defaultAccount)  == null){

            return false;
        }
        return true;

    }

    public boolean verify(String username,int password){

        // if the password as a string  in the database matches the password that you gave
        // as a string then it's true;
        if (sql.getUser(username, iDatabase.defaultAccount).get(password).toString().equals(
                String.valueOf(password))){
            return true;
        }
        return false;
    }




}
