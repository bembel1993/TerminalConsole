package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
    public static Connection connection = null;

    public static void connect() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("MySQL JDBC Driver Registered!");
        } catch (ClassNotFoundException e) {
            System.out.println("Where is your MySQL JDBC Driver?");
            e.printStackTrace();
            throw new SQLException();
        }
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/forterminal?useUnicode=true&serverTimezone=UTC",
                "root", "root");
        if(connection == null) {
            throw new SQLException();
        } else {
            System.out.println("Successfully connected");
        }
    }

   /* public static void close() {
        if(connection != null) {
         //   connection.close();
            System.out.println("Closing connection");
        }
    }*/
}
