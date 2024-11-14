-- 수신계좌정보
CREATE TABLE DEPOSIT_INFO (
    ACCOUNT_NO            VARCHAR2(20),        -- 수신계좌번호 (PK)
    ACCOUNT_ST_CD         VARCHAR2(2),         -- 계좌상태코드 (정상, 취소)
    ACCOUNT_TYPE_CD       VARCHAR2(2),         -- 계좌종류코드 (보통예금, 정기예금, 정기적금)
    CUSTOMER_NO           NUMBER,              -- 고객번호
    OPEN_DT               DATE,                -- 개설일
    MATURITY_DT           DATE,                -- 만기일
    CURRENT_BAL           NUMBER(15, 2),       -- 현재잔액
    ACCOUNT_DESC          VARCHAR2(255),       -- 계좌설명
    INTEREST_RATE         NUMBER(5, 2),        -- 이자율
    FEE_EXEMPTION_FLAG    VARCHAR2(1),         -- 수수료면제여부 (Y/N)
    CONSTRAINT DEPOSIT_INFO_PK PRIMARY KEY (ACCOUNT_NO)
);

-- 수신거래내역
CREATE TABLE DEPOSIT_TRSC_HIS (
    ACCOUNT_NO            VARCHAR2(20),        -- 수신계좌번호 (FK)
    TRSC_SEQ_NO           NUMBER,              -- 거래일련번호 (PK)
    TRSC_ST_CD            VARCHAR2(2),         -- 거래상태코드 (정상, 취소)
    TRSC_DT               DATE,                -- 거래일자
    TRSC_TM               VARCHAR2(8),         -- 거래시각
    REAL_PROC_DT          DATE,                -- 실처리일자
    REAL_PROC_TM          VARCHAR2(8),         -- 실처리시각
    CANCEL_DT             DATE,                -- 취소일자
    CANCEL_TM             VARCHAR2(8),         -- 취소일시
    CANCEL_TRSC_SEQ_NO    NUMBER,              -- 취소거래일련번호
    TRANSFER_PROC_CD      VARCHAR2(2),         -- 이체거래프로세스코드 (이체진행, 받는중, 취소, 받기완료)
    DEBIT_CREDIT_CD       VARCHAR2(2),         -- 입금지급코드 (입금거래, 출금거래)
    TRSC_TYPE_CD          VARCHAR2(2),         -- 거래종류코드(자동이체,현금,체크카드,예금이자)
    TRSC_CURRENCY_CD      VARCHAR2(3),         -- 거래통화코드
    BF_TRSC_BAL           NUMBER(15, 2),       -- 거래전잔액
    TRSC_AMT              NUMBER(15, 2),       -- 거래금액
    AF_TRSC_BAL           NUMBER(15, 2),       -- 거래후잔액
    FEE_AMT               NUMBER(15, 2),       -- 수수료금액
    CONSTRAINT DEPOSIT_TRSC_HIS_PK PRIMARY KEY (ACCOUNT_NO, TRSC_SEQ_NO),
    CONSTRAINT DEPOSIT_TRSC_HIS_FK1 FOREIGN KEY (ACCOUNT_NO) REFERENCES DEPOSIT_INFO(ACCOUNT_NO)
);

-- 거래관계
CREATE TABLE TRSC_RELATION (
    ORG_TRSC_ID           VARCHAR2(20),        -- 원거래아이디 (PK)
    ORG_TRSC_SEQ_NO       NUMBER,              -- 원거래일련번호 (PK)
    ORG_ASSIGN_CD         VARCHAR2(2),         -- 원거래업무코드 (수신, 여신, 고객, 타행)
    TRSC_TYPE_CD          VARCHAR2(2),         -- 거래구분코드 (진행중, 완료, 취소)
    REL_TRSC_ID           VARCHAR2(20),        -- 관련거래아이디
    REL_TRSC_SEQ_NO       NUMBER,              -- 관련거래일련번호
    REL_ASSIGN_CD         VARCHAR2(2),         -- 관계거래업무분코드 (수신, 여신, 고객, 타행)
    CONSTRAINT TRSC_RELATION_PK PRIMARY KEY (ORG_TRSC_ID, ORG_TRSC_SEQ_NO)
);

