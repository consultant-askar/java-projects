package com.revature.services;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImplementation;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImplementation;
import com.revature.models.Employee;



public class EmployeeService {

    EmployeeDao employeeDao;

    public EmployeeService(){
        this.employeeDao = new EmployeeDaoImplementation();
    }
        // new employee 
    public EmployeeService(EmployeeDao employeeDao){
        this.employeeDao = employeeDao;
    }
    
    


         /******************************* */
    public boolean validateCredentials(Employee credentials) {

        Employee employeeFromDb = employeeDao.getEmployeeByUsername(credentials.getUsername());
        if(employeeFromDb == null){
            return false;
        }

        if(employeeFromDb.getPassword().equals(credentials.getPassword())){
            return true;
        }
        return false;
    }
        /**************************** */

    public Employee getEmployeeGivenUsername(String username){
        return employeeDao.getEmployeeByUsername(username);
    }

        /*************************************** */
        /************************************** */

   




}
