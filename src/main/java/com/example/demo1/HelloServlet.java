package com.example.demo1;

import java.io.*;
import java.nio.file.FileStore;
import java.util.Date;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import model.Cart;

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

//        Integer count = (Integer) session.getAttribute("count");
//        if (count == null) {
//            count = 1;
//            session.setAttribute("count", count);
//        } else {
//            session.setAttribute("count", count + 1);
//        }

        // Hello
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Hello, " +  "</h1>");
        out.println("</br>");
        out.println("<h1>" + new Date() + "</h1>");
        out.println("</body></html>");
        Cart cart = (Cart) request.getAttribute("cart");

        String name = request.getParameter("name");
        int a = Integer.parseInt("110");
        Integer quantity = Integer.parseInt(request.getParameter("quantity")) ;

        if (cart == null) {
            cart = new Cart();

            cart.setProduct(name);
            cart.setQuantity(quantity);
        }

        session.setAttribute("cart", cart);

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