-- 은행고객정보
CREATE TABLE BANK_CUSTOMER (
    CUSTOMER_NO           VARCHAR2(20),        -- 고객번호 (PK)
    CUSTOMER_ST_CD        VARCHAR2(2),         -- 고객상태코드 (정상, 취소)
    CUSTOMER_TYPE_CD      VARCHAR2(2),         -- 고객종류코드 (개인, 법인)
    ID_CARD_TYPE_CD       VARCHAR2(2),         -- 신분증종류코드 (주민등록증, 운전면허증)
    ID_CARD_NO            VARCHAR2(20),        -- 실명번호
    CUSTOMER_NM           VARCHAR2(100),       -- 고객명
    KAKAO_NO              VARCHAR2(20),        -- 카카오고객번호
    EMAIL_ADDRESS         VARCHAR2(100),       -- 이메일주소
    MOBILE_PHONE_NO       VARCHAR2(20),        -- 휴대폰전화번호
    PRIVACY_AGREE_FLAG    VARCHAR2(1),         -- 개인정보동의여부 (Y/N)
    EMAIL_AGREE_FLAG      VARCHAR2(1),         -- EMAIL수신동의여부 (Y/N)
    SMS_AGREE_FLAG        VARCHAR2(1),         -- SMS수신동의여부 (Y/N)
    PUSH_AGREE_FLAG       VARCHAR2(1),         -- PUSH수신동의여부 (Y/N)
    KAKAO_AGREE_FLAG      VARCHAR2(1),         -- 카톡수신동의여부 (Y/N)
    CONSTRAINT BANK_CUSTOMER_PK PRIMARY KEY (CUSTOMER_NO)
);

-- 카카오고객정보
CREATE TABLE KAKAO_CUSTOMER (
    KAKAO_NO              VARCHAR2(20),        -- 카카오고객번호 (PK)
    KAKAO_ID              VARCHAR2(100),       -- 카카오톡아이디
    KAKAO_ST_CD           VARCHAR2(2),         -- 카카오고객상태코드 (정상, 취소)
    KAKAO_TYPE_CD         VARCHAR2(2),         -- 카카오고객구분코드 (개인, 법인)
    ID_CARD_TYPE_CD       VARCHAR2(2),         -- 신분증종류코드 (주민등록증, 운전면허증)
    ID_CARD_NO            VARCHAR2(20),        -- 실명번호
    KAKAO_NM              VARCHAR2(100),       -- 카카오고객명
    EMAIL_ADDRESS         VARCHAR2(100),       -- 이메일주소
    MOBILE_PHONE_NO       VARCHAR2(20),        -- 휴대폰전화번호
    KAKAO_BANK_CUST_FLAG  VARCHAR2(1),         -- 카카오뱅크고객여부
    PRIVACY_AGREE_FLAG    VARCHAR2(1),         -- 개인정보동의여부 (Y/N)
    EMAIL_AGREE_FLAG      VARCHAR2(1),         -- EMAIL수신동의여부 (Y/N)
    SMS_AGREE_FLAG        VARCHAR2(1),         -- SMS수신동의여부 (Y/N)
    PUSH_AGREE_FLAG       VARCHAR2(1),         -- PUSH수신동의여부 (Y/N)
    KAKAO_AGREE_FLAG      VARCHAR2(1),         -- 카톡수신동의여부 (Y/N)
    CONSTRAINT KAKAO_CUSTOMER_PK PRIMARY KEY (KAKAO_NO)
);

-- 카카오고객거래내역
CREATE TABLE KAKAO_CUSTOMER_TRSC_HIS (
    KAKAO_NO              VARCHAR2(20),        -- 카카오고객번호 (FK)
    TRSC_SEQ_NO           NUMBER,              -- 거래일련번호 (PK)
    TRSC_ST_CD            VARCHAR2(2),         -- 거래상태코드 (정상, 취소)
    TRSC_DT               DATE,                -- 거래일자
    TRSC_TM               VARCHAR2(8),         -- 거래시각
    REAL_PROC_DT          DATE,                -- 실처리일자
    REAL_PROC_TM          VARCHAR2(8),         -- 실처리시각
    CANCEL_DT             DATE,                -- 취소일자
    CANCEL_TM             VARCHAR2(8),         -- 취소일시
    CANCEL_TRSC_SEQ_NO    NUMBER,              -- 취소거래일련번호
    TRANSFER_PROC_CD      VARCHAR2(2),         -- 이체거래프로세스코드 (이체진행, 받는중, 취소, 받기완료)
    DEBIT_CREDIT_CD       VARCHAR2(2),         -- 입금지급구분코드 (입금거래, 출금거래)
    TRSC_CURRENCY_CD      VARCHAR2(3),         -- 거래통화코드
    TRSC_AMT              NUMBER(15, 2),       -- 거래금액
    CONSTRAINT KAKAO_CUSTOMER_TRSC_HIS_PK PRIMARY KEY (KAKAO_NO, TRSC_SEQ_NO),
    CONSTRAINT KAKAO_CUSTOMER_TRSC_HIS_FK1 FOREIGN KEY (KAKAO_NO) REFERENCES KAKAO_CUSTOMER(KAKAO_NO)
);

