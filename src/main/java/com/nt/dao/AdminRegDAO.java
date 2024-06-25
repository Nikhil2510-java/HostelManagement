package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.nt.sbean.AdminBean;

public class AdminRegDAO {
    public int regAdmin(AdminBean admin) {
        int row = 0;
        try (Connection con = DBConnection.getCon();
             PreparedStatement pstmt = con.prepareStatement("INSERT INTO ADMINTABLE (aname, hostelname, aaddress, alocation, amobilenumber, ausername, apassword) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            
            pstmt.setString(1, admin.getaName());
            pstmt.setString(2, admin.getHostelName());
            pstmt.setString(3, admin.getaAddress());
            pstmt.setString(4, admin.getaLocation());
            pstmt.setString(5, admin.getaMobileNO());
            pstmt.setString(6, admin.getaUsername());
            pstmt.setString(7, admin.getaPassword());
            
            row = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }
}
