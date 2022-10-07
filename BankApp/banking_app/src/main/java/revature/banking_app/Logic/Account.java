package revature.banking_app.Logic;

import java.util.ArrayList;

public abstract class Account {

    public abstract boolean goodStatus();

    public abstract Long getBalance();

    public abstract void applyForAccount(String accountType);

    public abstract String getAccountName();

    public abstract String getAccountStatus();

    public abstract String getActiveStatus();

    public abstract ArrayList<String> getAllAccountTypes();

    public abstract void deposit(long amount, String whichAccount);

    public abstract void setApproved(boolean b);

    public abstract void setDenied(boolean b);

    public abstract void saveAccountStatus(String accountStatus);

    public abstract void withdrawal(long amount, String whichAccount);

    public abstract Long getPassword();
}
