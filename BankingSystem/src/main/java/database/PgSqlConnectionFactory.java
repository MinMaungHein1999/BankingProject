package main.java.database;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PgSqlConnectionFactory implements  ConnectionFactory{

    private String url;
    private String username;
    private String password;
    private Connection connection;

    public PgSqlConnectionFactory(){
        String resourceName = "application.properties";
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        Properties properties = new Properties();
        try (InputStream resourceStream = loader.getResourceAsStream(resourceName)){


            properties.load(resourceStream);

            this.url = properties.getProperty("db.url");
            this.username = properties.getProperty("db.username");
            this.password = properties.getProperty("db.password");

        } catch (Exception e){
            System.out.println("Failed to load database configuration:"+ e.getMessage());
        }
    }

    @Override
    public Connection createConnection(){
        System.out.println(this.url);
        System.out.println(this.username);
        System.out.println(this.password);
        try {
            this.connection = DriverManager.getConnection(this.url, this.username, this.password);
            return  this.connection;
        }catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return null;
    }

    @Override
    public void closeConnection() {
        try {
            if (this.connection != null && !this.connection.isClosed()) {
                this.connection.close();
            }
        }catch(SQLException e){
            System.err.println("Failed to close connection : "+ e.getMessage());
        }
    }
}