-- 알림메시지템플릿
CREATE TABLE NOTIFICATION_TEMPLATE (
    TEMPLATE_ID           VARCHAR2(20),        -- 템플릿아이디 (PK)
    TEMPLATE_TYPE_CD      VARCHAR2(2),         -- 템플릿종류코드 (PUSH, EMAIL, SMS, TALK)
    TEMPLATE_BUSINESS_CD  VARCHAR2(2),         -- 템플릿업무코드 (수신, 여신, 고객, 타행)
    TEMPLATE_DESCRIPTION  VARCHAR2(255),       -- 템플릿설명
    TEMPLATE_TITLE        VARCHAR2(4000),      -- 템플릿타이틀
    TEMPLATE_MESSAGE_CONTENT CLOB,              -- 템플릿메시지내용
    CONSTRAINT NOTIFICATION_TEMPLATE_PK PRIMARY KEY (TEMPLATE_ID, TEMPLATE_TYPE_CD)
);

-- 알림메시지큐
CREATE TABLE NOTIFICATION_QUEUE (
    NOTIFICATION_QUEUE_NO NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY, -- 알림큐아이디 (AUTO INCREMENT)
    TEMPLATE_ID           VARCHAR2(20),        -- 템플릿아이디 (FK)
    TEMPLATE_TYPE_CD      VARCHAR2(2),         -- 템플릿종류코드 (PUSH, EMAIL, SMS, TALK)
    RECIPIENTTYPE_CD      VARCHAR2(2),         -- (고객번호, 카카오고객번호)
    RECIPIENT             VARCHAR2(20),        -- 받는사람
    NOTIFICATION_REG_DTM  TIMESTAMP,           -- 알림등록일시
    SCHEDULED_SEND_DATETIME TIMESTAMP,         -- 알림발송예정일시
    NOTIFICATION_TITLE_PARAM VARCHAR2(4000),   -- 알림타이틀파라미터
    NOTIFICATION_MESSAGE_PARAM VARCHAR2(4000), -- 알림메시지파라미터
    CONSTRAINT NOTIFICATION_QUEUE_FK1 FOREIGN KEY (TEMPLATE_ID, TEMPLATE_TYPE_CD) REFERENCES NOTIFICATION_TEMPLATE(TEMPLATE_ID, TEMPLATE_TYPE_CD)
);

-- 카카오톡메시지로그
CREATE TABLE NOTIFICATION_KAKAO_LOG (
    NOTIFICATION_DT       DATE,                -- 알림일자 (PK)
    KAKAO_NO              VARCHAR2(20),        -- 카카오고객번호 (PK)
    NOTIFICATION_SEQ_NO   NUMBER,              -- 알림일련번호 (PK)
    NOTIFICATION_QUEUE_NO NUMBER,              -- 알림큐아이디
    NOTIFICATION_CREATE_DTM TIMESTAMP,         -- 알림생성일시
    SCHEDULED_SEND_DTM    TIMESTAMP,           -- 발송예정일시
    REAL_SEND_DTM         TIMESTAMP,           -- 실제발송일시
    NOTIFICATION_TITLE    VARCHAR2(4000),      -- 알림타이틀
    NOTIFICATION_MESSAGE  CLOB,                -- 알림메시지
    CONSTRAINT NOTIFICATION_KAKAO_LOG_PK PRIMARY KEY (NOTIFICATION_DT, KAKAO_NO, NOTIFICATION_SEQ_NO),
    CONSTRAINT NOTIFICATION_KAKAO_LOG_FK1 FOREIGN KEY (KAKAO_NO) REFERENCES KAKAO_CUSTOMER(KAKAO_NO),
    CONSTRAINT NOTIFICATION_KAKAO_LOG_FK2 FOREIGN KEY (NOTIFICATION_QUEUE_NO) REFERENCES NOTIFICATION_SUCCESS(NOTIFICATION_QUEUE_NO)
);

