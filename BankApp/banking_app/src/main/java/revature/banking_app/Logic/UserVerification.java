package revature.banking_app.Logic;

import revature.banking_app.ui.iUserObject;

public class UserVerification {

    public boolean verify(String username){

        return true;
    }

    public boolean verify(int password){

        return true;
    }



    public EmployeeUser verifyEmployee(String rank){
        if (rank == "admin"){
            return new AdminUser();
        }
        return new EmployeeUser();
    }
}
