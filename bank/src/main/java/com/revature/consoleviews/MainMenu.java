package com.revature.consoleviews;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.models.Employee;
import com.revature.models.User;
import com.revature.services.EmployeeService;
import com.revature.services.UserService;
import com.revature.util.InputUtil;


public class MainMenu {

    static Logger logger = LogManager.getLogger(MainMenu.class);

    UserService userService = new UserService();
    EmployeeService employeeService = new EmployeeService();
    InputUtil inputUtil = new InputUtil();

    /******************************************************* */

    public void view(){
        
        Scanner scanner = new Scanner(System.in);
        Boolean running = true;

        while(running){
            System.out.print( "Welcome to the Bank Application!\n1) Customer login\n2) New Customer registeration");
            System.out.print("\n3) Employee Login");
            System.out.println("\n0) EXIT");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                case "3":
                    //Login
                    String usernameInput = inputUtil.retrieveString("Username: ");
                    String passwordInput = inputUtil.retrieveString("Password: ");

                    Boolean areCredentialsValid = userService.validateCredentials(new User(usernameInput, passwordInput));

                    if(areCredentialsValid){
                        logger.info("User " + usernameInput + " successfully logged into system");
                        User userFromDb = this.userService.getUserGivenUsername(usernameInput);
                        new dashboard().view(userFromDb);
                    }else{
                        System.out.println("Invalid username or password");
                    }

                    break;
                case "2":
                
                    //new customer registration
                    
                    String usernameInputReg = inputUtil.retrieveString("Username: ");
                    String passwordInputReg = inputUtil.retrieveString("Password: ");
                    String firstNameInputReg = inputUtil.retrieveString("First Name: ");
                    String lastNameInputReg = inputUtil.retrieveString("Last Name: ");

                    User userToCreate = new User(usernameInputReg, passwordInputReg, firstNameInputReg, lastNameInputReg);

                    User userFromDb = this.userService.createUser(userToCreate);

                    if(userFromDb == null){
                        System.out.println("Username already exists... aborting");
                        System.out.println("Try again...");
                    }else{
                        System.out.println("User Created");
                    }     
                    
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
}
