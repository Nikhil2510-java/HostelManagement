package com.nt.sbean;

import java.io.IOException;
import java.io.PrintWriter;

import com.nt.dao.MaintenceDAO;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/submit_request")
public class MaintenceServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/plain");
        PrintWriter pw = resp.getWriter();
        ServletContext context=getServletContext();
        UserBean u1= (UserBean) context.getAttribute("user");
        String name=u1.getuName();
        String mobile=u1.getuMobileNO();
        
        Maintence m1=new Maintence();
        m1.setName(name);
        m1.setMob(mobile);
        m1.setRoomNumber(req.getParameter("roomNumber"));
        m1.setRequestType(req.getParameter("requestType"));
        m1.setDetails(req.getParameter("details"));
        
        
       
        
        

        int row = new MaintenceDAO().requestUser(m1);

        if (row > 0) {
            resp.sendRedirect("request.html"); // Redirect to a success page
        } else {
            resp.sendRedirect("request-maintenance.html"); // Redirect to a failure page
        }
        
        
        pw.close();
	}

}
