package com.bootcamp;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
http://localhost:8080/info
 */
@WebServlet("/info")
public class StudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Configuration config = new freemarker.template.Configuration(Configuration.VERSION_2_3_32);
        config.setDefaultEncoding(String.valueOf(StandardCharsets.UTF_8));
        config.setDirectoryForTemplateLoading(new File("src/main/resources"));
        Map<String, Object> data = new HashMap<>();

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Rashad", 25, "Java"));
        studentList.add(new Student("Mammad", 28, "Java"));
        studentList.add(new Student("Ali", 23, "Java"));
        studentList.add(new Student("Tural", 26, "Java"));

        data.put("data", studentList);
        try (PrintWriter writer = resp.getWriter()) {
            config.getTemplate("student.ftl").process(data, writer);
        } catch (TemplateException e) {
            throw new RemoteException();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
