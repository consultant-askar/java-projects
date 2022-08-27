package com.revature.Models;

public class Reimbursement{

    private Integer reimbId;
    private String reimbAmount;
    private String reimbSubmitted;
    private String reimbResolved;
    private String reimbDescription;
    //private reimbReceipt bytea;           **********    how to represent this field????
    private Integer author;
    private Integer resolver;
    private Integer reimbStatus;
    private Integer reimbType;



    public Reimbursement() {

    }


    public Reimbursement(Integer reimbId, String reimbAmount, String reimbSubmitted, String reimbResolved, String reimbDescription, Integer author, Integer resolver, Integer reimbStatus, Integer reimbType) {
        this.reimbId = reimbId;
        this.reimbAmount = reimbAmount;
        this.reimbSubmitted = reimbSubmitted;
        this.reimbResolved = reimbResolved;
        this.reimbDescription = reimbDescription;
        this.author = author;
        this.resolver = resolver;
        this.reimbStatus = reimbStatus;
        this.reimbType = reimbType;
    }




    public Integer getReimbId() {
        return this.reimbId;
    }

    public void setReimbId(Integer reimbId) {
        this.reimbId = reimbId;
    }

    public String getReimbAmount() {
        return this.reimbAmount;
    }

    public void setReimbAmount(String reimbAmount) {
        this.reimbAmount = reimbAmount;
    }

    public String getReimbSubmitted() {
        return this.reimbSubmitted;
    }

    public void setReimbSubmitted(String reimbSubmitted) {
        this.reimbSubmitted = reimbSubmitted;
    }

    public String getReimbResolved() {
        return this.reimbResolved;
    }

    public void setReimbResolved(String reimbResolved) {
        this.reimbResolved = reimbResolved;
    }

    public String getReimbDescription() {
        return this.reimbDescription;
    }

    public void setReimbDescription(String reimbDescription) {
        this.reimbDescription = reimbDescription;
    }

    public Integer getAuthor() {
        return this.author;
    }

    public void setAuthor(Integer author) {
        this.author = author;
    }

    public Integer getResolver() {
        return this.resolver;
    }

    public void setResolver(Integer resolver) {
        this.resolver = resolver;
    }

    public Integer getReimbStatus() {
        return this.reimbStatus;
    }

    public void setReimbStatus(Integer reimbStatus) {
        this.reimbStatus = reimbStatus;
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
            ", author='" + getAuthor() + "'" +
            ", resolver='" + getResolver() + "'" +
            ", reimbStatus='" + getReimbStatus() + "'" +
            ", reimbType='" + getReimbType() + "'" +
            "}";
    }




    }

    



