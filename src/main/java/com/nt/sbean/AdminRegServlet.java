package com.nt.sbean;

import java.io.IOException;
import java.io.PrintWriter;
import com.nt.dao.AdminRegDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register-admin")
public class AdminRegServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/plain");
        PrintWriter pw = resp.getWriter();
        AdminBean admin = new AdminBean();

        admin.setaName(req.getParameter("name"));
        admin.setHostelName(req.getParameter("hostelname"));
        admin.setaAddress(req.getParameter("address"));
        admin.setaLocation(req.getParameter("location"));
        admin.setaMobileNO(req.getParameter("mobilenumber"));
        admin.setaUsername(req.getParameter("username"));
        admin.setaPassword(req.getParameter("password"));

        int row = new AdminRegDAO().regAdmin(admin);

        if (row > 0) {
            pw.write("success");
        } else {
            pw.write("failure");
        }
        pw.close();
    }
}
