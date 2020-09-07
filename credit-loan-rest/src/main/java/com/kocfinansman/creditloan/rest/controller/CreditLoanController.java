package com.kocfinansman.creditloan.rest.controller;

import com.kocfinansman.creditloan.model.CreditResult;
import com.kocfinansman.creditloan.rest.request.CreditLoanRequest;
import com.kocfinansman.creditloan.rest.response.CreditLoanResponse;
import com.kocfinansman.creditloan.service.impl.CreditLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreditLoanController {

    CreditLoanService service;

    @Autowired
    public CreditLoanController(CreditLoanService service){
        this.service = service;
    }

    @PostMapping(value="/creditloan")
    public CreditLoanResponse getCreditLoan(@RequestBody CreditLoanRequest request){
        CreditResult result = service.applyCreditLoan(request.getUser());
        CreditLoanResponse response = new CreditLoanResponse();
        response.setResult(result);
        return response;
    }

}
