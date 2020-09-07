package com.kocfinansman.creditloan.data.repositories.contract;


import com.kocfinansman.creditloan.model.User;

public interface IUserCreditScoreDao {

    public long findScoreByTc(String tc);

    public boolean saveCreditLoan(User user, long creditLimit);


}
