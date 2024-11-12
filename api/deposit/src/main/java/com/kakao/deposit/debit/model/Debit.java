package com.kakao.deposit.debit.model;

import com.kakao.domain.inf.deposit.DepositInf;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public abstract class Debit implements DepositInf {

    @Override
    public void debit() {
        log.debug("보내기 전");
    }

    public void validate() {
        log.debug("출금가능 계좌 확인");
    }
}
