package com.kakao.domain.jpa.entity.common;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "BANK_CUSTOMER")
public class BankCustomer {

    @Id
    @Column(name = "CUSTOMER_NO", nullable = false)
    private String customerNo; // 고객번호 (PK)

    @Column(name = "CUSTOMER_ST_CD")
    private String customerStCd; // 고객상태코드

    @Column(name = "CUSTOMER_TYPE_CD")
    private String customerTypeCd; // 고객종류코드

    @Column(name = "ID_CARD_TYPE_CD")
    private String idCardTypeCd; // 신분증종류코드

    @Column(name = "ID_CARD_NO")
    private String idCardNo; // 실명번호

    @Column(name = "CUSTOMER_NM")
    private String customerNm; // 고객명

    @Column(name = "KAKAO_NO")
    private String kakaoNo; // 카카오고객번호

    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress; // 이메일주소

    @Column(name = "MOBILE_PHONE_NO")
    private String mobilePhoneNo; // 휴대폰전화번호

    @Column(name = "PRIVACY_AGREE_FLAG")
    private String privacyAgreeFlag; // 개인정보동의여부

    @Column(name = "EMAIL_AGREE_FLAG")
    private String emailAgreeFlag; // EMAIL수신동의여부

    @Column(name = "SMS_AGREE_FLAG")
    private String smsAgreeFlag; // SMS수신동의여부

    @Column(name = "PUSH_AGREE_FLAG")
    private String pushAgreeFlag; // PUSH수신동의여부

    @Column(name = "KAKAO_AGREE_FLAG")
    private String kakaoAgreeFlag; // 카톡수신동의여부
}
