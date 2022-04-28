package revature.banking_app.Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class SQL_Database implements  iDatabase {


    @Override
    public HashMap getUser(String username,String accountType) {


       return getAllUsers().get(username+accountType);


    }

    @Override
    public HashMap<String, HashMap> getAllUsers() {

        try {
            // Step 1
            String query = "SELECT * FROM users JOIN ON users.id = accounts.id";
            Statement statement = ConnectionManager.getConnection().Statement(query);

            // Set the username filter value (ie the ?)


            ResultSet rs = statement.executeQuery(query);
            HashMap users  = new HashMap<>();

            // Step 2
            while (rs.next()) {
                // user exists
                HashMap<String, Object> user = new HashMap<>();
                user.put("username", rs.getString("username")); // also just the username variable
                user.put("password",  rs.getInt("password"));
                user.put("firstName", rs.getString("first_name"));
                user.put("lastname", rs.getString("last_name"));
                user.put("rank", rs.getString("rank"));
                user.put("accountType", rs.getString("account_Type"));
                user.put("owners", rs.getString("owners"));
                user.put("balance", rs.getInt("balance"));

                users.put(rs.getString("username")+rs.getString("account_Type"),user);

            }  return users; // user does not exist

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void saveUserInfo(HashMap user, String username, String infoType) {

    }
}
