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
            String query = "SELECT * FROM users JOIN ON users.id = accounts.id";
            Statement statement = conn.createStatement();

            // Set the username filter value (ie the ?)


            ResultSet rs = statement.executeQuery(query);
            HashMap users = new HashMap<>();

            // Step 2
            while (rs.next()) {
                // user exists
                HashMap<String, Object> user = new HashMap<>();
                user.put("username", rs.getString("username")); // also just the username variable
                user.put("password", rs.getInt("password"));
                user.put("name", rs.getString("name"));;
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
    public void saveUserInfo(HashMap user, String username) {

        if(getUser(username,"personalInfo") == null) {
            try {
                // Step 1


                String query = "Insert into " + personalInfo + " Values (?,?,?,?) " +
                        "Where username =" + username;
                PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(query);

                // Set the username filter value (ie the ?)
                statement.setString(1, user.get("username").toString());
                statement.setString(2, user.get("password").toString());
                statement.setString(3, user.get("name").toString());
                statement.setString(4, user.get("rank").toString());

                statement.execute();

                 query = "Insert into " + accountInfo + " Values (?,?,?,?,?)"+
                         "Where username =" + username;
                statement = ConnectionManager.getConnection().prepareStatement(query);

                statement.setString(1, user.get("accountType").toString());
                statement.setString(2, user.get("accountStatus").toString());
                statement.setString(3, user.get("activeStatus").toString());
                statement.setString(4, user.get("owners").toString());
                statement.setString(5, user.get("balance").toString());


                statement.execute();


            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }else{
            try {
                // Step 1


                String query = "Update personalInfo  SET (?,?,?,?)"+
                        "Where username =" + username;
                PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(query);

                // Set the username filter value (ie the ?)
                statement.setString(1, user.get("username").toString());
                statement.setString(2, user.get("password").toString());
                statement.setString(3, user.get("name").toString());
                statement.setString(4, user.get("rank").toString());
                statement.execute();


                query = "Update accountInfo  SET (?,?,?,?,?)"+
                        "Where username =" + username;
                statement = ConnectionManager.getConnection().prepareStatement(query);

                statement.setString(1, user.get("accountType").toString());
                statement.setString(2, user.get("accountStatus").toString());
                statement.setString(3, user.get("activeStatus").toString());
                statement.setString(4, user.get("owners").toString());
                statement.setString(5, user.get("balance").toString());
                statement.execute();




            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
       }

}
