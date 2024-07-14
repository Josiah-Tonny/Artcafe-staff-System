package com.artcafe.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/register")
public class RegistrationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        Part profilePicturePart = request.getPart("profilePicture");
        String department = request.getParameter("department");
        String position = request.getParameter("position");
        int age = Integer.parseInt(request.getParameter("age"));
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String workID = request.getParameter("workID");
        String checkInTime = request.getParameter("checkInTime");
        String checkOutTime = request.getParameter("checkOutTime");
        String dob = request.getParameter("dob");
        String role = request.getParameter("role");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String workLocation = request.getParameter("workLocation");

        // Check if the user is registering as a supervisor
        boolean isSupervisor = "Supervisor".equals(role);

        // Validate supervisor credentials
        if (isSupervisor && (username == null || username.isEmpty() || password == null || password.isEmpty())) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<h1>Error: Supervisor must have username and password</h1>");
            return;
        }

        // Save registration data to database (Supabase or other)
        saveRegistrationData(firstname, lastname, profilePicturePart, department, position, age, phoneNumber, email,
                workID, checkInTime, checkOutTime, dob, role, username, password, workLocation, isSupervisor);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Registration Successful!</h1>");
        out.println("<p>First Name: " + firstname + "</p>");
        out.println("<p>Last Name: " + lastname + "</p>");
        out.println("<p>Department: " + department + "</p>");
        out.println("<p>Position: " + position + "</p>");
        out.println("<p>Age: " + age + "</p>");
        out.println("<p>Phone Number: " + phoneNumber + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<p>Work ID: " + workID + "</p>");
        out.println("<p>Check-in Time: " + checkInTime + "</p>");
        out.println("<p>Check-out Time: " + checkOutTime + "</p>");
        out.println("<p>Date of Birth: " + dob + "</p>");
        out.println("<p>Role: " + role + "</p>");
        out.println("<p>Work Location: " + workLocation + "</p>");
        if (isSupervisor) {
            out.println("<p>Username: " + username + "</p>");
        }
    }

    private void saveRegistrationData(String firstname, String lastname, Part profilePicturePart, String department,
                                      String position, int age, String phoneNumber, String email, String workID,
                                      String checkInTime, String checkOutTime, String dob, String role, String username,
                                      String password, String workLocation, boolean isSupervisor) {
        // Implement logic to save the registration data to the database
    }
}
