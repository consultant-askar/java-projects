package com.revature.models;
/*
    table user_accounts ( 
	-account_no serial primary key,
	-account_type varchar (50) not null,
	-balance real default 0.0,
	-details varchar(250) default null,
	-approve_creation boolean default false,
	-user_id_fk int references users (id) not null
  */

public class UserAccount {

    private Integer accountNumber;
    private String accountType;
    private float balance;
    private String details;
    private Boolean approveCreation;
    private Integer userIdFk;

    public UserAccount(Integer accountNumber, String accountType, float balance, String details, Boolean approveCreation, Integer userIdFk) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;
        this.details = details;
        this.approveCreation = approveCreation;
        this.userIdFk = userIdFk;
    }
    public UserAccount(String accountType, float balance, String details, Boolean approveCreation, Integer userIdFk) {

        this.accountType = accountType;
        this.balance = balance;
        this.details = details;
        this.approveCreation = approveCreation;
        this.userIdFk = userIdFk;
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

    public Boolean isApproveCreation() {
        return this.approveCreation;
    }

    public Boolean getApproveCreation() {
        return this.approveCreation;
    }

    public void setApproveCreation(Boolean approveCreation) {
        this.approveCreation = approveCreation;
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
            ", approveCreation='" + isApproveCreation() + "'" +
            ", userIdFk='" + getUserIdFk() + "'" +
            "}";
    }
        


}