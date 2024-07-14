package com.artcafe.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Fetch data from Supabase or database
        int totalWorkers = fetchTotalWorkers();
        int workersOnLeave = fetchWorkersOnLeave();
        List<Worker> registeredStaff = fetchRegisteredStaff();

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Load the dashboard.html file
        String dashboardHTML = Utils.loadFileFromResources("dashboard.html");

        // Replace placeholders with actual data
        dashboardHTML = dashboardHTML.replace("${totalWorkers}", String.valueOf(totalWorkers));
        dashboardHTML = dashboardHTML.replace("${workersOnLeave}", String.valueOf(workersOnLeave));
        dashboardHTML = dashboardHTML.replace("${registeredStaff}", generateRegisteredStaffHTML(registeredStaff));

        // Write the HTML to the response
        out.println(dashboardHTML);
    }

    private int fetchTotalWorkers() {
        // Implement logic to fetch total workers from the database
        return 50; // Replace with actual implementation
    }

    private int fetchWorkersOnLeave() {
        // Implement logic to fetch workers on leave from the database
        return 5; // Replace with actual implementation
    }

    private List<Worker> fetchRegisteredStaff() {
        // Implement logic to fetch registered staff from the database
        return List.of(); // Replace with actual implementation
    }

    private String generateRegisteredStaffHTML(List<Worker> registeredStaff) {
        StringBuilder html = new StringBuilder();
        for (Worker worker : registeredStaff) {
            html.append("<div>")
                .append("<img src='").append(worker.getProfilePicture()).append("' alt='Profile Picture'>")
                .append("<p>").append(worker.getFullName()).append("</p>")
                .append("<p>").append(worker.getDepartment()).append("</p>")
                .append("<p>").append(worker.getWorkLocation()).append("</p>")
                .append("</div>");
        }
        return html.toString();
    }
}
