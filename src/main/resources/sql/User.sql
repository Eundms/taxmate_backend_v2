-- User
CREATE SEQUENCE USER_SEQ START WITH 1 INCREMENT BY 1;

CREATE TABLE USER (
    id BIGINT PRIMARY KEY DEFAULT nextval('USER_SEQ'),
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    username VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT NULL
);
