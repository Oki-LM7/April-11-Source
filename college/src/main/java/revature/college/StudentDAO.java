package revature.college;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class StudentDAO {
  
	//this create an instance of our getConnection() method
	// from the ConnectionManager
	
private static Connection conn = ConnectionManager.getConnection();

//this method returns all students
public static ArrayList<StudentModel> getAllStudents(){
	
	//create a statement that uses a connection to the 
	//database
	try {
		Statement statement = conn.createStatement();
		ResultSet rs = statement.executeQuery("SELECT *"
				+ " FROM Student");
		ArrayList<StudentModel> students = 
				new ArrayList<StudentModel>();
		//this loop runs so long as there is another row in 
		// our result set
		while(rs.next()) {
			
			//datatype name = rs.getDatatype("databaseColumnName")
			int id = rs.getInt("id");
			String firstName = rs.getString("firstName");
			String lastName = rs.getString("lastName");
			int age= rs.getInt("age");
			Date date = rs.getDate("birthday");
			String favColor = rs.getString("fav_color");
			
			// adds each new student to our student list
			students.add(new StudentModel(id,firstName, 
					lastName,age, date, favColor));
			
		}return students;
	}catch(SQLException e) {
		e.printStackTrace();
	}return null;
} 
   

   //this meth
    
public void addStudent(StudentModel)
	
}
