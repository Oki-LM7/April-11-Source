package revature.banking_app.Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class SQL_Database implements  iDatabase {

    private Connection conn = ConnectionManager.getConnection();

    @Override
    public HashMap getUser(String username, String accountType) {


        return getAllUsers().get(username + accountType);


    }

    @Override
    public HashMap<String, HashMap> getAllUsers() {

        try {
            // Step 1
            String query = "SELECT * FROM users JOIN ON personal_Info.id = " +
                    "accounts_Info.owner_id";
            Statement statement = conn.createStatement();

            // Set the username filter value (ie the ?)


            ResultSet rs = statement.executeQuery(query);
            if(rs == null){
                System.out.println("connection must have closed or  select query didn't work");
            }
            HashMap users = new HashMap<String,Object>();

            // Step 2
            while (rs.next()) {
                // user exists
                HashMap<String, Object> user = new HashMap<>();
                user.put("username", rs.getString("username")); // also just the username variable
                user.put("password", rs.getInt("password"));
                user.put("name", rs.getString("name"));
                user.put("rank", rs.getString("rank"));
                user.put("id", rs.getInt("id"));
                user.put("ownerID", rs.getInt("owner_id"));
                user.put("accountType", rs.getString("account_type"));
                user.put("accountStatus", rs.getString("account_status"));
                user.put("activeStatus", rs.getString("active_status"));
                user.put("owners", rs.getString("owners"));
                user.put("balance", rs.getInt("balance"));

                users.put(rs.getString("username") + rs.getString("account_Type"), user);

            }
            return users; // user does not exist

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void saveUserInfo(HashMap user, String username, String accountType) {
         // If my select statement returns null, then insert a new user entry
        //If it dosen't return null then update the existing user entry
        if(getUser(username,defaultAccount) == null) {
            try {
                // Step 1


                String query = "Insert into " + personalInfo + " Values (?,?,?,?) " +
                        "Where username = " + username;
                PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(query);

                if(statement == null){
                    System.out.println("connection must have closed or Insert query didn't work");
                }


                // Set the username filter value (ie the ?)
                statement.setString(1,  String.valueOf(user.get("username")));
                statement.setString(2,  String.valueOf(user.get("password")));
                statement.setString(3,  String.valueOf(user.get("name")));
                statement.setString(4,  String.valueOf(user.get("rank")));

                statement.execute();

                 query = "Insert into " + accountInfo + " Values (?,?,?,?,?) "+
                         "join on personalInfo.id = account_Info.owner_id "+
                         "Where username =" + username+ "and account_type = "+ accountType;
                statement = ConnectionManager.getConnection().prepareStatement(query);

                if(statement == null){
                    System.out.println("connection must have closed or Insert query didn't work");
                }

                statement.setString(1,  String.valueOf(user.get("accountType")));
                statement.setString(2,  String.valueOf(user.get("accountStatus")));
                statement.setString(3,  String.valueOf(user.get("activeStatus")));
                statement.setString(4,  String.valueOf(user.get("owners")));
                statement.setString(5,  String.valueOf(user.get("balance")));


                statement.execute();


            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            try {
                // Step 1


                String query = "Update personal_Info  SET (" +
                        "username = ?," +
                        "password = ?," +
                        "name =?," +
                        "rank =?) "+
                        "Where username = " + username;
                PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(query);
                if(statement == null){
                    System.out.println("connection must have closed or Update query didn't work");
                }
                // Set the username filter value (ie the ?)
                statement.setString(1,  String.valueOf(user.get("username")));
                statement.setString(2,  String.valueOf(user.get("password")));
                statement.setString(3,  String.valueOf(user.get("name")));
                statement.setString(4,  String.valueOf(user.get("rank")));
                statement.execute();


                query = "Update account_Info  SET (" +
                        "account_type = ?," +
                        "account_status = ?," +
                        "active_status = ?," +
                        "owners = ?," +
                        "balance = ?) "+
                        "join on personal_Info.id = account_Info.owner_id "+
                        "Where username =" + username + "and account_type = " + accountType;
                statement = ConnectionManager.getConnection().prepareStatement(query);

                if(statement == null){
                    System.out.println("connection must have closed or Update query didn't work");
                }

                statement.setString(1, String.valueOf(user.get("accountType")));
                statement.setString(2,  String.valueOf(user.get("accountStatus")));
                statement.setString(3,  String.valueOf(user.get("activeStatus")));
                statement.setString(4,  String.valueOf(user.get("owners")));
                statement.setString(5,  String.valueOf(user.get("balance")));
                statement.execute();




            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
       }

}
