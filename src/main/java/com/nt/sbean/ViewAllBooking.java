package com.nt.sbean;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.nt.dao.ViewAllBookingDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/viewBookings")
public class ViewAllBooking extends HttpServlet {
   
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		   resp.setContentType("text/html");
	       PrintWriter pw = resp.getWriter();
	       
	       List<Booking> list = new ViewAllBookingDAO().listBooking();

	       pw.println("<html><head><title>View All Students Request</title>");
	       pw.println("<link rel='stylesheet' type='text/css' href='Style/style2.css'>");
	       pw.println("</head><body>");
	       pw.println("<h1>Requests</h1>");
	       pw.println("<table border='1'><tr><th>Booked_by</th><th>Booked_MOB</th><th>Booking_Name</th><th>Room_type</th><th>Payment_Method</th><th>Booking_AMT</th><th>Balnce_AMT</th></tr>");
	       
	       for (Booking b1 : list) {
	           pw.println("<tr>");
	           pw.println("<td>" + b1.getName() + "</td>");
	           pw.println("<td>" + b1.getMob() + "</td>");
	           pw.println("<td>" + b1.getBookNAME() + "</td>");
	           pw.println("<td>" + b1.getRoomTYPE() + "</td>");
	           pw.println("<td>" + b1.getPayment_METHOD()+ "</td>");
	           pw.println("<td>" + b1.getBooking_AMT()+ "</td>");
	           pw.println("<td>" + b1.getBalance_AMT()+ "</td>");
	           
	           
	           pw.println("</tr>");
	       }
	       
	       pw.println("</table>");
	       pw.println("</body></html>");
	       pw.close();
	   }
	
	
}
