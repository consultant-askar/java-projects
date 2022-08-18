package com.revature.consoleviews;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.UserAccount;
import com.revature.models.PendingAccounts;
import com.revature.models.User;
import com.revature.services.PendingAccountService;
import com.revature.services.UserAccountService;
import com.revature.util.InputUtil;

public class dashboard {

    
    UserAccountService userAccountService = new UserAccountService();
    PendingAccountService pAccountService = new PendingAccountService();
    InputUtil inputUtil = new InputUtil();
   
    public void view(User userFromDb) {
        

        Boolean running = true;
        while(running){
            System.out.println("Welcome " + userFromDb.getFirstname());
            printAccounts(userFromDb);
            System.out.println("\n\n1) Apply For New Account\n2) Deposite\n3) Withdraw\n4) Check Balance\n5 Transfer Money");

            String input = inputUtil.retrieveString("Choose: ");

            switch (input) {
                case "1":
                    // apply (request) new account
                    String accountType = inputUtil.retrieveString("Account type: ");
                    Integer userId = inputUtil.retrieveInt( "User ID: ");
                    
                    this.pAccountService.creatRequest(new PendingAccounts(accountType, userId));
                   
                    System.out.println("Request was sent...waiting for approval");
                    
                    break;
                    
                case "2":
                    // deposite money
                    System.out.println("");
                    
                    break;
                case "3":
                   // withdraw

                    break;
                case "4": 
                // check balance
                    break;
                case "5":
                    //transfer money
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

     private void printAccounts(User userFromDb){
       List<UserAccount> accounts = this.userAccountService.getAllAccountsGivenUserId(userFromDb.getId());

         for(UserAccount account : accounts){
            System.out.println(account);
        }
    }
    
}
