package com.revature.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConnectionUtil {

    

    static String url = "jdbc:postgresql://database-1.ctwtedjgef6h.us-west-2.rds.amazonaws.com/ERS";
    private static final String username = "postgres";
    private static final String password = "Revlearning22";

    public static Connection getConnection(){

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {

            e.printStackTrace();
            //System.out.println(e); // check this line
        }

        return conn;
    }
}

