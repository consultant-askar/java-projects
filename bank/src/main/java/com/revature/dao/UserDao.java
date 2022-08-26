package com.revature.dao;

import java.util.List;
import com.revature.models.User;





public interface UserDao {

List<User> getAllUsers();

User getUserByUsername(String usertname);

void createUser(User userToCreate);
    
}
