package com.artcafe.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/leave")
public class LeaveServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String reason = request.getParameter("reason");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");

        // Save leave request data to Supabase or database
        saveLeaveRequest(reason, startDate, endDate);

        PrintWriter out = response.getWriter();
        out.println("<h1>Leave Request Submitted Successfully!</h1>");
        out.println("<p>Reason: " + reason + "</p>");
        out.println("<p>Start Date: " + startDate + "</p>");
        out.println("<p>End Date: " + endDate + "</p>");
    }

    private void saveLeaveRequest(String reason, String startDate, String endDate) {
        // Implement logic to save the leave request data to the database
    }
}
