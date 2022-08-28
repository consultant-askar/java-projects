package com.revature.Dao;

import java.util.List;

import com.revature.Models.Reimbursement;




// The Manager will utilize this dao

public interface ReimbDao {


List<Reimbursement>getAllReimbByStatus(Integer reimbStatusId);

List<Reimbursement>getAllReimbursements();

// RR: Reimbursement Request

void approveOrDenyRR(Integer reimbStatusId);

    
}
