package com.kakao.deposit.debit.module;

import com.kakao.deposit.debit.model.Debit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class KakaoFriendDeposit extends Debit {

    @Override
    public void debit() {
        System.out.println("Kakao Talk");
    }
}
