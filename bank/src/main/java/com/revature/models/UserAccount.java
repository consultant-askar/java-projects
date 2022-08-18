package com.revature.models;


public class UserAccount {

    private Integer accountNumber;
    private String accountType;
    private float balance;
    private String details;
    private Integer userIdFk;

    
    public UserAccount() {
    }

    public UserAccount(Integer accountNumber, String accountType, float balance, String details, Integer userIdFk) {
    this.accountNumber = accountNumber;
    this.accountType = accountType;
    this.balance = balance;
    this.details = details;
    this.userIdFk = userIdFk;
    }

    public UserAccount(String accountType, float balance, String details, Integer userIdFk) {
        
        this.accountType = accountType;
        this.balance = balance;
        this.details = details;
        this.userIdFk = userIdFk;
        }
    
    public UserAccount(Integer accountNumber, float balance){
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public Integer getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountType() {
        return this.accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public float getBalance() {
        return this.balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getUserIdFk() {
        return this.userIdFk;
    }

    public void setUserIdFk(Integer userIdFk) {
        this.userIdFk = userIdFk;
    }

    @Override
    public String toString() {
        return "{" +
            " accountNumber='" + getAccountNumber() + "'" +
            ", accountType='" + getAccountType() + "'" +
            ", balance='" + getBalance() + "'" +
            ", details='" + getDetails() + "'" +
            ", userIdFk='" + getUserIdFk() + "'" +
            "}";
    }

   
        


}
