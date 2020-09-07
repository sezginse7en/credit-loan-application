package com.kocfinansman.creditloan.rest.request;


import com.kocfinansman.creditloan.model.User;

public class CreditLoanRequest {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
