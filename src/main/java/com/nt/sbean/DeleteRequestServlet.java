package com.nt.sbean;

import java.io.IOException;

import com.nt.dao.MaintenceDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/deleteRequest")
public class DeleteRequestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String mobile = req.getParameter("mobile");
        String roomNumber = req.getParameter("id");

        MaintenceDAO dao = new MaintenceDAO();
        dao.deleteRequest(name, mobile, roomNumber);

        resp.sendRedirect("viewRequest");
    }
}
