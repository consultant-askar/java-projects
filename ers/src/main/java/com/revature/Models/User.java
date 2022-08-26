package com.revature.Models;

public class User {

    private Integer userId;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String userRole;

    public User() {
    }

    public User(String username, String password) {
        
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String firstName, String lastName, String email, String userRole) {
        
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userRole = userRole;
    }

    public User(Integer userId, String username, String password, String firstName, String lastName, String email, String userRole) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userRole = userRole;
    }

    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserRole() {
        return this.userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }



   

    @Override
    public String toString() {
        return "{" +
            " userId='" + getUserId() + "'" +
            ", username='" + getUsername() + "'" +
            ", password='" + getPassword() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", email='" + getEmail() + "'" +
            ", userRole='" + getUserRole() + "'" +
            "}";
    }
    
}
