package com.kakao.domain.jpa.entity.common.pk;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.time.LocalDate;

public class NotificationKakaoLogPk {

    @Id
    @Column(name = "NOTIFICATION_DT")
    private LocalDate notificationDt; // 알림일자 (PK)

    @Id
    @Column(name = "KAKAO_NO", length = 20)
    private String kakaoNo; // 카카오고객번호 (PK)

    @Id
    @Column(name = "NOTIFICATION_SEQ_NO")
    private Long notificationSeqNo; // 알림일련번호 (PK)
}
