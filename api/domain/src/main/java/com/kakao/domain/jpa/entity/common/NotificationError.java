package com.kakao.domain.jpa.entity.common;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Clob;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NOTIFICATION_ERROR")
public class NotificationError {

    @Id
    @Column(name = "NOTIFICATION_QUEUE_NO")
    private Long notificationQueueNo; // 알림큐아이디 (PK)

    @Column(name = "TEMPLATE_ID")
    private String templateId; // 템플릿아이디

    @Column(name = "TEMPLATE_TYPE_CD")
    private String templateTypeCd; // 템플릿종류코드 (PUSH, EMAIL, SMS, TALK)

    @Column(name = "RECIPIENTTYPE_CD")
    private String recipientTypeCd; // (고객번호, 카카오고객번호)

    @Column(name = "RECIPIENT")
    private String recipient; // 받는사람

    @Column(name = "NOTIFICATION_CREATE_DTM")
    private LocalDateTime notificationCreateDtm; // 알림생성일시

    @Column(name = "NOTIFICATION_ERROR_DTM")
    private LocalDateTime notificationErrorDtm; // 알림오류일시

    @Column(name = "NOTIFICATION_ERROR_CNT")
    private Long notificationErrorCnt; // 알림오류건수

    @Column(name = "NOTIFICATION_TITLE_PARAM")
    private String notificationTitleParam; // 알림타이틀파라미터

    @Column(name = "NOTIFICATION_MESSAGE_PARAM")
    private String notificationMessageParam; // 알림메시지파라미터

    @Column(name = "ERROR_LOG")
    private Clob errorLog; // 오류로그
}