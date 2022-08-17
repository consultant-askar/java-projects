package com.revature.models;

public class PendingAccounts {

    private Integer accountNumber;
    private String accountType;
    private String details;
    private Boolean approveCreation;
    private Integer userIdFk;

    public PendingAccounts() {
    }


    public PendingAccounts(Integer accountNumber, String accountType, String details, Boolean approveCreation, Integer userIdFk) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.details = details;
        this.approveCreation = approveCreation;
        this.userIdFk = userIdFk;
    }


    public PendingAccounts(String accountType, String details, Boolean approveCreation, Integer userIdFk) {
        
        this.accountType = accountType;
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
            ", details='" + getDetails() + "'" +
            ", approveCreation='" + isApproveCreation() + "'" +
            ", userIdFk='" + getUserIdFk() + "'" +
            "}";
    }
    
}
