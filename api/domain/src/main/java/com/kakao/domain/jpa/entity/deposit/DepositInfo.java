package com.kakao.domain.jpa.entity.deposit;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DEPOSIT_INFO")
public class DepositInfo {

    @Id
    @Column(name = "ACCOUNT_NO", nullable = false)
    private String accountNo; // 수신계좌번호 (PK)

    @Column(name = "ACCOUNT_ST_CD", nullable = false)
    private String accountStCd; // 계좌상태코드

    @Column(name = "ACCOUNT_TYPE_CD", nullable = false)
    private String accountTypeCd; // 계좌종류코드

    @Column(name = "CUSTOMER_NO", nullable = false)
    private String customerNo; // 고객번호

    @Column(name = "OPEN_DT")
    private LocalDate openDt; // 개설일

    @Column(name = "MATURITY_DT")
    private LocalDate maturityDt; // 만기일

    @Column(name = "CURRENT_BAL")
    private BigDecimal currentBal; // 현재잔액

    @Column(name = "ACCOUNT_DESC")
    private String accountDesc; // 계좌설명

    @Column(name = "INTEREST_RATE")
    private BigDecimal interestRate; // 이자율

    @Column(name = "FEE_EXEMPTION_FLAG")
    private String feeExemptionFlag; // 수수료면제여부
}
