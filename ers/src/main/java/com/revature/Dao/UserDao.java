package com.revature.Dao;
import com.revature.Models.*;
import java.util.List;



public interface UserDao {

    

    List<Reimbursement>viewMyPastTickets();


    void addNewReimbursement(Reimbursement reimbursement);



    
}
