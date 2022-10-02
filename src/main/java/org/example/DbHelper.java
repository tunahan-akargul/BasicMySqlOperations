package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {

    static String name = "root";
    static String password = "AzimIcin16";
    static String dbUrl = "jdbc:mySql://localhost:3306/mysqlproject";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, name, password);
    }

    public void getErrorMessage(SQLException exception){
        System.out.println(exception.getMessage());
        System.out.println(exception.getErrorCode());
    }
}
