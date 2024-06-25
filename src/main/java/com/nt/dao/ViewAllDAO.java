package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nt.sbean.UserBean;

public class ViewAllDAO {

    public List<UserBean> viewStu() {
        List<UserBean> list = new ArrayList<>();
        try (Connection con = DBConnection.getCon();
             PreparedStatement pstmt = con.prepareStatement("SELECT * FROM USERTABLE")) {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                UserBean user = new UserBean();
                user.setuId(rs.getInt("USERID")); 
                user.setuName(rs.getString("UNAME")); 
                user.setuAadharNo(rs.getString("UAADHAR")); 
                user.setuAddress(rs.getString("UADDRESS")); 
                user.setuLocation(rs.getString("ULOCATION")); 
                user.setuMobileNO(rs.getString("UMOBILENUMBER"));
                user.setUsername(rs.getString("USERNAME")); 
                user.setuPassword(rs.getString("PASSWORD")); 
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public UserBean getUserById(int uId) {
        UserBean user = null;
        try (Connection con = DBConnection.getCon();
             PreparedStatement pstmt = con.prepareStatement("SELECT * FROM USERTABLE WHERE USERID = ?")) {
            pstmt.setInt(1, uId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new UserBean();
                user.setuId(rs.getInt("USERID")); 
                user.setuName(rs.getString("UNAME")); 
                user.setuAadharNo(rs.getString("UAADHAR")); 
                user.setuAddress(rs.getString("UADDRESS")); 
                user.setuLocation(rs.getString("ULOCATION")); 
                user.setuMobileNO(rs.getString("UMOBILENUMBER")); 
                user.setUsername(rs.getString("USERNAME")); 
                user.setuPassword(rs.getString("PASSWORD")); 
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public void updateUser(UserBean user) {
        try (Connection con = DBConnection.getCon();
             PreparedStatement pstmt = con.prepareStatement(
                     "UPDATE USERTABLE SET UNAME=?, UAADHAR=?, UADDRESS=?, ULOCATION=?, UMOBILENUMBER=?, USERNAME=?, PASSWORD=? WHERE USERID=?")) {
            pstmt.setString(1, user.getuName());
            pstmt.setString(2, user.getuAadharNo());
            pstmt.setString(3, user.getuAddress());
            pstmt.setString(4, user.getuLocation());
            pstmt.setString(5, user.getuMobileNO());
            pstmt.setString(6, user.getUsername());
            pstmt.setString(7, user.getuPassword());
            pstmt.setInt(8, user.getuId());
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteUser(int uId) {
        try (Connection con = DBConnection.getCon();
             PreparedStatement pstmt = con.prepareStatement("DELETE FROM USERTABLE WHERE USERID = ?")) {
            pstmt.setInt(1, uId);
            pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
