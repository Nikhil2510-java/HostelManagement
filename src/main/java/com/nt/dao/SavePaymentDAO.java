package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SavePaymentDAO {
	public int savePayment(String userName, String roomType, double paymentAmount) {
		int row=0;
		try (Connection con = DBConnection.getCon();
				PreparedStatement pstmt = con
						.prepareStatement("INSERT INTO payments (user_name, room_type, amount) VALUES (?, ?, ?)")) {
			pstmt.setString(1, userName);
			pstmt.setString(2, roomType);
			pstmt.setDouble(3, paymentAmount);
			row=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			// Handle database errors
		}
		return row;
	}
	
	

}
