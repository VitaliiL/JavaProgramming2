package project;

import lombok.AllArgsConstructor;

import java.sql.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class JdbcConnection {
    private static Connection connection;
    private static final String DB_URL = "jdbc:h2:mem:mydatabase";
    private static final String DB_DRIVER = "org.h2.Driver";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName(DB_DRIVER);

        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            Statement statement = connection.createStatement();
            statement.executeUpdate("create table posts(id identity, post_date timestamp, post_message varchar(255))");

            PreparedStatement preparedStatement = connection
                    .prepareStatement(
                            "insert into posts(post_date, post_message) " +
                                    "values (?, ?)");
            preparedStatement.setTimestamp(1, Timestamp.from(Instant.now()));
            preparedStatement.setString(2, "Hello, World!");
            preparedStatement.execute();

            List<Record> records = new ArrayList<>();

            ResultSet resultSet = statement
                    .executeQuery("SELECT * FROM posts");

            while (resultSet.next()) {
                long id = resultSet.getLong("id");
                Timestamp postDate = resultSet.getTimestamp("post_date");
                String postMessage = resultSet.getString("post_message");

                Record record = new Record(id, postDate, postMessage);
                records.add(record);
            }

            System.out.println("records = " + records);
        } catch (SQLException e) {
            System.err.println("Data base is'not available.");
            e.printStackTrace();
        }
    }
}