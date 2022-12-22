package com.example.demo1.books;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "servlet_books_2", value = "/servlet_2")
public class Servlet_books_2 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter pw = response.getWriter();
        try {
            Class.forName(Util.driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            Connection connection = DriverManager.getConnection(Util.url, Util.user, Util.password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(Util.resultSet);
            while (resultSet.next()) {
                pw.println(resultSet.getString("title") + " "
                        + resultSet.getString("author"));
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
