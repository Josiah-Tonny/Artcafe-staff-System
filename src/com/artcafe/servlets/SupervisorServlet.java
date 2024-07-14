package com.artcafe.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class SupervisorServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Validate supervisor credentials
        boolean isValidSupervisor = validateSupervisorCredentials(username, password);

        if (isValidSupervisor) {
            response.sendRedirect("dashboard"); // Redirect to dashboard
        } else {
            response.sendRedirect("login.html"); // Redirect back to login page on failure
        }
    }

    private boolean validateSupervisorCredentials(String username, String password) {
        // Implement logic to validate supervisor credentials against the database
        return "admin".equals(username) && "password".equals(password); // Replace with actual implementation
    }
}
