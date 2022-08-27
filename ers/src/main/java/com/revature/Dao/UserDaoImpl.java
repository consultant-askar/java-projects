package com.revature.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.Models.User;
import com.revature.Util.ConnectionUtil;

public class UserDaoImpl implements UserDao {

    @Override
    public User getUserByUsername(String username) {
       
        User user = null;
        
        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "select * from users where username = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);  
            ResultSet rs = ps.executeQuery();  
            while (rs.next()) {
                user = new User (rs.getInt(1),
                                rs.getString(2), 
                                rs.getString(3),
                                rs.getString(4), 
                                rs.getString(5), 
                                rs.getString(6), 
                                rs.getInt(7));
                            } 

        } catch (SQLException e) {
            System.out.println(e);
        }

            return user;
        }





    @Override
    public void createUser(User user) {
        
        
        try {
            
            Connection conn = ConnectionUtil.getConnection();

            String sql = "insert into users (username, password, first_name, last_name, email, user_role_id_fk) values ( ?, ?, ?, ?, ?, ?);";

            PreparedStatement ps = conn.prepareStatement(sql);

                ps.setString(1, user.getUsername());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getFirstname());
                ps.setString(4, user.getLastname());
                ps.setString(5, user.getEmail());
                ps.setInt(6, user.getUserRole());

            ps.executeUpdate();

            conn.close();

        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }






        
}
