package com.kakao.domain.inf.deposit;

public interface DepositInf {

    void validate();

    void open();

    void credit();
//
    void debit();

    void close();
}
