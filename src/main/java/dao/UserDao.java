package dao;

import domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    // 인터페이스, facotory, spring

    private ConnectionMaker connectionMaker;

    public UserDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) throws SQLException, ClassNotFoundException {
        Connection c = connectionMaker.makeConnection();
        PreparedStatement ps = c.prepareStatement("INSERT INTO users(id, name, password) VALUES(?, ?, ?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getId());
        ps.executeUpdate();
        ps.close();
        c.close();
    }

    public User findById(String id) throws SQLException, ClassNotFoundException {
        Connection c = connectionMaker.makeConnection();
        PreparedStatement ps = c.prepareStatement("SELECT id, name, password FROM users WHERE id=?");
        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User(rs.getString("id"),rs.getString("name"),rs.getString("password"));

        rs.close();
        ps.close();
        c.close();
        return user;
    }

    public static void main(String[] args) {
        UserDao userDao = new User
    }
}
