package revature.banking_app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import revature.banking_app.Data.SQL_Database;
import revature.banking_app.Data.iDatabase;
import revature.banking_app.Logic.CustomerUser;
import revature.banking_app.ui.iUserObject;

import java.util.HashMap;

/**
 * Hello world!
 *
 */
public class App 
{
	

    private static final Logger logger = LogManager.getLogger(App.class);
    public static void main( String[] args )
    {



        SQL_Database sql = new SQL_Database();

        String username = "rob123";
        int password = 123;
        String name = "rob robinson";
        String rank = "employee";

        HashMap<String, Object> testUser = new HashMap<>();
        testUser.put("username",username);
        testUser.put("password", password);
        testUser.put("name", name);
        testUser.put("rank", rank);
        testUser.put(iDatabase.accountBalance, iDatabase.defaultBalance);
        testUser.put(iDatabase.accountType, iDatabase.defaultAccount );
        testUser.put(iDatabase.activeStatus, iDatabase.activeAccount);
        testUser.put(iDatabase.accountStatus, iDatabase.pendingStatus);
        testUser.put(iDatabase.owners, name);

        sql.saveAccountInfo(testUser);
        //sql.saveUserInfo(testUser );



    }
}
