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
		Scanner input = new Scanner(System.in);
		System.out.println (message);
		int num = input.nextInt();
		input.close();
		return num;
	}
	
	public String promptforString(String message){
		Scanner input = new Scanner(System.in);
		System.out.println (message);
		String s = input.next();
		input.close();
		return s;
	}
}
