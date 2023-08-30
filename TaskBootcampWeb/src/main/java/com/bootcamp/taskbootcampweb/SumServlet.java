package com.bootcamp.taskbootcampweb;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "sum", value = "/SumServlet")
public class SumServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String num1Str = request.getParameter("num1");
        String num2Str = request.getParameter("num2");

        int num1 = Integer.parseInt(num1Str);
        int num2 = Integer.parseInt(num2Str);

        int sum = num1 + num2;

        response.setContentType("text/html");

        response.getWriter().println("<html><body>");
        response.getWriter().println("<h2>Sum of " + num1 + " and " + num2 + " is: " + sum + "</h2>");
        response.getWriter().println("</body></html>");
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get the parameters from the request
        String num1Str = request.getParameter("num1");
        String num2Str = request.getParameter("num2");

        // Convert the parameters to numbers
        int num1 = Integer.parseInt(num1Str);
        int num2 = Integer.parseInt(num2Str);

        // Calculate the sum
        int sum = num1 + num2;

        // Set the response content type
        response.setContentType("text/html");

        // Write the result to the response
        response.getWriter().println("<html><body>");
        response.getWriter().println("<h2>Sum of " + num1 + " and " + num2 + " is: " + sum + "</h2>");
        response.getWriter().println("</body></html>");
    }
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        // Get parameters from the request
//        String num1Str = request.getParameter("num1");
//        String num2Str = request.getParameter("num2");
//
//        // Set the content type for the response
//        response.setContentType("text/html");
//
//        try (PrintWriter out = response.getWriter()) {
//            // Write HTML content for the client
//            out.println("<html><body>");
//            out.println("<form action=\"/your-web-app-context/sum\" method=\"post\">");
//            out.println("Number 1: <input type=\"text\" name=\"num1\"><br>");
//            out.println("Number 2: <input type=\"text\" name=\"num2\"><br>");
//            out.println("<input type=\"submit\" value=\"Calculate Sum\">");
//            out.println("</form>");
//
//            if (num1Str != null && num2Str != null) {
//                // Calculate sum using SumServlet
//                int num1 = Integer.parseInt(num1Str);
//                int num2 = Integer.parseInt(num2Str);
//                int sum = num1 + num2;
//                out.println("<h2>Sum of " + num1 + " and " + num2 + " is: " + sum + "</h2>");
//            }
//
//            out.println("</body></html>");
//        }
//    }
}