package com.kakao.domain.jpa.entity.common;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NOTIFICATION_QUEUE")
public class NotificationQueue {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NOTIFICATION_QUEUE_NO", nullable = false)
    private Long notificationQueueNo; // 알림큐아이디 (AUTO INCREMENT)

    @Column(name = "TEMPLATE_ID")
    private String templateId; // 템플릿아이디 (PK)

    @Column(name = "TEMPLATE_TYPE_CD")
    private String templateTypeCd; // 템플릿종류코드

    @Column(name = "RECIPIENTTYPE_CD")
    private String recipientTypeCd; // 받는사람타입 (고객번호, 카카오고객번호)

    @Column(name = "RECIPIENT")
    private String recipient; // 받는사람

    @Column(name = "NOTIFICATION_REG_DTM")
    private LocalDateTime notificationRegDtm; // 알림등록일시

    @Column(name = "SCHEDULED_SEND_DATETIME")
    private LocalDateTime scheduledSendDatetime; // 알림발송예정일시

    @Column(name = "NOTIFICATION_TITLE_PARAM")
    private String notificationTitleParam; // 알림타이틀파라미터

    @Column(name = "NOTIFICATION_MESSAGE_PARAM")
    private String notificationMessageParam; // 알림메시지파라미터
}
