package com.nt.sbean;

public class Maintence {
	private String name;
	private String mob;
	private String roomNumber;
	private String requestType;
	private String details;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Maintence [name=" + name + ", mob=" + mob + ", roomNumber=" + roomNumber + ", requestType="
				+ requestType + ", details=" + details + "]";
	}

}
