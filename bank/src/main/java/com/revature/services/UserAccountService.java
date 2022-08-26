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
    public void deleteUserAccount(Integer accountToDelete){
        this.userAccountDao.deleteUserAccount(accountToDelete);
    }

    

    public void depositeFunds(Integer accountId, String amountToDeposite){
        UserAccount userAccount = userAccountDao.getAccountById(accountId);
        Float depositeAmount = 0.0f;
        try{
            depositeAmount = Float.parseFloat(amountToDeposite);

        }catch(NumberFormatException e){
            System.out.println("invalid input");
        }
        if(depositeAmount < 1) {
            System.out.println("Amount must be greater than one dollar");
        }
        depositeAmount +=  userAccount.getBalance();
        //depositeFunds(userAccountDao.getAccountById(accountId), depositeAmount);
        //return true;
    }



    public boolean deposite(Integer accountId, Float amount) {

        
        
        UserAccount account = userAccountDao.getAccountById(accountId);


        Float depositeAmount = 0.0f;
        try{
            depositeAmount = amount;

        }catch(NumberFormatException e){
            System.out.println("invalid input");
        }
        if(depositeAmount < 1) {
            System.out.println("Amount must be greater than one dollar");
        }
        
        
    
        this.userAccountDao.deposite(accountId, amount);


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
