package bankOtomation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bank {

	Boolean candanım = true;
	Scanner scan = new Scanner(System.in);

	static ArrayList<User> users = new ArrayList<User>();

	public void start() {

		while (true) {
			selectOperation();
		}
	}

	public void selectOperation() {

		System.out.println("====================");
		System.out.println(" 1- Enter Account\r 2- Create Account");
		System.out.println("====================");

		System.out.print("Enter operation: ");
		int select = scan.nextInt();
		System.out.println();
		
		User user = new User(null, 0, 1000);

		while(candanım) {
		user.admin();	
		candanım=false;
		}
		
		if (select == 1) {
			user.userLog();
		} else if (select == 2) {
			user.userReg();
		} else {
			System.out.println("\r!! Select a valid choice !!");
			System.out.println();
			selectOperation();
		}

	}

}
