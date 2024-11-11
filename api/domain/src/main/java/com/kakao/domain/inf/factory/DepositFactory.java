package com.kakao.domain.inf.factory;

import com.kakao.domain.inf.deposit.DepositInf;

public interface DepositFactory {

    DepositInf injectionDepositInf(String deposit);

}
