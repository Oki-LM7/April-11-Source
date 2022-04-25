package revature.college;

import java.sql.Connection;
import java.sql.DriverManager;

//this is the class where I will make a connection to 
//the database
public class ConnectionManager {
	
	
	private static Connection connection;
	
	//connection String format is httpprotocal:sqltype://
	//serverURL:portNumber/databaseName
	//for postgresql we use port 5432
	//this is our connection data
	private static String connectionString =""
			+ "jdbc:postgresql://otto.db.elephantsql.com:"
			+ "5432/xjkkgqyh",
			username = "xjkkgqyh",
			password = "4fNXLkK9Zl2M_3is-PZT24_52SgzU0uy";
	        
   public static Connection getConnection() {
	   
	   //this will not compile without being in a try/catch
	   //block
	  try {
		  if(connection == null || connection.isClosed()) {
			  //this ensures that the driver class is loaded
			  //before we try to use it
			  //it will fail without the driver class.
			  // it needs the maven dependency added in the
			  //pom.xml file
			  Class.forName("org.postgresql.Driver");
			  //use the DriverManager to make sure there is a 
			  //suitable driver to make the connection string
			  //work. Calls the postgres driver
			   //Set up the output/input io stream to pass
			  //data between the app and the database
			 
			  connection = DriverManager.getConnection(
					  connectionString,username,password);
		  }	return connection;
	  }catch(Exception e) {
	
	  }	  return null;
	   
	   
	   
	   
	
	   
   }
}
