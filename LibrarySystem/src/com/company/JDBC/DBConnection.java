package com.company.JDBC;

import java.sql.*;

public class DBConnection {

    private static Connection con = null;

    static {
        String url = "jdbc:postgresql://localhost:5432/SDP";
        String user = "postgres";
        String pass = "236318m";
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/SDP", "postgres", "236318m");
            }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Connection getConnection() {
        return con;
    }
}
