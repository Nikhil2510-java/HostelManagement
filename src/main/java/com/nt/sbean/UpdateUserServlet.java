package com.nt.sbean;

import java.io.IOException;

import com.nt.dao.ViewAllDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/updateUser")
public class UpdateUserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uId = Integer.parseInt(req.getParameter("uId"));
        String uName = req.getParameter("uName");
        String uAadharNo = req.getParameter("uAadharNo");
        String uAddress = req.getParameter("uAddress");
        String uLocation = req.getParameter("uLocation");
        String uMobileNO = req.getParameter("uMobileNO");
        String username = req.getParameter("username");
        String uPassword = req.getParameter("uPassword");

        UserBean user = new UserBean();
        user.setuId(uId);
        user.setuName(uName);
        user.setuAadharNo(uAadharNo);
        user.setuAddress(uAddress);
        user.setuLocation(uLocation);
        user.setuMobileNO(uMobileNO);
        user.setUsername(username);
        user.setuPassword(uPassword);

        new ViewAllDAO().updateUser(user);

        resp.sendRedirect("viewUser");
    }
}
