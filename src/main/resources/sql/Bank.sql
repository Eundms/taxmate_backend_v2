-- 한국 은행
CREATE SEQUENCE KOREA_BANK_SEQ START WITH 1 INCREMENT BY 1;

CREATE TABLE KOREA_BANK (
    id BIGINT PRIMARY KEY DEFAULT nextval('KOREA_BANK_SEQ'),
    base_interest_rate NUMERIC(2,2), -- 소수점 앞 , 뒤 몇개
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 은행 상품
CREATE SEQUENCE BANK_PRODUCT_SEQ START WITH 1 INCREMENT BY 1;

CREATE TABLE BANK_PRODUCT (
    id BIGINT PRIMARY KEY DEFAULT nextval('BANK_PRODUCT_SEQ'),
    name VARCHAR(50),
    description VARCHAR(255),
    type VARCHAR(10) CHECK (type IN ('DEPOSIT', 'SAVINGS')),
    rate NUMERIC(2,2),
    duration INTERVAL, -- 3 days, 3 months
    repeat VARCHAR(10) CHECK (type IN ('DAILY', 'WEEK', 'MONTH')) -- null if type deposit
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- 은행 상품 가입
CREATE SEQUENCE PRODUCT_JOIN_SEQ START WITH 1 INCREMENT BY 1;

CREATE TABLE PRODUCT_JOIN (
    id BIGINT PRIMARY KEY DEFAULT nextval("PRODUCT_JOIN_SEQ"),
    user_id BIGINT,
    bank_product_id BIGINT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-------------
-- 만기일
CREATE OR REPLACE VIEW PRODUCT_JOIN_VIEW AS
    SELECT
        PJ.id AS id,
        PJ.user_id AS user_id,
        PJ.bank_product_id AS bank_product_id,
        BP.name AS name,
        BP.type AS type,
        BP.rate AS rate,
        BP.duration AS duration,
        BP.repeat AS repeat,
        PJ.created_at + BP.duration AS expected_expiration_date
    FROM PRODUCT_JOIN PJ LEFT JOIN BANK_PRODUCT BP
        ON PJ.bank_product_id = BP.id;