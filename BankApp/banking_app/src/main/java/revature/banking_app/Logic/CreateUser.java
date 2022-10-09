package revature.banking_app.Logic;


import revature.banking_app.ui.iUserObject;

public class CreateUser {




    public  iUserObject getUser(String rank){
        if (rank.equals("customer")){
            return  new CustomerUser();
        }else if (rank.equals("employee"))
            return new EmployeeUser();
        else {
            return  new AdminUser();
        }
    }


    public EmployeeUser getEmployeeUser() {
        EmployeeUser employeeUser = new EmployeeUser();


        if(employeeUser.rank.equals("admin")){
            employeeUser = new AdminUser();

            return  employeeUser;
        }
        return employeeUser;
    }
}
