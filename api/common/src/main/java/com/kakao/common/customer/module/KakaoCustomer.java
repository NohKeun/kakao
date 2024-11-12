package com.kakao.common.customer.module;

import com.kakao.common.customer.model.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public abstract class KakaoCustomer extends Customer {

    @Override
    public void validate() {
        super.validate();

        //kakao 테이블에서 조회
    }
}
