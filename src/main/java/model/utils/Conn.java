package model.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conn {
    private static final String DATABASE = "db_s2_ETU003315";
    private static final String URL = "jdbc:mysql://localhost:3306/"+DATABASE;
    private static final String USER = "ETU003315";
    private static final String PASSWORD = "8SGhNqh4";

    public static Connection getConnection() throws Exception {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            throw e;
        }
    }
}
