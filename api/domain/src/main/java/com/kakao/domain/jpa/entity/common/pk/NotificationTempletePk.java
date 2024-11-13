package com.kakao.domain.jpa.entity.common.pk;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;


public class NotificationTempletePk implements Serializable {
   @Id
   @Column(name = "TEMPLATE_ID", length = 20)
   private String templateId; // 템플릿아이디 (PK)

   @Id
   @Column(name = "TEMPLATE_TYPE_CD")
   private String templateTypeCd; // 템플릿종류코드

}
