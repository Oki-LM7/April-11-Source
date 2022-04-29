package revature.banking_app.Test;

import revature.banking_app.Data.SQL_Database;
import revature.banking_app.Data.iDatabase;

import java.util.HashMap;

public class Driver {


    public static void Main(String [] args){

        HashMap<String, Object> testUser = new HashMap<>();

        SQL_Database sql = new SQL_Database();

        String username = "rob123";
        int password = 123;
        String name = "rob robinson";
        String rank = "customer";

        testUser.put("username", username);
        testUser.put("password", password);
        testUser.put("name",name);
        testUser.put("rank",rank);

      sql.saveUserInfo(testUser,testUser.get(username).toString(), iDatabase.defaultAccount);


    }
}
