package com.revature.services;

import java.util.List;
import com.revature.dao.UserAccountDao;
import com.revature.dao.UserAccountDaoImplementation;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImplementation;
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

    
}
