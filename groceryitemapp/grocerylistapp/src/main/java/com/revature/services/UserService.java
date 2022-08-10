package com.revature.services;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoJavaImpl;
import com.revature.models.User;
import com.revature.store.Store;

/* 
 * Service layer is for business logic...
 *      meaning if you need to write some algorithm to meet a requirement of your
 *          project, it will happen in this layer
 * 
 */
public class UserService {

    UserDao userDao = new UserDaoJavaImpl();
    

    public boolean validateCredentials(User credentials) {

        User userFromStore = userDao.getUserByUsername(credentials.getUsername());
        if(userFromStore == null){
            return false;
        }

        if(userFromStore.getPassword().equals(credentials.getPassword())){
            return true;
        }
    

        return false;
    }

    public User getUserGivenUsername(String username){
        return userDao.getUserByUsername(username);
    }


    public User createUser(User userToCreate){

        User userFromDb = userDao.getUserByUsername(userToCreate.getUsername());

        if(userFromDb == null){
            userDao.createUser(userToCreate);
            return userToCreate;
        }

        return null;
    }
}
