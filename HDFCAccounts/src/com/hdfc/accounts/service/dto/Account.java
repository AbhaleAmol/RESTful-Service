package com.hdfc.accounts.service.dto;

public class Account {

	private String accountNumber;
	private String accountHolderName;
	private String accountType;
	private String emailID;
	private String mobileNumber;
	private boolean chequeFacility;
	private boolean netBankingFacility;
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getEmailID() {
		return emailID;
	}
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public boolean isChequeFacility() {
		return chequeFacility;
	}
	public void setChequeFacility(boolean chequeFacility) {
		this.chequeFacility = chequeFacility;
	}
	public boolean isNetBankingFacility() {
		return netBankingFacility;
	}
	public void setNetBankingFacility(boolean netBankingFacility) {
		this.netBankingFacility = netBankingFacility;
	}
}
