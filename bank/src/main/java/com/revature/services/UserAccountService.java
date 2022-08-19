package com.revature.services;

import java.util.List;
import com.revature.dao.UserAccountDao;
import com.revature.dao.UserAccountDaoImplementation;
import com.revature.models.UserAccount;



public class UserAccountService {
    
        // Service layer utilizes Dao layser
    UserAccountDao userAccountDao = new UserAccountDaoImplementation();

            /********** */
    public void createUserAccount(UserAccount userAccount){
        this.userAccountDao.createUserAccount(userAccount);
        }
            /******** */
    public List<UserAccount> getAllAccountsGivenUserId(Integer userId){
        return this.userAccountDao.getAllAccountsGivenUserId(userId);
    }
            /********* */
    public void deleteUserAccount(UserAccount useraccount){
        this.userAccountDao.deleteUserAccount(useraccount);
    }

    

    public boolean deposite(Integer userAcc, Float amount) {

        
        if (amount < 0) { 
            System.out.println("Amount must be positive number");
         return false;

        }
        // send information to Dao
    
        this.userAccountDao.deposite(userAcc, amount);


        return true;
    }

    
    public boolean withdraw(Integer userAcc, Float amount) {

        
        if (amount < 0) { 
            System.out.println("Amount must be positive number");
         return false;

        }
        
    
        this.userAccountDao.withdraw(userAcc, amount);


        return true;
    }

}
