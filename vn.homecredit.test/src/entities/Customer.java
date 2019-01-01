package entities;

import java.util.Date;

public class Customer {
	private String customerId;
	private String customerName;
	private boolean isMale;
	private Date dateOfBirth;
	private String address;
	private String city;
	private String state;
	private Integer pin;
	private Integer mobileNum;
	private String email;
	private String password;
	private Account account;
	
	public Customer() {}
	
	public Customer(String customerId, String customerName, boolean isMale, Date dateOfBirth, String address, String city, String state,
			Integer pin, Integer mobileNum, String email, String password) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.isMale = isMale;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.mobileNum = mobileNum;
		this.email = email;
		this.password = password;
	}
	
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public boolean isMale() {
		return isMale;
	}
	public void setMale(boolean isMale) {
		this.isMale = isMale;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Integer getPin() {
		return pin;
	}
	public void setPin(Integer pin) {
		this.pin = pin;
	}
	public Integer getMobileNum() {
		return mobileNum;
	}
	public void setMobileNum(Integer mobileNum) {
		this.mobileNum = mobileNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
}
