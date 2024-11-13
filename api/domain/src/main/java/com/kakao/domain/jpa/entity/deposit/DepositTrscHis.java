package com.kakao.domain.jpa.entity.deposit;

import com.kakao.domain.jpa.entity.deposit.pk.DepositTrscHisPk;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DEPOSIT_TRSC_HIS")
@IdClass(DepositTrscHisPk.class)
public class DepositTrscHis {

    @Id
    @Column(name = "ACCOUNT_NO", nullable = false)
    private String accountNo; // 수신계좌번호 (FK)

    @Id
    @Column(name = "TRSC_SEQ_NO", nullable = false)
    private Long trscSeqNo; // 거래일련번호 (PK)

    @Column(name = "TRSC_ST_CD")
    private String trscStCd; // 거래상태코드

    @Column(name = "TRSC_DT")
    private LocalDate trscDt; // 거래일자

    @Column(name = "TRSC_TM")
    private String trscTm; // 거래시각

    @Column(name = "REAL_PROC_DT")
    private LocalDate realProcDt; // 실처리일자

    @Column(name = "REAL_PROC_TM")
    private String realProcTm; // 실처리시각

    @Column(name = "CANCEL_DT")
    private LocalDate cancelDt; // 취소일자

    @Column(name = "CANCEL_TM")
    private String cancelTm; // 취소일시

    @Column(name = "CANCEL_TRSC_SEQ_NO")
    private Long cancelTrscSeqNo; // 취소거래일련번호

    @Column(name = "TRANSFER_PROC_CD")
    private String transferProcCd; // 이체거래프로세스코드

    @Column(name = "DEBIT_CREDIT_CD")
    private String debitCreditCd; // 입금지급코드

    @Column(name = "TRSC_CURRENCY_CD")
    private String trscCurrencyCd; // 거래통화코드

    @Column(name = "BF_TRSC_BAL")
    private BigDecimal bfTrscBal; // 거래전잔액

    @Column(name = "TRSC_AMT")
    private BigDecimal trscAmt; // 거래금액

    @Column(name = "AF_TRSC_BAL")
    private BigDecimal afTrscBal; // 거래후잔액

    @Column(name = "FEE_AMT")
    private BigDecimal feeAmt; // 수수료금액
}