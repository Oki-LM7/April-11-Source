package revature.banking_app.ui;

import java.util.Scanner;

public class ScannerInput {

	
	
	

	
	
	
	public int promptforInt(String message) {

		System.out.println(message);
		Scanner input = new Scanner(System.in);

			if(!input.hasNextInt()){
				return -1;
			}

		return input.nextInt();
	}
	
	public String promptforString(String message){

		System.out.println (message);
		Scanner input = new Scanner(System.in);


		return input.next();
	}
}
