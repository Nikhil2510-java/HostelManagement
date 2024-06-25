package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import com.nt.sbean.UserBean;

public class UserRegDAO {
    public int regUser(UserBean user) {
        int row = 0;
        try (Connection con = DBConnection.getCon();
             PreparedStatement pstmt = con.prepareStatement("INSERT INTO USERTABLE (uname, uaadhar, uaddress, ulocation, umobilenumber, username, password) VALUES (?, ?, ?, ?, ?, ?, ?)")) {
            
            pstmt.setString(1, user.getuName());
            pstmt.setString(2, user.getuAadharNo());  
            pstmt.setString(3, user.getuAddress());
            pstmt.setString(4, user.getuLocation());
            pstmt.setString(5, user.getuMobileNO());  
            pstmt.setString(6, user.getUsername());
            pstmt.setString(7, user.getuPassword());
            
            row = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }
}
