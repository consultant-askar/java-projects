package com.revature.services;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImplementation;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImplementation;
import com.revature.models.Employee;
import com.revature.models.User;


public class EmployeeService {

    EmployeeDao employeeDao;

    public EmployeeService(){
        this.employeeDao = new EmployeeDaoImplementation();
    }
        // new employee 
    public EmployeeService(EmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }
    
    UserDao userDao;


    public EmployeeService(UserDao userDao){
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

    public User createUser(User euserToCreate){

        User userFromDb = userDao.getUserByUsername(euserToCreate.getUsername());

        if(userFromDb == null){
            userDao.createUser(euserToCreate);
            return euserToCreate;
        }

        return null;
    }




}
