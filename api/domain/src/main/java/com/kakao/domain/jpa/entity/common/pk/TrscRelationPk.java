package com.kakao.domain.jpa.entity.common.pk;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false) //lombok
public class TrscRelationPk {

    @Id
    @Column(name = "ORG_TRSC_ID", nullable = false)
    private String orgTrscId; // 원거래아이디 (PK)

    @Id
    @Column(name = "ORG_TRSC_SEQ_NO", nullable = false)
    private Long orgTrscSeqNo; // 원거래일련번호 (PK)
}
