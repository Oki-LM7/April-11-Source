package revature.college;

import java.util.ArrayList;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//create an instance of the DAO so that we may call it
		//its methods
	StudentDAO studentDAO = new StudentDAO();
		
		//studentDAO.getAllStudents();
	//created an array list to store all our students from our
	//getAllStudents
	ArrayList<StudentModel> students = 
			studentDAO.getAllStudents();
	
	for(StudentModel i: students) {
		System.out.println(i);
	}
		

	}

}
