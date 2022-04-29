package revature.banking_app.Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class SQL_Database implements  iDatabase {


    @Override
    public HashMap getUser(String username, String accountType) {


        return getAllUsers().get(username + accountType);


    }

    @Override
    public HashMap<String, HashMap> getAllUsers() {

        try {
            // Step 1
            String query = "SELECT * FROM users JOIN ON users.id = accounts.id";
            Statement statement = ConnectionManager.getConnection().Statement(query);

            // Set the username filter value (ie the ?)


            ResultSet rs = statement.executeQuery(query);
            HashMap users = new HashMap<>();

            // Step 2
            while (rs.next()) {
                // user exists
                HashMap<String, Object> user = new HashMap<>();
                user.put("username", rs.getString("username")); // also just the username variable
                user.put("password", rs.getInt("password"));
                user.put("firstName", rs.getString("first_name"));
                user.put("lastname", rs.getString("last_name"));
                user.put("rank", rs.getString("rank"));
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
    public void saveUserInfo(HashMap user, String username, String infoType) {
        try {
            // Step 1
            String query = "Insert into " + infoType + " Values (?,?,?,?)";
            PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(query);

            // Set the username filter value (ie the ?)
            statement.setString(1, user.get("username").toString());
            statement.setString(2, user.get("username").toString());
            statement.setString(3, user.get("username").toString());
            statement.setString(4, user.get("username").toString());
            statement.setString(5, user.get("username").toString());
            statement.setString(6, user.get("username").toString());
            statement.setString(7, user.get("username").toString());
            statement.setString(8, user.get("username").toString());
            statement.setString(9, user.get("username").toString());
            statement.setString(10, user.get("username").toString());




        }  catch(SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

       }

}
