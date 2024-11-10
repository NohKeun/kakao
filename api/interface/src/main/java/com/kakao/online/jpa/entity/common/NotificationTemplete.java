package com.kakao.online.jpa.entity.common;

import com.oneqoncore.jpa.common.BaseEntity;
import com.inobis.jpa.entity.aact.pk.AactAccClsbrPk;
import lombok.*;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity @Table(name="NOTIFICATION_TEMPLETE")
@IdClass(AactAccClsbrPk.class)
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(callSuper=false) //lombok
public class NotificationTemplete extends BaseEntity implements Serializable {
   /** VARCHAR2(4)         */ @Id @Column(name="BR_NO"     , length=4               , nullable=false) private String      brNo                        ;
   /** DATE                */ @Id @Column(name="OPEN_IL"                            , nullable=false) private LocalDate   openIl                      ;
   /** VARCHAR2(1)         */     @Column(name="IBM_RCVGB" , length=1                               ) private String      ibmRcvgb                    ;
   /** VARCHAR2(1)         */     @Column(name="PRE_CLSGB" , length=1                               ) private String      preClsgb                    ;
   /** VARCHAR2(1)         */     @Column(name="POS_CLEAR" , length=1                               ) private String      posClear                    ;
   /** VARCHAR2(1)         */     @Column(name="BON_CLSGB" , length=1                               ) private String      bonClsgb                    ;
   /** VARCHAR2(1)         */     @Column(name="OPEN_GB"   , length=1                               ) private String      openGb                      ;
   /** DATE                */     @Column(name="TR_IL"                              , nullable=false) private LocalDate   trIl                        ;
   /** VARCHAR2(100)       */     @Column(name="CLS_BIT"   , length=100                             ) private String      clsBit                      ;

}
