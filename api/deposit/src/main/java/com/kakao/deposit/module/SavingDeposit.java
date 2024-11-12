package com.kakao.deposit.module;

import com.kakao.deposit.model.Deposit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SavingDeposit extends Deposit {
    private final ValidateDeposit validateDeposit;

    @Override
    public void validate() {
        super.validate();
        validateDeposit.validateSaving();
    }

    @Override
    public void credit() {
        super.credit();
    }

    @Override
    public void debit() {
        super.debit();
    }
}
