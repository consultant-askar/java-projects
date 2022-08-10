package com.revature;

import java.util.Scanner;
import com.revature.models.User;
import com.revature.store.Store;
import com.revature.util.InputUtil;
import com.revature.consoleviews.MainMenu;;


/**
 * Grocery List App
 *  register a new user  
 *  login as a new user
 *  When I am logged in:
    - create new grocery list item
      be able to define: 
        qty of that item
        value to see if item in the cart
    - delete a grocey list item
    - update if the item in the cart
  must persist the data (eventually)
    ***********************************
    What does a user need?
        - username (unique)
        - password
        - firstname
        - lastname
 */
public class App 
{
    public static void main( String[] args )
    {
       MainMenu mainMenu = new MainMenu();
       mainMenu.view();


    }


}
