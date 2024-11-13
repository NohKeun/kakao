package com.kakao.domain.jpa.entity.common;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NOTIFICATION_SUCCESS")
public class NotificationSuccess {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "NOTIFICATION_QUEUE_NO", nullable = false)
    private Long notificationQueueNo; // 알림큐아이디 (PK)

    @Column(name = "TEMPLATE_ID", nullable = false)
    private String templateId; // 템플릿아이디

    @Column(name = "TEMPLATE_TYPE_CD", nullable = false)
    private String templateTypeCd; // 템플릿종류코드 (PUSH, EMAIL, SMS, TALK)

    @Column(name = "RECIPIENTTYPE_CD")
    private String recipientTypeCd; // (고객번호, 카카오고객번호)

    @Column(name = "RECIPIENT")
    private String recipient; // 받는사람

    @Column(name = "NOTIFICATION_CREATE_DTM")
    private LocalDateTime notificationCreateDtm; // 알림생성일시

    @Column(name = "NOTIFICATION_SUCCESS_DTM")
    private LocalDateTime notificationSuccessDtm; // 알림성공일시

    @Column(name = "NOTIFICATION_TITLE_PARAM")
    private String notificationTitleParam; // 알림타이틀파라미터

    @Column(name = "NOTIFICATION_MESSAGE_PARAM")
    private String notificationMessageParam; // 알림메시지파라미터
}
