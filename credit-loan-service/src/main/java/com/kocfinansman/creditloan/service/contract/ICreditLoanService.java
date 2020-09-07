package com.kocfinansman.creditloan.service.contract;

import com.kocfinansman.creditloan.model.CreditResult;
import com.kocfinansman.creditloan.model.User;

public interface ICreditLoanService {

    public CreditResult applyCreditLoan(User user);

}
