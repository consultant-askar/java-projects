package com.revature;


import com.revature.consoleviews.MainMenu;


public class App 
{
   // static Logger logger = LogManager.getLogger(App.class);
    public static void main( String[] args )
    {
        MainMenu mainMenu = new MainMenu();
        mainMenu.view();


    }
}
