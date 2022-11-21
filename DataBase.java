package bankOtomation;

public class DataBase extends Bank {

	
	private static int ID;
	private int userID;
	private String userName;
	private double userBalance;
	
	
	public DataBase(String userName, double userBalance, int userID) {
		this.userID = userID;
		this.userBalance = userBalance;
		this.userName = userName;
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
	
	public static void userAdd(User user) {
		
		users.add(user);
		
	}

	
}
