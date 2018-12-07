
public class Account {
	
	private String accountName;
	private Double accountBalance;
	
	public Account (String accountName, Double accountBalance) {
		this.accountName = accountName;
		this.accountBalance = accountBalance;
	}
	
	private static int getAccountPassword() {
		return 123456; 
	}
	
	public static Boolean testAccountPassword(int input) {
		if (input == getAccountPassword()) {
			return true;
		}
		return false;
	}

	
}
;