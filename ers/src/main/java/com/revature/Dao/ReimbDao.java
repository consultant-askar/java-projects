package com.revature.Dao;

import java.util.List;

import com.revature.Models.Reimbursement;





public interface ReimbDao {

List<Reimbursement>viewAllReimb();


List<Reimbursement>getAllReimbByStatus();



void approveOrDeny(Reimbursement reimbursement);

    
}
