package com.kocfinansman.creditloan.model;

public class User {

    private String tc;
    private String name;
    private String phoneNumber;
    private long monthlyIncoming;

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public long getMonthlyIncoming() {
        return monthlyIncoming;
    }

    public void setMonthlyIncoming(long monthlyIncoming) {
        this.monthlyIncoming = monthlyIncoming;
    }
}
