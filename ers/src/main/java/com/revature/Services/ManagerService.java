package com.revature.services;

import java.util.List;
import com.revature.dao.*;
import com.revature.models.*;




public class ManagerService {
    
    ReimbDao reimbDao;
    UserDao userDao;

    public ManagerService(){
        this.userDao = new UserDaoImpl();
    }

    public ManagerService(UserDao userDao){
        this.userDao = userDao;
    }


    public boolean validateCredentials(User credentials) {

        User userFromDb = userDao.getUserByUsername(credentials.getUsername());
        if (userFromDb == null) {
            return false;
        }

        if (userFromDb.getPassword().equals(credentials.getPassword())) {
            return true;
        }
        return false;
    }

    

    public List<Reimbursement>getAllRBS(Integer reimbStatusId){
        return reimbDao.getAllReimbByStatus(reimbStatusId);
    }


    public List<Reimbursement>getAllR(){
        return reimbDao.getAllReimbursements();
    }


    public void approveOrDeny(Integer statusID, Integer authorId, Integer reimbId){
             reimbDao.approveOrDenyRR(statusID, authorId, reimbId);
    }




}
