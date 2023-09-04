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
import java.util.HashMap;
import java.util.Map;

//http://localhost:8080/calculate?num1=5&num2=6
//http://localhost:8080/calculate
@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {
    private Configuration configuration;

    @Override
    public void init() throws ServletException {
        configuration = new freemarker.template.Configuration(Configuration.VERSION_2_3_32);
        configuration.setDefaultEncoding(String.valueOf(StandardCharsets.UTF_8));
        try {
            configuration.setDirectoryForTemplateLoading(new File("src/main/resources"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));
        Calculator calculator = new Calculator();
        int result = calculator.add(num1, num2);

        Map<String, Object> data = new HashMap<>();
        data.put("result", result);
        try (PrintWriter writer = response.getWriter()) {
            configuration.getTemplate("calculator.ftl").process(data, writer);
        } catch (TemplateException e) {
            throw new RemoteException();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int num1 = Integer.parseInt(request.getParameter("num1"));
        int num2 = Integer.parseInt(request.getParameter("num2"));

        Calculator calculator = new Calculator();
        int result = calculator.add(num1, num2);

        Map<String, Object> data = new HashMap<>();
        data.put("result", result);
        try (PrintWriter writer = response.getWriter()) {
            configuration.getTemplate("calculator.ftl").process(data, writer);
        } catch (TemplateException e) {
            throw new RemoteException();
        }
    }
}
