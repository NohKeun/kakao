package com.kakao.domain.jpa.entity.common;

import com.kakao.domain.jpa.entity.common.pk.NotificationKakaoLogPk;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Clob;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NOTIFICATION_KAKAO_LOG")
@IdClass(NotificationKakaoLogPk.class)
public class NotificationKakaoLog {

    @Id
    @Column(name = "NOTIFICATION_DT")
    private LocalDate notificationDt; // 알림일자 (PK)

    @Id
    @Column(name = "KAKAO_NO", length = 20)
    private String kakaoNo; // 카카오고객번호 (PK)

    @Id
    @Column(name = "NOTIFICATION_SEQ_NO")
    private Long notificationSeqNo; // 알림일련번호 (PK)

    @Column(name = "NOTIFICATION_QUEUE_NO")
    private Long notificationQueue; // 알림큐아이디 (FK)

    @Column(name = "NOTIFICATION_CREATE_DTM")
    private LocalDateTime notificationCreateDtm; // 알림생성일시

    @Column(name = "SCHEDULED_SEND_DTM")
    private LocalDateTime scheduledSendDtm; // 발송예정일시

    @Column(name = "REAL_SEND_DTM")
    private LocalDateTime realSendDtm; // 실제발송일시

    @Column(name = "NOTIFICATION_TITLE")
    private String notificationTitle; // 알림타이틀

    @Column(name = "NOTIFICATION_MESSAGE")
    private Clob notificationMessage; // 알림메시지
}
