package com.nt.sbean;

import java.io.IOException;
import java.io.PrintWriter;
import com.nt.dao.UserRegDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register-user")
public class UserRegServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        PrintWriter pw = resp.getWriter();
        UserBean user = new UserBean();

        user.setuName(req.getParameter("name"));
        user.setuAadharNo(req.getParameter("aadhar"));
        user.setuAddress(req.getParameter("address"));
        user.setuLocation(req.getParameter("location"));
        user.setuMobileNO(req.getParameter("mobilenumber"));
        user.setUsername(req.getParameter("username"));
        user.setuPassword(req.getParameter("password"));

        int row = new UserRegDAO().regUser(user);

        if (row > 0) {
            pw.write("success");
        } else {
            pw.write("failure");
        }
        pw.close();
    }
}
