package com.nt.sbean;

import java.io.IOException;
import java.io.PrintWriter;

import com.nt.dao.ViewAllDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editUser")
public class EditUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = Integer.parseInt(req.getParameter("uId"));
        UserBean user = new ViewAllDAO().getUserById(userId);

        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        pw.println("<html><head><title>Edit Student</title></head><body>");
        pw.println("<h1>Edit Student Details</h1>");
        pw.println("<form action='updateUser' method='post'>");
        pw.println("<input type='hidden' name='uId' value='" + user.getuId() + "'/>");
        pw.println("Name: <input type='text' name='uName' value='" + user.getuName() + "'/><br/>");
        pw.println("Aadhar No: <input type='text' name='uAadharNo' value='" + user.getuAadharNo() + "'/><br/>");
        pw.println("Address: <input type='text' name='uAddress' value='" + user.getuAddress() + "'/><br/>");
        pw.println("Location: <input type='text' name='uLocation' value='" + user.getuLocation() + "'/><br/>");
        pw.println("Mobile No: <input type='text' name='uMobileNO' value='" + user.getuMobileNO() + "'/><br/>");
        pw.println("Username: <input type='text' name='username' value='" + user.getUsername() + "'/><br/>");
        pw.println("Password: <input type='text' name='uPassword' value='" + user.getuPassword() + "'/><br/>");
        pw.println("<input type='submit' value='Update'/>");
        pw.println("</form>");
        pw.println("</body></html>");
        pw.close();
    }
}
