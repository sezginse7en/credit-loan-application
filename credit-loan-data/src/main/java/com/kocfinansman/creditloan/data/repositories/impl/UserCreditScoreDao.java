package com.kocfinansman.creditloan.data.repositories.impl;

import com.kocfinansman.creditloan.data.constant.QueryConstants;
import com.kocfinansman.creditloan.data.repositories.contract.IUserCreditScoreDao;
import com.kocfinansman.creditloan.exception.CreditLoanException;
import com.kocfinansman.creditloan.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserCreditScoreDao implements IUserCreditScoreDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public long findScoreByTc(String tc) {
        try {
            return jdbcTemplate.queryForObject(QueryConstants.SELECT_SCORE_BY_TC,
                    new Object[]{tc},Long.class);
        }catch (Exception exception){
            throw new CreditLoanException("-1","An error has occured when user find : " + exception.getMessage());
        }
    }

    @Override
    public boolean saveCreditLoan(User user, long creditLimit) {
        try{
            return jdbcTemplate.update(QueryConstants.INSERT_CREDIT_LOAN, ps -> {
                ps.setString(1,user.getTc());
                ps.setString(2,user.getName());
                ps.setString(3,user.getPhoneNumber());
                ps.setLong(4,creditLimit);
            }) == 1;
        }catch (Exception exception){
            throw new CreditLoanException("-1","An error has occured when user create : " + exception.getMessage());
        }

    }
}
