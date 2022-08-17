package com.revature.consoleviews;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.UserAccount;
import com.revature.models.User;
import com.revature.services.UserAccountService;
import com.revature.util.InputUtil;

public class dashboard {

    private static final String deleteUserAccount = null;
    UserAccountService userAccountService = new UserAccountService();
    InputUtil inputUtil = new InputUtil();
    private String accountType;
    private float balance;

    public void view(User userFromDb) {
        

        Boolean running = true;
        while(running){
            System.out.println("Welcome " + userFromDb.getFirstname());
            printItems(userFromDb);
            System.out.println("\n\n1) Create New Account\n2) Delete Account\n3) List All Accounts I Have\n0) LOGOUT");

            String input = inputUtil.retrieveString("Choose: ");

            switch (input) {
                case "1":
                    Integer accountNumber = inputUtil.retrieveInt("Account Number: ");
                    
                    this.userAccountService.createUserAccount(new UserAccount());
                    System.out.println("Account Created");
                    break;
                case "2":
                    // delete account
                    
                    break;
                case "3":
                   // List All accounts

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
       List<UserAccount> accounts = this.userAccountService.getAllAccountsGivenUserId(userFromDb.getId());

         for(UserAccount account : accounts){
            System.out.println(account);
        }
    }
    
}
