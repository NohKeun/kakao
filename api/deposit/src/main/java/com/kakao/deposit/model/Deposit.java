package com.kakao.deposit.model;

import com.kakao.deposit.module.ValidateDeposit;
import com.kakao.domain.inf.deposit.DepositInf;
import com.kakao.domain.jpa.repository.deposit.DaoDepositInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public abstract class Deposit implements DepositInf {

    @Autowired
    ValidateDeposit validateDeposit;

    @Override
    public void open() {

    }

    @Override
    public void credit() {

    }

    @Override
    public void debit(){

    }

    @Override
    public void close() {

    }

    @Override
    public void validate() {
        validateDeposit.validateCommon();
    }
}
