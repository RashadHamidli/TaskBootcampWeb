package com.bootcamp.entity;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//https://localhost:8080/hello
public class Calc extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");
        int i = Integer.parseInt(num1) + Integer.parseInt(num2);
        PrintWriter writer = response.getWriter();
        writer.println(i);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String num1 = request.getParameter("x");
        String num2 = request.getParameter("y");
        int x = Integer.parseInt(num1);
        int y = Integer.parseInt(num2);
        int i = x + y;
        String headerData = response.getHeader("HeaderData");
        PrintWriter writer = response.getWriter();
        writer.println(i);
        writer.println(headerData);
    }
}
