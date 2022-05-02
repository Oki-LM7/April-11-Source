package revature.banking_app.Data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.ToNumberPolicy;
import com.google.gson.reflect.TypeToken;
import io.javalin.Javalin;
import io.javalin.http.Handler;

import java.util.HashMap;

public class AccountInfoController {
    SQL_Database sql  ;
    public AccountInfoController(Javalin app) {

        sql = new SQL_Database();

        app.get("/users/account/{username}/{accountType}", getHandler);
        app.post("/users/account", postHandler);
        app.put("/users/account/{username}", putHandler);

    }

    /* The 'Algorithm' for controllers
     * 0. Determine if data is flowing in (to your db) o
     *    or out (back to the requestor)
     * 1. Get data (either from the body (if data is flowing in)
     *    or path (if data is flowing out))
     * 2. Use data with your DAO
     * 3. Return desired result
     */

    public Handler getHandler = ctx -> {

        // Get the path's username
        String username = ctx.pathParam("username");
        String accountType = ctx.pathParam("accountType");

        System.out.println("username: "+ username + " account Type: " + accountType) ;

        // Get the user based on the username
        HashMap<String,Object> user = sql.getUser(username,accountType);

        // Turns the given Java object into JSON format,
        // which is a text format understood by almost everybody and
        // can be used in any system running any technology
        // Think of JSON as a universal data transfer format
        ctx.json(user);
    };


    // The 'create' command
    public Handler postHandler = ctx -> {

        // Turn the body of the request from JSON (ie text) into
        // a hashmap

        //the doubles need to be converted to longs
        Gson gson = new GsonBuilder()
                .setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE)
                .create();

        String userJson = ctx.body();

        HashMap<String,Object> user =
                gson.fromJson(userJson, new TypeToken<HashMap<String, Object>>(){}.getType());








        System.out.println("user: " + user);

        sql.saveAccountInfo(user);

        // As a best practice, responses should have descriptive
        // status codes
        ctx.status(201);
    };

    // 'update' command
    public Handler putHandler = ctx -> {

        // Turn the body of the request from JSON (ie text) into
        // a hashmap

        //make sure doubles are converted to ints
        Gson gson = new GsonBuilder()
                .setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE)
                .create();



        String userJson = ctx.body();

        HashMap<String,Object> user =
                gson.fromJson(userJson, new TypeToken<HashMap<String, Object>>(){}.getType());

//convert all doubles to ints


        sql.saveAccountInfo(user);

        ctx.status(200);
    };


}
