package com.nt.sbean;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.nt.dao.ViewAllAdminDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewAdmin")
public class ViewAllAdmin extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		PrintWriter pw = resp.getWriter();

		List<AdminBean> list = new ViewAllAdminDAO().viewAdmin();

		pw.println("<html><head><title>View All Students</title>");
		pw.println("<link rel='stylesheet' type='text/css' href='Style/style2.css'>");
		pw.println("</head><body>");
		pw.println("<h1>All Admin List</h1>");
		
		pw.println(
				"<table border='1'><tr><th>Name</th><th>Hostel_Name</th><th>Address</th><th>Location</th><th>Mobile_no</th><th>UserName</th><th>Password</th></tr>");

		for (AdminBean a1 : list) {
			pw.println("<tr>");
			pw.println("<td>" + a1.getaName() + "</td>");
			pw.println("<td>" + a1.getHostelName() + "</td>");
			pw.println("<td>" + a1.getaAddress() + "</td>");
			pw.println("<td>" + a1.getaLocation() + "</td>");
			pw.println("<td>" + a1.getaMobileNO() + "</td>");
			pw.println("<td>" + a1.getaUsername() + "</td>");
			pw.println("<td>" + a1.getaPassword() + "</td>");

			pw.println("</tr>");
		}

		pw.println("</table>");
		pw.println("</body></html>");
		pw.close();
	}
}
