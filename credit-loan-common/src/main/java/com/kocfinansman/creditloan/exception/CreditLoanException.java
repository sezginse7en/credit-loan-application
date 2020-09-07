package com.kocfinansman.creditloan.exception;

public class CreditLoanException extends RuntimeException{

    private final String code;
    private final String message;

    public CreditLoanException(String code,String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
