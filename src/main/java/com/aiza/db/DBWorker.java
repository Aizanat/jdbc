package com.aiza.db;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class DBWorker {
    private static final String URL = "jdbc:mysql://localhost:3306/aizanat";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    Connection connection;

    public DBWorker() {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);

            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println(connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public User getUser(int id) throws SQLException {
        String query = "SELECT login, password FROM user WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
        User user = new User();
        while (resultSet.next()) {
            user.setLogin(resultSet.getString(1));
            user.setPassword(resultSet.getString(2));
        }
        return user;
    }

}



