package revature.banking_app.ui;

import java.util.Scanner;

public class ScannerInput {

	
	
	
	public double promptforDouble(String message) {
		Scanner input = new Scanner(System.in);
		System.out.println (message);
		double d = input.nextDouble();
		input.close();
		return d;
	}
	
	
	
	public int promptforInt(String message) {

		System.out.println(message);
		Scanner input = new Scanner(System.in);

			if(!input.hasNextInt()){
				return -1;
			}

            int num = input.nextInt();
		return num;
	}
	
	public String promptforString(String message){

		System.out.println (message);
		Scanner input = new Scanner(System.in);
		String s  = input.next();



		return s;
	}
}
