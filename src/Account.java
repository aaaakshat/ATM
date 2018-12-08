
public class Account {
	
	public String accountName;
	public Double accountBalance;
	private int accountPassword;
	Transactions transactions = new Transactions();
	
	public Account (String accountName, Double accountBalance, int accountPassword) {
		this.accountName = accountName;
		this.accountBalance = accountBalance;
		this.accountPassword = accountPassword;
	}
	
	private int getAccountPassword() {
		return accountPassword; 
	}
	
	public Boolean testAccountPassword(int input) {
		if (input == getAccountPassword()) {
			return true;
		}
		return false;
	}

	public void newTransactionEntry(String transactionMsg, Double transactionAmount, Double newAccountBalance) {
		transactions.addTransactionObj(transactionMsg, transactionAmount, newAccountBalance);
	}
	
}
