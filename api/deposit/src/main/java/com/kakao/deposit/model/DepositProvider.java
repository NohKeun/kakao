package com.kakao.deposit.model;

import com.kakao.deposit.module.SavingDeposit;
import com.kakao.deposit.module.TimeDeposit;
import com.kakao.domain.inf.deposit.DepositInf;
import com.kakao.domain.inf.factory.DepositFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class DepositProvider implements DepositFactory {

    private final SavingDeposit savingDeposit;
    private final TimeDeposit timeDeposit;

    @Override
    public DepositInf injectionDepositInf(String deposit) {
        if (StringUtils.compare(deposit, "saving") == 0 ) {
            return savingDeposit;
        }
        else if (StringUtils.compare(deposit, "time") == 0 ) {
            return timeDeposit;
        }
        else {
            return null;
        }
    }
}
