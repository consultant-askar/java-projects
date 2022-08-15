package com.revature;

import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.consoleviews.MainMenu;
import com.revature.dao.UserDao;
import com.revature.dao.UserDaoImplementation;
import com.revature.models.User;
import com.revature.util.InputUtil;

/**
 * Bank App
 *  register a new user
 *  login as a new user
 *  
 * What does a user need?
 *      - username (unique)
 *      - password
 *      - firstname
 *      - lastname
 *
 */
public class App 
{
    static Logger logger = LogManager.getLogger(App.class);
    public static void main( String[] args )
    {
        MainMenu mainMenu = new MainMenu();
        mainMenu.view();



        /* 
         * Log4j allows to log exceptions into a file
         * 
         * 
         * log4j has logging priorities:
         * All > debug > info > warn > error > fatal
         * 
         */



    }
}