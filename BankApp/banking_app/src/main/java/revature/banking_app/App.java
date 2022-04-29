package revature.banking_app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import revature.banking_app.Data.SQL_Database;
import revature.banking_app.Data.iDatabase;

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

        sql.saveUserInfo(testUser, String.valueOf(testUser.get(username)), iDatabase.defaultAccount);



    }
}
