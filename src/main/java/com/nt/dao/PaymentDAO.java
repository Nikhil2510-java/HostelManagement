package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.nt.sbean.Payment;

public class PaymentDAO {

    // Retrieve all payment records
    public List<Payment> getAllPayments() {
        List<Payment> payments = new ArrayList<>();

        try (Connection con = DBConnection.getCon();
             PreparedStatement pstmt = con.prepareStatement("SELECT * FROM payments")) {

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Payment payment = new Payment();
                payment.setId(rs.getInt("id"));
                payment.setUserName(rs.getString("user_name"));
                payment.setRoomType(rs.getString("room_type"));
                payment.setAmount(rs.getDouble("amount"));
                payment.setDate(rs.getString("payment_date")); // Assuming payment_date is a string for simplicity
                payments.add(payment);
            }
        } catch (Exception e) {
            e.printStackTrace();
            // Handle database errors
        }

        return payments;
    }
}