-- 고객메시지로그
CREATE TABLE NOTIFICATION_CUSTOMER_LOG (
    NOTIFICATION_DT       DATE,                -- 알림일자 (PK)
    CUSTOMER_NO           VARCHAR2(20),        -- 고객번호 (PK)
    NOTIFICATION_SEQ_NO   NUMBER,              -- 알림일련번호 (PK)
    NOTIFICATION_QUEUE_NO NUMBER,              -- 알림큐아이디
    NOTIFICATION_CREATE_DTM TIMESTAMP,         -- 알림생성일시
    SCHEDULED_SEND_DTM    TIMESTAMP,           -- 발송예정일시
    REAL_SEND_DTM         TIMESTAMP,           -- 실제발송일시
    NOTIFICATION_TITLE    VARCHAR2(4000),      -- 알림타이틀
    NOTIFICATION_MESSAGE  CLOB,                -- 알림메시지
    CONSTRAINT NOTIFICATION_CUSTOMER_LOG_PK PRIMARY KEY (NOTIFICATION_DT, CUSTOMER_NO, NOTIFICATION_SEQ_NO),
    CONSTRAINT NOTIFICATION_CUSTOMER_LOG_FK1 FOREIGN KEY (CUSTOMER_NO) REFERENCES BANK_CUSTOMER(CUSTOMER_NO),
    CONSTRAINT NOTIFICATION_CUSTOMER_LOG_FK2 FOREIGN KEY (NOTIFICATION_QUEUE_NO) REFERENCES NOTIFICATION_SUCCESS(NOTIFICATION_QUEUE_NO)
);


-- 알림메시지성공
CREATE TABLE NOTIFICATION_SUCCESS (
    NOTIFICATION_QUEUE_NO NUMBER,              -- 알림큐아이디 (PK)
    TEMPLATE_ID           VARCHAR2(20),        -- 템플릿아이디
    TEMPLATE_TYPE_CD      VARCHAR2(2),         -- 템플릿종류코드 (PUSH, EMAIL, SMS, TALK)
    RECIPIENTTYPE_CD      VARCHAR2(2),         -- (고객번호, 카카오고객번호)
    RECIPIENT             VARCHAR2(20),        -- 받는사람
    NOTIFICATION_CREATE_DTM TIMESTAMP,         -- 알림생성일시
    NOTIFICATION_SUCCESS_DTM TIMESTAMP,          -- 알림성공일시
    NOTIFICATION_TITLE_PARAM VARCHAR2(4000),   -- 알림타이틀파라미터
    NOTIFICATION_MESSAGE_PARAM VARCHAR2(4000), -- 알림메시지파라미터
    CONSTRAINT NOTIFICATION_SUCCESS_PK PRIMARY KEY (NOTIFICATION_QUEUE_NO),
    CONSTRAINT NOTIFICATION_SUCCESS_FK1 FOREIGN KEY (TEMPLATE_ID, TEMPLATE_TYPE_CD) REFERENCES NOTIFICATION_TEMPLATE(TEMPLATE_ID, TEMPLATE_TYPE_CD)
);

-- 알림메시지오류
CREATE TABLE NOTIFICATION_ERROR (
    NOTIFICATION_QUEUE_NO NUMBER,              -- 알림큐아이디 (PK)
    TEMPLATE_ID           VARCHAR2(20),        -- 템플릿아이디
    TEMPLATE_TYPE_CD      VARCHAR2(2),         -- 템플릿종류코드 (PUSH, EMAIL, SMS, TALK)
    RECIPIENTTYPE_CD      VARCHAR2(2),         -- (고객번호, 카카오고객번호)
    RECIPIENT             VARCHAR2(20),        -- 받는사람
    NOTIFICATION_CREATE_DTM TIMESTAMP,         -- 알림생성일시
    NOTIFICATION_ERROR_DTM TIMESTAMP,          -- 알림오류일시
    NOTIFICATION_ERROR_CNT NUMBER,             -- 알림오류건수
    NOTIFICATION_TITLE_PARAM VARCHAR2(4000),   -- 알림타이틀파라미터
    NOTIFICATION_MESSAGE_PARAM VARCHAR2(4000), -- 알림메시지파라미터
    ERROR_LOG            CLOB,                -- 오류로그
    CONSTRAINT NOTIFICATION_ERROR_PK PRIMARY KEY (NOTIFICATION_QUEUE_NO),
    CONSTRAINT NOTIFICATION_ERROR_FK1 FOREIGN KEY (TEMPLATE_ID, TEMPLATE_TYPE_CD) REFERENCES NOTIFICATION_TEMPLATE(TEMPLATE_ID, TEMPLATE_TYPE_CD)
);