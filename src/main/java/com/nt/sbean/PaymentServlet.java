package com.nt.sbean;

import java.io.IOException;
import java.math.BigDecimal;

import com.nt.dao.SavePaymentDAO;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext context = getServletContext();
        UserBean u1 = (UserBean) context.getAttribute("user");
        String name = u1.getuName();

        String roomType = request.getParameter("roomType");
        double amt=Double.parseDouble(request.getParameter("paymentAmount"));

        SavePaymentDAO savePaymentDAO = new SavePaymentDAO();
        int rowsInserted = savePaymentDAO.savePayment(name, roomType, amt);

        if (rowsInserted > 0) {
            // Payment successful, redirect to success page
            response.sendRedirect("payment_success.html");
        } else {
            // Payment failed, redirect back to payment page
            response.sendRedirect("rent-payment.html?error=PaymentFailed");
        }
    }
}
