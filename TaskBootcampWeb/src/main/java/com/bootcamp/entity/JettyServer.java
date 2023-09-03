package com.bootcamp.entity;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class JettyServer {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");

        server.setHandler(context);

        context.addServlet(new ServletHolder(new Calc()), "/calc");
        context.addServlet(StaticFileServlet.class, "/*");
        context.addServlet(StudentServlet.class, "/info");
        server.setHandler(context);

        server.start();
        server.join();
    }
}
