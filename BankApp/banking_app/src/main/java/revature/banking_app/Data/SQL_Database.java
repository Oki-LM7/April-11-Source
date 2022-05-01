package revature.banking_app.Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class SQL_Database implements  iDatabase {

    private Connection conn = ConnectionManager.getConnection();

    @Override
    public HashMap<String,Object> getUser(String username, String accountType) {


        return getAllUsers().get(username + accountType);


    }

    @Override
    public HashMap<String, HashMap<String,Object>> getAllUsers() {

        try {
            // Step 1
            String query = "SELECT * FROM " + personalInfo+ " JOIN " + accountInfo +
                    " ON personal_info.id = " +
                    " account_info.owner_id";
            Statement statement = conn.createStatement();

            // Set the username filter value (ie the ?)


            ResultSet rs = statement.executeQuery(query);
            if(rs == null){
                System.out.println("connection must have closed or  select query didn't work");
            }

            HashMap<String, HashMap<String,Object>> users =
                    new HashMap<String, HashMap<String,Object>>();

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
            return users;

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void saveUserInfo(HashMap<String,Object> user, String username, String accountType) {
         // If my select statement returns null, then insert a new user entry
        //If it dosen't return null then update the existing user entry
        // a duplicate username cannot be allowed
        if(getUser(username,defaultAccount) == null) {
            try {
                // Step 1


                String personalInfoQuery = "Insert into " + personalInfo + "(username,password,name,rank)" + " Values (?,?,?,?) " ;

                PreparedStatement personalInfoStatement = ConnectionManager.getConnection().prepareStatement(personalInfoQuery);

                if(personalInfoStatement == null){
                    System.out.println("connection must have closed or Insert query didn't work");
                }


                // Set the username filter value (ie the ?)
                personalInfoStatement.setString(1, (String) user.get("username"));
                personalInfoStatement.setInt(2, (Integer) user.get("password"));
                personalInfoStatement.setString(3, (String) user.get("name"));
                personalInfoStatement.setString(4, (String) user.get("rank"));

                personalInfoStatement.execute();





            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {


                // first get owner id from personal_info, then insert into account info and make sure ownerid = personalinfo.id
                //sql needs quotes around where searches


                String idQuery  = "Select * from " + personalInfo+ " Where username = " + "'"+ username + "'" ;
                Statement idStatement = conn.createStatement();
                ResultSet rs = idStatement.executeQuery(idQuery);

                int ownerID = 0;
                while (rs.next()) {

                     ownerID = rs.getInt("id");


                }
                String accountInfoQuery = "Insert into " + accountInfo + "( account_type,account_status,active_status,owners,balance,owner_id)" +
                        " Values (?,?,?,?,?,?) ";
                PreparedStatement accountInfoStatement = ConnectionManager.getConnection().prepareStatement(accountInfoQuery);

                if(accountInfoStatement == null){
                    System.out.println("connection must have closed or Insert query didn't work");
                }

                accountInfoStatement.setString(1, (String) user.get("accountType"));
                accountInfoStatement.setString(2, (String) user.get("accountStatus"));
                accountInfoStatement.setString(3, (String) user.get("activeStatus"));
                accountInfoStatement.setString(4, (String) user.get("owners"));
                accountInfoStatement.setInt(5, (Integer) user.get("balance"));
                accountInfoStatement.setInt(6, ownerID);


                accountInfoStatement.execute();


            }catch (SQLException e){
                e.printStackTrace();
            }
        }else{
            try {
                // Step 1 update personal info


                String personalInfoQuery = "Update " + personalInfo + "  SET (" +
                        "username = ?," +
                        "password = ?," +
                        "name =?," +
                        "rank =?) "+
                        "Where username = " + username;
                PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(personalInfoQuery);
                if(statement == null){
                    System.out.println("connection must have closed or Update query didn't work");
                }
                // Set the username filter value (ie the ?)
                statement.setString(1, (String) user.get("username"));
                statement.setInt(2, (Integer) user.get("password"));
                statement.setString(3, (String) user.get("name"));
                statement.setString(4, (String) user.get("rank"));
                statement.execute();





            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {

               String accountInfoQuery = "Update " + accountInfo+ "  SET (" +
                        "account_type = ?," +
                        "account_status = ?," +
                        "active_status = ?," +
                        "owners = ?," +
                        "balance = ?) "+
                        "join " + personalInfo + " on personal_info.id = account_info.owner_id "+
                        "Where username = " + username + " and account_type = " + accountType;
                PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(accountInfoQuery);

                if(statement == null){
                    System.out.println("connection must have closed or Update query didn't work");
                }

                statement.setString(1, (String) user.get("accountType"));
                statement.setString(2, (String) user.get("accountStatus"));
                statement.setString(3, (String) user.get("activeStatus"));
                statement.setString(4, (String) user.get("owners"));
                statement.setInt(5, (Integer) user.get("balance"));
                statement.execute();



            }catch (SQLException e){
                e.printStackTrace();
            }
        }
       }

}
