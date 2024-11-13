package com.kakao.domain.jpa.entity.common;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.sql.Clob;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "NOTIFICATION_TEMPLATE")
public class NotificationTemplate {

   @Id
   @Column(name = "TEMPLATE_ID", nullable = false)
   private String templateId; // 템플릿아이디 (PK)

   @Id
   @Column(name = "TEMPLATE_TYPE_CD")
   private String templateTypeCd; // 템플릿종류코드

   @Column(name = "TEMPLATE_BUSINESS_CD")
   private String templateBusinessCd; // 템플릿업무코드

   @Column(name = "TEMPLATE_DESCRIPTION")
   private String templateDescription; // 템플릿설명

   @Column(name = "TEMPLATE_TITLE")
   private String templateTitle; // 템플릿타이틀

   @Column(name = "TEMPLATE_MESSAGE_CONTENT")
   private Clob templateMessageContent; // 템플릿메시지내용
}
