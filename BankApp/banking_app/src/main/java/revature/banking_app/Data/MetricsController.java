package revature.banking_app.Data;

import io.javalin.Javalin;
import io.javalin.http.Handler;

import java.util.HashMap;

public class MetricsController {

     SQL_DataSource sql = new SQL_DataSource();
     String averageBalance = "average-balance";
     String totalUsers ="total-users";

    public MetricsController(Javalin app) {

        sql = new SQL_DataSource();

        app.get("/users/metrics/{metricType}", getHandler);


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
        String metricType = ctx.pathParam("metricType");


        System.out.println("metric: "+ metricType ) ;

        // Get the user based on the username

        // Turns the given Java object into JSON format,
        // which is a text format understood by almost everybody and
        // can be used in any system running any technology
        // Think of JSON as a universal data transfer format

        ctx.result(metrics(metricType));
    };

    String metrics(String metric){
        if(metric.equals(averageBalance)){
           return String.valueOf(averageBalance());
        }else if (metric.equals(totalUsers)){

           return String.valueOf(totalUsers());
        }else{
            System.out.println("We do not offer that metric.");
        }
        return "We do not offer that metric.";
    }



     long averageBalance(){

         HashMap users = sql.getAllUsers();
         if (users ==null){
             // prevents divide by 0
             return -1;
         }
         long balance = 0;
         long totalBalances =0;
         for (Object user: users.values()
              ) {
            //every object is a hashmap
             HashMap userMap = (HashMap) user;

             if( userMap.get("balance") != null){
                 balance =  balance + (Long) userMap.get("balance");
                 totalBalances = totalBalances+1;
             }

         }
         return balance/totalBalances;
     }

     long totalUsers(){
         HashMap users = sql.getAllUsers();
        return  users.size();
     }
}
