package revature.banking_app;

import io.javalin.Javalin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import revature.banking_app.Data.*;
import revature.banking_app.ui.MainMenu;

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
       // Javlin Test  use  username: andrew   and   accountType: checkings
        // then  username: dave123   and   accountType: savings
       Javalin app = Javalin.create().start(7070);
        PersonalInfoController personalInfoController = new PersonalInfoController(app);
    AccountInfoController accountInfoController = new AccountInfoController(app);
        MetricsController metricsController = new MetricsController(app);

        SQL_DataSource sql = new SQL_DataSource();

        String username = "rob123";
        long password = 123L;
        String name = "rob robinson";
        String rank = "employee";

        HashMap<String, Object> testUser = new HashMap<>();
        testUser.put("username",username);
        testUser.put("password", password);
        testUser.put("name", name);
        testUser.put("rank", rank);
        testUser.put(iDataSource.accountBalance, iDataSource.defaultBalance);
        testUser.put(iDataSource.accountType, iDataSource.defaultAccount );
        testUser.put(iDataSource.activeStatus, iDataSource.activeAccount);
        testUser.put(iDataSource.accountStatus, iDataSource.pendingStatus);
        testUser.put(iDataSource.owners, name);


        String and = " and ryan";
        HashMap<String, Object> andrew = new HashMap<>();

        andrew.put("username", "andrew");
        andrew.put("password", 5);
        andrew.put("name", name);
        andrew.put(iDataSource.rank, iDataSource.admin);
        andrew.put(iDataSource.accountBalance, (long)500000);
        andrew.put(iDataSource.accountType, iDataSource.checkings);
        andrew.put(iDataSource.activeStatus, iDataSource.activeAccount);
        andrew.put(iDataSource.owners,name + and);

      //get Tests
  /*
    HashMap map = new HashMap<>();
      map = sql.getUser("dav123","savings");
      System.out.println(map);

   */



     //Post Test  uses
     /*
     {"accountStatus":approved,"password":55,"activeStatus":"active","balance":800000,
     "accountType":"savings","name":"dave davidson","rank":"employee","owners":"dave davidson and ryan",
     "id":null,"ownerID":null,"username":"dave123"}

     HashMap<String, Object> andrew = new HashMap<>();

        andrew.put("username", "dave123");
        andrew.put("password", 55);
        andrew.put("name", "dave davidson");
        andrew.put(iDatabase.rank, iDatabase.admin);
        andrew.put(iDatabase.accountBalance, 500000);
        andrew.put(iDatabase.accountType, iDatabase.savings);
        andrew.put(iDatabase.activeStatus, iDatabase.activeAccount);
        andrew.put(iDatabase.owners,name + and);
      */






       // sql.saveAccountInfo(andrew);
        //sql.saveUserInfo(andrew );


        // Test UI
        MainMenu mainMenu = new MainMenu();
        mainMenu.menuOptions();


    }
}
