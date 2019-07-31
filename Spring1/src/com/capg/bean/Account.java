package com.capg.bean;

public class Account {
	private String customerName;
	private long mobileNumber;
	private String emailId;
	private int accountBalance;
	public String getName() {
		return customerName;
	}
	public void setName(String name) {
		this.customerName = name;
	}
	public long getPhoneNumber() {
		return mobileNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.mobileNumber = phoneNumber;
	}
	public String getEmailid() {
		return emailId;
	}
	public void setEmailid(String emailid) {
		this.emailId = emailid;
	}
	public int getBalance() {
		return accountBalance;
	}
	public void setBalance(int balance) {
		this.accountBalance = balance;
	}

}
