package com.revature.dao;

import com.revature.models.User;
import com.revature.store.Store;
import java.util.List;

public interface UserDao {
    
    
    //  public User[] getAllUsers(){
    //   return Store.users;
    //  }
     

  List <User> getAllUsers();

  User getUserByUserName(String username);

  void createUser(User user);


}
