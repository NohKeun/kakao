package com.kakao.deposit.service;

import com.kakao.deposit.iomodel.DebitServiceInput;
import com.kakao.deposit.iomodel.DebitServiceOutput;
import com.kakao.domain.inf.common.NotificationInf;
import com.kakao.domain.inf.deposit.DepositInf;
import com.kakao.domain.inf.factory.CommonFactory;
import com.kakao.domain.inf.factory.DepositFactory;
import com.kakao.domain.jpa.entity.common.BankCustomer;
import com.kakao.domain.jpa.repository.common.DaoBankCustomer;
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

    //Dao Repository
    private final DaoBankCustomer daoBankCustomer;

    //해당 클래스에서 사용할 전역변수
    private DebitServiceInput input;
    private DebitServiceOutput output = new DebitServiceOutput();

    //구현체 호출 인터페이스
    private NotificationInf notificationInf;
    private DepositInf depositInf;

    public DebitServiceOutput execute(DebitServiceInput input) throws Exception{
        this.input = input;

        //1.injection(의존성주입) -> 수신통장 종류 , 알림메시지 종류 , 고객 종류
        this.notificationInf = commonFactory.injectionNotificationInf("kakaoTalk");
        this.notificationInf.sendNotification();

        this.depositInf = depositFactory.injectionDepositInf("saving");
        this.depositInf.debit();

        daoBankCustomer.insert(new BankCustomer());

        //2.validate
        //수신 : 출금 가능여부 검증 -> 계좌종류 별로
        //고객 : 유효한 고객 검증(블랙리스트 등)

        //3.debit to kakao(input에 카카오톡 친구로 보내기)

        //4.noti(해당 거래에 해당하는 방식으로 전송)

        //5.성공 반환

        return output;
    }
}
