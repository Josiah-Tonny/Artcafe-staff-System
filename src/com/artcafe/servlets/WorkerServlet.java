package com.artcafe.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/worker-register")
public class WorkerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fullname = request.getParameter("fullname");
        String department = request.getParameter("department");
        String email = request.getParameter("email");
        String phonenumber = request.getParameter("phonenumber");
        String image = request.getParameter("image");
        String workLocation = request.getParameter("workLocation");

        // Save worker data to Supabase or database
        saveWorkerData(fullname, department, email, phonenumber, image, workLocation);

        PrintWriter out = response.getWriter();
        out.println("<h1>Worker Registered Successfully!</h1>");
        out.println("<p>Full Name: " + fullname + "</p>");
        out.println("<p>Department: " + department + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<p>Phone Number: " + phonenumber + "</p>");
        out.println("<p>Image: " + image + "</p>");
        out.println("<p>Work Location: " + workLocation + "</p>");
    }

    private void saveWorkerData(String fullname, String department, String email, String phonenumber, String image, String workLocation) {
        // Implement logic to save the worker data to the database
    }
}
