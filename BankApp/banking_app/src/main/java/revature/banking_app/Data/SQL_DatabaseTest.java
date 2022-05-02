package revature.banking_app.Data;

import static org.junit.jupiter.api.Assertions.*;

class SQL_DatabaseTest {
     SQL_Database sql = new SQL_Database();
    @org.junit.jupiter.api.Test
    void getUser() {
        long password = 5;
        assertEquals( password , sql.getUser("andrew",iDatabase.checkings).get("password") );
    }

    @org.junit.jupiter.api.Test
    void getAllUsers() {
        assertNotNull(sql.getAllUsers());
    }

    @org.junit.jupiter.api.Test
    void saveUserInfo() {

    }

    @org.junit.jupiter.api.Test
    void saveAccountInfo() {
    }
}