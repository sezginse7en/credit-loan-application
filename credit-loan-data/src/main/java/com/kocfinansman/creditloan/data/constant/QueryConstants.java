package com.kocfinansman.creditloan.data.constant;

public class QueryConstants {

    public static final String SELECT_SCORE_BY_TC = "SELECT score from user_credit_score where tc = ?";

    public static final String INSERT_CREDIT_LOAN = "INSERT INTO user_credit_loan (tc,name,phone_number,credit_limit) VALUES" +
            "  (?,?,?,?);";

}
