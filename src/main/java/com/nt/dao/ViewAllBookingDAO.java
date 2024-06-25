package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nt.sbean.Booking;

public class ViewAllBookingDAO {

	
	public List<Booking> listBooking() {
		
		List<Booking>list=new ArrayList<Booking>();
		Booking b1=null;
		try(Connection con=DBConnection.getCon();
				PreparedStatement pstmt=con.prepareStatement("SELECT * FROM BOOKING ");)
		{
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				b1=new Booking();
				b1.setName(rs.getString(1));
				b1.setMob(rs.getString(2));
				b1.setBookNAME(rs.getString(3));
				b1.setRoomTYPE(rs.getString(4));
				b1.setPayment_METHOD(rs.getString(5));
				b1.setBooking_AMT(rs.getDouble(6));
				b1.setBalance_AMT(rs.getDouble(7));
				list.add(b1);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}

}
