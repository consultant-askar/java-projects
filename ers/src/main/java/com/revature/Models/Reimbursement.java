package com.revature.models;

import java.sql.Date;
import java.util.List;

public class Reimbursement {

    private Integer reimbId;
    private Double reimbAmount;
    private Date reimbSubmitted;
    private Date reimbResolved;
    private String reimbDescription;
    //private reimbReceipt bytea;           **********    how to represent Bytea data type ????
    private Integer authorFK;        // foreign key
    private Integer resolver;       // foreign key      
    private Integer reimbStatusId; // foreign key
    private Integer reimbType;    // foreign key

    
    public Reimbursement(Integer reimbId, Double reimbAmount, Date reimbSubmitted, Date reimbResolved, String reimbDescription, Integer authorFK, Integer resolver, Integer reimbStatusId, Integer reimbType) {
        this.reimbId = reimbId;
        this.reimbAmount = reimbAmount;
        this.reimbSubmitted = reimbSubmitted;
        this.reimbResolved = reimbResolved;
        this.reimbDescription = reimbDescription;
        this.authorFK = authorFK;
        this.resolver = resolver;
        this.reimbStatusId = reimbStatusId;
        this.reimbType = reimbType;
    }



    public Reimbursement() {
    }

    public Reimbursement(Double reimbAmount, Integer reimbType) { 

        this.reimbAmount = reimbAmount;
        this.reimbType = reimbType;
    }

    public Reimbursement(Integer authorFK, Double reimbAmount, Integer reimbType) { 

        this.authorFK = authorFK;
        this.reimbAmount = reimbAmount;
        this.reimbType = reimbType;
    }

    public Reimbursement (Double reimbAmount, Date reimbSubmitted, Integer reimbType) {
    
        this.reimbAmount = reimbAmount;
        this.reimbSubmitted = reimbSubmitted;
        this.reimbType = reimbType;
    }

    public Reimbursement(Double reimbAmount, Date reimbSubmitted, Date reimbResolved, String reimbDescription,Integer reimbStatusId, Integer reimbType) {
        
        this.reimbAmount = reimbAmount;
        this.reimbSubmitted = reimbSubmitted;
        this.reimbResolved = reimbResolved;
        this.reimbDescription = reimbDescription;
        this.reimbStatusId = reimbStatusId;
        this.reimbType = reimbType;
    }



    public Integer getReimbId() {
        return this.reimbId;
    }

    public void setReimbId(Integer reimbId) {
        this.reimbId = reimbId;
    }

    public Double getReimbAmount() {
        return this.reimbAmount;
    }

    public void setReimbAmount(Double reimbAmount) {
        this.reimbAmount = reimbAmount;
    }

    public Date getReimbSubmitted() {
        return this.reimbSubmitted;
    }

    public void setReimbSubmitted(Date reimbSubmitted) {
        this.reimbSubmitted = reimbSubmitted;
    }

    public Date getReimbResolved() {
        return this.reimbResolved;
    }

    public void setReimbResolved(Date reimbResolved) {
        this.reimbResolved = reimbResolved;
    }

    public String getReimbDescription() {
        return this.reimbDescription;
    }

    public void setReimbDescription(String reimbDescription) {
        this.reimbDescription = reimbDescription;
    }

    public Integer getAuthorFK() {
        return this.authorFK;
    }

    public void setAuthorFK(Integer authorFK) {
        this.authorFK = authorFK;
    }

    public Integer getResolver() {
        return this.resolver;
    }

    public void setResolver(Integer resolver) {
        this.resolver = resolver;
    }

    public Integer getReimbStatus() {
        return this.reimbStatusId;
    }

    public void setReimbStatus(Integer reimbStatus) {
        this.reimbStatusId = reimbStatus;
    }

    public Integer getReimbType() {
        return this.reimbType;
    }

    public void setReimbType(Integer reimbType) {
        this.reimbType = reimbType;
    }




    @Override
    public String toString() {
        return "{" +
            " reimbId='" + getReimbId() + "'" +
            ", reimbAmount='" + getReimbAmount() + "'" +
            ", reimbSubmitted='" + getReimbSubmitted() + "'" +
            ", reimbResolved='" + getReimbResolved() + "'" +
            ", reimbDescription='" + getReimbDescription() + "'" +
            ", authorFK='" + getAuthorFK() + "'" +
            ", resolver='" + getResolver() + "'" +
            ", reimbStatus='" + getReimbStatus() + "'" +
            ", reimbType='" + getReimbType() + "'" +
            "}";
    }





    }




    

    



