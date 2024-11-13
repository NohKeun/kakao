package com.kakao.domain.jpa.entity.common.pk;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false) //lombok
public class NotificationCustomerLogPk {
    @Id
    @Column(name = "NOTIFICATION_DT", nullable = false)
    private LocalDate notificationDt; // 알림일자 (PK)

    @Id
    @Column(name = "CUSTOMER_NO", nullable = false)
    private String customerNo; // 고객번호 (PK)

    @Id
    @Column(name = "NOTIFICATION_SEQ_NO", nullable = false)
    private Long notificationSeqNo; // 알림일련번호 (PK)
}
