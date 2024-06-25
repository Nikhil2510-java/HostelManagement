package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nt.sbean.AdminBean;

public class ViewAllAdminDAO {
	public List<AdminBean> viewAdmin() {

		List<AdminBean> list = new ArrayList<>();
		AdminBean a1 = null;
		try (Connection con = DBConnection.getCon();
				PreparedStatement pstmt = con.prepareStatement("SELECT * FROM ADMINTABLE ");) {
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				a1 = new AdminBean();
				a1.setaName(rs.getString(1));
				a1.setHostelName(rs.getString(2));
				a1.setaAddress(rs.getString(3));
				a1.setaLocation(rs.getString(4));
				a1.setaMobileNO(rs.getString(5));
				a1.setaUsername(rs.getString(6));
				a1.setaPassword(rs.getString(7));
				list.add(a1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}
}
