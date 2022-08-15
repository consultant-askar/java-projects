package com.revature.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.models.User;
import com.revature.util.ConnectionUtil;


public interface UserDao {

List<User> getAllUsers();

User getUserByUsername(String usertname);

void createUser(User user);
    
}
