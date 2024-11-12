package com.kakao.deposit.model;

import com.kakao.domain.inf.deposit.DepositInf;
import com.kakao.domain.inf.factory.DepositFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class DepositProvider implements DepositFactory {

    @Override
    public DepositInf injectionDepositInf(String deposit) {
        return null;
    }
}
