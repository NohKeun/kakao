package com.kakao.domain.jpa.entity.common.pk;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false) //lombok
public class NotificationTemplatePk {

   @Id
   @Column(name = "TEMPLATE_ID", nullable = false)
   private String templateId; // 템플릿아이디 (PK)

   @Id
   @Column(name = "TEMPLATE_TYPE_CD", nullable = false)
   private String templateTypeCd; // 템플릿종류코드

}
