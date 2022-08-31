package com.revature.controllers;

import java.util.List;

import com.revature.models.*;
import com.revature.services.*;
import io.javalin.http.Context;



public class EmployeeController {

    EmployeeService userService = new EmployeeService();



        public void getAllMyReimbursements(Context ctx){
            User user = ctx.sessionAttribute("user");
            if (user == null) {
                ctx.json(new JsonResponse(false, "no session found to retrieve item", null));
                return;
            }
            List<Reimbursement> reimbursements = userService.viewAllMyR(user.getUsername());
            ctx.json(new JsonResponse(true, "your reimbursements " + user.getFirstname(), reimbursements));
        }


        
        public void createItem(Context ctx){
            Reimbursement reimb = ctx.bodyAsClass(Reimbursement.class);
            User userFromSession = ctx.sessionAttribute("user");
            reimb.setAuthorFK(userFromSession.getUserId());
            userService.createNewReimbR(reimb);
            ctx.json(new JsonResponse(true, "Reimbursement Request created", null));
        }



    public void register(Context ctx){
        User userCredentials = ctx.bodyAsClass(User.class);

        User userFromDb = userService.createUser(userCredentials);

        if(userFromDb == null){
            ctx.json(new JsonResponse(false, "username already exists in the system", null));
        }else{
            ctx.json(new JsonResponse(true, "user created", userFromDb));
        }
    }
}

    

