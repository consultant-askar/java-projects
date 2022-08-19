package com.revature.services;

import java.util.List;

import com.revature.dao.PendingAccDaoImpl;
import com.revature.dao.PendingAccountDao;
import com.revature.models.PendingAccounts;

public class PendingAccountService {

    PendingAccountDao pendingAccountDao = new PendingAccDaoImpl();
    
   

   public void creatRequest(PendingAccounts pendingAccounts) {
        this.pendingAccountDao.creatRequest(pendingAccounts);

   }

   public List<PendingAccounts> getAllPendings() { 
   return this.pendingAccountDao.getAllPendings();

}


}
