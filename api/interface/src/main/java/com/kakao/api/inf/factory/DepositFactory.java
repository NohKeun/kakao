package com.kakao.api.inf.factory;

import com.kakao.api.inf.deposit.DepositInf;

public interface DepositFactory {

    DepositInf injectionDepositInf(String deposit);

}
