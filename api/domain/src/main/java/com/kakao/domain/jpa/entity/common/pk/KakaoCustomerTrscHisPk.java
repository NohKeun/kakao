package com.kakao.domain.jpa.entity.common.pk;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false) //lombok
public class KakaoCustomerTrscHisPk {
    @Id
    @Column(name = "KAKAO_NO", nullable = false)
    private String kakaoNo; // 카카오고객번호 (FK)

    @Id
    @Column(name = "TRSC_SEQ_NO", nullable = false)
    private Long trscSeqNo; // 거래일련번호 (PK)
}
