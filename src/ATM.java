import java.util.*;

public class ATM {

	Account client;
	
	
	public ATM(String accountName, Double accountBalance, int accountPassword) {
		this.client = new Account(accountName, accountBalance, accountPassword);
	}
	
	public String getAccountBalance() {
		return client.accountName + ": $" + Double.toString(client.accountBalance);
	}

	public void accountDeposit() {
		
	}
	
	public void accountWithdrawal() {
		
	}
	
	public void accountHistory() {
		
	}
	
	public void accountChangePin() {
		
	}
	
	public void endTransaction() {
		
	}
}
