package com.revature.Services;

import com.revature.Models.User;
import com.revature.Dao.*;



public class EmployeeService {

    UserDao userDao;

    public EmployeeService(){
        this.userDao = new UserDaoImpl();
    }

    public EmployeeService(UserDao userDao){
        this.userDao = userDao;
    }

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

    public User getUserGivenUsername(String username){
        return userDao.getUserByUsername(username);
    }

    public User createUser(User userToCreate){

        User userFromDb = userDao.getUserByUsername(userToCreate.getUsername());

        if(userFromDb == null){
            userDao.createUser(userToCreate);
            userFromDb = userDao.getUserByUsername(userToCreate.getUsername());
            return userFromDb;
        }

        return null;
    }
    
}
