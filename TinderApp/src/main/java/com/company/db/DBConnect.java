package com.company.db;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class DBConnect {
    public static Connection connect() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:postgresql://localhost:5432/tinder_app_main";

        String userName = "admin";
        String password = "admin";

        Connection conn = DriverManager.getConnection(url, userName, password);
        return conn;
    }
}
