import java.util.*;

public class ATM {

	Account account;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account = new Account("John Applesmith", 99999910.00, 123456);
		ATM atm = new ATM(account);
		System.out.println(atm.getAccountBalance());
	}
	
	public ATM(Account account) {
		this.account = account;
	}
	
	public String getAccountBalance() {
		return account.accountName + ": $" + Double.toString(account.accountBalance);
	}

}
