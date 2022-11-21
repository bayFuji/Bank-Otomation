package bankOtomation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {

	Scanner scan = new Scanner(System.in);

	private static int entID,ID, userCount = 0;
	private int userID;
	private String entUserName, userName, entName, entOp, entIDs = "";
	private double userBalance;
	private boolean control1 = true, control2 = true, control3 = true, control4=true, control5=true;

	public User(String userName, double userBalance, int userID) {
		// users = new ArrayList<User>();
		this.control1 = control1;
		this.entName = entName;
		this.entID = entID;
		this.userID = userID;
		this.userBalance = userBalance;
		this.userName = userName;
		this.entUserName = entUserName;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public double getUserBalance() {
		return userBalance;
	}

	public void setUserBalance(double userBalance) {
		this.userBalance = userBalance;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void userLog() {

		userLogMenu();

	}

	public void userLogMenu() {

		userSearch(entName);
	}

	public void userSearch(String entName) {

		boolean control1 = true;
		boolean yokmu = true;

		do {
			if (DataBase.users.size() == 0) {
				System.out.println("!! Database is empty !!");
				break;
			}

			else {
				yokmu = true;
				System.out.print("Please enter your name: ");
				this.entName = scan.nextLine();

				if(this.entName.equalsIgnoreCase("admin")) {
					yokmu=false;
					System.out.println();
					System.out.println("List of bank users:");
					System.out.println("==================================================");
					for (int i =0; i<Bank.users.size();i++) {
						System.out.print("  "+(i+1)+"- " +Bank.users.get(i).getUserName()+"  \t= TCB-"+Bank.users.get(i).getUserID()+" = ");
						System.out.println(Bank.users.get(i).getUserBalance()+" TL");
					}
					System.out.println("==================================================");
					System.out.println("");
				}
				
				for (int i = 0; i < DataBase.users.size(); i++) {

					if (this.entName.equalsIgnoreCase(Bank.users.get(i).userName) && !this.entName.equalsIgnoreCase("exit")) {
						yokmu = false;
						control1 = false;
						control2 = false;						
						userIDControl(i);
						break;
					}

					else if (this.entName.equalsIgnoreCase("exit")) {
						System.out.println();
						control1 = false;
						control2 = false;
						break;
					}

				}
				if (yokmu && !this.entName.equalsIgnoreCase("exit")) {
					System.out.println();
					System.out.println("\t!! User not found !!");
					System.out.println();

				}
			}

		} while (control1 || control2);
	}

	public void userIDControl(int i) {

		System.out.print("Please enter your User ID '" + Bank.users.get(i).userName + "': TCB-");
		String userIDs = Bank.users.get(i).getUserID() + "";
		// control System.out.println(userIDs);
		do {
			entIDs = scan.nextLine();
			// entIDs = entID+"";
			if (this.entIDs.equals(userIDs) && !this.entIDs.equalsIgnoreCase("exit")) {
				control1 = false;
				control2 = false;
				System.out.println();
				System.out.println("\rWelcome '" + this.entName.toLowerCase() + "'.");
				userOp(i);
			} else if (!this.entIDs.equals(userIDs) && !this.entIDs.equalsIgnoreCase("exit")) {
				control1 = false;
				control2 = true;
				System.out.println();
				System.out.println("\t!! Your User ID is wrong !!");
				System.out.println();
				System.out.print("Please enter your User ID '"+Bank.users.get(i).userName+"': TCB-");
			} else if (this.entIDs.equalsIgnoreCase("exit")) {
				System.out.println();
				control2 = false;
				control1 = false;
			}
		} while (control2);
	}

	public void userOp(int i) {

		do {
			boolean control3 = true;
			
			System.out.println("==========================================");
			System.out.println("||  Name.....: " + entName.toLowerCase());
			System.out.println("||  ID.......: TCB-" + Bank.users.get(i).getUserID());
			System.out.println("||  Balance..: " + Bank.users.get(i).getUserBalance());
			System.out.println("==========================================");
			System.out.println(" 1 - Deposit Money");
			System.out.println(" 2 - Withdraw Money");
			System.out.println(" 3 - Money Transfer");
			System.out.println(" 4 - Main Menu");
			System.out.println("==========================================");
			System.out.print("Please select your operation: ");
			
			int entOp = scan.nextInt();
			System.out.println();

			if (entOp == 1) {
				System.out.println();
				System.out.print("Enter the amount of money you want to deposit: ");
				double entDep = scan.nextDouble();

				while (entDep < 0.0) {
					System.out.println();
					System.out.println("\t!! You can only enter a positive value !!");
					System.out.println();
					System.out.print("Enter the amount of money you want to deposit: ");
					entDep = scan.nextDouble();
				}
				while (entDep > 1000000) {
					System.out.println();
					System.out.println("\t!! You can enter a maximum of '6' digit number !!");
					System.out.println();
					System.out.print("Enter the amount of money you want to deposit: ");
					entDep = scan.nextDouble();
				}
				System.out.println();
				System.out.println(" ===> "+entDep+"TL has been withdrawn from your account. <===");
				Bank.users.get(i).setUserBalance(Bank.users.get(i).getUserBalance() + entDep);
				System.out.println();
			}

			else if (entOp == 2) {
				System.out.println();
				System.out.print("Enter the amount of money you want to withdraw: ");
				double entWit = scan.nextDouble();

				while (entWit < 0.0) {
					System.out.println();
					System.out.println("\t!! You can only enter a positive value !!");
					System.out.println();
					System.out.print("Enter the amount of money you want to withdraw: ");
					entWit = scan.nextDouble();
				}
				while (entWit > 1000000) {
					System.out.println();
					System.out.println("\t!! You can enter a maximum of '6' digit number !!");
					System.out.println();
					System.out.print("Enter the amount of money you want to withdraw: ");
					entWit = scan.nextDouble();
				}
				
				while (entWit > Bank.users.get(i).getUserBalance()) {
					System.out.println("\t!! You don't have enough money to withdraw !!");
					System.out.print("Enter the amount of money you want to withdraw: ");
					entWit = scan.nextDouble();
				}
				System.out.println();
				System.out.println(" ===> "+entWit+"TL has been withdrawn from your account. <===");
				Bank.users.get(i).setUserBalance(Bank.users.get(i).getUserBalance() - entWit);
				System.out.println();
			}

			else if (entOp == 3) {
				System.out.println();
				moneyTransfer(i);
			}

			else if (entOp == 4) {
				control3 = false;
				System.out.println();
				break;
			}

		} while (control3);
	}

	public void moneyTransfer(int i) {

		for (int a = 0; a < Bank.users.size(); a++) {

			System.out.print("  " + (a + 1) + " => " + Bank.users.get(a).getUserName());
			System.out.println();
		}
		System.out.print("Select the account you want to transfer money to: ");
		
		int entAcc = scan.nextInt();
	
		while (entAcc>Bank.users.size()) {
			System.out.println("\r!! Please choose one of the given values !!");
			System.out.println();
			System.out.print("Select the account you want to transfer money to: ");
			entAcc = scan.nextInt();
			
		}
			
			
		entAcc -= 1;

		System.out.println();
		
		while (entName.equals(Bank.users.get(entAcc).getUserName())) {
			System.out.println("\t!! You can't transfer money to yourself !!");
			System.out.println();
			System.out.print("Please select another account:");
			
			entAcc = scan.nextInt();
			entAcc -= 1;
		}
		System.out.println();
		System.out.print("Enter the amount of money you want to transfer to '" + Bank.users.get(entAcc).getUserName() + "' : ");
		double entTra = scan.nextDouble();

		while (entTra > Bank.users.get(i).getUserBalance()) {
			System.out.println("\r!! You do not have enough funds in your account for this transaction !!");
			System.out.println();
			System.out.print("Enter the amount of money you want to transfer to '" + Bank.users.get(entAcc).getUserName() + "' : ");
			entTra = scan.nextDouble();
			System.out.println("");
		}

		if (entTra <= Bank.users.get(i).getUserBalance()) {
			Bank.users.get(entAcc).setUserBalance(Bank.users.get(entAcc).getUserBalance() + entTra);
			Bank.users.get(i).setUserBalance(Bank.users.get(i).getUserBalance() - entTra);
		
			System.out.println();
			System.out.println(" ===> "+entTra + "TL has been transfered to '" + Bank.users.get(entAcc).getUserName() + "'. <===");
			System.out.println();
		}

	}

	public void userReg() {

		userRegMenu();
	
		DataBase.userAdd(this);
		
		
		if(!control5 && this.entUserName.equals("exit")) {
			Bank.users.remove(this);
		}
		control4=true;
	}

	public void userRegMenu() {
		
		do {
			boolean controlSame = true;
			control4=true;
			System.out.print("Hello new user.\rYour first name: ");
			String entFirstName = scan.nextLine();
			System.out.print("Your second name: ");
			String entSecondName = scan.nextLine();
	
			this.entUserName = entFirstName+" "+entSecondName;
			
			for(int k=0; k<Bank.users.size(); k++) {
				if(Bank.users.get(k).userName.equalsIgnoreCase(this.entUserName)) {
					System.out.println("\r!! There is an account that already taked this name !!");
					System.out.println();
					controlSame= false;
					control4 = true;					
					break;
				}
			}
			
			if(entUserName.equals("exit")&&controlSame) {
				System.out.println();				
				control4= false;
				control5= false;
				break;
			}
				
			else if (!this.entUserName.equals("exit") && control4 && controlSame) {		
				this.userName = this.entUserName;
				createUserID();
				System.out.println();
				System.out.println("Your account has been created '" + this.userName + "'. Your 'User ID' is: TCB-" + userID);
				System.out.println();
				control4= false;
			}
		
		}while(control4);
			
		
	}

	public void createUserID() {

		userCount++;
		this.userID = 1002 + userCount;
	}
	
	public void admin() {
		
		User userAdmin1 = new User("Eren Memişoğlu",1000.0,1001);
		Bank.users.add(userAdmin1);
		User userAdmin2 = new User("Engin Büyükdigan",500.0,1002);
		Bank.users.add(userAdmin2);

	}

}
