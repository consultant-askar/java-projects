package com.revature;



import com.revature.controllers.*;
import com.revature.controllers.SessionController;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class App {
    public static void main( String[] args )
    {
       
    

        EmployeeController userController = new EmployeeController();
       // GroceryItemController groceryItemController = new GroceryItemController();
        SessionController sessionController = new SessionController();

        /*
         * addStaticFiles is how we are going to host our frontend
         * - you will put your frontend structure in the resources folder
         */
        Javalin app = Javalin.create(config -> {
            // Location.CLASSPATH is referencing the resources folder for maven
            config.addStaticFiles("/frontend", Location.CLASSPATH);
        }).start(9000);

        // register user
        app.post("/api/user", userController::register);

        // session endpoints
        app.get("/api/session", sessionController::checkSession);
        app.post("/api/session", sessionController::login);
        app.delete("/api/session", sessionController::logout);

     
        // grocery item endpoints
    //    app.get("/api/item", groceryItemController::getAllItemsGivenUserId);
    //    app.post("/api/item", groceryItemController::createItem);
    //    app.patch("/api/item/{itemId}", groceryItemController::markItemComplete);
    //    app.delete("/api/item/{itemId}", groceryItemController::deleteItem);
       
      

    }
}
