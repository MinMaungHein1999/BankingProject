package main.java.database;

import java.io.FileInputStream;
import java.io.IOException;
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
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("application.properties"));
            this.url = properties.getProperty("db.url");
            this.username = properties.getProperty("db.username");
            this.password = properties.getProperty("db.password");

        } catch (Exception e){
            System.out.println("Failed to load database configuration:"+ e.getMessage());
        }
    }

    @Override
    public Connection createConnection(){
        try {
            this.connection = DriverManager.getConnection(this.url, this.username, this.password);

        }catch (SQLException e) {
            System.out.print(e.getMessage());
        }
        return this.connection;
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
