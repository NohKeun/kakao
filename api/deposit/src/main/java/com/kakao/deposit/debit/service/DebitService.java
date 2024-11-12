package com.kakao.deposit.debit.service;

import com.kakao.domain.inf.deposit.DepositInf;
import com.kakao.domain.inf.factory.CommonFactory;
import com.kakao.domain.inf.common.NotificationInf;
import com.kakao.domain.inf.factory.DepositFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DebitService {

    //의존성주입 매서드
    private final CommonFactory commonFactory;
    private final DepositFactory depositFactory;

    //구현체 호출 인터페이스
    private NotificationInf notificationInf;
    private DepositInf depositInf;

    //Dao Repository

    public void debit() {

        this.notificationInf = commonFactory.injectionNotificationInf("kakaoTalk");
        this.notificationInf.sendNotification();

        //1.injection(의존성주입)

        //2.validate
        //-출금계좌 검증
        //-

        //2.고객정보 검증

    }


}
