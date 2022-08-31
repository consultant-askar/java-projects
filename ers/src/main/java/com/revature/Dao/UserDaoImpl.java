package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;



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
            e.printStackTrace();
        }

         return user;
    }



    @Override
    public void createUser(User user) {
        
        try {
            
            Connection conn = ConnectionUtil.getConnection();

            String sql = "insert into users (username, password, first_name, last_name, email) values ( ?, ?, ?, ?, ?);";

            PreparedStatement ps = conn.prepareStatement(sql);

                ps.setString(1, user.getUsername());
                ps.setString(2, user.getPassword());
                ps.setString(3, user.getFirstname());
                ps.setString(4, user.getLastname());
                ps.setString(5, user.getEmail());
               

            ps.executeUpdate();

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }





    @Override
    public List<Reimbursement> viewAllMyRR(String username) {
        
             List<Reimbursement> userReimb = new ArrayList<>();

        try (Connection conn = ConnectionUtil.getConnection()) {
            String sql = "select r.reimb_amount, r.reimb_submitted, r.reimb_resolved, r.reimb_description, r.reimb_status_id, r.reimb_type_id from reimbursement r inner join users u on r.reimb_author_fk  = u.user_id where u.username = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                userReimb.add(new Reimbursement (rs.getDouble(1),
                        rs.getDate(2),
                        rs.getDate(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6)));
                       
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userReimb;
    }






        
}
