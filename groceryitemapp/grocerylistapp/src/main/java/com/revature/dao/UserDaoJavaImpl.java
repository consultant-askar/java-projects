package com.revature.dao;

import java.util.List;

import com.revature.models.User;
import com.revature.store.Store;

public class UserDaoJavaImpl implements UserDao{

    @Override
    public List<User> getAllUsers() {
        return Store.users;
    }

    @Override
    public User getUserByUsername(String username) {

        User userFromDb = null;

        for (User user : Store.users) {
            if (user == null) {
                break;
            }

            if (user.getUsername().equals(username)) {
                userFromDb = user; 
                break;
            }
        }

        return userFromDb;
    }

    @Override
    public void createUser(User user) {
        Store.users.add(user);  
    }
    
}