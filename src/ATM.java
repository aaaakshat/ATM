import java.util.*;

public class ATM {

	Account client;
	
	
	public ATM(String accountName, Double accountBalance, int accountPassword) {
		this.client = new Account(accountName, accountBalance, accountPassword);
	}
	
	public String getAccountBalance() {
		return client.accountName + ": $" + Double.toString(client.accountBalance);
	}

	public void accountDeposit(Double depositValue) {
		client.accountBalance = client.accountBalance + depositValue;
		client.newTransactionEntry("DEPOSIT:", depositValue);
	}
	
	public String accountWithdrawal(Double withdrawalValue) {
		if (withdrawalValue <= client.accountBalance) {
			client.accountBalance = client.accountBalance - withdrawalValue;
			client.newTransactionEntry("WITHDRAWAL:", withdrawalValue);
			return "success";
		} else {
			return "failure";
		}
	}
	
	public String accountHistory() {
		return client.transactions.getHistory();
	}
	
	public String accountChangePin(int oldPassword, int newPassword) {
		if (client.testAccountPassword(oldPassword)) {
			client.setPassword(oldPassword, newPassword);
			return "success";
		} else {
			return "failure";
		}
	}
	
}
