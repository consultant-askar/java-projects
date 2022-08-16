package com.revature.consoleviews;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.UserAccount;
import com.revature.models.User;
import com.revature.services.UserAccountService;
import com.revature.util.InputUtil;

public class dashboard {

    UserAccountService userAccountService = new UserAccountService();
    InputUtil inputUtil = new InputUtil();

    public void view(User userFromDb) {
        

        Boolean running = true;
        while(running){
            System.out.println("Welcome " + userFromDb.getFirstname());
            printItems(userFromDb);
            System.out.println("\n\n1) Create New Account\n2) View Balance in Checking\n3) View Balance in Savings\n0)LOGOUT");

            String input = inputUtil.retrieveString("Choose: ");

            switch (input) {
                case "1":
                    String groceryName = inputUtil.retrieveString("Name of Item: ");
                    Integer groceryQty = inputUtil.retrieveInt("Amount: ");
                    this.groceryItemService.createGroceryItem(new GroceryItem(groceryName, groceryQty, userFromDb.getId()));
                    System.out.println("Item Created");
                    break;
                case "2":
                    Integer itemId = inputUtil.retrieveInt("Item Id: ");
                    this.groceryItemService.markInCartGivenGroceryId(itemId);
                    System.out.println("marked in cart if item id exists");
                    break;
                case "3":
                    Integer groceryItemId = inputUtil.retrieveInt("Item Id: ");
                    this.groceryItemService.deleteAGroceryItemGivenGroceryId(groceryItemId);
                    System.out.println("item deleted if item id exists");
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("invalid input");
                    break;
            }


        }
    }

    private void printItems(User userFromDb){
        List<GroceryItem> items = this.groceryItemService.getAllGroceryItemsGivenUserId(userFromDb.getId());

        for(GroceryItem item : items){
            System.out.println(item);
        }
    }
    
}
