package com.kakao.api.debit.model;

import com.kakao.api.inf.deposit.DepositInf;
import com.kakao.api.inf.factory.DepositFactory;
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
