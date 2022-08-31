package com.revature.dao;
import com.revature.models.*;
import java.util.List;



public interface UserDao {

    //--
    User getUserByUsername(String username);



    // RR : Reimb Request   //--
    List <Reimbursement> viewAllMyRR(String username);

   

    //--
    void createUser(User user);

    
}
