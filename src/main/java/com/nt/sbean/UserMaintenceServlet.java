package com.nt.sbean;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.nt.dao.MaintenceDAO;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewRequest")
public class UserMaintenceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        ServletContext context = getServletContext();

        UserBean u1 = (UserBean) context.getAttribute("user");

        if (u1 == null) {
            out.println("<html>");
            out.println("<head><title>Error</title></head>");
            out.println("<body>");
            out.println("<h1>User not found in the context.</h1>");
            out.println("</body>");
            out.println("</html>");
            return;
        }

        String name = u1.getuName();
        String mobile = u1.getuMobileNO();

        List<Maintence> requests = new MaintenceDAO().getAllRequestsForUser(name, mobile);

        out.println("<html>");
        out.println("<head><title>Maintenance Requests</title>");
        out.println("<link rel='stylesheet' type='text/css' href='Style/style2.css'>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Maintenance Requests from User: " + name + "</h1>");
        out.println("<table border='1'>");
        out.println("<tr><th>Username</th><th>Mobile</th><th>Room Number</th><th>Request Type</th><th>Details</th><th>Actions</th></tr>");

        for (Maintence request : requests) {
            out.println("<tr>");
            out.println("<td>" + request.getName() + "</td>");
            out.println("<td>" + request.getMob() + "</td>");
            out.println("<td>" + request.getRoomNumber() + "</td>");
            out.println("<td>" + request.getRequestType() + "</td>");
            out.println("<td>" + request.getDetails() + "</td>");
            out.println("<td>");
            out.println("<a href='editRequest?id=" + request.getRoomNumber() + "&name=" + request.getName() + "&mobile=" + request.getMob() + "'>Edit</a> | ");
            out.println("<a href='deleteRequest?id=" + request.getRoomNumber() + "&name=" + request.getName() + "&mobile=" + request.getMob() + "' onclick='return confirm(\"Are you sure you want to delete this request?\")'>Delete</a>");
            out.println("</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String name = req.getParameter("name");
        String mobile = req.getParameter("mobile");
        String roomNumber = req.getParameter("roomNumber");

        MaintenceDAO dao = new MaintenceDAO();

        if ("edit".equals(action)) {
            // Perform edit operation
            String newRequestType = req.getParameter("newRequestType");
            String newDetails = req.getParameter("newDetails");

            Maintence request = new Maintence();
            request.setName(name);
            request.setMob(mobile);
            request.setRoomNumber(roomNumber);
            request.setRequestType(newRequestType);
            request.setDetails(newDetails);

            dao.updateRequest(request);
        } else if ("delete".equals(action)) {
            // Perform delete operation
            dao.deleteRequest(name, mobile, roomNumber);
        }

        // Redirect back to the view page
        resp.sendRedirect("viewRequest");
    }
}
