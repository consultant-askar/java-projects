package com.revature.services;

import java.util.List;

import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImplementation;
import com.revature.models.UserAccount;

public class UserAccountService {

    GroceryItemDao groceryItemDao = new GroceryItemDaoImpl();

    public void createGroceryItem(GroceryItem groceryItem){
        this.groceryItemDao.createGroceryItem(groceryItem);
    }

    public List<GroceryItem> getAllGroceryItemsGivenUserId(Integer userId){
        return this.groceryItemDao.getAllItemsGivenUserId(userId);
    }

    public void deleteAGroceryItemGivenGroceryId(Integer groceryItemId){
        this.groceryItemDao.deleteGroceryItem(groceryItemId);
    }

    
}
