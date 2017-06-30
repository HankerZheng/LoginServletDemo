package net.antra.hanz.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by hanzheng on 6/29/17.
 */
public class JDBConnect {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException();
        }
    }
    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/MYSERVLET",
                "servlet",
                "^lC@n1p5gBrua_4j"
        );
        conn.setAutoCommit(false);
        return conn;
    }
}
