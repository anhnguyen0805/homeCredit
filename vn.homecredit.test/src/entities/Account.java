package entities;

import java.util.Date;

public class Account {
	private String accountId;
	private String accountType;
	private Date dateOfOpening;
	private long currentAmount;
	
	public Account() {}

	public Account(String accountId, String accountType, Date dateOfOpening, long currentAmount) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.dateOfOpening = dateOfOpening;
		this.currentAmount = currentAmount;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public Date getDateOfOpening() {
		return dateOfOpening;
	}

	public void setDateOfOpening(Date dateOfOpening) {
		this.dateOfOpening = dateOfOpening;
	}

	public long getCurrentAmount() {
		return currentAmount;
	}

	public void setCurrentAmount(long currentAmount) {
		this.currentAmount = currentAmount;
	}
}
