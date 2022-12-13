package com.example.demo1;

import java.io.*;
import java.nio.file.FileStore;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String name = request.getParameter("name");
//        String lastName = request.getParameter("lastName");
//        response.setContentType("text/html");

        double num1 = Integer.parseInt(request.getParameter("num1"));
        double num2 = Integer.parseInt(request.getParameter("num2"));
        String operator = request.getParameter("operator");
        double rezult = 0;


        if (operator == "division" && num2 != 0) {
            rezult = num1 / num2;
        } else if (operator == "*") {
            rezult = num1 * num2;
        } else if (operator == "+") {
            rezult = num1 + num2;
        }else if (operator == "-") {
            rezult = num1 - num2;
        }
//

//        HttpSession session = request.getSession();
//
//        Integer count = (Integer) session.getAttribute("count");
//        if (count == null) {
//            count = 1;
//            session.setAttribute("count", count);
//        }else {
//            session.setAttribute("count", + 1);
//        }

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Hello, " + num1 + " " + operator + " " + num2 + "</h1>");
        out.println("<h1>Rezultat:  " + rezult + "</h1>");
        out.println("</br>");
        out.println("<h1>" + new Date() + "</h1>");
        out.println("</body></html>");
        //Cart cart = (Cart) session.getA

//        RequestDispatcher dispatcher = request.getRequestDispatcher("/first-servlet.jsp");
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            throw new RuntimeException(e);
//        }

//        response.sendRedirect("https://www.google.com/");
    }

    public void destroy() {
    }
}