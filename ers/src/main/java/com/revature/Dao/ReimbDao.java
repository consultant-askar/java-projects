package com.revature.dao;

import java.util.List;

import com.revature.models.Reimbursement;




// The Manager will utilize this dao

public interface ReimbDao {


List<Reimbursement>getAllReimbByStatus(Integer reimbStatusId);


List<Reimbursement>getAllReimbursements();

// RR: Reimbursement Request

void approveOrDenyRR(Integer statusID, Integer authorId, Integer reimbId);



void createNewRR(Reimbursement reimbursement);

    
}
