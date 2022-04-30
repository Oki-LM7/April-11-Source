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
        String rank = "customer";

        iUserObject.userStrings.put("username", username);
        iUserObject.userInts.put("password", password);
        iUserObject.userStrings.put("name",name);
        iUserObject.userStrings.put("rank",rank);

        sql.saveUserInfo(iUserObject.userStrings, iUserObject.userInts,
                iUserObject.userStrings.get("name"), iDatabase.defaultAccount);



    }
}
