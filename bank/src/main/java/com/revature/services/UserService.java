package com.revature.services;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImplementation;
import com.revature.models.User;


public class UserService {

    UserDao userDao;

    public UserService(){
        this.userDao = new UserDaoImplementation();
    }

    public UserService(UserDao userDao){
        this.userDao = userDao;
    }
         /******************************* */
    public boolean validateCredentials(User credentials) {

        User userFromDb = userDao.getUserByUsername(credentials.getUsername());
        if(userFromDb == null){
            return false;
        }

        if(userFromDb.getPassword().equals(credentials.getPassword())){
            return true;
        }
        return false;
    }
        /**************************** */

    public User getUserGivenUsername(String username){
        return userDao.getUserByUsername(username);
    }

        /*************************************** */
        /************************************** */

    public User createUser(User userToCreate){

        User userFromDb = userDao.getUserByUsername(userToCreate.getUsername());

        if(userFromDb == null){
            userDao.createUser(userToCreate);
            return userToCreate;
        }

        return null;
    }
}
