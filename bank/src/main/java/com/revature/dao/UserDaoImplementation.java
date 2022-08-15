package com.revature.dao;

import java.util.List;
import java.util.logging.LogManager;
import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;

public class UserDaoImplementation implements UserDao {

     static Logger logger = LogManager.getLogger(UserDaoImplementation.class);

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        
        try {
            //this line creates an active connection to the database
            Connection conn = ConnectionUtil.getConnection();

            //sql that we will be executing
            String sql = "select * from users";
            PreparedStatement ps = conn.prepareStatement(sql);

            //execute the SQL statement and return the result set into the variable rs
            ResultSet rs = ps.executeQuery();

            //iterate through the result set
            while(rs.next()){
                users.add(new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }

            conn.close();
            
        } catch (SQLException e) {
            logger.error("Sql Exception Occured", e);
        }

        return users;
    }

    @Override
    public User getUserByUsername(String username) {
        
        User user = null;
        
        //try with resources will close the object thats within the parenthesis
        try(Connection conn = ConnectionUtil.getConnection()) {

            //sql that we will be executing
            String sql = "select * from users where username = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, username);

            //execute the SQL statement and return the result set into the variable rs
            ResultSet rs = ps.executeQuery();

            //iterate through the result set
            while(rs.next()){
                user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
            }
            
        } catch (SQLException e) {
            logger.error("Sql Exception Occured", e);
        }

        return user;
    }

    @Override
    public void createUser(User user) {
        
        try {
            //this line created creates an active connection to the database
            Connection conn = ConnectionUtil.getConnection();

            //sql that we will be executing
            String sql = "insert into users (username, password, firstname, lastname) values (?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);

            //the parameterIndex is references what questionmark we want to put a value in for
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getFirstname());
            ps.setString(4, user.getLastname());

            ps.executeUpdate();

            conn.close();
            
        } catch (SQLException e) {
            logger.error("Sql Exception Occured", e);
        }
    }
    
}
