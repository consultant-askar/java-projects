package com.revature.dao;

import com.revature.models.Employee;
import com.revature.models.UserAccount;

import java.util.List;

public interface EmployeeDao {

    
    

    Employee getEmployeeByUsername(String username);
       
    void createUser(Employee employee);

        

    List<UserAccount> getAllUserAccounts();

   // List<> getAllPendingAccounts();

    //List<> getAllTransactions();

    //void approveOrDeny();



}
