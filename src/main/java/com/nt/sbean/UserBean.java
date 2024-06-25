package com.nt.sbean;

public class UserBean {
	private Integer uId;
	private String uName;
	private String uAadharNo;
	private String uAddress;
	private String uLocation;
	private String uMobileNO;
	private String username;
	private String uPassword;

	public Integer getuId() {
		return uId;
	}

	public void setuId(Integer uId) {
		this.uId = uId;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuAadharNo() {
		return uAadharNo;
	}

	public void setuAadharNo(String uAadharNo) {
		this.uAadharNo = uAadharNo;
	}

	public String getuAddress() {
		return uAddress;
	}

	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}

	public String getuLocation() {
		return uLocation;
	}

	public void setuLocation(String uLocation) {
		this.uLocation = uLocation;
	}

	public String getuMobileNO() {
		return uMobileNO;
	}

	public void setuMobileNO(String uMobileNO) {
		this.uMobileNO = uMobileNO;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	@Override
	public String toString() {
		return "UserBean [uId=" + uId + ", uName=" + uName + ", uAadharNo=" + uAadharNo + ", uAddress=" + uAddress
				+ ", uLocation=" + uLocation + ", uMobileNO=" + uMobileNO + ", username=" + username + ", uPassword="
				+ uPassword + "]";
	}

}