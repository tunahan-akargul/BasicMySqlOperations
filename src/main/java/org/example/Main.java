package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Transactions transactions = new Transactions();

        transactions.readMessage();
        transactions.insertMessage();

    }
}
