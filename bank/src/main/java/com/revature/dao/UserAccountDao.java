package com.revature.dao;
import com.revature.models.UserAccount;
import java.util.List;


public interface UserAccountDao {

    void createUserAccount(UserAccount useraccount);
    void deleteUserAccount(UserAccount useraccount);
    List<UserAccount>getAllAccountsGivenUserId(Integer userId);
}



