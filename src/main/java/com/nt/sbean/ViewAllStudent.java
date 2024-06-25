package com.nt.sbean;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.nt.dao.ViewAllDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewUser")
public class ViewAllStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        List<UserBean> list = new ViewAllDAO().viewStu();

        pw.println("<html><head><title>View All Students</title>");
        pw.println("<link rel='stylesheet' type='text/css' href='Style/style2.css'>");
        pw.println("</head><body>");
        
        pw.println("<h1>Student List<br></h1>");
        pw.println("<table border='1'><tr><th>ID</th><th>Name</th><th>Aadhar No</th><th>Address</th><th>Location</th><th>Mobile No</th><th>Username</th><th>Password</th><th>Edit</th><th>Delete</th></tr>");
        
        for (UserBean user : list) {
            pw.println("<tr>");
            pw.println("<td>" + user.getuId() + "</td>");
            pw.println("<td>" + user.getuName() + "</td>");
            pw.println("<td>" + user.getuAadharNo() + "</td>");
            pw.println("<td>" + user.getuAddress() + "</td>");
            pw.println("<td>" + user.getuLocation() + "</td>");
            pw.println("<td>" + user.getuMobileNO() + "</td>");
            pw.println("<td>" + user.getUsername() + "</td>");
            pw.println("<td>" + user.getuPassword() + "</td>");
            pw.println("<td><a href='editUser?uId=" + user.getuId() + "'>Edit</a></td>");
            pw.println("<td><a href='deleteUser?uId=" + user.getuId() + "'>Delete</a></td>");
            pw.println("</tr>");
        }

        pw.println("</table>");
        pw.println("</body></html>");
        pw.close();
    }
}
