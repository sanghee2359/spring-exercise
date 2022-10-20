package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import static java.lang.System.getenv;

public class AWSConnectionMaker implements ConnectionMaker{
    @Override
    public Connection makeConnection() throws ClassNotFoundException, SQLException {
        Map<String, String> env = getenv();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection c = DriverManager.getConnection(env.get("DB_HOST"),env.get("DB_USER"),env.get("DB_PASSWORD"));
        return c;
    }
}
