package com.nt.sbean;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.nt.dao.ViewAllRequestDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewRequests")
public class ViewAllRequest extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();

        List<Maintence> list = new ViewAllRequestDAO().listRequest();

        pw.println("<html><head><title>View All Students Request</title>");
        pw.println("<link rel='stylesheet' type='text/css' href='Style/style2.css'>");
        pw.println("</head><body>");
        pw.println("<h1>Requests</h1>");
        pw.println(
                "<table border='1'><tr><th>NAME</th><th>MOB</th><th>Room_NO</th><th>Type_OF_Request</th><th>Details</th><th>Action</th></tr>");

        for (Maintence m1 : list) {
            pw.println("<tr>");
            pw.println("<td>" + m1.getName() + "</td>");
            pw.println("<td>" + m1.getMob() + "</td>");
            pw.println("<td>" + m1.getRoomNumber() + "</td>");
            pw.println("<td>" + m1.getRequestType() + "</td>");
            pw.println("<td>" + m1.getDetails() + "</td>");
            pw.println("<td><form method='post' action='viewRequests'>");
            pw.println("<input type='hidden' name='action' value='delete'>");
            pw.println("<input type='hidden' name='name' value='" + m1.getName() + "'>");
            pw.println("<input type='submit' value='Delete'></form></td>");
            pw.println("</tr>");
        }

        pw.println("</table>");
        pw.println("</body></html>");
        pw.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action != null && action.equals("delete")) {
            String name = req.getParameter("name");
            if (name != null && !name.isEmpty()) {
                // Call DAO to delete the request by name
                boolean deleted = new ViewAllRequestDAO().deleteRequestByName(name);
                if (deleted) {
                    resp.sendRedirect("viewRequests"); // Redirect back to the same page after deletion
                } else {
                    resp.getWriter().println("Failed to delete request."); // Handle deletion failure
                }
            }
        }
    }
}
