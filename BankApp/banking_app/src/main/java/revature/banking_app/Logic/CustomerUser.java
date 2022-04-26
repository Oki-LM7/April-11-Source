package revature.banking_app.Logic;

import revature.banking_app.ui.iUserObject;

public class CustomerUser implements iUserObject {

    String name;
    @Override
    public void welcomePrompt() {
        System.out.println(" Thank you for logging on to the bank app " + name);
    }

    @Override
    public void backGreeting() {
        System.out.println(" Hello again "  + name);
    }

    @Override
    public void exitGreeting() {
        System.out.println(" Thank you for using the bank app " + name + " We hope you had a great experience");
    }
}
