package com.nt.sbean;

import java.io.IOException;
import java.io.PrintWriter;
import com.nt.dao.AdminLoginDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/admin")
public class AdminLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        boolean userPresent = new AdminLoginDao().adminLogin(username, password);

        if (userPresent) {
            RequestDispatcher rd = req.getRequestDispatcher("admin.html");
            rd.forward(req, resp);
        } else {
            pw.print("<p>Invalid Username and Password</p>");
            RequestDispatcher rd = req.getRequestDispatcher("admin-login.html");
            rd.include(req, resp);
        }
    }
}
