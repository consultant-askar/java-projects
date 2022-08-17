package com.revature.dao;

import com.revature.models.PendingAccounts;
import java.util.List;


public interface PendingAccountDao {


void approveCustomersPengingAccount(PendingAccounts pendingAccount);

void denyCustomersPengingAccount(PendingAccounts pendingAccount);

List<PendingAccounts> getAllPendings();


    
}
