package com.revature.dao;
import com.revature.models.UserAccount;
import java.util.List;


public interface UserAccountDao {

    void createUserAccount(UserAccount useraccount);
    void deleteUserAccount(UserAccount useraccount);
    List<UserAccount>getAllAccountsGivenUserId(Integer userId);

    /************************************ */
    
    void transferMoney(UserAccount accountNumber, UserAccount accountNumberAccount, UserAccount balance);
    
    void deposite(UserAccount accountNumber, UserAccount balance);
    void withdraw(UserAccount accountNumber, UserAccount balance);


}



