package com.company.servlet;

import com.company.Utils.FreemarkerEngine;
import com.company.controller.UserController;
import com.company.dao.UserDAO;
import com.company.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.HashMap;

public class RegisterServlet extends HttpServlet {
    private final Connection connection;
    private UserController userController;
    private final FreemarkerEngine f = new FreemarkerEngine();

    public RegisterServlet(Connection connection) {
        this.connection = connection;
        this.userController = new UserController(new UserDAO(connection));
    }

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        f.render(rs, "register.ftl", new HashMap<>());
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        String email = rq.getParameter("email");
        String password = rq.getParameter("password");
        String name = rq.getParameter("name");
        String surname = rq.getParameter("surname");
        String gender = rq.getParameter("gender");
        boolean genderB = gender.equalsIgnoreCase("male");
        String imgUrl = rq.getParameter("imgUrl");
        User user = new User(email, password, name, surname, genderB, imgUrl);

        userController.addUser(user);

        rs.sendRedirect("/login");
    }

}
