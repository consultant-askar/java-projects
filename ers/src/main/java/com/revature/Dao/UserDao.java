package com.revature.Dao;
import com.revature.Models.*;
import java.util.List;



public interface UserDao {

    
    User getUserByUsername(String username);


   // List <Reimbursement> viewMyPastReimbRequests();


    //void requestNewReimb (Reimbursement reimbursement);

    void createUser(User user);

    
}
