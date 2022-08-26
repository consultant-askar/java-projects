package com.revature.Dao;

import java.util.List;

import com.revature.Models.Reimbursement;
import com.revature.Models.reimbursement;




public interface ReimbDao {

List<Reimbursement>viewAllReimb();


List<Reimbursement>getAllReimbByStatus();



void approveOrDeny(reimbursement reimbursement);

    
}
