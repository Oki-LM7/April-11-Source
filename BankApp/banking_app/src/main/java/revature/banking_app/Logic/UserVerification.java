package revature.banking_app.Logic;

import revature.banking_app.Data.SQL_DataSource;
import revature.banking_app.Data.iDataSource;

public class UserVerification {

    iDataSource sql = new SQL_DataSource();
    public boolean verify(String username){
        // if the user dosen't exist then you cannot login
       if(sql.getUser(username, iDataSource.defaultAccount)  == null){

            return false;
        }
        return true;

    }

    public boolean verify(String username,Long password){

        // if the password as a string  in the database matches the password that you gave
        // as a string then it's true;
        if ((long)sql.getUser(username, iDataSource.defaultAccount).get("password")  == Long.valueOf(password)){
            return true;
        }
        return false;
    }




}
