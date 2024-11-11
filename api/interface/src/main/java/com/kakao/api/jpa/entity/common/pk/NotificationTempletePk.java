package com.kakao.api.jpa.entity.common.pk;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity @Table(name="NOTIFICATION_TEMPLETE")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @EqualsAndHashCode(callSuper=false) //lombok
public class NotificationTempletePk implements Serializable {
   /** VARCHAR2(4)         */ @Id @Column(name="BR_NO"     , length=4               , nullable=false) private String      brNo                        ;
   /** DATE                */ @Id @Column(name="OPEN_IL"                            , nullable=false) private LocalDate   openIl                      ;

}
