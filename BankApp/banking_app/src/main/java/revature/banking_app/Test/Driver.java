package revature.banking_app.Test;

import java.util.HashMap;

public class Driver {


    public static void Main(String [] args){

        HashMap<String, Object> testUser = new HashMap<>();

        String username = "rob123";
        int password = 123;
        String name = "rob robinson";
        String rank = "customer";

        testUser.put("username", username);
        testUser.put("password", password);
        testUser.put("name",name);
        testUser.put("rank",rank);




    }
}
