package com.kakao.api.debit.model;

import com.kakao.api.inf.deposit.DepositInf;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public abstract class Debit implements DepositInf {

    @Override
    public void debit() {
        log.debug("보내기 전");

    }
}
