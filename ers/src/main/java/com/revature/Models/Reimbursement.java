package com.revature.Models;

public class Reimbursement {

    private Integer reimbId;
    private String reimbAmount;
    private String reimbSubmitted;
    private String reimbResolved;
    private String reimbDescription;
    //private reimbReceipt bytea;
    private String author;
    private String resolver;
    private String reimbStatus;
    private String reimbType;

    public Reimbursement() {
    }

    public Reimbursement(Integer reimbId, String reimbAmount, String reimbSubmitted, String reimbResolved, String reimbDescription, String author, String resolver, String reimbStatus, String reimbType) {
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

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getResolver() {
        return this.resolver;
    }

    public void setResolver(String resolver) {
        this.resolver = resolver;
    }

    public String getReimbStatus() {
        return this.reimbStatus;
    }

    public void setReimbStatus(String reimbStatus) {
        this.reimbStatus = reimbStatus;
    }

    public String getReimbType() {
        return this.reimbType;
    }

    public void setReimbType(String reimbType) {
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
