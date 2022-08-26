package com.revature.models;

import java.sql.Date;

public class Transactions {

    private Integer id;
    private String transactionType;
    private String details;
    private Date transactionTime;

    public Transactions(Integer id, String transactionType, String details, Date transactionTime) {
        this.id = id;
        this.transactionType = transactionType;
        this.details = details;
        this.transactionTime = transactionTime;
    }

    public Transactions(String transactionType, String details, Date transactionTime) {
        
        this.transactionType = transactionType;
        this.details = details;
        this.transactionTime = transactionTime;
    }




    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTransactionType() {
        return this.transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getTransactionTime() {
        return this.transactionTime;
    }

    public void setTransactionTime(Date transactionTime) {
        this.transactionTime = transactionTime;
    }



    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", transactionType='" + getTransactionType() + "'" +
            ", details='" + getDetails() + "'" +
            ", transactionTime='" + getTransactionTime() + "'" +
            "}";
    }
    
}
