package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.nt.sbean.Booking;
import com.nt.sbean.UserBean;

public class UserBookDAO {
	
	public int bookUser(Booking b1,String name,String mobile) {
        int row = 0;
        UserBean user=new UserBean();
        try (Connection con = DBConnection.getCon();
             PreparedStatement pstmt = con.prepareStatement("INSERT INTO BOOKING VALUES(?,?,?,?,?,?,?)")) {
            
            pstmt.setString(1, name);
            pstmt.setString(2, mobile);
            pstmt.setString(3, b1.getBookNAME());
            pstmt.setString(4, b1.getRoomTYPE());
            pstmt.setString(5, b1.getPayment_METHOD());
            pstmt.setDouble(6, b1.getBooking_AMT());
            pstmt.setDouble(7, b1.getBalance_AMT());
            
            row = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }
}
