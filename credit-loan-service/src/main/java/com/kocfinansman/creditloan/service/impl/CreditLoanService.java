package com.kocfinansman.creditloan.service.impl;

import com.kocfinansman.creditloan.data.repositories.contract.IUserCreditScoreDao;
import com.kocfinansman.creditloan.exception.CreditLoanException;
import com.kocfinansman.creditloan.model.CreditResult;
import com.kocfinansman.creditloan.model.User;
import com.kocfinansman.creditloan.service.contract.ICreditLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreditLoanService implements ICreditLoanService {

    public static final int CREDIT_LIMIT_MULTIPLIER = 4;
    IUserCreditScoreDao repository;

    @Autowired
    public CreditLoanService(IUserCreditScoreDao userCreditScoreDao){
        this.repository = userCreditScoreDao;
    }

    private long getCreditScoreByTc(String tc) {
        try{
            return repository.findScoreByTc(tc);
        }catch (CreditLoanException exception){
            throw new CreditLoanException("-2", "There is a technical problem now, please try again later");
        }
    }

    @Override
    public CreditResult applyCreditLoan(User user) {

        long creditLimit = 0;
        long creditScore = getCreditScoreByTc(user.getTc());

        if (creditScore < 500){
            return getUnsuccessfulCreditResultMessage();
        }
        else if(creditScore >= 500 && creditScore < 1000 && user
        .getMonthlyIncoming() < 5000){
            try {
                creditLimit = 10000;
                saveCreditLoan(user,creditLimit);
                return getSuccessfulCreditResultMessage(creditLimit);
            }catch (CreditLoanException exception){
                throw new CreditLoanException("123","There is an error when credit loan operation, you may be applied to credit before");
            }
        }
        else if(creditScore >= 1000 ){
            creditLimit = user.getMonthlyIncoming() * CREDIT_LIMIT_MULTIPLIER;
            saveCreditLoan(user,creditLimit);
            return getSuccessfulCreditResultMessage(creditLimit);
        }
        return getUnsuccessfulCreditResultMessage();
    }

    private boolean saveCreditLoan(User user, long creditLimit) {
            return repository.saveCreditLoan(user,creditLimit);
    }

    private CreditResult getSuccessfulCreditResultMessage(long creditLimit){
        CreditResult result = new CreditResult();
        result.setMessage("Credit loan is successful!");
        result.setResult(true);
        result.setLimit(creditLimit);
        return result;
    }

    private CreditResult getUnsuccessfulCreditResultMessage(){
        CreditResult result = new CreditResult();
        result.setMessage("Credit loan is unsuccessful!");
        result.setResult(false);
        result.setLimit(0);
        return result;
    }
}
