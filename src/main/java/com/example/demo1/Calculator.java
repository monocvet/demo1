package com.example.demo1;

import java.io.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "calculator", value = "/calculator")
public class Calculator extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Integer a = Integer.parseInt(request.getParameter("a"));
        Integer b = Integer.parseInt(request.getParameter("b"));
        String operation = request.getParameter("operation");
        Integer result = 0;

        switch (operation) {
            case "division":
                result = a / b;
                break;
            case "addition":
                result = a + b;
                break;
            case "multiplication":
                result = a * b;
                break;
            case "subtraction":
                result = a - b;
                break;
        }
        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + a + " " + operation + " " + b + "</h1>");
        out.println("<h1>Rezultat:  " + result + "</h1>");
        out.println("</br>");
        out.println("</body></html>");

    }

    public void destroy() {
    }
}