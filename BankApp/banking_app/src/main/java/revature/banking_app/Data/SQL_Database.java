package revature.banking_app.Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class SQL_Database implements  iDatabase {

    private Connection conn = ConnectionManager.getConnection();

    @Override
    public HashMap<String,Object> getUser(String username, String accountType) {

        // only would return null if their is personal info but not account info
        if(getAllUsers().get(username + accountType) == null){
            System.out.println(" Account info is not saved yet. ");

        }
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
                user.put("password", rs.getLong("password"));
                user.put("name", rs.getString("name"));
                user.put("rank", rs.getString("rank"));
                user.put("id", rs.getLong("id"));
                user.put("ownerID", rs.getLong("owner_id"));
                user.put("accountType", rs.getString("account_type"));
                user.put("accountStatus", rs.getString("account_status"));
                user.put("activeStatus", rs.getString("active_status"));
                user.put("owners", rs.getString("owners"));
                user.put("balance", rs.getLong("balance"));

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
    public void saveUserInfo(HashMap<String,Object> user) {
         // If my select statement returns null, then insert a new user entry
        //If it dosen't return null then update the existing user entry
        // a duplicate username cannot be allowed
        String username = (String )user.get("username");
        String accountType = (String) user.get("accountType");
        if(getUser( username, accountType) == null) {

            System.out.println(" either username: "+ (String) user.get("username") + " or "+
                    "accountType: " + (String) user.get("accountType") +" does not exist" +
                    " if the username is available then we will try to insert this entry" );


            try {
                // insert if doesn't exist

                // so if the username or password already exist then I stop the insert

                String userQuery  = "Select * from " + personalInfo+ " Where username = " +
                        "'"+ username + "'"  + " or password = " +
                        (Long)user.get("password");
                Statement userStatement = conn.createStatement();
                ResultSet rs = userStatement.executeQuery(userQuery);

                String comparisonUserName = "";
                long comparisonPassword = -1;
                while (rs.next()) {

                    comparisonUserName = rs.getString("username");
                    comparisonPassword = rs.getLong("password");


                }

                // if comparison user = "", then the username does not exist so
                // we can insert. If the password = -100 , then the password
                // cannot exist because all passwords have to be positive
                if(comparisonPassword == -1 || comparisonUserName.equals("")){


                String personalInfoQuery = "Insert into " + personalInfo + "(username,password,name,rank)" + " Values (?,?,?,?) " ;

                PreparedStatement personalInfoStatement = ConnectionManager.getConnection().prepareStatement(personalInfoQuery);

                if(personalInfoStatement == null){
                    System.out.println("connection must have closed or Insert query didn't work");
                }


                // Set the username filter value (ie the ?)
                personalInfoStatement.setString(1, (String) user.get("username"));
                personalInfoStatement.setLong(2, (Long) user.get("password"));
                personalInfoStatement.setString(3, (String) user.get("name"));
                personalInfoStatement.setString(4, (String) user.get("rank"));

                personalInfoStatement.execute();}
                else{
                    System.out.println("Either the username: " + username + " or password: "
                    + (Long)user.get("password") + " already exists" );
                }





            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }else{
            try {
                // Step 1 update personal info if the username does exist
                //SQL needs single quotes for where claus text


                String personalInfoQuery = "Update " + personalInfo + "  SET " +
                        "username = ?," +
                        "password = ?," +
                        "name = ?," +
                        "rank = ?  "+
                        "Where username = " + "'" + username+ "'";
                PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(personalInfoQuery);
                if(statement == null){
                    System.out.println("connection must have closed or Update query didn't work");
                }
                // Set the username filter value (ie the ?)
                statement.setString(1, (String) user.get("username"));
                statement.setLong(2, (Long) user.get("password"));
                statement.setString(3, (String) user.get("name"));
                statement.setString(4, (String) user.get("rank"));
                statement.execute();





            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
       }

    @Override
    public void saveAccountInfo(HashMap<String, Object> user) {

        // if both the username and account type exist, then update. Otherwise insert if the username
        // exist. Will not insert if the ownerID is wrong
        //

        String username = (String) user.get("username");
        String accountType = (String) user.get("accountType");

        if( getUser(username,accountType)  != null) {

            // If this username exists then the id must exist
            long ownerID = (Long) getUser(username,accountType).get("id")  ;
            try {
           //update
                String accountInfoQuery = "Update " + accountInfo + "  SET " +
                        "account_type = ?," +
                        "account_status = ?," +
                        "active_status = ?," +
                        "owners = ?," +
                        "balance = ? " +
                        "Where owner_id = " + ownerID  + " and account_type = " + "'" + accountType +"'";
                PreparedStatement statement =
                        ConnectionManager.getConnection().prepareStatement(accountInfoQuery);

                if (statement == null) {
                    System.out.println("connection must have closed or Update query didn't work");
                }

                statement.setString(1, (String) user.get("accountType"));
                statement.setString(2, (String) user.get("accountStatus"));
                statement.setString(3, (String) user.get("activeStatus"));
                statement.setString(4, (String) user.get("owners"));
                statement.setLong(5, (Long) user.get("balance"));
                statement.execute();


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println(" either username:"+ (String) user.get("username") + " or "+
                    "accountType: " + (String) user.get("accountType") + " does not exist" +
                    " if you have a username with us we will insert this entry" );


                 //insert


            try {


                // first get owner id from personal_info, then insert into account info and make sure ownerid = personalinfo.id
                //sql needs quotes around where searches
                // if there was no ownerID, then they have no personal info account


                String idQuery  = "Select * from " + personalInfo+ " Where username = " + "'"+ username + "'" ;
                Statement idStatement = conn.createStatement();
                ResultSet rs = idStatement.executeQuery(idQuery);

                long newOwnerID = 0;
                while (rs.next()) {

                    newOwnerID = rs.getLong("id");


                }
                // The id is 0 if the user never existed
                if(newOwnerID == 0){
                    System.out.println("only a user with personal info can create an account");
                }else {
                    String accountInfoQuery = "Insert into " + accountInfo + "( account_type,account_status,active_status,owners,balance,owner_id)" +
                            " Values (?,?,?,?,?,?) ";
                    PreparedStatement accountInfoStatement = ConnectionManager.getConnection().prepareStatement(accountInfoQuery);

                    if (accountInfoStatement == null) {
                        System.out.println("connection must have closed or Insert query didn't work");
                    }

                    accountInfoStatement.setString(1, (String) user.get("accountType"));
                    accountInfoStatement.setString(2, (String) user.get("accountStatus"));
                    accountInfoStatement.setString(3, (String) user.get("activeStatus"));
                    accountInfoStatement.setString(4, (String) user.get("owners"));
                    accountInfoStatement.setLong(5, (Long) user.get("balance"));
                    accountInfoStatement.setLong(6, newOwnerID);


                    accountInfoStatement.execute();
                }


            }catch (SQLException e){
                e.printStackTrace();
            }

        }
    }

}
