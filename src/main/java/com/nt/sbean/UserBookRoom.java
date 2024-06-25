package com.nt.sbean;

import java.io.IOException;
import java.io.PrintWriter;

import com.nt.dao.UserBookDAO;
import com.nt.dao.UserRegDAO;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/bookroom")
public class UserBookRoom extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/plain");
        PrintWriter pw = resp.getWriter();
        ServletContext context=getServletContext();
       UserBean u1= (UserBean) context.getAttribute("user");
       String name=u1.getuName();
       String mobile=u1.getuMobileNO();
        
        Booking b1=new Booking();
        
        b1.setBookNAME(req.getParameter("username"));
        b1.setRoomTYPE(req.getParameter("room-type"));
        
        b1.setPayment_METHOD(req.getParameter("payment-method"));
        b1.setBooking_AMT(Double.parseDouble(req.getParameter("booking-amount")));
        b1.setBalance_AMT(UserBookRoom.balAmtCal(b1.getRoomTYPE(), b1.getBooking_AMT()));
       
        
        

        int row = new UserBookDAO().bookUser(b1,name,mobile);

        if (row > 0) {
            resp.sendRedirect("success.html"); // Redirect to a success page
        } else {
            resp.sendRedirect("view-room.html"); // Redirect to a failure page
        }
        
        
        pw.close();
		
		
	}
	
	public static Double balAmtCal(String roomtype,double bookamt) {
          
		if(roomtype.equalsIgnoreCase("2-sharing")) {
			return 6000-bookamt;
		}
		else if(roomtype.equalsIgnoreCase("3-sharing")) {
			return 5000-bookamt;
		}
		else if(roomtype.equalsIgnoreCase("4-sharing")) {
			return 4000-bookamt;
		}
		else {
			return -1.0;
		}

    }

}
