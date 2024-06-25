package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nt.sbean.Maintence;

public class ViewAllRequestDAO {

	public List<Maintence> listRequest() {

		List<Maintence> list = new ArrayList<Maintence>();
		Maintence m1 = null;
		try (Connection con = DBConnection.getCon();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM MAINTENCE ");) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				m1 = new Maintence();
				m1.setName(rs.getString(1));
				m1.setMob(rs.getString(2));
				m1.setRoomNumber(rs.getString(3));
				m1.setRequestType(rs.getString(4));
				m1.setDetails(rs.getString(5));
				list.add(m1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	public boolean deleteRequestByName(String name) {
		boolean deleted = false;
		try (Connection con = DBConnection.getCon();
				PreparedStatement pstmt = con.prepareStatement("DELETE FROM MAINTENCE WHERE USERNAME = ?")) {
			pstmt.setString(1, name);
			int rowsDeleted = pstmt.executeUpdate();
			if (rowsDeleted > 0) {
				deleted = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// Handle SQL exception
		}
		return deleted;
	}

}
