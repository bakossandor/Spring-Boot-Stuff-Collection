package com.sandor;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:C:\\PROJECTS2\\FOLLOWING-SPRING-COURSE\\jdbc-playground\\data.db");
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE IF NOT EXISTS users (name TEXT, phone INTEGER, email TEXT)");
            statement.execute("INSERT INTO users (name, phone, email) VALUES('Sándor', 000, 'my@mail.com')");
            statement.execute("SELECT * FROM users");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                System.out.println("name: " + resultSet.getString("name"));
            }
            resultSet.close();

            ResultSet resultSet1 = statement.executeQuery("SELECT * FROM users");
            while (resultSet1.next()) {
                System.out.println("name: " + resultSet.getString("name"));
            }
            resultSet1.close();

            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println("Database exeption: " + e.getMessage());
        }

    }
}
