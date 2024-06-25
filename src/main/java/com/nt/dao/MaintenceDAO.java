package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nt.sbean.Maintence;

public class MaintenceDAO {

    // Insert a new maintenance request
    public int requestUser(Maintence m1) {
        int row = 0;

        try (Connection con = DBConnection.getCon();
             PreparedStatement pstmt = con.prepareStatement("INSERT INTO MAINTENCE (USERNAME, USERMOBILE, ROOM_NO, REQUSET_TYPE, DETAILS) VALUES (?, ?, ?, ?, ?)")) {

            pstmt.setString(1, m1.getName());
            pstmt.setString(2, m1.getMob());
            pstmt.setString(3, m1.getRoomNumber());
            pstmt.setString(4, m1.getRequestType());
            pstmt.setString(5, m1.getDetails());

            row = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    // Retrieve all maintenance requests for a given user (name and mobile number)
    public List<Maintence> getAllRequestsForUser(String name, String mobile) {
        List<Maintence> requests = new ArrayList<>();

        try (Connection con = DBConnection.getCon();
             PreparedStatement pstmt = con.prepareStatement("SELECT * FROM MAINTENCE WHERE USERNAME = ? AND USERMOBILE = ?")) {

            pstmt.setString(1, name);
            pstmt.setString(2, mobile);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Maintence m = new Maintence();
                m.setName(rs.getString("USERNAME"));
                m.setMob(rs.getString("USERMOBILE"));
                m.setRoomNumber(rs.getString("ROOM_NO"));
                m.setRequestType(rs.getString("REQUSET_TYPE"));
                m.setDetails(rs.getString("DETAILS"));
                requests.add(m);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return requests;
    }

    // Update a maintenance request
    public int updateRequest(Maintence m1) {
        int row = 0;

        try (Connection con = DBConnection.getCon();
             PreparedStatement pstmt = con.prepareStatement("UPDATE MAINTENCE SET REQUSET_TYPE=?, DETAILS=? WHERE USERNAME=? AND USERMOBILE=? AND ROOM_NO=?")) {

            pstmt.setString(1, m1.getRequestType());
            pstmt.setString(2, m1.getDetails());
            pstmt.setString(3, m1.getName());
            pstmt.setString(4, m1.getMob());
            pstmt.setString(5, m1.getRoomNumber());

            row = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    // Delete a maintenance request
    public int deleteRequest(String name, String mobile, String roomNumber) {
        int row = 0;

        try (Connection con = DBConnection.getCon();
             PreparedStatement pstmt = con.prepareStatement("DELETE FROM MAINTENCE WHERE USERNAME=? AND USERMOBILE=? AND ROOM_NO=?")) {

            pstmt.setString(1, name);
            pstmt.setString(2, mobile);
            pstmt.setString(3, roomNumber);

            row = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }
}
