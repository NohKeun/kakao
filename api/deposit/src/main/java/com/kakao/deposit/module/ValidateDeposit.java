package com.kakao.deposit.module;

import com.kakao.domain.jpa.repository.deposit.DaoDepositInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ValidateDeposit {
    @Autowired
    DaoDepositInfo daoDepositInfo;

    public void validateCommon() {
        daoDepositInfo.findById("");
    }

    public void validateSaving() {
        //Saving 계좌 검증
    }
}
