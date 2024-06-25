package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminLoginDao {
	
	public boolean adminLogin(String username,String password) {
		boolean isPresent=false;
		try(Connection con=DBConnection.getCon();
				PreparedStatement pstmt=con.prepareStatement("SELECT * FROM ADMINTABLE WHERE AUSERNAME=? AND APASSWORD=?");
				)
		{
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				isPresent=true;
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return isPresent;
	}
}
