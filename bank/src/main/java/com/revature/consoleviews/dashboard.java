package com.revature.consoleviews;

import java.util.List;

import com.revature.models.UserAccount;
import com.revature.models.Employee;
import com.revature.models.PendingAccounts;
import com.revature.models.User;
import com.revature.services.PendingAccountService;
import com.revature.services.UserAccountService;
import com.revature.util.InputUtil;
import com.revature.services.EmployeeService;
import com.revature.services.UserService;

public class dashboard {

    
    UserAccountService userAccountService = new UserAccountService();
    PendingAccountService pAccountService = new PendingAccountService();
    InputUtil inputUtil = new InputUtil();
   
    public void view(User userFromDb) {
        

        Boolean running = true;
        while(running){
            System.out.println("Welcome " + userFromDb.getFirstname());
            printAccounts(userFromDb);
          
            System.out.println("\n\n1) Apply For New Account\n2) Deposite\n3) Withdraw\n4) Check Balance\n5 Delete Account");

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
                    // Integer accountNo = inputUtil.retrieveInt( "Enter account number :");                  
                    // Float amount = Float.parseFloat(inputUtil.retrieveString("Enter Amount to be deposited: "));
                    // this.userAccountService.deposite(accountNo, amount);
                    
                    Integer accountNo = inputUtil.retrieveInt( "Enter account number :");                  
                    Float amount = inputUtil.retrieveFloat("Enter Amount to be deposited: ");
                    this.userAccountService.deposite(accountNo, amount);

                  
                    break;
                case "3":
                   // withdraw
                   Integer accountNow = inputUtil.retrieveInt( "Enter account number :");                  
                   Float amountw = Float.parseFloat(inputUtil.retrieveString("Enter Amount to be deposited: "));
                   this.userAccountService.withdraw(accountNow, amountw);
                 

                    break;
                case "4": 
                // check balance
                     printAccounts(userFromDb);
                   
                  
                    break;
                case "5":
                    //delete account
                    Integer accountToDelete = inputUtil.retrieveInt( "Enter account number you want to delete:");                  
                    
                    this.userAccountService.deleteUserAccount(accountToDelete);
                    System.out.println("Account deleted.");

                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("invalid input..please try again");
                    break;
            }

        }
        
    }
    /////////////////////////////
     private void printAccounts(User userFromDb){
       List<UserAccount> accounts = this.userAccountService.getAllAccountsGivenUserId(userFromDb.getId());

           
         for(UserAccount account : accounts){
            System.out.println(account);
           }
     }

    
     /*************************************************** */

     EmployeeService employeeService = new EmployeeService();
     public void view(Employee employeeFromDb) {
        

        Boolean running = true;
        while(running){
            System.out.println("Welcome " + employeeFromDb.getFirstname() + employeeFromDb.getLastname());
            
          
            System.out.println("\n\n1 ) View all accounts in the system\n2 ) View pending account requests\n0 ) EXIT");

            String input = inputUtil.retrieveString("Choose: ");

            switch (input) {
                case "1":
                List<UserAccount> accounts = this.employeeService.getAllUserAccounts();

           
                for(UserAccount account : accounts){
                System.out.println(account);
                }

                break;
                    
                case "2":

                List<PendingAccounts> accountsP = this.pAccountService.getAllPendings();

        
                for(PendingAccounts account : accountsP){
                System.out.println(account);
                }
                
                break; 

                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("invalid input..please try again..");
                break;
            }

        }
        
    }


  
}
 

