package com.nt.sbean;

import java.io.IOException;

import com.nt.dao.ViewAllDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteUser")
public class DeleteUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int uId = Integer.parseInt(req.getParameter("uId"));
        new ViewAllDAO().deleteUser(uId);
        resp.sendRedirect("viewUser");
    }
}
