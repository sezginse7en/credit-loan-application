package com.kocfinansman.creditloan.model;


public class UserCreditScore {

    public String tc;
    public long score;

    public UserCreditScore(){
    }

    public UserCreditScore(String tc, long score) {
        this.tc = tc;
        this.score = score;
    }

    @Override
    public String toString() {
        return String.format(
                "UserCreditScore[tc=%s, score='%d']",
                tc, score);
    }
}
