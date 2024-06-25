package com.nt.sbean;

import java.io.IOException;
import java.io.PrintWriter;

import com.nt.dao.UserLoginDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/user")
public class UserLoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        UserBean u1 = new UserLoginDao().userLogin(username, password);

        if (u1!=null) {
        	ServletContext context=getServletContext();
        	context.setAttribute("user", u1);
            RequestDispatcher rd = req.getRequestDispatcher("user.html");
            rd.forward(req, resp);
        } else {
            pw.print("<p>Invalid Username and Password</p>");
            RequestDispatcher rd = req.getRequestDispatcher("user-login.html");
            rd.include(req, resp);
        }
    }
}
