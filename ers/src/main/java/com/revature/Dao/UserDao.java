package com.revature.Dao;
import com.revature.Models.*;
import java.util.List;



public interface UserDao {

    
    User getUserByUsername(String username);

    // RR : Reimb request
    List <Reimbursement> viewAllMyRR(User user);


    void createNewRR (Reimbursement reimbursement);


    void createUser(User user);

    
}
