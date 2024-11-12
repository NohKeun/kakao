package com.kakao.common.customer.model;

import com.kakao.common.customer.module.BankCustomer;
import com.kakao.common.customer.module.KakaoCustomer;
import com.kakao.domain.inf.common.CustomerInf;
import com.kakao.domain.inf.factory.CommonFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
@RequiredArgsConstructor
public abstract class CustomerProvider implements CommonFactory {

    private final BankCustomer bankCustomer;
    private final KakaoCustomer kakaoCustomer;

    @Override
    public CustomerInf injectionCustomerInf(String cust) {
        if (StringUtils.compare(cust, "email") == 0 ) {
            return bankCustomer;
        }
        else if (StringUtils.compare(cust, "kakaoTalk") == 0 ) {
            return kakaoCustomer;
        }
        else {
            return null;
        }
    }
}
