package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con =
                DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/thuvien?useSSL=false&serverTimezone=UTC",
                    "root",
                    ""
                );
            System.out.println("Ket noi thanh cong");
            return con;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}