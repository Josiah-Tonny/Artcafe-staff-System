package com.artcafe.servlets;

import io.github.cdimascio.dotenv.Dotenv;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/uploadData")
@MultipartConfig
public class UploadDataServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Part filePart = request.getPart("dataFile");

        try (InputStream inputStream = filePart.getInputStream()) {
            processCSVData(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.setContentType("text/html");
        response.getWriter().println("<h1>Data Upload Successful!</h1>");
    }

    private void processCSVData(InputStream inputStream) throws IOException, SQLException {
        Dotenv dotenv = Dotenv.load();
        String supabaseUrl = dotenv.get("SUPABASE_URL");
        String supabaseKey = dotenv.get("SUPABASE_KEY");

        Connection connection = DriverManager.getConnection(supabaseUrl, "postgres", supabaseKey);
        String sql = "INSERT INTO workers (firstname, lastname, profile_picture, department, position, age, phone_number, email, work_id, check_in_time, check_out_time, date_of_birth, role, work_location) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            statement.setString(1, data[0]);
            statement.setString(2, data[1]);
            statement.setString(3, data[2]);
            statement.setString(4, data[3]);
            statement.setString(5, data[4]);
            statement.setInt(6, Integer.parseInt(data[5]));
            statement.setString(7, data[6]);
            statement.setString(8, data[7]);
            statement.setString(9, data[8]);
            statement.setString(10, data[9]);
            statement.setString(11, data[10]);
            statement.setDate(12, java.sql.Date.valueOf(data[11]));
            statement.setString(13, data[12]);
            statement.setString(14, data[13]); // Work location
            statement.executeUpdate();
        }
        statement.close();
        connection.close();
    }
}
