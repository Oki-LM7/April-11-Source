package revature.banking_app.Logic;

import revature.banking_app.Data.Database;
import revature.banking_app.ui.iUserObject;

public class CreateUser {


    public iUserObject getUser(String rank){
        if (rank == "customer"){
            return  new CustomerUser();
        }else if (rank == "employee")
            return new EmployeeUser();
        else {
            return  new AdminUser();
        }
    }
}
