package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConnectionUtil {

    /* 
     * Steps to setup log4j
     * 1. add log4j-core and lo4j-api to dependencies
     * 2. add the config file to the project
     *      - this is inside a folder called resources under the main folder
     * 
     * Steps to utilize log4j
     * 1. create variable Logger logger = LogManager.getLogger([CLASS YOU ARE IN]);
     * 2. logger.error();     
     * 
     */
    static Logger logger = LogManager.getLogger(ConnectionUtil.class);

     //url syntax: jdbc:postgresql://[DBEndpoint]/[DB]
    //System.getenv() is a method to retrieve values of environment variables
    private static final String url = "jdbc:postgresql://" + System.getenv("database-1.ctwtedjgef6h.us-west-2.rds.amazonaws.com") + "/bankmini";
    private static final String username = System.getenv("postgres");
    private static final String password = System.getenv("Revlearning22");

    public static Connection getConnection(){

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            logger.error("connection attemp error", e);
        }

        return conn;
    }
}
