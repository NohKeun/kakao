package com.kakao.domain.jpa.entity.deposit.pk;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false) //lombok
public class DepositTrscHisPk implements Serializable {

    @Id
    @Column(name = "ACCOUNT_NO", nullable = false)
    private String accountNo; // 수신계좌번호 (FK)

    @Id
    @Column(name = "TRSC_SEQ_NO", nullable = false)
    private Long trscSeqNo; // 거래일련번호 (PK)
}
