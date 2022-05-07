package revature.banking_app.Logic;

public class AdminUser extends  EmployeeUser {

  
  boolean adminPrivileges;

  public AdminUser(){
    this.adminPrivileges = true;
  }

  @Override
  public boolean hasAdminPrivileges() {
    return adminPrivileges;
  }
}
