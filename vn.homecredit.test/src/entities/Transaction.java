package entities;

public class Transaction {
	private String transactionId;
	private String accountNo;
	private Integer amountCredited;
	private String typeOfTransaction;
	private String description;
	private String currentBalance;

	public Transaction() {}

	public Transaction(String transactionId, String accountNo, Integer amountCredited, String typeOfTransaction,
			String description, String currentBalance) {
		super();
		this.transactionId = transactionId;
		this.accountNo = accountNo;
		this.amountCredited = amountCredited;
		this.typeOfTransaction = typeOfTransaction;
		this.description = description;
		this.currentBalance = currentBalance;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public Integer getAmountCredited() {
		return amountCredited;
	}

	public void setAmountCredited(Integer amountCredited) {
		this.amountCredited = amountCredited;
	}

	public String getTypeOfTransaction() {
		return typeOfTransaction;
	}

	public void setTypeOfTransaction(String typeOfTransaction) {
		this.typeOfTransaction = typeOfTransaction;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(String currentBalance) {
		this.currentBalance = currentBalance;
	}
	
	

}
