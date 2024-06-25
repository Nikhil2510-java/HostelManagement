package com.nt.sbean;

public class Booking {
	private String name;
	private String mob;
	private String bookNAME;
	private String roomTYPE;
	private String payment_METHOD;
	private Double booking_AMT;
	private Double balance_AMT;

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

	public String getBookNAME() {
		return bookNAME;
	}

	public void setBookNAME(String bookNAME) {
		this.bookNAME = bookNAME;
	}

	public String getRoomTYPE() {
		return roomTYPE;
	}

	public void setRoomTYPE(String roomTYPE) {
		this.roomTYPE = roomTYPE;
	}

	public String getPayment_METHOD() {
		return payment_METHOD;
	}

	public void setPayment_METHOD(String payment_METHOD) {
		this.payment_METHOD = payment_METHOD;
	}

	public Double getBooking_AMT() {
		return booking_AMT;
	}

	public void setBooking_AMT(Double booking_AMT) {
		this.booking_AMT = booking_AMT;
	}

	public Double getBalance_AMT() {
		return balance_AMT;
	}

	public void setBalance_AMT(Double balance_AMT) {
		this.balance_AMT = balance_AMT;
	}

	@Override
	public String toString() {
		return "Booking [name=" + name + ", mob=" + mob + ", bookNAME=" + bookNAME + ", roomTYPE=" + roomTYPE
				+ ", payment_METHOD=" + payment_METHOD + ", booking_AMT=" + booking_AMT + ", balance_AMT=" + balance_AMT
				+ "]";
	}

}
