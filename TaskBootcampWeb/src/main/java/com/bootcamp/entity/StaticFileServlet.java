package com.bootcamp.entity;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class StaticFileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestedName = req.getPathInfo();
        if (requestedName.startsWith("/"))
            requestedName = requestedName.substring(1);
        String fileName = getClass().getClassLoader().getResource(requestedName).getFile().substring(3);

        try (ServletOutputStream os = resp.getOutputStream()) {
            Files.copy(Path.of(fileName), os);
        }
    }
}
