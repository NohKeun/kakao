package com.kakao.deposit.debit.model;

import com.kakao.domain.inf.deposit.DepositInf;
import com.kakao.domain.inf.factory.DepositFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class DebitFactory implements DepositFactory {

    @Override
    public DepositInf injectionDepositInf(String deposit) {
        return null;
    }
}
