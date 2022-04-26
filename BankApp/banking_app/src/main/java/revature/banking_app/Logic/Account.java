package revature.banking_app.Logic;

public class Account {

    String name;
    String accountType;
    boolean approved = false;
    boolean denied = false;

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public void setDenied(boolean denied) {
        this.denied = denied;
    }

    public String getAccountName(){
        return  name+ " " + accountType;
    }
}
