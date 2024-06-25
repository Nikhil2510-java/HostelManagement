package com.nt.sbean;



import java.io.IOException;
import java.io.PrintWriter;

import com.nt.dao.MaintenceDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editRequest")
public class EditRequestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String mobile = req.getParameter("mobile");
        String roomNumber = req.getParameter("id");

        MaintenceDAO dao = new MaintenceDAO();
        Maintence request = dao.getAllRequestsForUser(name, mobile).stream()
                .filter(req1 -> req1.getRoomNumber().equals(roomNumber))
                .findFirst()
                .orElse(null);

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<head>");
        out.println("<title>Edit Request</title>");
        out.println("<link rel='stylesheet' type='text/css' href='Style/style2.css'>");
        out.println("</head>");

        out.println("<body>");
        if (request != null) {
            out.println("<h1>Edit Maintenance Request</h1>");
            out.println("<form method='post' action='viewRequest'>");
            out.println("<input type='hidden' name='action' value='edit'>");
            out.println("<input type='hidden' name='name' value='" + request.getName() + "'>");
            out.println("<input type='hidden' name='mobile' value='" + request.getMob() + "'>");
            out.println("<input type='hidden' name='roomNumber' value='" + request.getRoomNumber() + "'>");
            out.println("Request Type: <input type='text' name='newRequestType' value='" + request.getRequestType() + "'><br>");
            out.println("Details: <textarea name='newDetails'>" + request.getDetails() + "</textarea><br>");
            out.println("<input type='submit' value='Update'>");
            out.println("</form>");
        } else {
            out.println("<h1>Request not found</h1>");
        }
        out.println("</body>");
        out.println("</html>");
    }
}
