package revature.banking_app.Logic;


import revature.banking_app.Data.SQL_Database;
import revature.banking_app.Data.iDatabase;
import revature.banking_app.ui.iUserObject;

import java.util.HashMap;

public class CreateUser {



    public static iUserObject getUser(String rank){
        if (rank == "customer"){
            return  new CustomerUser();
        }else if (rank == "employee")
            return new EmployeeUser();
        else {
            return  new AdminUser();
        }
    }
}
