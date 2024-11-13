package com.kakao.domain.jpa.entity.common;

import com.kakao.domain.jpa.entity.common.pk.TrscRelationPk;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TRSC_RELATION")
@IdClass(TrscRelationPk.class)
public class TrscRelation {

    @Id
    @Column(name = "ORG_TRSC_ID", nullable = false)
    private String orgTrscId; // 원거래아이디 (PK)

    @Id
    @Column(name = "ORG_TRSC_SEQ_NO", nullable = false)
    private Long orgTrscSeqNo; // 원거래일련번호 (PK)

    @Column(name = "ORG_ASSIGN_CD")
    private String orgAssignCd; // 원거래업무코드

    @Column(name = "TRSC_TYPE_CODE")
    private String trscTypeCode; // 거래구분코드

    @Column(name = "REL_TRSC_ID")
    private String relTrscId; // 관련거래아이디

    @Column(name = "REL_TRSC_SEQ_NO")
    private Long relTrscSeqNo; // 관련거래일련번호

    @Column(name = "REL_ASSIGN_CD")
    private String relAssignCd; // 관계거래업무분코드
}