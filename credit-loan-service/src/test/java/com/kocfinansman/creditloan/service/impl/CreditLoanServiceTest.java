package com.kocfinansman.creditloan.service.impl;

import com.kocfinansman.creditloan.data.repositories.contract.IUserCreditScoreDao;
import com.kocfinansman.creditloan.data.repositories.impl.UserCreditScoreDao;
import com.kocfinansman.creditloan.model.CreditResult;
import com.kocfinansman.creditloan.model.User;
import com.kocfinansman.creditloan.service.contract.ICreditLoanService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class CreditLoanServiceTest{

    private IUserCreditScoreDao mockDao;
    private User testUserCase1;
    private User testUserCase2;
    private User testUserCase3;
    private ICreditLoanService service;

    @Before
    public void setUp(){
        mockDao = mock(UserCreditScoreDao.class);
        testUserCase1 = new User();
        testUserCase1.setName("User 1");
        testUserCase1.setMonthlyIncoming(400);
        testUserCase1.setPhoneNumber("1231231122");
        testUserCase1.setTc("12345678900");

        testUserCase2 = new User();
        testUserCase2.setName("User 2");
        testUserCase2.setMonthlyIncoming(750);
        testUserCase2.setPhoneNumber("1231231111");
        testUserCase2.setTc("12345678900");

        testUserCase3 = new User();
        testUserCase3.setName("User 3");
        testUserCase3.setMonthlyIncoming(5000);
        testUserCase3.setPhoneNumber("1231231133");
        testUserCase3.setTc("12345678901");

        service = new CreditLoanService(mockDao);
    }

    @Test
    public void testUnSuccessfullApplyCreditLoanWhenScoreLT_500(){
        //given
        when(mockDao.findScoreByTc(anyString())).thenReturn(400L);
        when(mockDao.saveCreditLoan(testUserCase1,0)).thenReturn(false);

        //when
        CreditResult result = service.applyCreditLoan(testUserCase1);

        //then
        verify(mockDao,times(1)).findScoreByTc(anyString());
        verify(mockDao,times(0)).saveCreditLoan(testUserCase1,0);
        assertFalse(result.isResult());
        assertEquals(0,result.getLimit());
        assertNotNull(result.getMessage());
    }

    @Test
    public void testSuccessfullApplyCreditLoanWhenScoreBW_500_1000(){
        //given
        when(mockDao.findScoreByTc(anyString())).thenReturn(750L);
        when(mockDao.saveCreditLoan(testUserCase2,10000L)).thenReturn(true);

        //when
        CreditResult result = service.applyCreditLoan(testUserCase2);

        //then
        verify(mockDao,times(1)).findScoreByTc(anyString());
        verify(mockDao,times(1)).saveCreditLoan(testUserCase2,10000L);
        assertTrue(result.isResult());
        assertEquals(10000L,result.getLimit());
        assertNotNull(result.getMessage());
    }

    @Test
    public void testSuccessfullApplyCreditLoanWhenScoreGT_1000(){
        //given
        when(mockDao.findScoreByTc(anyString())).thenReturn(1500L);
        when(mockDao.saveCreditLoan(testUserCase3,20000L)).thenReturn(true);

        //when
        CreditResult result = service.applyCreditLoan(testUserCase3);

        //then
        verify(mockDao,times(1)).findScoreByTc(anyString());
        verify(mockDao,times(1)).saveCreditLoan(testUserCase3,20000L);
        assertTrue(result.isResult());
        assertEquals(20000L,result.getLimit());
        assertNotNull(result.getMessage());
    }

}