package revature.banking_app.Logic;


import revature.banking_app.Data.SQL_Database;
import revature.banking_app.Data.iDatabase;
import revature.banking_app.ui.MenuNavigation;
import revature.banking_app.ui.iUserObject;

import java.util.HashMap;

public class CreateUser {




    public static iUserObject getUser(String rank){
        if (rank.equals("customer")){
            return  new CustomerUser();
        }else if (rank.equals("employee"))
            return new EmployeeUser();
        else {
            return  new AdminUser();
        }
    }


    public EmployeeUser getEmployeeUser(iUserObject userObject) {
        EmployeeUser employeeUser = new EmployeeUser();


        if(employeeUser.rank.equals("admin")){
            employeeUser = new AdminUser();

            return  employeeUser;
        }
        return employeeUser;
    }
}
