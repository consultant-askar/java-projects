package com.revature.consoleviews;

import java.util.Scanner;

import com.revature.models.User;
import com.revature.services.UserService;
import com.revature.store.Store;
import com.revature.util.InputUtil;

public class MainMenu {

    UserService userService = new UserService();
    InputUtil inputUtil = new InputUtil();
    
    public void view(){
        //scanner allows us to take input from the console
        Scanner scanner = new Scanner(System.in);
        Boolean running = true;

        while(running){
            System.out.println( "Grocery List App!\n1) login\n2) register\n0) EXIT" );
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    //recieving input for username
                    String usernameInput = inputUtil.retrieveString("Username: ");
                    String passwordInput = inputUtil.retrieveString("Password: ");

                    Boolean areCredentialsValid = userService.validateCredentials(new User(usernameInput, passwordInput));

                    if(areCredentialsValid){
                        System.out.println("Welcome Fam");
                    }else{
                        System.out.println("Invalid username or password");
                    }

                    break;
                case "2":
                    //some logic for register
                    //recieving input for username
                    String usernameInputReg = inputUtil.retrieveString("Username: ");
                    String passwordInputReg = inputUtil.retrieveString("Password: ");
                    String firstNameInputReg = inputUtil.retrieveString("First Name: ");
                    String lastNameInputReg = inputUtil.retrieveString("Last Name: ");

                    User userToCreate = new User(usernameInputReg, passwordInputReg, firstNameInputReg, lastNameInputReg);

                    User userFromDb = this.userService.createUser(userToCreate);

                    if(userFromDb == null){
                        System.out.println("Username already exists... aborting");
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
