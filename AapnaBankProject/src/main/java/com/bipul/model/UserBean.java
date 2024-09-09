package com.bipul.model;

import java.io.Serializable;

public class UserBean implements Serializable{

	private Long userAccount;
	private String userName;
	private String password;
	private Double amount;
	private String address;
	private Long phone;
	
	public UserBean() {
		super();
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public Long getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(Long userAccount) {
		this.userAccount = userAccount;
	}
	
	
}
