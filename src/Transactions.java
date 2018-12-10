
public class Transactions {

	String transactionMsg;
	Double transactionAmount;
	Double newAccountBalance;
	String history = "";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public void addTransactionObj(String transactionMsg, Double transactionAmount, Double newAccountBalance) {
		this.transactionMsg = transactionMsg;
		this.transactionAmount = transactionAmount;
		this.newAccountBalance = newAccountBalance;
		String history = transactionMsg + "     $" +Double.toString(transactionAmount) + "     NEW BAL. $" + Double.toString(newAccountBalance) + "\n";
		this.history = this.history + history;
	}
	
	public String getHistory() {
		return this.history ;
	}
}
