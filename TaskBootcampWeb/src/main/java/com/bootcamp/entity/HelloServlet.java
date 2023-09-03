package com.bootcamp.entity;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//https://localhost:8080/hello
public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");
        int i = Integer.parseInt(num1)+Integer.parseInt(num2);
        PrintWriter writer = response.getWriter();
        writer.println(i);

    }
}
