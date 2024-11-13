package com.kakao.deposit.service;

import com.kakao.deposit.iomodel.DebitServiceInput;
import com.kakao.deposit.iomodel.DebitServiceOutput;
import com.kakao.domain.inf.common.CustomerInf;
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
    private CustomerInf customerInf;

    public DebitServiceOutput execute(DebitServiceInput input) throws Exception{
        this.input = input;

        //1.injection(의존성주입)
        injection();

        //2.validate
        validation();

        //3.debit
        debit();

        daoBankCustomer.insert(new BankCustomer());

        //2.validate
        //수신 : 출금 가능여부 검증 -> 계좌종류 별로
        //고객 : 유효한 고객 검증(블랙리스트 등)

        //3.debit to kakao(input에 카카오톡 친구로 보내기)

        //4.noti(해당 거래에 해당하는 방식으로 전송)

        //5.성공 반환

        return output;
    }

    private void injection() throws Exception {

        //수신은 보통예금 계좌
        this.depositInf = depositFactory.injectionDepositInf("saving");

        //알림은 카카오톡으로
        this.notificationInf = commonFactory.injectionNotificationInf("kakao");

        //고객은 카카오고객
        this.customerInf = commonFactory.injectionCustomerInf("kakao");
    }

    private void validation() throws Exception {

        /**
         * 계좌 종류에 따라서 검증함수 호출
         * if Saving(보통예금) 계좌인 경우
         * 1.정상계좌 여부 체크
         * 2.잔액, 만기 체크
         */
        this.depositInf.validate();

        /**
         * 고객 종류에 따라서 검증함수 호출
         * 1.정상고객 여부 체크
         * 2.블랙리스트 체크(신용3사 제휴 검증 등)
         */
        this.customerInf.validate();
    }

    private void debit() throws Exception {
        this.depositInf.debit();
    }
}
