package com.kakao.domain.jpa.entity.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import jakarta.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "KAKAO_CUSTOMER")
public class KakaoCustomer {

    @Id
    @Column(name = "KAKAO_NO", nullable = false)
    private String kakaoNo; // 카카오고객번호 (PK)

    @Column(name = "KAKAO_ID")
    private String kakaoId; // 카카오톡아이디

    @Column(name = "KAKAO_ST_CD")
    private String kakaoStCd; // 카카오고객상태코드

    @Column(name = "KAKAO_TYPE_CD")
    private String kakaoTypeCd; // 카카오고객구분코드

    @Column(name = "ID_CARD_TYPE_CD")
    private String idCardTypeCd; // 신분증종류코드

    @Column(name = "ID_CARD_NO")
    private String idCardNo; // 실명번호

    @Column(name = "KAKAO_NM")
    private String kakaoNm; // 카카오고객명

    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress; // 이메일주소

    @Column(name = "MOBILE_PHONE_NO")
    private String mobilePhoneNo; // 휴대폰전화번호

    @Column(name = "KAKAO_BANK_CUST_FLAG")
    private String kakaoBankCustFlag; // 카카오뱅크고객여부

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
