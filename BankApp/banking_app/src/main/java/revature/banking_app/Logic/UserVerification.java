package revature.banking_app.Logic;

public class UserVerification {
    Database
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
