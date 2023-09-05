package com.bootcamp;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class JettyServer {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");


//        context.addServlet(StaticFileServlet.class, "/*");
//        context.addServlet(StudentServlet.class, "/info");
        context.addServlet(CalculatorServlet.class, "/calculate");
        server.setHandler(context);

        server.start();
        server.join();
    }
}
