package org.example;

import javax.swing.*;
import java.sql.*;

public class Transactions {
    public void insertMessage() throws SQLException {
    Connection connection = null;
    DbHelper helper = new DbHelper();
    PreparedStatement statement = null;
    ResultSet resultSet;
    try {
        connection = helper.getConnection();
        System.out.println("Connection activated.");
        String name = JOptionPane.showInputDialog("Please enter your name.");
        String message = JOptionPane.showInputDialog("Please enter a message.");
        String sql = "insert into mysqlproject.messages (name, message) values (?, ?)";
        statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setString(2, message);
        int result = statement.executeUpdate();


    } catch (SQLException exception) {
        helper.getErrorMessage(exception);
    } finally {
        statement.close();
        connection.close();
    }
}

    public void readMessage() throws SQLException {
        Connection connection = null;
        DbHelper helper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet;
        try {

            connection = helper.getConnection();
            statement = connection.createStatement();
            String sql = "select * from messages";
            resultSet = statement.executeQuery(sql);
            String message = "";
            while (resultSet.next()){
                message += resultSet.getString("name");
                message += " : ";
                message += resultSet.getString("message");
                message += "\n";
            }
            JOptionPane.showMessageDialog(null,message + "\n");
            System.out.println("Request completed.");


        } catch (SQLException exception) {
            helper.getErrorMessage(exception);
        } finally {
            statement.close();
            connection.close();
            System.out.println("Connection closed.");
        }
    }
}
