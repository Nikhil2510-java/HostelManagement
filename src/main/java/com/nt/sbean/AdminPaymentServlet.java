package com.nt.sbean;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.nt.dao.PaymentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewRent")
public class AdminPaymentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        PaymentDAO paymentDAO = new PaymentDAO();
        List<Payment> payments = paymentDAO.getAllPayments();

        out.println("<html>");
        out.println("<head><title>Student Payments List</title>");
        out.println("<link rel='stylesheet' type='text/css' href='Style/style2.css'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Admin Payments</h1>");
        out.println("<table border='1'>");
        out.println("<tr><th>ID</th><th>User Name</th><th>Room Type</th><th>Amount</th><th>Date</th></tr>");

        for (Payment payment : payments) {
            out.println("<tr>");
            out.println("<td>" + payment.getId() + "</td>");
            out.println("<td>" + payment.getUserName() + "</td>");
            out.println("<td>" + payment.getRoomType() + "</td>");
            out.println("<td>" + payment.getAmount() + "</td>");
            out.println("<td>" + payment.getDate() + "</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }
}
