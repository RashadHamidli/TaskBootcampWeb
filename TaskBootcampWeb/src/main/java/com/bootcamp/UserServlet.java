package com.bootcamp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "UserServlet", value = "/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        User user = new User(name, surname);

        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("surname", surname);
        List<User> list = new ArrayList<>();
        list.add(new User(name, surname));

        PrintWriter writer = response.getWriter();
        writer.println(map);

        list.forEach(System.out::println);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        User user = new User(name, surname);

        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("surname", surname);
        List<User> list = new ArrayList<>();
        list.add(new User(name, surname));

        PrintWriter writer = response.getWriter();
        writer.println(map);

        list.forEach(System.out::println);
    }
}
