package com.example.HelloWorld.DAO;

import com.example.HelloWorld.Entity.Developer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DevelopersDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/DemoProject";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "1516886";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<Developer> index() {
        List<Developer> developers = new ArrayList<Developer>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "select * from developers";
            ResultSet resultSet = statement.executeQuery(SQL);

            while(resultSet.next()) {
                Developer developer = new Developer();

                developer.setId(resultSet.getInt("id"));
                developer.setName(resultSet.getString("name"));
                developer.setNickname(resultSet.getString("nickname"));
                developer.setAge(resultSet.getInt("age"));
                developer.setEmail(resultSet.getString("email"));


                developers.add(developer);
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        return developers;
    }

    public Developer show(int id) {
        Developer developer = null;

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("select * from developers where id=?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            developer = new Developer();

            developer.setId(resultSet.getInt("id"));
            developer.setName(resultSet.getString("name"));
            developer.setNickname(resultSet.getString("nickname"));
            developer.setAge(resultSet.getInt("age"));
            developer.setEmail(resultSet.getString("email"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return developer;
    }

    public void save(Developer developer) {
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into developers values(?, ?, ?, ?, ?)");

            preparedStatement.setInt(1, developer.getId());
            preparedStatement.setString(2, developer.getName());
            preparedStatement.setString(3, developer.getNickname());
            preparedStatement.setInt(4, developer.getAge());
            preparedStatement.setString(5, developer.getEmail());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void delete(int id) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("delete from developers where id=?");

            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
